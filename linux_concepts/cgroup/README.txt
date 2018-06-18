https://www.kernel.org/doc/Documentation/cgroup-v1/00-INDEX
https://www.kernel.org/doc/Documentation/cgroup-v1/cgroups.txt

cgroups (control groups) :
    Linux kernel feature that limits, accounts for, and isolates the resource usage (CPU, memory, disk I/O, network, etc.) of a collection of processes

History :
    was merged into the Linux kernel mainline in kernel version 2.6.24, 2008

Versions :
    1.  cgroups-v1  -   kernel 2.6.24 in 2008
    2.  cgroups-v2  -   kernel 4.5, 2016

Features :
    unified interface to many different use cases, from controlling single processes (by using nice, for example) to whole operating system-level virtualization
    Cgroups provides:
        1.  Resource limiting
                groups can be set to not exceed a configured memory limit, which also includes the file system cache
        2.  Prioritization
                some groups may get a larger share of CPU utilization or disk I/O throughput
        3.  Accounting
                measures a group's resource usage, e.g, for billing purposes
        4.  Control
                freezing groups of processes, their checkpointing and restarting
