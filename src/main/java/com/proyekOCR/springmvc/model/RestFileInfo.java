/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyekOCR.springmvc.model;

/**
 *
 * @author Nur Muhamad
 */
public class RestFileInfo {
    
    private String fileName;
    private long fileSize;

    public String getFileName() {
     return fileName;
    }

    public void setFileName(String fileName) {
     this.fileName = fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }
    
}
