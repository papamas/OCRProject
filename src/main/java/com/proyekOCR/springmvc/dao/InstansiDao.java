/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyekOCR.springmvc.dao;
import com.proyekOCR.springmvc.model.Instansi;
import java.util.List;

/**
 *
 * @author Nur Muhamad
 */
public interface InstansiDao {
    
    List<Instansi> findAll();
    Instansi findByKode(String kode);
    
}
