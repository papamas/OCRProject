/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyekOCR.springmvc.controller;

import com.proyekOCR.springmvc.model.JenisSK;
import com.proyekOCR.springmvc.model.KeyDokumen;
import com.proyekOCR.springmvc.model.KeywordDokumen;
import com.proyekOCR.springmvc.model.User;
import com.proyekOCR.springmvc.service.JenisSKService;
import com.proyekOCR.springmvc.service.KeywordDokumenService;
import com.proyekOCR.springmvc.service.UserService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Nur Muhamad
 */
@Controller
public class KeywordDokumenController {
    
    @Autowired
    KeywordDokumenService keywordDokumenService ;
    
    @Autowired
    MessageSource messageSource;
    
    @Autowired
    JenisSKService jenisSKService;
    
    @Autowired
    UserService userService;
    
    
    @RequestMapping(value="/listKeyDokumen", method = RequestMethod.GET)
    public String getList(ModelMap model) {

            List<KeywordDokumen> keywords = keywordDokumenService.findAll();
            model.addAttribute("keywords", keywords);
            return "listKeywordDokumen";
    }

    @RequestMapping(value = { "/newKeyDokumen" }, method = RequestMethod.GET)
    public String newKeyDokumen(ModelMap model) {
            KeyDokumen keyDokumen = new KeyDokumen();
            model.addAttribute("keyDokumen", keyDokumen);
            model.addAttribute("dokumenList",jenisSKService.findAll());
            model.addAttribute("edit", false);
            return "newKeyDokumen";
    }
    
    @RequestMapping(value = { "/newKeyDokumen" }, method = RequestMethod.POST)
    public String saveKeyDokumen(@Valid KeyDokumen keyDokumen,
            BindingResult result, ModelMap model) {
            
            if (result.hasErrors()) 
            {    
                model.addAttribute("dokumenList",jenisSKService.findAll());  
                return "newKeyDokumen";
            }
            
            User user = userService.findBySSO(getPrincipal());
            JenisSK jenisSK = jenisSKService.findById(Integer.parseInt(keyDokumen.getNamaDokumen()));

            KeywordDokumen keywordDokumen = new KeywordDokumen();
            keywordDokumen.setNamaKeyword(keyDokumen.getnamaKeyword());
            keywordDokumen.setUser(user);
            keywordDokumen.setJenisSK(jenisSK);
            keywordDokumenService.save(keywordDokumen);
            
            return "redirect:/listKeyDokumen";
    } 
    
    @RequestMapping(value = { "/edit-keyDokumen-{id}" }, method = RequestMethod.GET)
    public String editKeyDokumen(@PathVariable int id, ModelMap model)  {

            KeywordDokumen keywordDokumen = keywordDokumenService.findById(id);
            KeyDokumen keyDokumen= new KeyDokumen();
            
            keyDokumen.setNamaDokumen(String.valueOf(keywordDokumen.getJenisSK().getId()));
            keyDokumen.setnamaKeyword(keywordDokumen.getNamaKeyword());
            
            model.addAttribute("keyDokumen", keyDokumen);
            model.addAttribute("dokumenList",jenisSKService.findAll());  
            model.addAttribute("edit", true);    
            return "newKeyDokumen";
    }
    
    @RequestMapping(value = { "/edit-keyDokumen-{id}" }, method = RequestMethod.POST)
    public String updateKeyDokumen(@Valid KeyDokumen keyDokumen, BindingResult result,
                    ModelMap model, @PathVariable int id)  {

            if (result.hasErrors()) {
                
                model.addAttribute("dokumenList",jenisSKService.findAll());
                model.addAttribute("edit", true);
                return "newKeyDokumen";
            }
            User user = userService.findBySSO(getPrincipal());
            JenisSK jenisSK = jenisSKService.findById(Integer.parseInt(keyDokumen.getNamaDokumen()));
            
            KeywordDokumen keywordDokumen = new KeywordDokumen();
            
            keywordDokumen.setId(id);
            keywordDokumen.setNamaKeyword(keyDokumen.getnamaKeyword());
            keywordDokumen.setJenisSK(jenisSK);
            keywordDokumen.setUser(user);
            keywordDokumenService.update(keywordDokumen);            
            
        return"redirect:/listKeyDokumen";   
    }            
    
    @RequestMapping(value = { "/delete-keyDokumen-{id}" }, method = RequestMethod.GET)
    public String deleteKeyDokumen(@PathVariable int id) {            
                KeywordDokumen keywordDokumen = keywordDokumenService.findById(id);
                keywordDokumenService.delete(id);
                return "redirect:/listKeyDokumen";
    }
    
    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
                userName = ((UserDetails)principal).getUsername();
        } else {
                userName = principal.toString();
        }
        return userName;
    }
    
}
