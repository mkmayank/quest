IP addresses
    -   32 bit number ( Ipv4 )

        4 bytes ( 4 * 8 ) 32 bit

        2^8 . 2^8 . 2^8 . 2^8
        0-255 . 0-255 . 0-255 . 0-255

======================

    -   Each ip address is divide into
        network number portion . host number portion

Classfull address (1981)
Classless Inter-Domain Routing (1993)

======================

Classfull address
    class A -   leading bits 0  -   size of nw 2^7 ( first 8 bits )     -   CIDR /8

        start     0.  0.  0.  0 =   00000000.00000000.00000000.00000000
        end     127.255.255.255 =   01111111.11111111.11111111.11111111
                                    0nnnnnnn.HHHHHHHH.HHHHHHHH.HHHHHHHH

    class B -   leading bits 10 -   size of nw 2^14 ( first 16 bits )   -   CIDR /16

        start   128.  0.  0.  0 =   10000000.00000000.00000000.00000000
        end     191.255.255.255 =   10111111.11111111.11111111.11111111
                                    10nnnnnn.nnnnnnnn.HHHHHHHH.HHHHHHHH

    class C -   leading bits 110 -  size of nw 2^21 ( first 24 bits )   -   CIDR /24

        start   192.  0.  0.  0 =   11000000.00000000.00000000.00000000
        end     223.255.255.255 =   11011111.11111111.11111111.11111111
                                    110nnnnn.nnnnnnnn.nnnnnnnn.HHHHHHHH

    class D -   leading bits 1110   -   special

        start   224.  0.  0.  0 =   11100000.00000000.00000000.00000000
        end     239.255.255.255 =   11101111.11111111.11111111.11111111
                                    1110XXXX.XXXXXXXX.XXXXXXXX.XXXXXXXX

    class E -   leading bits 1111   -   special

        start   240.  0.  0.  0 =   11110000.00000000.00000000.00000000
        end     255.255.255.255 =   11111111.11111111.11111111.11111111
                                    1111XXXX.XXXXXXXX.XXXXXXXX.XXXXXXXX

    starting and ending address are reserved in every class

======================

private address space

    24-bit block    -   single class A network

        start   10.  0.  0.  0 =   00001010.00000000.00000000.00000000
        end     10.255.255.255 =   00001010.11111111.11111111.11111111

    20-bit block    -   16 contiguous class B networks

        start   172. 16.  0.  0 =   10101100.00010000.00000000.00000000
        end     172. 31.255.255 =   10101100.00011111.11111111.11111111

    16-bit block    -   256 contiguous class C networks

        start   192.168.  0.  0 =   11000000.10101000.00000000.00000000
        end     192.168.255.255 =   11000000.10101000.11111111.11111111

======================
CIDR
