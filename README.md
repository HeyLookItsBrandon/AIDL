AIDL Example
============

This project is a simple example of an AIDL service and a client app.

The `service-app` module is an application that provides a `Service` and has no UI of its own. _To
deploy it from Android Studio, edit the run/debug configuration and under Launch Options, change
"Launch" from "Default Activity" to "Nothing."_

The `client-app` module defines an `Activity` that binds to the service, calls one of the methods
defined in its interface and displays the value returned.

The `service-artifacts` module defines the service's interface as an AIDL file. It is defined
in a separate module so that its contents (the AIDL file) will be accessible from both the client
and service modules.
