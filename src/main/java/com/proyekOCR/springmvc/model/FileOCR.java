/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyekOCR.springmvc.model;

import java.io.Serializable;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Nur Muhamad
 */
public class FileOCR implements Serializable{
    
    private static final long serialVersionUID = 1L;
        
    private MultipartFile file;
    private boolean fixSkew = true;
    
    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
            this.file = file;
    }
    
    public boolean isFixSkew(){
        return fixSkew;
    }
    
    public void setfixSkew(boolean fix){
        this.fixSkew = fix;
    }
}
