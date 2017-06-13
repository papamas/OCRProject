/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyekOCR.springmvc.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
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
@Table(name="KEYWORD_INSTANSI")
public class KeywordInstansi  implements Serializable {
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @NotEmpty
    @Column(name="NAMA_KEYWORD",nullable=false)
    private String namaKeyword;

    
    @ManyToOne(optional = false)
    @JoinColumn(name = "USER_ID",nullable=false)
    private User user;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "KODE_INSTANSI",nullable=false)
    private Instansi instansi;
    
    
    public Integer getId(){
            return id;
    }

    public void setId(Integer id){
        this.id = id;
    }
    
    public String getNamaKeyword(){
            return namaKeyword;
    }

    public void setNamaKeyword(String nama){
        this.namaKeyword = nama;
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
    
    
    @Override
    public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((id == null) ? 0 : id.hashCode());
            result = prime * result + ((namaKeyword == null) ? 0 : namaKeyword.hashCode());
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
            KeywordInstansi other = (KeywordInstansi) obj;
            if (id == null) {
                    if (other.id != null)
                            return false;
            } else if (!id.equals(other.id))
                    return false;
            if (namaKeyword == null) {
                    if (other.namaKeyword != null)
                            return false;
            } else if (!namaKeyword.equals(other.namaKeyword))
                    return false;
            return true;
    }

    @Override
    public String toString() {
            return "Keyword Instansi [id=" 
                    + id + ", nama=" + namaKeyword
                    + " , user=" + user 
                    + "]";
    }


    
}
