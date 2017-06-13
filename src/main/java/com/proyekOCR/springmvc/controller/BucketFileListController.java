/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyekOCR.springmvc.controller;

import com.proyekOCR.springmvc.model.BucketFileList;
import com.proyekOCR.springmvc.model.Template;
import com.proyekOCR.springmvc.model.User;
import com.proyekOCR.springmvc.service.BucketFileListService;
import com.proyekOCR.springmvc.service.UserService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
public class BucketFileListController {
    
    @Autowired
    BucketFileListService bucketFileListService ;
    
    @Autowired
    UserService userService;
        

    
    @RequestMapping(value="/listFileBucket", method = RequestMethod.GET)
    public String getList(ModelMap model) {

            List<BucketFileList> BucketFileList = bucketFileListService.findAll();
            model.addAttribute("fileBucketList", BucketFileList);
            return "listFileBucket";
    }
    
    @RequestMapping(value = { "/update-statusBucket-{id}" }, method = RequestMethod.GET)
    public String updateFileBucket(@PathVariable int id, ModelMap model)  {

            BucketFileList bucketFileList = bucketFileListService.findById(id);
            model.addAttribute("bucketFileList", bucketFileList);
            return "updateFileBucket";
    }
    
    @RequestMapping(value = { "/update-statusBucket-{id}" }, method = RequestMethod.POST)
    public String updateFileBucket(@Valid BucketFileList bucketFileList, BindingResult result,
			ModelMap model, @PathVariable int id) {

        if (result.hasErrors()) {
            /*
            for(int i=0;i < result.getFieldErrorCount();i++){
               System.out.println(result.getFieldErrors().get(i));
            }
            */
            return "updateFileBucket";
        }
        
                        
        User user = userService.findBySSO(getPrincipal());
                        
        bucketFileList.setUser(user);
        bucketFileList.setStatus(bucketFileList.getStatus());
        
        bucketFileListService.update(bucketFileList);
        return "redirect:/listFileBucket";
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
