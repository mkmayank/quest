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
