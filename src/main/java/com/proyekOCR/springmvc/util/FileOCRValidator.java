/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyekOCR.springmvc.util;

import com.proyekOCR.springmvc.model.FileOCR;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Nur Muhamad
 */
@Component
public class FileOCRValidator implements Validator{
    
    private Pattern pattern;
    private Matcher matcher;
    private static final String IMAGE_PATTERN =
            "([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)";

    public FileOCRValidator(){
      pattern = Pattern.compile(IMAGE_PATTERN);
    }

    @Override
    public boolean supports(Class<?> type) {
        return FileOCR.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        FileOCR file = (FileOCR) o;
        
        if(file.getFile()!=null){
			
            String fileName = file.getFile().getOriginalFilename().toLowerCase();

            boolean valid = this.validateFile(fileName);

            if (file.getFile().getSize() != 0) {
                if(!valid) {
                    errors.rejectValue("file", "notallow.file");
                }                               
            }
            else{
                errors.rejectValue("file", "missing.file");     
            }                

            //System.out.println(fileName);                
        }

    }
    
    public boolean validateFile(final String image){

        matcher = pattern.matcher(image);
        return matcher.matches();

     }
    
}
