/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyekOCR.springmvc.service;

import com.proyekOCR.springmvc.dao.KeywordInstansiDao;
import com.proyekOCR.springmvc.model.KeywordInstansi;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Nur Muhamad
 */
@Service("keywordInstansiService")
@Transactional
public class KeywordInstansiServiceImpl implements KeywordInstansiService {

    @Autowired
    private KeywordInstansiDao dao;
     
    @Override
    public void save(KeywordInstansi keyword) {
        dao.save(keyword);
    }

    @Override
    public List<KeywordInstansi> findAll() {
        return dao.findAll();
    }

    @Override
    public KeywordInstansi findById(int id) {
         return dao.find(id);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public void update(KeywordInstansi keyword) {
        KeywordInstansi entity = dao.find(keyword.getId());
        if(entity!=null){			
            entity.setNamaKeyword(keyword.getNamaKeyword());
            entity.setInstansi(keyword.getInstansi());
        }    
    }
    
}
