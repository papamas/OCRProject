package com.proyekOCR.springmvc.util;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.proyekOCR.springmvc.model.FileBucket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



@Component
public class FileValidator implements Validator {
		
	private Pattern pattern;
        private Matcher matcher;
        private static final String IMAGE_PATTERN =
                "([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)";
        
        public FileValidator(){
	  pattern = Pattern.compile(IMAGE_PATTERN);
        }


   
        public boolean supports(Class<?> clazz) {
            return FileBucket.class.isAssignableFrom(clazz);
	}

	public void validate(Object obj, Errors errors) {
		FileBucket file = (FileBucket) obj;
			
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
                
                if("NONE".equals(file.getTemplateName())){
                        
                    errors.rejectValue("templateName", "required.templateName");
                }
                
                if("NONE".equals(file.getInstansi())){
                        
                    errors.rejectValue("instansi", "required.instansi");
                }     
                
	}
        
        /**
        * Validate image with regular expression
        * @param image image for validation
        * @return true valid image, false invalid image
        */
        public boolean validateFile(final String image){

               matcher = pattern.matcher(image);
               return matcher.matches();

        }
}

