package edu.princeton.cs.exercise;

import edu.princeton.cs.algs4.StdOut;

import java.net.InetAddress;
import java.net.URL;

public class DNS {
    private static int parsePort(String href) throws Exception {
        URL url = new URL(href);
        int port = url.getPort();
        if (port < 0)
        {
            port = url.getDefaultPort();
        }

        return port;
    }

    public static String parseHostIp(String href) throws Exception {
        URL url = new URL(href);
        String host = url.getHost();
        InetAddress inetAddress = InetAddress.getByName(host);
        return "port: " + parsePort(href) +
                "\n" + "host: " + host +
                "\n" + "ip: " + inetAddress.getHostAddress();
    }

    public static void main(String[] args) throws Exception {
        //String href = "http://www.baidu.com";
        String href = "https://blog.csdn.net/renfufei/article/details/78722127";
        StdOut.println(parseHostIp(href));
    }

}
