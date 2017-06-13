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
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Nur Muhamad
 */
  
@Entity
@Table(name="TEMPLATE_CORDINATE")
public class TemplateCordinate implements Serializable{
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

      
    @NotEmpty
    @Column(name="NAME", nullable=false)
    private String name;


    @NotNull
    @Column(name="HEIGHT", nullable=false)
    private double height;
    
    @NotNull
    @Column(name="WIDTH", nullable=false)
    private double width;

    @NotNull    
    @Column(name="X1", nullable=false)
    private double X1;  
    
    @NotNull    
    @Column(name="Y1", nullable=false)
    private double Y1;
    
    @NotNull    
    @Column(name="X2", nullable=false)
    private double X2;  
    
    @NotNull   
    @Column(name="Y2", nullable=false)
    private double Y2;  
    

    @ManyToOne(optional = false)
    @JoinColumn(name = "USER_ID")
    private User user;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "TEMPLATE_ID")
    private Template template;
   
    
    public Integer getId(){
            return id;
    }

    public void setId(Integer id){
        this.id = id;
    }
    
    public Template getTemplate(){
            return template;
    }

    public void setTemplate(Template template){
        this.template = template;
    }
    
    public String getName(){
            return name;
    }

    public void setName(String name){
        this.name = name;
    }
    
    public double getHeight(){
            return height;
    }

    public void setHeight(double height){
        this.height = height;
    }

    public double getWidth(){
        return width;
    }
        
    public void setWidth(double width){
        this.width = width;
    }
    
    public double getX1(){
        return X1;
    }
        
    public void setX1(double X1){
        this.X1 = X1;
    }
    
    
    public double getY1(){
        return Y1;
    }
        
    public void setY1(double Y1){
        this.Y1 = Y1;
    }
    
    public double getX2(){
        return X2;
    }
        
    public void setX2(double X2){
        this.X2 = X2;
    }
    
    public double getY2(){
        return Y2;
    }
        
    public void setY2(double Y2){
        this.Y2 = Y2;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }
    
    
    
    
    @Override
    public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((id == null) ? 0 : id.hashCode());
            //result = prime * result + ((templateName == null) ? 0 : templateName.hashCode());
            return result;
    }
    
    @Override
    public boolean equals(Object obj) {
            if (this == obj)
                    return true;
            if (obj == null)
                    return false;
            if (!(obj instanceof TemplateCordinate))
                    return false;
            TemplateCordinate other = (TemplateCordinate) obj;
            if (id == null) {
                    if (other.id != null)
                            return false;
            } else if (!id.equals(other.id))
                    return false;
            /*
            if (templateName == null) {
                    if (other.templateName != null)
                            return false;
            } else if (!templateName.equals(other.templateName))
                    return false;
            */
            return true;
    }

    @Override
    public String toString() {
        
        return "Template Cordinate"
                + " [Height=" + height + ","
                + " Width=" + width + ","
                + " X1=" + X1 + " ,"
                + " Y1=" + Y1 + " ,"
                + " X2=" + X2 + " ,"
                + " Y2=" + Y2 + " ,"
                + " Template=" + template.toString() + " ,"
                + " user=" + user.toString() + "]";
    }


    
}
