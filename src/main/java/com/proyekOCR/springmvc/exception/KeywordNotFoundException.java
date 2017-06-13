/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyekOCR.springmvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Nur Muhamad
 */
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such Keyword")
public class KeywordNotFoundException extends RuntimeException {
    
	private static final long serialVersionUID = 1L;
	
        public KeywordNotFoundException(String key){
		super(key+" not available");
	}
} 
