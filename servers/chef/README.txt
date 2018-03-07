chef development kit
knife
chef-client
ohai

The search engine is based on Apache Solr and is run from the Chef server.


-   RSA public key-pairs are used to authenticate the chef-client with the Chef server,
    every time a chef-client needs access to data that is stored on the Chef server.
    This prevents any node from accessing data that it shouldn’t and
    it ensures that only nodes that are properly registered with the Chef server can be managed.
