/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyekOCR.springmvc.exception;

/**
 *
 * @author Nur Muhamad
 */
public class ElectricityNotFoundException extends RuntimeException {
    
	private static final long serialVersionUID = 1L;
	
        public ElectricityNotFoundException(String villageName) {
		super(villageName+":Electricity not available");
	}
} 
