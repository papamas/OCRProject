/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyekOCR.springmvc.service;
import com.proyekOCR.springmvc.model.Template;
import java.util.List;
/**
 *
 * @author Nur Muhamad
 */
public interface TemplateService {
    
    void saveTemplate(Template template);
    
    List<Template> findAllTemplates();
    
    Template findById(int id);
    
    Template findByName(String templateName);

    List<Template> findByInsTemp(String kodeInstansi,String templateName);
    
    List<Template> findAllByUserId(int id);
	
    void deleteById(int id);
    
    boolean isUnique(String kodeInstansi,String templateName);   

    public void updateTemplate(Template template);

    public void updateFile(Template template);
        
    public Template findByInstansiTemplate(String kodeInstansi,String templateName);
}
