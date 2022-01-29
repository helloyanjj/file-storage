package com.goldwind.ep.filestorage.util;

import com.goldwind.ep.filestorage.FileStorageApplication;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.SftpATTRS;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = FileStorageApplication.class)
class SFTPUtilTest {

    private SFTPUtil sftpUtil = new SFTPUtil("yjj2", "123456", "172.28.16.1", 22);

    {
        sftpUtil.login();
    }

    @Test
    void login() {
        sftpUtil.login();
    }

    @Test
    void logout() {
        sftpUtil.logout();
    }

    @Test
    void upload() throws Exception{
        File file = new File("D:\\put\\ep.png");
        InputStream is = new FileInputStream(file);
        sftpUtil.upload("/", "/s", "6.png", is);
        logout();
    }

    @Test
    void download() throws Exception{
        sftpUtil.download("/s", "6.png", "D:\\download\\8.png");
        logout();
    }

    @Test
    void testDownload() {
    }

    @Test
    void delete() {
    }

    @Test
    void listFiles() throws Exception{
        System.out.println(sftpUtil.listFiles("/"));
        Vector<?> files = sftpUtil.listFiles("/");
        for (Object f : files) {
            ChannelSftp.LsEntry entry = (ChannelSftp.LsEntry) f;
            System.out.println(entry.getFilename());
            System.out.println(entry.getLongname());
            SftpATTRS sftpATTRS = entry.getAttrs();
        }
    }
}