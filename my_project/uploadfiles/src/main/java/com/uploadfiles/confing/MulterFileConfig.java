package com.uploadfiles.confing;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

/**
 *  图片上传配置类
 */
@Configuration
public class MulterFileConfig {

    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(DataSize.ofBytes(9000*9000)); // 最大文件上传
        factory.setMaxRequestSize(DataSize.ofBytes(9000*9000)); // 设置总上传数据总大小
        return factory.createMultipartConfig();
    }
}
