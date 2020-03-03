package com.uploadfiles.controller;

import com.uploadfiles.pojo.Files;
import com.uploadfiles.resp.RespData;
import com.uploadfiles.service.FilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/upload")
public class FileController {

    @Autowired
    private FilesService filesService;

    @PostMapping("/files")
    public String uploadFiles(MultipartFile file){
        System.out.println("============  "+file.getSize());

        filesService.upload(file);
        return "success";
    }

    @GetMapping("/findAll")
    public RespData findAll(){
        List<Files> all = filesService.findAll();
        return RespData.success(200, all);
    }
}
