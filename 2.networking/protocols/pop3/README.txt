Post Office Protocol

Port    :   110
        :   995 (SSL)

RFC     :   1939    :   https://tools.ietf.org/html/rfc1939 :   POP3


==========================================================

status indicators:
    +OK
    -ERR


states:
    tcp connection is opened
    pop3 server issues the greeting
        AUTHORIZATION state -   client needs to authenticate itself
    client authenticate itself
        TRANSACTION state   -   client do its actions, server locks the resources
    client issued QUIT command
        UPDATE state        -   server release the resources
    server says goodbye

commands:

    QUIT
    STAT, LIST, RETR, DELE, NOOP, RSET
