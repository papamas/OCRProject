/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyekOCR.springmvc.model;

import java.io.Serializable;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Nur Muhamad
 */
public class KeyInstansi implements Serializable{
    
    private static final long serialVersionUID = 1L;
        
    @NotEmpty
    private String namaInstansi;
    
    @NotEmpty
    private String namaKeyword;
       
    public String getnamaInstansi(){
        return namaInstansi;
    }
    
    public void setnamaInstansi(String namaInstansi){
        this.namaInstansi = namaInstansi;
    }
    
    public String getnamaKeyword(){
        return namaKeyword;
    }
    
    public void setnamaKeyword(String namaKeyword){
        this.namaKeyword = namaKeyword;
    }
}