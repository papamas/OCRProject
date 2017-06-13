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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Nur Muhamad
 */
@Entity
@Table(name="FILE_BUCKET")
public class BucketFileList implements Serializable{
    
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

    @Column(name="INSTANSI")
    private String instansi;
    
    @ManyToOne(optional = true)
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column(name="NIP")
    private String nip;
    
    @NotEmpty       
    @Column(name="STATUS")
    private String status;
    
    @CreationTimestamp
    @Column(name="CREATED_DATE")    
    private Date createdDate;
    
    @UpdateTimestamp
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
    
    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
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
