/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyekOCR.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Nur Muhamad
 */
@Entity
@Table(name="JENIS_SK")
public class JenisSK {    
    
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @NotEmpty
    @Column(name="NAMA_SK",nullable=false)    
    private String namaSK;
    
    @NotEmpty
    @Column(name="ALIAS",nullable=false)    
    private String alias;    
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "USER_ID",nullable=false)
    private User user;
    
    
    public Integer getId(){
            return id;
    }

    public void setId(Integer id){
        this.id = id;
    }    

    public String getNamaSK() {
        return namaSK;
    }

    public void setNamaSK(String namaSK) {
        this.namaSK = namaSK;
    }
    
     public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
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
		result = prime * result + ((alias== null) ? 0 : alias.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Instansi))
			return false;
		JenisSK other = (JenisSK) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (alias == null) {
			if (other.alias != null)
				return false;
		} else if (!alias.equals(other.alias))
			return false;
		return true;
	}
    
    
}
