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
