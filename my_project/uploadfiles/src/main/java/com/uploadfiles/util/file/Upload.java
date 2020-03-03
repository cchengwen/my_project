package com.uploadfiles.util.file;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

@Log4j2
public class Upload {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public String uploadFile(MultipartFile file, String path) {
        try {
            File file1 = new File("");
            //  获取项目目录根路径 如：E:\my_project_demo\my_project
            String projectUrl = file1.getCanonicalPath() + path;
            log.info("完整路径： " + projectUrl);

            //  完整路径
            String floderPath = projectUrl + sdf.format(new Date());
            log.info("图片目录路径 ：" + floderPath);

            //  根据日期创建文件夹（根据完整路径创建）
            File floder = new File(floderPath);
            log.info("文件：" + floder);

            if (!floder.exists()) {
                floder.mkdir();
                log.info("文件名不存在，已为您创建文件为：" + floder.getName());
            }

            String oldName = file.getOriginalFilename();
            log.info("旧文件名：" + oldName);
            String newName = new Date().getTime() + oldName.substring(oldName.lastIndexOf("."));
            log.info("新文件名：" + newName);

            // 写入文件
            file.transferTo(new File(floder, newName));
            return floderPath + "\\" + newName;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}
