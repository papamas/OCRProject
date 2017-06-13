/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyekOCR.springmvc.service;

import com.proyekOCR.springmvc.dao.KeywordDokumenDao;
import com.proyekOCR.springmvc.model.KeywordDokumen;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Nur Muhamad
 */
@Service("keywordDokumenService")
@Transactional
public class KeywordDokumenServiceImpl implements KeywordDokumenService {

    @Autowired
    private KeywordDokumenDao dao;
     
    @Override
    public void save(KeywordDokumen keyword) {
        dao.save(keyword);
    }

    @Override
    public List<KeywordDokumen> findAll() {
        return dao.findAll();
    }

    @Override
    public KeywordDokumen findById(int id) {
         return dao.find(id);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public void update(KeywordDokumen keyword) {
        KeywordDokumen entity = dao.find(keyword.getId());
        if(entity!=null){			
            entity.setNamaKeyword(keyword.getNamaKeyword());
            entity.setJenisSK(keyword.getJenisSK());
        }    
    }
    
}
