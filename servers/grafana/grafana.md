##### [Docs](https://graphite.readthedocs.io/en/latest/)

##### Graphite [consists 3 parts](https://graphiteapp.org/) :

|         |          |
| ------------- |-------------|
| carbon  | a high-performance service that listens for time-series data |
| whisper | a simple database library for storing time-series data |
| graphite-web | Graphite's user interface & API for rendering graphs and dashboards|

> Metrics get fed into the stack via the Carbon service, which writes the data out to Whisper databases for long-term storage. Users interact with the Graphite web UI or API, which in turn queries Carbon and Whisper for the data needed to construct the requested graphs.

---


##### Installation :

```bash
#Carbon, whisper
sudo apt-get install graphite-carbon
```

> Default installation dir : `/opt/graphite`

---

##### carbon [daemons](https://graphite.readthedocs.io/en/latest/carbon-daemons.html) :

|         |          |
| ------------- |-------------|
| `carbon-cache.py` | <li> accepts metrics over various protocols and writes them to disk as efficiently as possible </li> <li> caches metric values in RAM and flush them to disk on an interval using whisper library </li> <li> provides a query service for in-memory metric datapoints, used by the Graphite webapp to retrieve “hot data” </li> <br/> <li>Configurations : `carbon.conf` , `storage-schemas.conf` </li>|
| `carbon-relay.py` | <li>for replication and sharding</li><br/> <li>Configurations : `carbon.conf` , `relay-rules.conf` </li> |
| `carbon-aggregator.py` | <li> to run in front of `carbon-cache.py` to buffer metrics over time before reporting them into whisper. This is useful when granular reporting is not required, and can help reduce I/O load and whisper file sizes due to lower retention policies. </li> <br/> <li>Configurations : `carbon.conf` , `aggregation-rules.conf` </li>|
| `carbon-aggregator-cache.py`| <li/> `carbon-aggregator-cache.py` combines both `carbon-aggregator.py` and `carbon-cache.py`. This is useful to reduce the resource and administration overhead of running both daemons. </li> <br/> <li>Configurations : `carbon.conf` , `relay-rules.conf`, `aggregation-rules.conf` </li>|


> As the number of incoming metrics increases, one `carbon-cache.py` instance may not be enough to handle the I/O load. To scale out, simply run multiple `carbon-cache.py` instances (on one or more machines) behind a `carbon-aggregator.py` or `carbon-relay.py`.
