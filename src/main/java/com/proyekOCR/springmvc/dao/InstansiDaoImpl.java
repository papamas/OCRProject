/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyekOCR.springmvc.dao;

import com.proyekOCR.springmvc.model.Instansi;
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
@Repository("InstansiDao")
@Transactional

public class InstansiDaoImpl extends AbstractDao<Integer, Instansi>implements InstansiDao{
    
    static final Logger logger = LoggerFactory.getLogger(InstansiDao.class);
	

    @SuppressWarnings("unchecked")
    public List<Instansi> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("kodeInstansi"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Instansi> listInstansi = (List<Instansi>) criteria.list();
        
        return listInstansi;
    }
    
    @Override
    public Instansi findByKode(String kode) {
        logger.info("kode instansi : {}", kode);
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("kodeInstansi", kode));
        Instansi instansi = (Instansi)crit.uniqueResult();
        if(instansi!=null){

            Hibernate.initialize(instansi.getKodeInstansi());
        }
        
        return instansi;
    }
    
}
