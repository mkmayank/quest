`vmstat`
* virtual memory statistics
* first report produced gives averages since the last reboot
* additional reports give information on a sampling period of length delay




```bash
vmstat 1
procs -----------memory---------- ---swap-- -----io---- -system-- ------cpu-----
 r  b   swpd   free   buff  cache   si   so    bi    bo   in   cs us sy id wa st
 6  0 3703656 3203376 800840 99533968    0    0     0    18    0    0  3  1 96  0  0
 6  0 3703656 3202856 800848 99534320    0    0     0  2028 6528 1291 19  0 81  0  0
 6  0 3703656 3477172 800848 99534776    0    0     0   156 6474 1191 19  0 81  0  0
 7  0 3703656 3313176 800848 99535120    0    0     0   276 7105 2127 19  1 80  0  0
^C
```

`vmstat [options] [delay [count]]`

* delay is in seconds
* count is total no of reports, default is infinite