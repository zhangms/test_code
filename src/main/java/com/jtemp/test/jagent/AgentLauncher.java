package com.jtemp.test.jagent;

import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

import java.util.List;

public class AgentLauncher {

    public static void main(String[] args) {
        try {
            String javaPid = "";
            AgentLauncher launcher = new AgentLauncher();
            launcher.attachAgent(javaPid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void attachAgent(String javaPid) throws Exception {
        List<VirtualMachineDescriptor> descriptors = VirtualMachine.list();
        VirtualMachineDescriptor descriptor = null;
        for (VirtualMachineDescriptor virtualMachineDescriptor : descriptors) {
            if (virtualMachineDescriptor.id().equals(javaPid)) {
                descriptor = virtualMachineDescriptor;
            }
        }
        VirtualMachine virtualMachine = null;
        try {
            if (descriptor == null) {
                virtualMachine = VirtualMachine.attach(javaPid);
            } else {
                virtualMachine = VirtualMachine.attach(descriptor);
            }
        } finally {
            if (virtualMachine != null) {
                virtualMachine.detach();
            }
        }
    }

}
