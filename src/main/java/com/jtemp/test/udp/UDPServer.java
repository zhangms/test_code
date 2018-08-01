package com.jtemp.test.udp;


import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {

    public static void main(String[] args) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket(8080);

            byte[] data = new byte[30];
            DatagramPacket packet = new DatagramPacket(data, data.length);
            while (true) {
                datagramSocket.receive(packet);
                byte[] recv = packet.getData();
                System.out.println(String.format("received from %s:%s %s", packet.getAddress(), packet.getPort(), new String(recv, 0, packet.getLength())));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
