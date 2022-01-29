package com.goldwind.ep.filestorage.util;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.xfer.FileSystemFile;

import java.io.File;

public class SSHJUtil {


    public static void main(String[] args) throws Exception{
        SSHClient ssh = new SSHClient();
        ssh.loadKnownHosts();
        ssh.connect("172.28.16.1");
        try {
            ssh.authPublickey(System.getProperty("yjj2"));

            // Present here to demo algorithm renegotiation - could have just put this before connect()
            // Make sure JZlib is in classpath for this to work
            ssh.useCompression();

            final String src = System.getProperty("user.home") + File.separator + "test_file";
            ssh.newSCPFileTransfer().upload(new FileSystemFile(src), "/tmp/");
        } finally {
            ssh.disconnect();
        }
    }
}
