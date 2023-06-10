package com.example.demo.utilities;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class DemoUtilities {

    public static String getHostName() {
        String hostname = "undefined";
        try {
            hostname = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            hostname = e.getClass().getName();
        }
        return hostname;
    }
}
