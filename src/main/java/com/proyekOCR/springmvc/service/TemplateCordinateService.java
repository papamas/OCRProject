/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyekOCR.springmvc.service;

import com.proyekOCR.springmvc.model.TemplateCordinate;
import java.util.List;

/**
 *
 * @author Nur Muhamad
 */
public interface TemplateCordinateService {
    
    void saveTemplateCordinate(TemplateCordinate templateCordinate);
    
    List<TemplateCordinate> findAllById(int id);
    
    TemplateCordinate findById(int id);
    
    List<TemplateCordinate> findAllByUserId(int id);
	
    void deleteById(int id);    
    
    public void updateTemplateCordinate(TemplateCordinate cordinate);
    
    List<TemplateCordinate> findByName(String name);

    List<TemplateCordinate> findByNameAndTemplate(int templateId,String name); 
    
}
