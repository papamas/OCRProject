/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyekOCR.springmvc.dao;

import com.proyekOCR.springmvc.model.TemplateCordinate;
import java.util.List;

/**
 *
 * @author Nur Muhamad
 */

public interface TemplateCordinateDao {
    
    void save(TemplateCordinate templateCordinate);
    
    List<TemplateCordinate> findAllById(int id);
    
    TemplateCordinate findById(int id);	
        
    void deleteById(int id);

    public List<TemplateCordinate> findAllByUserId(int userId);
    
    List<TemplateCordinate> findByName(String name);
    
    List<TemplateCordinate> findByNameAndTemplate(int templateId, String name);
    
}
