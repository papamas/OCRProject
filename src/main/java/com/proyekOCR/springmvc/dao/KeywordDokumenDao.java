/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyekOCR.springmvc.dao;

import com.proyekOCR.springmvc.model.KeywordDokumen;
import java.util.List;

/**
 *
 * @author Nur Muhamad
 */
public interface KeywordDokumenDao {
    void save(KeywordDokumen keyword);    
    List<KeywordDokumen> findAll();    
    KeywordDokumen find(int id);    
    void delete(int id);
    
}
