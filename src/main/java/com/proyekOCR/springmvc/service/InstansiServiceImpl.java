/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyekOCR.springmvc.service;

import com.proyekOCR.springmvc.dao.InstansiDao;
import com.proyekOCR.springmvc.model.Instansi;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Nur Muhamad
 */
@Service("instansiService")
public class InstansiServiceImpl implements InstansiService {
    
    @Autowired
    private InstansiDao dao;

    @Override
    public List<Instansi> findAll() {
        return dao.findAll();
    }
    
    @Override
    public Instansi findByKode(String kode){
        return dao.findByKode(kode);
    }

    
    
}
