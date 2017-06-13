/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyekOCR.springmvc.dao;
import com.proyekOCR.springmvc.model.Template;
import java.util.List;


/**
 *
 * @author Nur Muhamad
 */
public interface TemplateDao {
    
    void save(Template template);
    
    List<Template> findAllTemplates();
    
    Template findById(int id);	
    
    Template findByName(String templateName);
    
    Template findByInstansiTemplate(String kodeInstansi,String templateName);
  
    void deleteById(int id);

    public List<Template> findAllByUserId(int userId);
    
    List<Template> findByInsTemp(String kodeInstansi,String templateName);
  
    
}
