package com.goldwind.ep.filestorage.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SFTPController {


    @RequestMapping(path = {"/helloSpringBoot"})
    public String HelloSpring (){


        return ("hello sftp");
    }
}
