package cn.com.demo.ssm.web.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;

@Controller
@RequestMapping("/file")
public class DemoFileController {
    @RequestMapping("/upload")
    public void testUpload(@RequestParam("userName") String userName,
                           @RequestParam("myFile") MultipartFile uploadFile) throws Exception {
        System.out.println("userName--->" + userName);
        // 获取上传的文件名
        String fileName = uploadFile.getOriginalFilename();
        fileName = "e:/temp/upload/" + fileName;
        uploadFile.transferTo(new File(fileName));
    }

    @RequestMapping("/download")
    @ResponseBody
    public ResponseEntity<byte[]> testDownload(HttpSession session) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);// 下载内容
        // 默认文件名
        headers.setContentDispositionFormData("attachment", "mysql-connector-java-5.1.6.jar");
        byte[] bytes = FileUtils.readFileToByteArray(new File("e:/tmp/mysql-connector-java-5.1.6.jar"));
        ResponseEntity<byte[]> result = new ResponseEntity<byte[]>(bytes, headers, HttpStatus.CREATED);
        return result;
    }

    @RequestMapping("/verifyCode")
    @ResponseBody// <img src=".../verifyCode"/>
    public ResponseEntity<byte[]> testVerifyCode() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);// 下载内容
        byte[] bytes = null;//FileUtils.readFileToByteArray(new File("e:/tmp/mysql-connector-java-5.1.6.jar"));
        ResponseEntity<byte[]> result = new ResponseEntity<byte[]>(bytes, headers, HttpStatus.OK);
        return result;
    }
}
