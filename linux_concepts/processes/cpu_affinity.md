### CPU affinity
 > determines the set of CPUs on which a process is eligible to run

* use for performance benefits
* restricting a thread to run on a single CPU also avoids the performance cost caused by the cache invalidation that occurs

**sched_setaffinity**
> syscall to set affinity

**isolcpus**
> * kernel boot param that isolate certain cpus from kernel scheduling
* remove the specified CPUs, from the general kernel SMP balancing and scheduler algroithms.
* the only way to move a process onto or off an "isolated" CPU is via the CPU affinity syscalls

```bash
$ cat /sys/devices/system/cpu/isolated
2-37

$ cat /proc/cmdline
BOOT_IMAGE=/vmlinuz-3.10.0-862.el7.x86_64 root=UUID=efdc233f-0b96-4afa-a5fe-95d6cae0fa76 ro crashkernel=auto rhgb quiet selinux=0 idle=poll isolcpus=2-37 intel_idle.max_cstate=1 nosoftlookup nohalt nmi_watchdog=0

$ cat /proc/$$/status | grep Cpus_allowed_list
Cpus_allowed_list:	0-1,38-223

# for pinned proccess with cpu affinity
$ cat /proc/147703/status | grep Cpus_allowed_list:
Cpus_allowed_list:	17
```


**CPUAffinity option in /etc/systemd/system.conf**
> sets affinity for systemd itself, as well as everything it launches, unless their .service file overrides the CPUAffinity setting with its own value.