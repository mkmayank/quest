-   written in Go

*   Namespaces
    -   provide a layer of isolation

*   Control groups (cgroup)
    -   limits an application to a specific set of resources

*   Union file systems
    -   file systems that operate by creating layers

*   Container format
    -   Docker Engine combines the namespaces, control groups, and UnionFS into a wrapper called a container format
    -   default container format is libcontainer
