/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyekOCR.springmvc.dao;

import com.proyekOCR.springmvc.model.BucketFileList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
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
@Repository("BucketFileListDao")
@Transactional
public class BucketFileListDaoImpl extends AbstractDao<Integer, BucketFileList> implements BucketFileListDao{

    static final Logger logger = LoggerFactory.getLogger(BucketFileListDaoImpl.class);
    
    
    @Override
    public List<BucketFileList> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.desc("updateDate"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        return (List<BucketFileList>)criteria.list();
    }
    
    @Override
    public void save(BucketFileList bucketFileList) {
       persist(bucketFileList);
    }

    @Override
    public BucketFileList find(int id) {
        return getByKey(id);
    }

    @Override
    public List<BucketFileList> findAllByDate(String instansi,String status,String sdate, String edate)  {
        
        Date d1 = new Date();
        Date d2 = new Date();
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            d1 = formatter.parse(sdate);
            d2 = formatter.parse(edate);            
        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(BucketFileListDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
            Criteria criteria = createEntityCriteria().addOrder(Order.desc("updateDate"));
            Criterion    c1 = Restrictions.and(Restrictions.ge("createdDate", d1),Restrictions.lt("createdDate", d2));
            Criterion    c2 = Restrictions.and(Restrictions.ge("updateDate", d1),Restrictions.lt("updateDate", d2));
            Criterion    c3 = Restrictions.eq("status",status);
            
            Criterion  cret = Restrictions.and(Restrictions.or(c1, c2), c3);            
            criteria.add(cret);
            
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
            return (List<BucketFileList>)criteria.list();
    }
}
