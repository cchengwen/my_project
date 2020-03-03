package com.uploadfiles.service;

import com.uploadfiles.mapper.FilesMapper;
import com.uploadfiles.pojo.Files;
import com.uploadfiles.util.file.Upload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class FilesService {
    @Value("${files_url.upload_url}")
    private String path;

    @Autowired private FilesMapper filesMapper;


    public void upload(MultipartFile file){
        String url = new Upload().uploadFile(file, path);
        filesMapper.insert(url);
    }

    public List<Files> findAll(){
        List<Files> files = filesMapper.selectAll();
        System.out.println(files);
        return files;
    }
}
