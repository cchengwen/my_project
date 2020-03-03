package com.uploadfiles.mapper;

import com.uploadfiles.pojo.Files;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FilesMapper {

    @Insert("INSERT INTO files(img_url) VALUES(#{imgURL})")
    void insert(String imgUrl);

    @Select("SELECT id, img_url AS imgUrl FROM files")
    List<Files> selectAll();




}
