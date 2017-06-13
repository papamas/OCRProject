/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyekOCR.springmvc.service;
import com.proyekOCR.springmvc.model.BucketFileList;
import java.util.List;

/**
 *
 * @author Nur Muhamad
 */
public interface BucketFileListService {    
    List<BucketFileList> findAll();   
    void save(BucketFileList bucketFilelist); 
    BucketFileList findById(int id);    
    void update(BucketFileList bucketFileList); 
    List<BucketFileList> findAllByDate(String instansi,String status,String sdate, String edate);
    
}
