/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyekOCR.springmvc.service;

import com.proyekOCR.springmvc.dao.JenisSKDao;
import com.proyekOCR.springmvc.model.JenisSK;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nur Muhamad
 */
@Service("jenisSKService")
public class JenisSKServiceImpl implements JenisSKService {
    
    @Autowired
    private JenisSKDao dao;

    @Override
    public List<JenisSK> findAll() {
        return dao.findAll();
    }
    
    @Override
    public JenisSK findById(Integer id){
        return dao.findById(id);
    }

    
    
}
