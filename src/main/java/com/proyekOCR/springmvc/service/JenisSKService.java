/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyekOCR.springmvc.service;

import com.proyekOCR.springmvc.model.Instansi;
import com.proyekOCR.springmvc.model.JenisSK;
import java.util.List;

/**
 *
 * @author Nur Muhamad
 */
public interface JenisSKService {        
    List<JenisSK> findAll();
    JenisSK findById(Integer id);
    
}
