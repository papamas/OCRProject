/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyekOCR.springmvc.dao;

import com.proyekOCR.springmvc.model.KeywordDokumen;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Nur Muhamad
 */
@Repository("KeywordDokumenDao")
@Transactional
public class KeywordDokumenDaoImpl extends AbstractDao<Integer, KeywordDokumen> implements KeywordDokumenDao{

    static final Logger logger = LoggerFactory.getLogger(KeywordInstansiDaoImpl.class);
    
    @Override
    public void save(KeywordDokumen keyword) {
       persist(keyword);
    }

    @Override
    public List<KeywordDokumen> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        return (List<KeywordDokumen>)criteria.list();
    }

    @Override
    public KeywordDokumen find(int id) {
        return getByKey(id);
    }

    @Override
    public void delete(int id) {
        KeywordDokumen keyword =  getByKey(id);
	delete(keyword);
    }
    
}
