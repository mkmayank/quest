Kernel 4.4.0-122-generic on an x86_64

rhel login: root
Password:
Last login: Tue May  8 17:45:06 on console
-bash-4.2# ip a
1: lo: <LOOPBACK,UP,LOWER_UP> mtu 65536 qdisc noqueue state UNKNOWN qlen 1
    link/loopback 00:00:00:00:00:00 brd 00:00:00:00:00:00
    inet 127.0.0.1/8 scope host lo
       valid_lft forever preferred_lft forever
    inet6 ::1/128 scope host
       valid_lft forever preferred_lft forever
2: host0@if16: <BROADCAST,MULTICAST,UP,LOWER_UP> mtu 1500 qdisc noqueue state UP qlen 1000
    link/ether 4e:60:04:64:68:7b brd ff:ff:ff:ff:ff:ff link-netnsid 0
    inet 192.168.20.171/32 brd 192.168.20.171 scope global host0
       valid_lft forever preferred_lft forever
    inet6 fe80::4c60:4ff:fe64:687b/64 scope link
       valid_lft forever preferred_lft forever
-bash-4.2# df -hT
df: cannot read table of mounted file systems
-bash-4.2#
-bash-4.2#
-bash-4.2# df
df: cannot read table of mounted file systems
-bash-4.2# fdisk -l
-bash-4.2#
-bash-4.2#
-bash-4.2# lsblk
NAME   MAJ:MIN RM   SIZE RO TYPE MOUNTPOINT
sda      8:0    0 465.8G  0 disk
|-sda1   8:1    0   3.8G  0 part [SWAP]
`-sda2   8:2    0   462G  0 part
-bash-4.2#
-bash-4.2#
-bash-4.2#
-bash-4.2# blkid
-bash-4.2#
-bash-4.2#
-bash-4.2#
-bash-4.2# cat /etc/mtab .
cat: .: Is a directory
-bash-4.2# cat /etc/mtab  
-bash-4.2# cat /etc/fta  
cat: /etc/fta: No such file or directory
-bash-4.2# cat /etc/ftab
cat: /etc/ftab: No such file or directory
-bash-4.2# cat /etc/fstab
cat: /etc/fstab: No such file or directory
-bash-4.2# cat /etc/f    
favicon.png   filesystems   fprintd.conf  
-bash-4.2# cat /etc/f
favicon.png   filesystems   fprintd.conf  
-bash-4.2# cat /etc/filesystems
xfs
ext4
ext3
ext2
nodev proc
nodev devpts
iso9660
vfat
hfs
hfsplus
*
-bash-4.2# grep -v rootfs /proc/mounts
/dev/sda2 / ext4 rw,relatime,errors=remount-ro,data=ordered 0 0
tmpfs /sys tmpfs ro,nosuid,nodev,noexec,relatime,mode=755 0 0
tmpfs /sys/fs/cgroup tmpfs ro,nosuid,nodev,noexec 0 0
cgroup /sys/fs/cgroup/hugetlb cgroup ro,nosuid,nodev,noexec,relatime,hugetlb,release_agent=/run/cgmanager/agents/cgm-release-agent.hugetlb 0 0
cgroup /sys/fs/cgroup/pids cgroup ro,nosuid,nodev,noexec,relatime,pids,release_agent=/run/cgmanager/agents/cgm-release-agent.pids 0 0
cgroup /sys/fs/cgroup/perf_event cgroup ro,nosuid,nodev,noexec,relatime,perf_event,release_agent=/run/cgmanager/agents/cgm-release-agent.perf_event 0 0
cgroup /sys/fs/cgroup/net_cls,net_prio cgroup ro,nosuid,nodev,noexec,relatime,net_cls,net_prio 0 0
cgroup /sys/fs/cgroup/cpu,cpuacct cgroup ro,nosuid,nodev,noexec,relatime,cpu,cpuacct 0 0
cgroup /sys/fs/cgroup/freezer cgroup ro,nosuid,nodev,noexec,relatime,freezer 0 0
cgroup /sys/fs/cgroup/cpuset cgroup ro,nosuid,nodev,noexec,relatime,cpuset,clone_children 0 0
cgroup /sys/fs/cgroup/memory cgroup ro,nosuid,nodev,noexec,relatime,memory 0 0
cgroup /sys/fs/cgroup/blkio cgroup ro,nosuid,nodev,noexec,relatime,blkio 0 0
cgroup /sys/fs/cgroup/devices cgroup ro,nosuid,nodev,noexec,relatime,devices 0 0
cgroup /sys/fs/cgroup/systemd cgroup ro,nosuid,nodev,noexec,relatime,xattr,release_agent=/lib/systemd/systemd-cgroups-agent,name=systemd 0 0
tmpfs /dev tmpfs rw,nosuid,mode=755 0 0
tmpfs /dev/shm tmpfs rw,nosuid,nodev 0 0
devpts /dev/pts devpts rw,nosuid,noexec,relatime,gid=5,mode=620,ptmxmode=666 0 0
devpts /dev/console devpts rw,nosuid,noexec,relatime,gid=5,mode=620,ptmxmode=000 0 0
tmpfs /run tmpfs rw,nosuid,nodev,mode=755 0 0
tmpfs /run/systemd/nspawn/incoming tmpfs ro,relatime,size=394524k,mode=755 0 0
tmpfs /tmp tmpfs rw 0 0
proc /proc proc rw,nosuid,nodev,noexec,relatime 0 0
proc /proc/sys proc ro,nosuid,nodev,noexec,relatime 0 0
sysfs /sys/block sysfs ro,nosuid,nodev,noexec,relatime 0 0
sysfs /sys/bus sysfs ro,nosuid,nodev,noexec,relatime 0 0
sysfs /sys/class sysfs ro,nosuid,nodev,noexec,relatime 0 0
sysfs /sys/dev sysfs ro,nosuid,nodev,noexec,relatime 0 0
sysfs /sys/devices sysfs ro,nosuid,nodev,noexec,relatime 0 0
sysfs /sys/kernel sysfs ro,nosuid,nodev,noexec,relatime 0 0
cgroup /sys/fs/cgroup/systemd/machine.slice/machine-rhel.scope cgroup rw,nosuid,nodev,noexec,relatime,xattr,release_agent=/lib/systemd/systemd-cgroups-agent,name=systemd 0 0
tmpfs /proc/sys/kernel/random/boot_id tmpfs ro,nosuid,nodev,mode=755 0 0
tmpfs /proc/kmsg tmpfs rw,nosuid,nodev,mode=755 0 0
hugetlbfs /dev/hugepages hugetlbfs rw,relatime 0 0
mqueue /dev/mqueue mqueue rw,relatime 0 0
tmpfs /run/user/0 tmpfs rw,nosuid,nodev,relatime,size=394524k,mode=700 0 0
-bash-4.2# grep -v rootfs /proc/mounts > /etc/mtab
-bash-4.2# df -hT
Filesystem     Type   Size  Used Avail Use% Mounted on
/dev/sda2      ext4   455G   20G  413G   5% /
tmpfs          tmpfs  1.9G     0  1.9G   0% /sys
tmpfs          tmpfs  1.9G     0  1.9G   0% /sys/fs/cgroup
tmpfs          tmpfs  1.9G     0  1.9G   0% /dev
tmpfs          tmpfs  1.9G     0  1.9G   0% /dev/shm
tmpfs          tmpfs  1.9G   68K  1.9G   1% /run
tmpfs          tmpfs  386M   11M  375M   3% /run/systemd/nspawn/incoming
tmpfs          tmpfs  1.9G     0  1.9G   0% /tmp
tmpfs          tmpfs  386M     0  386M   0% /run/user/0
-bash-4.2#
-bash-4.2#
-bash-4.2#
-bash-4.2#
-bash-4.2#
-bash-4.2# man mtab
No manual entry for mtab
-bash-4.2# df -hT
Filesystem     Type   Size  Used Avail Use% Mounted on
/dev/sda2      ext4   455G   20G  413G   5% /
tmpfs          tmpfs  1.9G     0  1.9G   0% /sys
tmpfs          tmpfs  1.9G     0  1.9G   0% /sys/fs/cgroup
tmpfs          tmpfs  1.9G     0  1.9G   0% /dev
tmpfs          tmpfs  1.9G     0  1.9G   0% /dev/shm
tmpfs          tmpfs  1.9G   68K  1.9G   1% /run
tmpfs          tmpfs  386M   11M  375M   3% /run/systemd/nspawn/incoming
tmpfs          tmpfs  1.9G     0  1.9G   0% /tmp
tmpfs          tmpfs  386M     0  386M   0% /run/user/0
