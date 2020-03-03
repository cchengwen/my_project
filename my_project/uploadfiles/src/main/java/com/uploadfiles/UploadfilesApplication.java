package com.uploadfiles;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.uploadfiles.mapper")
public class UploadfilesApplication {

    public static void main(String[] args) {
        SpringApplication.run(UploadfilesApplication.class, args);
    }

}
