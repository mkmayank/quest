```bash
$ uptime
 17:27:41 up 49 min,  1 user,  load average: 0.43, 0.42, 0.34
```
|||
|-|-|
| `17:27:41`          |current time |
| `49 mins`           |time since system is on |
| `1 user`            |current logged-in users |
| `0.43, 0.42, 0.34`  |load average |

---

```bash
$ cat /proc/loadavg
0.37 0.41 0.33 1/1287 13513
```

|||
|-|-|
| `0.37 0.41 0.33` | load average |
| `1`              | no of currently runnable scheduling tasks |
|  `1287`          | no. of currently existing scheduling tasks |
| `13513`          | PID of most recently created task |

---

found this gem :
[http://www.brendangregg.com/blog/2017-08-08/linux-load-averages.html](http://www.brendangregg.com/blog/2017-08-08/linux-load-averages.html)

---

load averages
* system load averages
* average number of running + waiting tasks

---
history

* original load averages show only CPU demand
    * no. of running + waiting(not blocked for I/O) processes

---
Present time :
from [loadavg.c source code](https://github.com/torvalds/linux/blob/master/kernel/sched/loadavg.c)

global load average
* is an exponentially decaying average of
    * nr_running + nr_uninterruptible

from [loadavg.h source code](https://github.com/torvalds/linux/blob/e4cbce4d131753eca271d9d67f58c6377f27ad21/include/linux/sched/loadavg.h#L21)
* 1 5 15 are constants in the equation (EXP_1, EXP_5, EXP_15)
    * (need to study mathematics for it)

---

Reason given for including nr_uninterruptible processes :
* processes which are swapping or waiting on "fast", i.e. noninterruptible, I/O, also consume resources
* It seems somewhat nonintuitive that the load average goes down on replacing fast swap disk with a slow swap disk...

---

load averages cannot be just divided by cpu count, as load average is measuring system load average

---

from load average we can know that there is higher demand for resources (CPus, disks, some locks), but not for which.

for clarification, we can use :

for CPU:
|||
|-|-|
| per-CPU utilization | eg, `mpstat -P ALL 1` |
| per-process CPU utilization | eg, `top` <br/>`pidstat 1` |
| per-thread run queue (scheduler) latency| eg, in `/proc/PID/schedstats` <br/> `delaystats` <br/> `perf sched` |
| CPU run queue latency | eg, in `/proc/schedstat` <br/> `perf sched` <br/> `runqlat bcc tool` |
| CPU run queue length | eg, `vmstat 1` and the 'r' column ??? <br/> `runqlen bcc tool` |

* first two are utilization metrics
* last three are saturation metrics
* Utilization metrics are useful for workload characterization
* saturation metrics useful for identifying a performance problem

best CPU saturation metrics are measures of run queue latency
* the time a task/thread was in a runnable state, but had to wait its turn
* These allows to calculate the magnitude of a performance problem,
    * eg. time% a thread spent in scheduler latency
* measuring the run queue length instead can suggest that there is a problem, but it's more difficult to estimate the magnitude

> `schedstats` facility was made a kernel tunable in Linux 4.6 (`sysctl kernel.sched_schedstats`) and changed to be off by default

`/proc/sched_debug` wait-time (scheduler latency) metric

