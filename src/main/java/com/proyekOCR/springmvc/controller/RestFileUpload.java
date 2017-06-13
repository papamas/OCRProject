/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyekOCR.springmvc.controller;

import com.proyekOCR.springmvc.model.RestFileInfo;
import java.io.File;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Nur Muhamad
 */
@RestController
@RequestMapping("/api/")

public class RestFileUpload {
    
    @Autowired
    ServletContext context;

    @RequestMapping(value = "/fileupload", headers=("content-type=multipart/*"), 
        method = RequestMethod.POST)
    public ResponseEntity<RestFileInfo> upload(@RequestParam("file") MultipartFile inputFile) {
        
        RestFileInfo fileInfo = new RestFileInfo();
        HttpHeaders headers = new HttpHeaders();
        if (!inputFile.isEmpty()) {
            try {
                String originalFilename = inputFile.getOriginalFilename();
                File destinationFile = new File(context.getRealPath("/static/file-bucket/original")+ 
                        File.separator + originalFilename);
                /*
                inputFile.transferTo(destinationFile);
                fileInfo.setFileName(destinationFile.getPath());
                fileInfo.setFileSize(inputFile.getSize());
                */
                FileCopyUtils.copy(inputFile.getBytes(),destinationFile);
                headers.add("Message", "Upload Successfully");
                return new ResponseEntity<>(fileInfo, headers, HttpStatus.OK);
                
            } catch (Exception e) {    

                return new ResponseEntity<RestFileInfo>(HttpStatus.BAD_REQUEST);
            }
        }else{
   
            return new ResponseEntity<RestFileInfo>(HttpStatus.BAD_REQUEST);
        }
    }
    
}
