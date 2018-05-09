https://access.redhat.com/solutions/1533893

install rootfs in some directory

    #   systemd-nspawn -b -D ROOTFS_DIR_PATH

    Install bridge utils

    #   yum install bridge-utils
    #   yum whatprovides *bin/brctl
    #   yum install bridge-utils-1.5-9.el7.x86_64

    create a new bridge
        #   brctl addbr br-enp0s3
        #   ip link set br-enp0s3 up

        #   ip addr show
        #   ip addr show enp0s3
        #   ip route

        #   brctl addif br-enp0s3 enp0s3 ; \
            ip addr del 192.168.20.154/24 dev enp0s3 ; \
            ip addr add 192.168.20.154/24 dev br-enp0s3 ; \
            ip route del default ; \
            ip route add default via 192.168.20.3 dev br-enp0s3 ;

    start nspwan container
        #   systemd-nspawn --network-bridge=br-enp0s3 -bD guest-os

    On guest

        #   ip link set host0 up
        #   ip addr add 192.168.20.171/24 dev host0
        #   ip route del default
        #   ip route add default via 192.168.20.3 dev host0

    Now guest has IP : 192.168.20.171


for persistent in RHEL :

in host
vi /etc/sysconfig/network-scripts/ifcfg-br0
DEVICE=br-enp0s3
TYPE=Bridge
BOOTPROTO=static
IPADDR=192.168.20.154
NETMASK=192.168.20.255
GATEWAY=192.168.20.3
ONBOOT=yes
DNS1=192.168.20.23

vi /etc/sysconfig/network-scripts/ifcfg-enp0s3
TYPE=Ethernet
NAME=enp0s3
DEVICE=enp0s3
BRIDGE=br-enp0s3

in guest
vi /etc/sysconfig/network-scripts/eth0

HWADDR=4E:60:04:64:68:7B
TYPE=Ethernet
BOOTPROTO=static
IPADDR=192.168.20.171
PREFIX=32
GATEWAY=192.168.20.3
DNS1=192.168.20.160
DNS2=192.168.20.170
DEFROUTE=yes
IPV4_FAILURE_FATAL=no
IPV6INIT=yes
IPV6_AUTOCONF=yes
IPV6_DEFROUTE=yes
IPV6_PEERDNS=yes
IPV6_PEERROUTES=yes
IPV6_FAILURE_FATAL=no
NAME=eth0
UUID=ae92faab-4e3f-42a6-a15f-8969157b7229
ONBOOT=yes




TO GENERATE MAC ADDRESS
echo $FQDN|md5sum|sed 's/^\(..\)\(..\)\(..\)\(..\)\(..\).*$/02:\1:\2:\3:\4:\5/'
