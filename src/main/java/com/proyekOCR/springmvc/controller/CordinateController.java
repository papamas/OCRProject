/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyekOCR.springmvc.controller;

import com.proyekOCR.springmvc.model.Template;
import com.proyekOCR.springmvc.model.TemplateCordinate;
import com.proyekOCR.springmvc.model.User;
import com.proyekOCR.springmvc.service.TemplateCordinateService;
import com.proyekOCR.springmvc.service.TemplateService;
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
public class CordinateController {
    
    @Autowired
    UserService userService;
        
    @Autowired
    TemplateService templateService;
        
    
    @Autowired
    TemplateCordinateService templateCordinateService;
        
    @Autowired
    MessageSource messageSource;
       
    @RequestMapping(value="/listCordinate-{templateId}", method = RequestMethod.GET)
    public String getListCordinatePage(@PathVariable int templateId, ModelMap model) {
            
        Template template = templateService.findById(templateId);
		
        List<TemplateCordinate> AllTemplateCordinate = templateCordinateService.findAllById(templateId);
        model.addAttribute("AllTemplateCordinate", AllTemplateCordinate);
        model.addAttribute("templateName",template.getTemplateName());
        model.addAttribute("fileName",template.getFileName());
        model.addAttribute("templateId",template.getId());
            
        
        return "listTemplateCordinate";
    }
    
    @RequestMapping(value="/newCordinate-{templateId}", method = RequestMethod.GET)
    public String getNewCordinatePage(@PathVariable int templateId,ModelMap model) {

            Template template = templateService.findById(templateId);
		
            TemplateCordinate fileModel = new TemplateCordinate();
            model.addAttribute("templateCordinate", fileModel);
            model.addAttribute("fileName",template.getFileName());
            model.addAttribute("templateName",template.getTemplateName());
            model.addAttribute("templateId",template.getId());
        
            
            return "newCordinate";
    }
    
    @RequestMapping(value = { "/newCordinate-{templateId}" }, method = RequestMethod.POST)
    public String saveUser(@Valid TemplateCordinate templateCordinate, BindingResult result,
			ModelMap model,@PathVariable int templateId) {

        if (result.hasErrors()) {
            return "newCordinate";
        }
        
        String userName = getPrincipal();
        
        Template template = templateService.findById(templateId);
        User user = userService.findBySSO(userName);
        
        templateCordinate.setTemplate(template);
        templateCordinate.setUser(user);
        templateCordinateService.saveTemplateCordinate(templateCordinate);

        
        return "redirect:/listCordinate-"+templateId;
    }
    
    @RequestMapping(value = { "/edit-cordinate-{cordinateId}" }, method = RequestMethod.GET)
    public String editTemplateCordinate(@PathVariable int cordinateId, ModelMap model)  {

        TemplateCordinate templateCordinate = templateCordinateService.findById(cordinateId);
        model.addAttribute("templateCordinate", templateCordinate);
        model.addAttribute("fileName",templateCordinate.getTemplate().getFileName());
        model.addAttribute("templateName",templateCordinate.getTemplate().getTemplateName());
        model.addAttribute("edit", true);
        return "newCordinate";
    }
    
    @RequestMapping(value = { "/edit-cordinate-{cordinateId}" }, method = RequestMethod.POST)
    public String updateTemplateCordinate(@Valid TemplateCordinate templateCordinate,
            BindingResult result,
            ModelMap model, @PathVariable int cordinateId) {

        if (result.hasErrors()) {
                return "newCordinate";
        }
        TemplateCordinate template = templateCordinateService.findById(cordinateId);
        templateCordinateService.updateTemplateCordinate(templateCordinate);

        return "redirect:/listCordinate-"+template.getTemplate().getId();
    }
    
    @RequestMapping(value = { "/delete-cordinate-{cordinateId}" }, method = RequestMethod.GET)
    public String deleteTemplateCordinate(@PathVariable int cordinateId) {
        
            TemplateCordinate templateCordinate = templateCordinateService.findById(cordinateId);
            templateCordinateService.deleteById(cordinateId);
            
            return "redirect:/listCordinate-"+templateCordinate.getTemplate().getId();
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
