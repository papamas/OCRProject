/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyekOCR.springmvc.service;

import com.proyekOCR.springmvc.dao.BucketFileListDao;
import com.proyekOCR.springmvc.model.BucketFileList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Nur Muhamad
 */
@Service("bucketFileListService")
@Transactional
public class  BucketFileListServiceImpl implements BucketFileListService {

    @Autowired
    private BucketFileListDao dao;

    @Override
    public List<BucketFileList> findAll() {        
        return dao.findAll();
    }

    @Override
    public void save(BucketFileList bucketFilelist) {
        dao.save(bucketFilelist);
    }

    @Override
    public BucketFileList findById(int id) {
        return dao.find(id);
    }

    @Override
    public void update(BucketFileList bucketFileList) {
       BucketFileList entity = dao.find(bucketFileList.getId());
        if(entity!=null){			
            entity.setStatus(bucketFileList.getStatus());
            entity.setUser(bucketFileList.getUser());
        }    
    }

    @Override
    public List<BucketFileList> findAllByDate(String instansi,String status,String sdate, String edate) {
       return dao.findAllByDate(instansi,status,sdate,edate);
    }
     
        
}
