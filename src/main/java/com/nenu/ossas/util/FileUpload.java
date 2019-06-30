package com.nenu.ossas.util;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Component
public class FileUpload {

    public File updateFile(MultipartFile multipartFile, String URL, String fileName){

        if (multipartFile.isEmpty()){
            return null;
        }

        String fileOriginalName = multipartFile.getOriginalFilename();
        String suffixName = fileOriginalName.substring(fileOriginalName.lastIndexOf("."));
        fileName = fileName + suffixName;
        File file = new File(URL,fileName);
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }

        try{
            multipartFile.transferTo(file);
        }catch (Exception e){
            e.printStackTrace();
        }
        return file;
    }
}
