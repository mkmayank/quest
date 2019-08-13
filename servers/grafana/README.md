Installation [Instructions](https://grafana.com/grafana/download) :
```bash
wget https://dl.grafana.com/oss/release/grafana_6.2.5_amd64.deb
sudo dpkg -i grafana_6.2.5_amd64.deb
```

Package [details](https://grafana.com/docs/installation/debian/#package-details) :


|         |          |
| ------------- |-------------|
| binary | /usr/sbin/grafana-server |
| Init.d script | /etc/init.d/grafana-server |
| default file (environment vars) to | /etc/default/grafana-server |
| configuration file | /etc/grafana/grafana.ini |
| systemd service (if systemd is available) | grafana-server.service |
| default log file | /var/log/grafana/grafana.log |
| default sqlite3 db | /var/lib/grafana/grafana.db |
| HTML/JS/CSS and other Grafana files | /usr/share/grafana |
| default HTTP port | 3000 |
| Default login and password | admin/ admin |