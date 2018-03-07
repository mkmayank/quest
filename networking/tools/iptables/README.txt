iptable
    -   it interacts with the packet filtering hooks (netfilter) in the kernel's networking stack
    https://www.digitalocean.com/community/tutorials/a-deep-dive-into-iptables-and-netfilter-architecture

==================

-   Prior to iptables,
        -   ipchains were used for creating Linux firewalls were in Linux kernel 2.2.x and
        -   ipfwadm in Linux kernel 2.0.x, which in turn was based on BSD's ipfw

-   Both ipchains and ipfwadm alter the networking code so they can manipulate packets,
    as Linux kernel lacked a general packets control framework until the introduction of Netfilter

==================

Chain / Tables

The iptables firewall uses tables to organize its rules.
These tables classify rules according to the type of decisions they are used to make

Within each iptables table, rules are further organized within separate "chains"
While tables are defined by the general aim of the rules they hold,
the built-in chains represent the netfilter hooks which trigger them

Chains title :
    -   PREROUTING  : Triggered by the NF_IP_PRE_ROUTING hook.
    -   INPUT       : Triggered by the NF_IP_LOCAL_IN hook.
    -   FORWARD     : Triggered by the NF_IP_FORWARD hook.
    -   OUTPUT      : Triggered by the NF_IP_LOCAL_OUT hook.
    -   POSTROUTING : Triggered by the NF_IP_POST_ROUTING hook.

Tables :
    -   Filter Table    -   make decisions to allow or deny a packet
    -   NAT Table       -   to implement network address translation rules
    -   Mangle Table    -   to alter the IP headers of the packet in various ways
    -   Raw Table       -   to provide a mechanism for marking packets in order to opt-out of connection tracking
    -   Security Table  -   to set internal SELinux security context marks on packets

==================

user-defined chains

==================

Packets that have been marked with the NOTRACK target in one of the raw chains will bypass the connection tracking routines.

==================

Packets by the connection tracking system will be in one of the following states:

    -   NEW         :   packet not associated with an existing connection, but is not invalid as a first packet

    -   ESTABLISHED :   packet receives a valid response in the opposite direction
                        e.g.
                            TCP => SYN/ACK
                            UDP and ICMP => response where source & destination of original packet are switched

    -   RELATED     :   packets that are not part of an existing connection,
                        but are associated with a connection already in the system
                        e.g.
                            helper connections in FTP data transmission
                            ICMP responsesto connection attempts by other protocols

    -   INVALID     :   packets not associated with an existing connection and
                        aren't appropriate for opening a new connection,
                        if they cannot be identified, or if they aren't routable among other reasons

    -   UNTRACKED   :   packets targeted in a raw table chain to bypass tracking

    -   SNAT        :   packets whose source address has been altered by NAT operations
                        so that it knows to change the source addresses back in reply packets

    -   DNAT        :   packets whose destination address has been altered by NAT operations
                        so that it knows to change the destination address back when routing reply packets
