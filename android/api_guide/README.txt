App components:
    1.  Activities
        -   Intent          -   startActivity / startActivityForResult
        -   manifest        -   required    -   <activity>

    2.  Services
        -   explicit Intent -   JobScheduler / startService / stopService
        -   manifest        -   required    -   <service>
        -   we should not declare intent filters

    3.  Broadcast receivers
        -   Intent          -   sendBroadcast / sendOrderedBroadcast / sendStickyBroadcast
        -   manifest        -   optional    -   <receiver>
                            -   can be created dynamically in code as BroadcastReceiver -   registerReceiver

    4.  Content providers
        -   ContentResolver -   query
        -   manifest        -   required    -   <provider>
