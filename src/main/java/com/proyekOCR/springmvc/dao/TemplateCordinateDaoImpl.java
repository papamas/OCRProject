/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyekOCR.springmvc.dao;

import com.proyekOCR.springmvc.model.TemplateCordinate;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Nur Muhamad
 */
@Repository("TemplateCorinateDao")
@Transactional
public class TemplateCordinateDaoImpl extends AbstractDao<Integer, TemplateCordinate> implements TemplateCordinateDao {

    static final Logger logger = LoggerFactory.getLogger(TemplateCordinateDao.class);

    @Override
    public void save(TemplateCordinate templateCordinate) {
        persist(templateCordinate);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<TemplateCordinate> findAllById(int templateId) {
        
        Criteria crit = createEntityCriteria();
        Criteria templateCriteria = crit.createCriteria("template");
        templateCriteria.add(Restrictions.eq("id", templateId));
        return (List<TemplateCordinate>)crit.list();
        
    }

    @Override
    public TemplateCordinate findById(int id) {
        return getByKey(id);
    }

    @Override
    public void deleteById(int id) {
       TemplateCordinate templateCordinate =  getByKey(id);
       delete(templateCordinate);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<TemplateCordinate> findAllByUserId(int userId) {
        Criteria crit = createEntityCriteria();
        Criteria userCriteria = crit.createCriteria("user");
        userCriteria.add(Restrictions.eq("id", userId));
        return (List<TemplateCordinate>)crit.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<TemplateCordinate> findByName(String name) {
        logger.info("Template Cordinate Name : {}", name);
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("name", name));
        return (List<TemplateCordinate>) crit.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<TemplateCordinate> findByNameAndTemplate(int templateId, String name) {
        logger.info("Template Cordinate findByNameAndTemplate : {} {} ", templateId,name);
        Criteria crit = createEntityCriteria();
        
        Criteria instansiCriteria = crit.createCriteria("template");
        instansiCriteria.add(Restrictions.eq("id", templateId));
        crit.add(Restrictions.eq("name",name));
        
        return (List<TemplateCordinate>) crit.list();
        
        
    }
    
}
