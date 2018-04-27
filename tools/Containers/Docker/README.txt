https://washraf.gitbooks.io/the-docker-ecosystem/content/

==========================

Docker availble in two editions :
    -   1.  Community Edition (CE)
    -   2.  Enterprise Edition (EE)

Docker CE has two update channels :
    -   Stable  -   reliable updates every quarter
    -   Edge    -   new features every month

Docker CE supported on Ubuntu on
    -   x86_64, armhf, s390x (IBM Z), and ppc64le (IBM Power) architectures

===========================

*   Docker accesses the Linux kernel's virtualization features
        -   either directly using the libcontainer library [version 0.9 +]
        -   or indirectly via libvirt, LXC (Linux Containers) or systemd-nspawn

===========================

Docker consists of 3 components:

    -   1.  Software:
        -   Docker daemon ("dockerd") , a persistent process that manages Docker containers and container objects
        -   daemon listens for API requests sent by the Docker Engine API

    -   2.  Objects:
        -   refer to different entities used to assemble an application in Docker
        -   main Docker objects are :
            -   container   -   standardized, encapsulated environment that runs applications
            -   image       -   read-only template used to build containers. used to store and ship applications
            -   service     -   allows containers to be scaled across multiple Docker daemons [swarm]

    -   3.  Registries:
        -   repository for Docker images
        -   Registries can be public or private
        -   Two main public registries are Docker Hub and Docker Cloud
        -   Docker Hub is the default registry where Docker looks for images

===========================
