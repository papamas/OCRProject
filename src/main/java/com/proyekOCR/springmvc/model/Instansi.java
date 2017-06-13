/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyekOCR.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Nur Muhamad
 */
@Entity
@Table(name="INSTANSI")
public class Instansi {    
    
    
    @Id
    @Column(name="KODE_INSTANSI")
    private String kodeInstansi;
    
    @Column(name="NAMA")    
    private String namaInstansi;
    
    

    public String getKodeInstansi() {
        return kodeInstansi;
    }

    public void setKodeInstansi(String kodeInstansi) {
        this.kodeInstansi = kodeInstansi;
    }
    
    public String getkodeInstansi() {
        return kodeInstansi;
    }

    public void setkodeInstansi(String kodeInstansi) {
        this.kodeInstansi = kodeInstansi;
    }
    
    public String getNamaInstansi(){
        return this.namaInstansi;        
    }
    
    public void setNamaInstansi(String namaInstansi){
        this.namaInstansi = namaInstansi;
    }
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kodeInstansi == null) ? 0 : kodeInstansi.hashCode());
		result = prime * result + ((namaInstansi== null) ? 0 : namaInstansi.hashCode());
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
		Instansi other = (Instansi) obj;
		if (kodeInstansi == null) {
			if (other.kodeInstansi != null)
				return false;
		} else if (!kodeInstansi.equals(other.kodeInstansi))
			return false;
		if (namaInstansi == null) {
			if (other.namaInstansi != null)
				return false;
		} else if (!namaInstansi.equals(other.namaInstansi))
			return false;
		return true;
	}
    
    
}
