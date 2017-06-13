/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyekOCR.Tesseract;


import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.Tesseract1;
import net.sourceforge.tess4j.TesseractException;

/**
 *
 * @author Nur Muhamad
 */
public class TesseractExample {
    
    public static void main(String[] args) {
        
        org.apache.log4j.PropertyConfigurator.configure("log4j.properties.txt"); // sets properties file for log4j
                
        File imageFile = new File("samples/eurotext.pdf");
       
        //System.out.println(System.getProperty("sun.arch.data.model"));
        Tesseract1 instance = new Tesseract1();
        
        try {
            String result = instance.doOCR(imageFile);
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }        
    }  

    
}
