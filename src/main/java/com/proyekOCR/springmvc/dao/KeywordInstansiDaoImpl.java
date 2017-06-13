/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyekOCR.springmvc.dao;

import com.proyekOCR.springmvc.model.KeywordInstansi;
import com.proyekOCR.springmvc.model.Template;
import com.proyekOCR.springmvc.model.TemplateCordinate;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Nur Muhamad
 */
@Repository("KeywordIntansiDao")
@Transactional
public class KeywordInstansiDaoImpl extends AbstractDao<Integer, KeywordInstansi> implements KeywordInstansiDao{

    static final Logger logger = LoggerFactory.getLogger(KeywordInstansiDaoImpl.class);
    
    @Override
    public void save(KeywordInstansi keyword) {
       persist(keyword);
    }

    @Override
    public List<KeywordInstansi> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        return (List<KeywordInstansi>)criteria.list();
    }

    @Override
    public KeywordInstansi find(int id) {
        return getByKey(id);
    }

    @Override
    public void delete(int id) {
        KeywordInstansi keyword =  getByKey(id);
	delete(keyword);
    }
    
}
