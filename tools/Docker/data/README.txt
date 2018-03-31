Disadvantages of storing data within the writable layer of a container :

    -   data doesn’t persist when that container is no longer running
    -   container’s writable layer is tightly coupled to the host machine where the container is running. It can’t be easily moved somewhere else
    -   Writing into a container’s writable layer requires a storage driver to manage the filesystem. The storage driver provides a union filesystem, using the Linux kernel. This extra abstraction reduces performance as compared to using data volumes, which write directly to the host filesystem

====================

3 ways to mount data into a container from the Docker host :
    1.  volumes         -   recommended
                        -   stored in a part of the host filesystem which is managed by Docker
                            /var/lib/docker/volumes

    2.  bind mount      -   anywhere on the host system

    3.  tmpfs volumes   -   in host system's memory only and never written to host filesystem


    -   data looks the same from within the container in all mounts
    -   It is exposed as either a directory or an individual file in the container’s filesystem

Volume  :
    -   can be created explicitly by
            docker volume create
    -   Docker can create a volume during container or service creation
    -   given volume can be mounted into multiple containers simultaneously
    -   volume can be removed using
            docker volume prune


If mount an empty volume into a directory in the container in which files or directories exist, these files or directories are propagated (copied) into the volume. Similarly, if container is started and specify a volume which does not already exist, an empty volume is created

If mount a bind mount or non-empty volume into a directory in the container in which some files or directories exist, these files or directories are obscured by the mount

        ==================
Layman :
volume or bind mount same chheez hai , bus fark yeh h kii volume docker ki specfic directory me banta hai
Docker CLI commands can not be used to directly manage bind mounts

====================
