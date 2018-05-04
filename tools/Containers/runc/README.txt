install go
make and install runc

create rootfs of OS
runc config
    https://github.com/opencontainers/runtime-spec/blob/master/config-linux.md
    https://github.com/opencontainers/runtime-spec/blob/master/config.md
    https://sreeninet.wordpress.com/2016/05/29/macvlan-and-ipvlan/
    https://blog.selectel.com/managing-containers-runc/

some info :

https://stackoverflow.com/questions/33109043/bash-bin-ping-operation-not-permitted-on-rhel-7-1-docker-image
https://unix.stackexchange.com/questions/382771/why-does-ping-need-setuid-permission
https://superuser.com/questions/1113812/how-to-configure-macvlan-interface-for-getting-the-ip
https://github.com/containernetworking/cni

http://blog.oddbit.com/2018/03/12/using-docker-macvlan-networks/

doubt :
https://superuser.com/questions/594550/how-does-bridged-networking-work-in-virtualbox

to create config :
https://thenewstack.io/ready-docker-containers-runc-runtime-riddler/
https://github.com/genuinetools/riddler

stadards :
https://github.com/containernetworking/cni

networking :
https://karampok.me/posts/container-networking-with-cni/
http://blog.mbrt.it/2017-10-01-demystifying-container-networking/
http://www.dasblinkenlichten.com/understanding-cni-container-networking-interface/
https://jvns.ca/blog/2016/12/22/container-networking/
http://crunchtools.com/getting-ninja-runc/

https://www.cyphar.com/blog/post/20160627-rootless-containers-with-runc

some tool :
https://github.com/jpetazzo/pipework

============================
https://unix.stackexchange.com/questions/381581/script-to-create-macvlan-bridge-on-the-host-doesnt-work-unless-its-run-twice


        sudo ip link add link eth0 my1 type macvlan mode bridge
        sudo ip address add 192.168.20.159/24 dev my1
        sudo ip link set dev my1 up
            sudo ip route flush dev eth0
            sudo ip route flush dev my1
        sudo ip route add 192.168.20.0/24 dev my1 metric 0
            sudo ip route add default via 192.168.20.3
            sudo route -n
============================

add ip to given interface :
    ip addr add 192.168.20.171 dev eth0

============================
https://qiita.com/kjtanaka/items/f16757c1f0cc86ff225b
============================
https://blog.codeship.com/connecting-docker-containers-to-production-network-ip-per-container/
http://www.nethero.org/post/115387066622/connecting-docker-containers-to-production-network
https://github.com/zenvdeluca/network-wrapper
============================

http://blog.oddbit.com/2014/08/11/four-ways-to-connect-a-docker/
https://gist.github.com/fulup-bzh/8fd32c8cde9a1e5ec971

host address : 192.168.20.137 on the 192.168.20.0/24 network
guest address : 192.168.20.171
gateway : 192.168.20.3

1.  creating a new bridge device
        # brctl addbr br-eth0
        # ip link set br-eth0 up

2.  add eth0 to this bridge
    move the ip address from eth0 onto the bridge

        # ip addr show eth0
        # ip route

        # brctl addif br-eth0 eth0
        # ip addr del 192.168.20.137/24 dev eth0
        # ip addr add 192.168.20.137/24 dev br-eth0
        # ip route del default
        # ip route add default via 192.168.20.3 dev br-eth0

****************************
    for start docker conatiner

            # docker run -d --name web larsks/simpleweb

        Create a veth interface pair:

            # ip link add web-int type veth peer name web-ext
            # ip link set web-ext up

        Add the web-ext link to the br-eth0 bridge:

            # brctl addif br-eth0 web-ext

        And add the web-int interface to the namespace of the container:

            # ip link set netns $(docker inspect -f '{{.State.Pid}}' web) dev web-int

            # nsenter -t $(docker inspect -f '{{.State.Pid}}' web) -n ip link set web-int up
            # nsenter -t $(docker inspect -f '{{.State.Pid}}' web) -n ip addr add 192.168.20.171/24 dev web-int
            # nsenter -t $(docker inspect -f '{{.State.Pid}}' web) -n ip route del default
            # nsenter -t $(docker inspect -f '{{.State.Pid}}' web) -n ip route add default via 192.168.20.3 dev web-int

    it is letting only host to container and container to host

****************************

for runc container

        $ sudo ip link add name veth-host type veth peer name veth-guest
        $ sudo ip link set veth-host up
        $ sudo brctl addif br-eth0 veth-host
        $ sudo ip netns add runc1
        $ sudo ip link set veth-guest netns runc1
        $ sudo ip netns exec runc1 ip link set veth-guest name eth1
        $ sudo ip netns exec runc1 ip addr add 192.168.20.171/24 dev eth1
        $ sudo ip netns exec runc1 ip link set eth1 up
        $ sudo ip netns exec runc1 ip route add default via 192.168.20.3

    edit config.json to include
        "namespaces": [
                          ...
                           {
                                   "type": "network",
                                   "path": "/var/run/netns/runc"
                           },
                           ...
============================


https://askubuntu.com/questions/755329/lxc-unprivileged-container-apt-get-fails-to-download-anything-inside
