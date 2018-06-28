package com.jtemp.test.jssh;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class Ssh {

    String host;
    int port;
    String username;
    String password;

    Session session;

    public Ssh(String host, int port, String username, String password) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    public void connect() throws JSchException {
        JSch jSch = new JSch();
        session = jSch.getSession(username, host, port);
        session.setConfig("StrictHostKeyChecking", "no");
        session.setPassword(password);
        session.connect(3000);
    }

    public void execCommand(String cmd) throws JSchException, IOException {
        if (session == null || !session.isConnected()) {
            throw new RuntimeException("session not connected");
        }
        ChannelExec channelExec = (ChannelExec) session.openChannel("exec");
        channelExec.setCommand(cmd);
        channelExec.connect(3000);

        InputStream in = channelExec.getErrStream();
        while (true) {
            if (in.available() > 0) {
                byte[] data = IOUtils.toByteArray(in);
                System.out.println(new String(data));
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
