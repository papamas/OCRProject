/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyekOCR.springmvc.service;
import com.proyekOCR.springmvc.service.OCRFullPageService;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

/**
 *
 * @author Nur Muhamad
 */
public class OCRFullPageServiceImpl implements OCRFullPageService{

    private String ImageId;
    private String ocrResult;
    private String path;
    
    @Override
    public String getImageId() {
        return ImageId;
    }

    @Override
    public void setImageId(String ImageId) {
        this.ImageId = ImageId;
    }
    
    public String getPath(){
        return path;
    }
    
    public void setPath(String path){
        this.path = path;
    }
    
    
    public void setocrResult(String ocrResult){
        this.ocrResult = ocrResult;
    }
    
    public String getocrResult () throws TesseractException{
        
        File imageFile = new File(path, this.getImageId());
                
        Tesseract instance = Tesseract.getInstance();
        String result = null;
 
        result = instance.doOCR(imageFile);
        
        ocrResult = result;
        return ocrResult;
    }
    
}
