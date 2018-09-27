package com.qf.mytt.admin.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(value = "upload")
public class UploadController {

    private static String STATIC_UPLOAD = "static/upload/";

    @RequestMapping(value = "image", method = RequestMethod.POST)
    public Map<String, Object> image(MultipartFile dropFile, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        String filePath = fileUpload(dropFile, request);
        map.put("imageUrl", filePath);
        return map;
    }

    private String fileUpload(MultipartFile dropFile, HttpServletRequest request) {
        String uploadDir = STATIC_UPLOAD + UUID.randomUUID().toString();
        String realPath = request.getSession().getServletContext().getRealPath("/");
        File realFile = new File(realPath, uploadDir);
        if (!realFile.exists()) {
            realFile.mkdirs();
        }
        File file = new File(realFile, dropFile.getOriginalFilename());
        try {
            dropFile.transferTo(file);
            int serverPort = request.getServerPort();
            String scheme = request.getScheme();
            String serverName = request.getServerName();
            String name = String.format("%s://%s:%s/%s/%s", scheme, serverName, serverPort, uploadDir, dropFile.getOriginalFilename());
            return name;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
