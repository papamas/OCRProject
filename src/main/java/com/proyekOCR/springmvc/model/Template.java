/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyekOCR.springmvc.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Nur Muhamad
 */
@Entity
@Table(name="TEMPLATE",
uniqueConstraints=@UniqueConstraint(columnNames={"TEMPLATE_NAME", "KODE_INSTANSI"}))
public class Template implements Serializable{
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    @Column(name="TEMPLATE_NAME", unique=true, nullable=false)
    private String templateName;

    @NotEmpty
    @Column(name="FILE_NAME", unique=true, nullable=false)
    private String fileName;
    
    @Column(name="TYPE", length=100, nullable=false)
    private String type;

        
    @Column(name="ACTIVE")
    private boolean active;  
    

    @ManyToOne(optional = false)
    @JoinColumn(name = "USER_ID")
    private User user;
    
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "KODE_INSTANSI")
    private Instansi instansi;
    
    
    
    
    public Integer getId(){
            return id;
    }

    public void setId(Integer id){
        this.id = id;
    }
    
    public String getTemplateName(){
            return templateName;
    }

    public void setTemplateName(String templateName){
        this.templateName = templateName;
    }

    public String getFileName(){
        return fileName;
    }
        
    public void setFileName(String fileName){
        this.fileName = fileName;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }
    
    public Instansi getInstansi(){
        return instansi;
    }
    
    public void setInstansi(Instansi instansi){
        this.instansi = instansi;
    }
    
    public boolean isActive(){
        return active;
    }
    
    public void setActive(boolean active){
        this.active = active;
    }
    
    public String getType() {
	return type;
    }

    public void setType(String type) {
	this.type = type;
    }

    
    @Override
    public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((id == null) ? 0 : id.hashCode());
            result = prime * result + ((templateName == null) ? 0 : templateName.hashCode());
            return result;
    }
    
    @Override
    public boolean equals(Object obj) {
            if (this == obj)
                    return true;
            if (obj == null)
                    return false;
            if (!(obj instanceof Template))
                    return false;
            Template other = (Template) obj;
            if (id == null) {
                    if (other.id != null)
                            return false;
            } else if (!id.equals(other.id))
                    return false;
            if (templateName == null) {
                    if (other.templateName != null)
                            return false;
            } else if (!templateName.equals(other.templateName))
                    return false;
            return true;
    }

    @Override
    public String toString() {
            return "Template [id=" 
                    + id + ", templateName=" + templateName
                    + " , fileName=" + fileName 
                    + " , user=" + user 
                    + " , type=" + type
                    + " , instansi=" + instansi
                    + " , active=" + active
                    + "]";
    }



    
}
