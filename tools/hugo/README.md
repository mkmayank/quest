```bash
# https://gohugo.io/getting-started/quick-start/

# install hugo via binary
$ sudo dpkg -i hugo_binary        

# create a new site
$ hugo new site quickstart
$ cd quickstart

# Download the theme
$ git init
$ git submodule add https://github.com/budparr/gohugo-theme-ananke.git themes/ananke
# add theme to project
$ echo 'theme = "ananke"' >> config.toml

# files can eb created manually and provide metadata in them
# or can use new command to do few things (like add title and date):
$ hugo new posts/my-first-post.md

# to start hugo server
$ hugo server

# to build static pages
# Output will be in ./public/ directory by default (-d/--destination flag to change it, or set publishdir in the config file).
$ hugo
```