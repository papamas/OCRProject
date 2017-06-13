/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyekOCR.springmvc.controller;

import com.proyekOCR.springmvc.model.Instansi;
import com.proyekOCR.springmvc.model.KeyInstansi;
import com.proyekOCR.springmvc.model.KeywordInstansi;
import com.proyekOCR.springmvc.model.User;
import com.proyekOCR.springmvc.service.InstansiService;
import com.proyekOCR.springmvc.service.KeywordInstansiService;
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
public class KeywordInstansiController {
    
    @Autowired
    KeywordInstansiService keywordInstansiService ;
    
    @Autowired
    MessageSource messageSource;
    
    @Autowired
    InstansiService instansiService;
    
    @Autowired
    UserService userService;
    
    
    @RequestMapping(value="/listKeyInstansi", method = RequestMethod.GET)
    public String getList(ModelMap model) {

            List<KeywordInstansi> keywords = keywordInstansiService.findAll();
            model.addAttribute("keywords", keywords);
            return "keywordInstansiList";
    }

    @RequestMapping(value = { "/newKeyInstansi" }, method = RequestMethod.GET)
    public String newKeyInstansi(ModelMap model) {
            KeyInstansi keyInstansi = new KeyInstansi();
            model.addAttribute("keyInstansi", keyInstansi);
            model.addAttribute("instansiList",instansiService.findAll());
            model.addAttribute("edit", false);
            return "newKeyInstansi";
    }

    @RequestMapping(value = { "/newKeyInstansi" }, method = RequestMethod.POST)
    public String saveKeyInstansi(@Valid KeyInstansi keyInstansi,
            BindingResult result, ModelMap model) {
            
            if (result.hasErrors()) 
            {    
                model.addAttribute("instansiList",instansiService.findAll());  
                return "newKeyInstansi";
            }
            
            User user = userService.findBySSO(getPrincipal());
            Instansi instansi = instansiService.findByKode(keyInstansi.getnamaInstansi());

            KeywordInstansi keywordInstansi = new KeywordInstansi();
            keywordInstansi.setNamaKeyword(keyInstansi.getnamaKeyword());
            keywordInstansi.setUser(user);
            keywordInstansi.setInstansi(instansi);
            keywordInstansiService.save(keywordInstansi);
            
            return "redirect:/listKeyInstansi";
    } 
    
    @RequestMapping(value = { "/edit-keyInstansi-{id}" }, method = RequestMethod.GET)
    public String editKeyInstansi(@PathVariable int id, ModelMap model)  {

            KeywordInstansi keywordInstansi = keywordInstansiService.findById(id);
            KeyInstansi keyInstansi = new KeyInstansi();
            
            keyInstansi.setnamaInstansi(keywordInstansi.getInstansi().getKodeInstansi());
            keyInstansi.setnamaKeyword(keywordInstansi.getNamaKeyword());
            
            model.addAttribute("keyInstansi", keyInstansi);
            model.addAttribute("instansiList",instansiService.findAll());  
            model.addAttribute("edit", true);    
            return "newKeyInstansi";
    }
    @RequestMapping(value = { "/edit-keyInstansi-{id}" }, method = RequestMethod.POST)
    public String updateKeyInstansi(@Valid KeyInstansi keyInstansi, BindingResult result,
                    ModelMap model, @PathVariable int id)  {

            if (result.hasErrors()) {
                
                model.addAttribute("instansiList",instansiService.findAll());
                model.addAttribute("edit", true);
                return "newKeyInstansi";
            }
            User user = userService.findBySSO(getPrincipal());
            Instansi instansi = instansiService.findByKode(keyInstansi.getnamaInstansi());
            
            KeywordInstansi keywordInstansi = new KeywordInstansi();
            
            keywordInstansi.setId(id);
            keywordInstansi.setNamaKeyword(keyInstansi.getnamaKeyword());
            keywordInstansi.setInstansi(instansi);
            keywordInstansi.setUser(user);
            keywordInstansiService.update(keywordInstansi);            
            
        return"redirect:/listKeyInstansi";   
    }            
    
    @RequestMapping(value = { "/delete-keyInstansi-{id}" }, method = RequestMethod.GET)
    public String deleteKeyInstansi(@PathVariable int id) {            
                KeywordInstansi keywordIntansi = keywordInstansiService.findById(id);
                keywordInstansiService.delete(id);
                return "redirect:/listKeyInstansi";
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
