package com.jtemp.test.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.TimeUnit;

public class UDPClient {

    public static void main(String[] args) {

        try {
            DatagramSocket socket = new DatagramSocket();

            String send = "abcdefghijklmnopqrstuvwxyz123";
            byte[] data = send.getBytes();

            DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 8080);
            socket.send(packet);

            TimeUnit.SECONDS.sleep(1);
            socket.close();
            System.out.println("client closed");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
