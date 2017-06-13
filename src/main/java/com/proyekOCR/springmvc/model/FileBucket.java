package com.proyekOCR.springmvc.model;

import java.io.Serializable;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;



public class FileBucket implements Serializable{
    
        private static final long serialVersionUID = 1L;
        
        private MultipartFile file;
        
        @NotEmpty
	private String templateName;
       
        private boolean active = true;
        
        @NotEmpty
        private String instansi;
        
        
        public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
        
        public String getTemplateName(){
            return templateName;
        }
        
        public void setTemplateName(String templateName){
            this.templateName = templateName;
        }
        
        public boolean isActive(){
            return active;
        }
        
        public void setActive(boolean active){
            this.active = active;
        }
        
        public String getInstansi(){
            return instansi;
        }
        
        public void setInstansi(String instansi){
            this.instansi = instansi;
        }
        
        @Override
        public String toString(){
            return "[ templateName " + templateName  +  "]";
        }
        
       
        
}
