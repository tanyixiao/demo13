package com.example.goods.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Controller
@RequestMapping("/color")
public class colorController {
    private final String File_Path="E:/vuefile/demo/demo13/img/";
    @RequestMapping("/img")
    public @ResponseBody String img(@RequestParam("file") MultipartFile file) throws IOException {
        String s = File_Path + file.getOriginalFilename();
        File file1 = new File(s);
        file.transferTo(file1);
        return s;
    }
    @RequestMapping("/deleteFile")
    public @ResponseBody String deleteFile(@RequestParam("file") String file) throws IOException{
        File file1 = new File(file);
        if (file1.exists()) {
            if (file1.delete()){
                return "200";
            }else {
                return "400";
            }
        }else {
            return "400";
        }
    }
    @RequestMapping("/addImg")
    public @ResponseBody String deleteFile(@RequestParam("file") MultipartFile file) throws IOException{
        String s = File_Path + file.getOriginalFilename();
//        byte[] bytes = file.getBytes();
//        FileOutputStream stream = new FileOutputStream("E:\\vuefile\\demo\\demo13\\img.jpg");
//        stream.write(bytes);
        File file1 = new File(s);
        file.transferTo(file1);
        return s;
    }
}
