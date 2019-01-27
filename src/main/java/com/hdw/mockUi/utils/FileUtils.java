package com.hdw.mockUi.utils;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


public class FileUtils {
    public static  String getStreamFromFile(String fliePath){
       InputStream inputStream =  FileUtils.class.getClassLoader().getResourceAsStream(fliePath);
        String jsonStr = null;
        try {
            jsonStr = IOUtils.toString(inputStream,"utf8");
            System.out.print(jsonStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }
}
