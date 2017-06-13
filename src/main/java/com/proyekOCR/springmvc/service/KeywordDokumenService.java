/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyekOCR.springmvc.service;
import com.proyekOCR.springmvc.model.KeywordDokumen;
import java.util.List;

/**
 *
 * @author Nur Muhamad
 */
public interface KeywordDokumenService {
    
    void save(KeywordDokumen keyword);    
    List<KeywordDokumen> findAll();    
    KeywordDokumen findById(int id);    
    void delete(int id);
    void update(KeywordDokumen keyword);    
    
    
}
