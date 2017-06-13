/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyekOCR.springmvc.dao;

import com.proyekOCR.springmvc.model.Template;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author Nur Muhamad
 */
@Repository("TemplateDao")
@Transactional
public class TemplateDaoImpl extends AbstractDao<Integer, Template>implements TemplateDao{
    
    static final Logger logger = LoggerFactory.getLogger(TemplateDao.class);
	

    @Override
    public void save(Template template) {
       persist(template);
    }

    @SuppressWarnings("unchecked")
    public List<Template> findAllByUserId(int userId){
            Criteria crit = createEntityCriteria();
            Criteria userCriteria = crit.createCriteria("user");
            userCriteria.add(Restrictions.eq("id", userId));
            return (List<Template>)crit.list();
    }
    
    @SuppressWarnings("unchecked")
    public List<Template> findAllTemplates() {
            Criteria criteria = createEntityCriteria().addOrder(Order.asc("instansi"));
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
            List<Template> templates = (List<Template>) criteria.list();

            // No need to fetch userProfiles since we are not showing them on list page. Let them lazy load. 
            // Uncomment below lines for eagerly fetching of userProfiles if you want.
            /*
            for(User user : users){
                    Hibernate.initialize(user.getUserProfiles());
            }*/
            return templates;
    
    }

    @Override
    public Template findById(int id) {
        return getByKey(id);
    }

    @Override
    public void deleteById(int id) {
        Template template =  getByKey(id);
	delete(template);
    }

    @Override
    public Template findByName(String templateName) {
        logger.info("Template Name : {}", templateName);
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("templateName", templateName));
        Template template = (Template)crit.uniqueResult();
        if(template!=null){

            Hibernate.initialize(template.getTemplateName());
        }
        return template;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Template> findByInsTemp(String kodeInstansi, String templateName) {
        logger.info("Template : {} ,{} ", templateName  , kodeInstansi);
        Criteria crit = createEntityCriteria();
        Criteria instansiCriteria = crit.createCriteria("instansi");
        instansiCriteria.add(Restrictions.eq("id", kodeInstansi));
        crit.add(Restrictions.eq("templateName", templateName));
        
        return (List<Template>)crit.list();
        /*
        Criterion temp = Restrictions.eq("templateName", templateName);
        Criterion kode = Restrictions.eq("instansi",kodeInstansi);
        
        LogicalExpression andExp = Restrictions.and(temp, kode);
        crit.add( andExp );
        //crit.setProjection(Projections.rowCount());
        List<Template> template = (List<Template>)  crit.list();
        /*
        if(template!=null){

            Hibernate.initialize(template.getTemplateName());
        }
        */
        //return template;
        /*
        Criteria crit = createEntityCriteria();
        Criterion temp = Restrictions.eq("templateName", templateName);
        Criterion kode = Restrictions.eq("instansi",kodeInstansi);
        
        crit.add(Restrictions.eq("templateName", templateName));
        crit.add(Restrictions.eq("instansi", kodeInstansi));
        
        LogicalExpression andExp = Restrictions.and(temp, kode);
        crit.add( andExp );
        
        //Template template = (Template)crit.uniqueResult();
        
        List<Template> template = crit.list();
        
        /*
        if(template!=null){

            Hibernate.initialize(template.getTemplateName());
        }
        
        System.out.println(template);
        return (Template) template;
        
        */
    }

    @Override
    public Template findByInstansiTemplate(String kodeInstansi, String templateName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
    
    
    
}
