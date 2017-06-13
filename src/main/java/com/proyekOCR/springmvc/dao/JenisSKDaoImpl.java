/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyekOCR.springmvc.dao;

import com.proyekOCR.springmvc.model.JenisSK;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *
 * @author Nur Muhamad
 */
@Repository("JenisSKDao")
@Transactional

public class JenisSKDaoImpl extends AbstractDao<Integer, JenisSK>implements JenisSKDao{
    
    static final Logger logger = LoggerFactory.getLogger(InstansiDao.class);
	

    @SuppressWarnings("unchecked")
    public List<JenisSK> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<JenisSK> listSK = (List<JenisSK>) criteria.list();
        
        return listSK;
    }
    
    @Override
    public JenisSK findById(Integer id) {
        
        logger.info("id jenis SK : {}", id);        
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("id", id));
        JenisSK jenisSK = (JenisSK)crit.uniqueResult();
        if(jenisSK!=null){
            Hibernate.initialize(jenisSK.getId());
        }        
        return jenisSK;
    }
    
}
