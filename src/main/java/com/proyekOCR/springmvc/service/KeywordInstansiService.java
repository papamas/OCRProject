/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyekOCR.springmvc.service;
import java.util.List;
import com.proyekOCR.springmvc.model.KeywordInstansi;

/**
 *
 * @author Nur Muhamad
 */
public interface KeywordInstansiService {
    
    void save(KeywordInstansi keyword);    
    List<KeywordInstansi> findAll();    
    KeywordInstansi findById(int id);    
    void delete(int id);
    public void update(KeywordInstansi keyword);    
    
    
}
