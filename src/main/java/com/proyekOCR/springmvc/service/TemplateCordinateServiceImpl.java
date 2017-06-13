/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyekOCR.springmvc.service;

import com.proyekOCR.springmvc.dao.TemplateCordinateDao;
import com.proyekOCR.springmvc.model.Template;
import com.proyekOCR.springmvc.model.TemplateCordinate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Nur Muhamad
 */
@Service("templateCordinateService")
@Transactional

public class TemplateCordinateServiceImpl implements TemplateCordinateService{
    
    @Autowired
    private TemplateCordinateDao dao;
    

    @Override
    public void saveTemplateCordinate(TemplateCordinate templateCordinate) {
        dao.save(templateCordinate);
    }

    @Override
    public List<TemplateCordinate> findAllById(int id) {
        return dao.findAllById(id);
    }

    @Override
    public TemplateCordinate findById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<TemplateCordinate> findAllByUserId(int id) {
        return dao.findAllByUserId(id);
    }

    @Override
    public void deleteById(int id) {
       dao.deleteById(id);
    }
    
    @Override
    public void updateTemplateCordinate(TemplateCordinate cordinate) {
        TemplateCordinate entity = dao.findById(cordinate.getId());
            if(entity!=null){
            
                entity.setName(cordinate.getName());
                entity.setHeight(cordinate.getHeight());
                entity.setWidth(cordinate.getWidth());
                entity.setX1(cordinate.getX1());
                entity.setY1(cordinate.getY1());
                entity.setX2(cordinate.getX2());
                entity.setY2(cordinate.getY2());
                

            }		
	    
    }

    @Override
    public List<TemplateCordinate> findByName(String name) {
        
        List<TemplateCordinate>  templateCordinate = dao.findByName(name);
        return templateCordinate;
    }

    @Override
    public List<TemplateCordinate> findByNameAndTemplate(int templateId, String name) {
        List<TemplateCordinate>  templateCordinate = dao.findByNameAndTemplate(templateId, name);
        return templateCordinate;

    }
    
}
