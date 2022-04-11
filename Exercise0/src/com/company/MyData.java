package com.company;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class MyData {
    public static void info() {


        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println("yyyy/MM/dd HH:mm:ss-> "+dtf.format(LocalDateTime.now()));

        System.out.println("Data: " + Lab2.name + ", " + Lab2.ID);

        System.out.println("User Name: " + System.getProperty("user.name"));

        System.out.println("Operating System Name: " + System.getProperty("os.name"));

        System.out.println("Version: " + System.getProperty("java.runtime.version"));

        InetAddress ip;
        try {
            ip = InetAddress.getLocalHost();
            System.out.println("Ip Address:" + ip);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}