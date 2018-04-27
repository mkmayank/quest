Network drivers:

    -   bridge
        -   default network driver
        -   use when applications run in standalone containers on same host that need to communicate

    -   host
        -   remove network isolation between container and Docker host, and use host’s networking directly
        -   only available for swarm services on Docker 17.06 and higher
        -   use when network stack should not be isolated from host

    -   overlay
        -   connect multiple Docker daemons together and enable swarm services to communicate with each other
        -   removes the need to do OS-level routing between containers
        -   used when containers need to communicated running on different hosts

    -   macvlan
        -   allow to assign a MAC address to a container, making it appear as a physical device on network
        -   Docker daemon routes traffic to containers by their MAC addresses
        -   use when containers need to be looked as physical hosts in network with a unique MAC adddress

    -   none
        -   disable all networking
        -   not available for swarm services
        -   when thrid party plugins need to be used
