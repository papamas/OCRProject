/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyekOCR.springmvc.service;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import com.proyekOCR.springmvc.util.FileOCRHelper;

/**
 *
 * @author Nur Muhamad
 */
public class OCRServiceImpl implements OCRService {
    private String X1;
    private String Y1;
    private String width;
    private String height;
    private String ImageId;
    private String ocrResult;
    private String path;
    private boolean deskew = false; 
      
    
    public String getPath(){
        return path;
    }
    
    public void setPath(String path){
        this.path = path;
    }
    
    public boolean isDeskew(){
        return deskew;
    }
    
    public void setDeskew(boolean deskew){
        this.deskew = deskew;
    }
    
    public void setocrResult(String ocrResult){
        this.ocrResult = ocrResult;
    }
    
    public String getocrResult () throws TesseractException{
        
        File imageFile = new File(path, this.getImageId());
       
        int x   = (int) Double.parseDouble(X1);
        int y   = (int) Double.parseDouble(Y1);
        int w   = (int) Double.parseDouble(width);
        int h   = (int) Double.parseDouble(height);
        
        //org.apache.log4j.PropertyConfigurator.configure("log4j.properties.txt"); // sets properties file for log4j
                
        Tesseract instance = Tesseract.getInstance();
        String result = null;
 
        try {
           
            if(isDeskew()){
                
                FileOCRHelper  helper = new FileOCRHelper();
                BufferedImage bi = helper.fixSkewImage(imageFile);
                result = instance.doOCR(bi,new Rectangle(x, y, w, h));                
            }else{
                
                result = instance.doOCR(imageFile,new Rectangle(x, y, w, h));
            }
                
            
        } catch (IOException e) {
            result = e.getMessage();
            
        }
        
        ocrResult = result;
        return ocrResult;
    }
    
    @Override
    public String getX1() {
        return X1;
    }

    @Override
    public void setX1(String X1) {
        this.X1 = X1;
    }

    @Override
    public String getY1() {
       return Y1;
    }

    @Override
    public void setY1(String Y1) {
       this.Y1 = Y1;
    }
    
   
    @Override
    public String getWidth() {
        return width;
    }

    @Override
    public void setWidth(String width) {
        this.width = width;
    }

    @Override
    public String getHeight() {
        return height;
    }

    @Override
    public void setHeight(String height) {
        this.height = height;
    }

    @Override
    public String getImageId() {
       return ImageId;
    }

    @Override
    public void setImageId(String ImageId) {
        this.ImageId = ImageId;
    }
    
  
    
}
