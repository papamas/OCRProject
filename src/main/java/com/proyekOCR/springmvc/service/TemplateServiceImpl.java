/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyekOCR.springmvc.service;

import com.proyekOCR.springmvc.dao.TemplateDao;
import com.proyekOCR.springmvc.model.Instansi;
import com.proyekOCR.springmvc.dao.InstansiDao;
import com.proyekOCR.springmvc.model.Template;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Nur Muhamad
 */
@Service("templateService")
@Transactional
public class TemplateServiceImpl implements TemplateService{
    
    @Autowired
    private TemplateDao dao;
    
    
    @Override
    public void saveTemplate(Template template) {
        dao.save(template);
        
    }
    
    public List<Template> findAllTemplates() {
	return dao.findAllTemplates();
    }

    @Override
    public Template findById(int id) {
       return dao.findById(id);
    }

    @Override
    public List<Template> findAllByUserId(int userId) {
        return dao.findAllByUserId(userId);
    }

    @Override
    public void deleteById(int id) {
       dao.deleteById(id);
    }
    
    
  @Override
    public Template findByName(String templateName) {
        
        Template template = dao.findByName(templateName);
        return template;
    }
    
    public void updateTemplate(Template template) {
		Template entity = dao.findById(template.getId());
		if(entity!=null){
			
		    entity.setTemplateName(template.getTemplateName());
                    entity.setActive(template.isActive());
			
		}
    }
    
    
    public void updateFile(Template template) {
		Template entity = dao.findById(template.getId());
		if(entity!=null){
			
			entity.setFileName(template.getFileName());
                        entity.setType(template.getType());
			
		}
    }

    @Override
    public Template findByInstansiTemplate(String kodeInstansi, String templateName) {
       Template template =  dao.findByInstansiTemplate(kodeInstansi, templateName);
       return template;
    }

    @Override
    public boolean isUnique(String kodeInstansi, String templateName) {
        
         List<Template> template = findByInsTemp(kodeInstansi,templateName);      
         if(template.size() > 0){
             return false;
         }
         else{
             return true;
         }
        
    }

    @Override
    public List<Template> findByInsTemp(String kodeInstansi, String templateName) {
          return dao.findByInsTemp(kodeInstansi, templateName);
    }

   

}
