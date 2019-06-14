**isolcpus** => kernel boot params that isolate certain cpus from kernel scheduling

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
