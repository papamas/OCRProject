/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyekOCR.springmvc.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Nur Muhamad
 */
@Entity
@Table(name="FILE_BUCKET")
public class Laporan implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;    
        
    
    @Column(name="ORIGINAL_FILE_NAME",nullable=false)
    private String originalFile;
    
    @Column(name="ANALIS_FILE_NAME")
    private String analisFile;
        
    @Column(name="DMS_FILE_NAME")
    private String dmsFile;
    
    @Column(name="JENIS_DOC")
    private String jenisDoc;

    @NotEmpty
    @Column(name="INSTANSI")
    private String instansi;

    @Column(name="NIP")
    private String nip;
    
    @NotEmpty       
    @Column(name="STATUS")
    private String status;
    
    @DateTimeFormat(pattern="dd/MM/yyyy") 
    @Past @NotNull
    @Column(name="CREATED_DATE")    
    private Date createdDate;
    
    
    @DateTimeFormat(pattern="dd/MM/yyyy") 
    @Past @NotNull
    @Column(name="UPDATE_DATE")
    private Date updateDate;
    
    public Integer getId(){
            return id;
    }

    public void setId(Integer id){
        this.id = id;
    }
    
    public String getOriginalFile(){
            return originalFile;
    }

    public void setOriginalFile(String originalFile){
        this.originalFile = originalFile;
    }
    
    public String getAnalisFile(){
            return analisFile;
    }

    public void setAnalisFile(String analisFile){
        this.analisFile = analisFile;
    }
    
    public String getdmsFile(){
            return dmsFile;
    }

    public void setdmsFile(String dmsFile){
        this.dmsFile = dmsFile;
    }
    
    public String getJenisDoc(){
            return jenisDoc;
    }

    public void setJenisDoc(String jenisDoc){
        this.jenisDoc = jenisDoc;
    }
    
    public String getInstansi(){
            return instansi;
    }

    public void setInstansi(String instansi){
        this.instansi = instansi;
    }
    
    public String getNip(){
            return nip;
    }

    public void setNip(String nip){
        this.nip = nip;
    }
    
    public String getStatus(){
            return status;
    }

    public void setStatus(String status){
        this.status = status;
    }
    
    public Date getCreatedDate(){
            return createdDate;
    }

    public void setCreatedDate(Date createdDate){
        this.createdDate = createdDate;
    }
    
    public Date getUpdateDate(){
            return updateDate;
    }

    public void setUpdateDate(Date updateDate){
        this.updateDate = updateDate;
    }
    
}
