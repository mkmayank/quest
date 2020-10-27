Internet Message Access Protocol

Port    :   143
        :   993 (SSL)

RFC     :   3501    :   https://tools.ietf.org/html/rfc3501 :   IMAP4rev1


*   IMAP4 protocol supports both predefined system flags and client-defined keywords
*   IMAP4 protocol allows clients to retrieve any of the individual MIME parts separately and also to retrieve portions of either individual parts or the entire message

==============================================

UIDVALIDITY -   If this value matches the previously returned UIDVALIDITY for this folder, client can rely on the UIDs.

==============================================

IMAP is a state protocol
    -   Not Authenticated State
    -   Authenticated State
    -   Selected State
    -   Logout State

Commands :
    In Any state :
        CAPABILITY, NOOP, LOGOUT
    Non Authenticated State :
        STARTTLS, AUTHENTICATE and LOGIN
    Authenticated State:
    SELECT, EXAMINE, CREATE, DELETE, RENAME, SUBSCRIBE, UNSUBSCRIBE, LIST, LSUB, STATUS, APPEND
