/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyekOCR.springmvc.dao;

import com.proyekOCR.springmvc.model.KeywordInstansi;
import com.proyekOCR.springmvc.model.Template;
import java.util.List;

/**
 *
 * @author Nur Muhamad
 */
public interface KeywordInstansiDao {
    void save(KeywordInstansi keyword);    
    List<KeywordInstansi> findAll();    
    KeywordInstansi find(int id);    
    void delete(int id);
    
}
