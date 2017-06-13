/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyekOCR.springmvc.controller;

import com.proyekOCR.springmvc.model.FileOCR;
import com.proyekOCR.springmvc.model.Template;
import com.proyekOCR.springmvc.model.TemplateCordinate;
import com.proyekOCR.springmvc.service.OCRFullPageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.io.File;
import javax.servlet.ServletContext;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.proyekOCR.springmvc.service.OCRServiceImpl;
import com.proyekOCR.springmvc.service.TemplateCordinateService;
import com.proyekOCR.springmvc.service.TemplateService;
import com.proyekOCR.springmvc.util.FileOCRHelper;
import com.proyekOCR.springmvc.util.FileOCRValidator;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
/**
 *
 * @author Nur Muhamad
 */
@Controller
public class OCRController {
    private String defaultX1 = "1";
    private String defaultY1 = "1";
    private String defaultWidth = "1";
    private String defaultHeight = "1";
    private String defaultImageId = "1";
    
    @Autowired
    ServletContext context; 
    
    @Autowired
    MessageSource messageSource;

    @Autowired
    FileOCRValidator fileValidator;
    
    @Autowired
    TemplateCordinateService templateCordinate; 
    
    @Autowired
    TemplateService tempService; 
    
    private static final String UPLOAD_LOCATION="D:/mytemp/";
	
    private String resultOCR = null;	
    
    @RequestMapping(value = { "/ocrPage" }, method = RequestMethod.GET)
	public String getOcrPage(ModelMap model) {
		return "ocrPage";
    }
        
    
    @RequestMapping("OCRJson")
    public @ResponseBody  OCRServiceImpl getOCRJSon(@RequestParam("x1")  String X1,
            @RequestParam("y1")  String Y1,
            @RequestParam("width") String width,@RequestParam("height") String height ,
            @RequestParam("imageId") String ImageId){
        
            String pathToWebImages = context.getRealPath(File.separator + "static" + File.separator + "template");
                  
            OCRServiceImpl OCRService = new OCRServiceImpl();
            
            OCRService.setX1(X1);
            OCRService.setY1(Y1);
            OCRService.setWidth(width);
            OCRService.setHeight(height);
            OCRService.setImageId(ImageId);
            OCRService.setPath(pathToWebImages);
 
        return OCRService;
     }
    
    @RequestMapping("OCRFullJson")
    public @ResponseBody  OCRFullPageServiceImpl getOCRFullJSon(@RequestParam("imageId") String ImageId){
        
            String pathToWebImages = context.getRealPath(File.separator + "static" + File.separator + "template");
                  
            OCRFullPageServiceImpl OCRService = new OCRFullPageServiceImpl();
            
            OCRService.setImageId(ImageId);
            OCRService.setPath(pathToWebImages);
 
        return OCRService;
     }
    
    @RequestMapping(value="/ocrTest", method = RequestMethod.GET)
    public String getOCRTest(ModelMap model) {

            FileOCR fileModel = new FileOCR();
            model.addAttribute("fileOCR", fileModel);
           
            return "ocrTest";
    }
    
    @RequestMapping(value="/ocrTest", method = RequestMethod.POST)
    public String OCRTestPost(@Valid FileOCR fileOCR,
            BindingResult result, ModelMap model)  {

            String pathToWebImages = context.getRealPath(File.separator + "static" + 
                    File.separator + File.separator +
                    "template" );

            if (result.hasErrors()) {
                    System.out.println("validation errors");
                    return "ocrTest";
            } else {

                    System.out.println("Fetching file");
                    OCRServiceImpl OCRService = new OCRServiceImpl();
                    FileOCRHelper helper = new FileOCRHelper();
                    
                    //MultipartFile multipartFile = fileOCR.getFile();
                    List<TemplateCordinate> tempCordinate  = templateCordinate.findByName("instansi");
                    HashMap<Integer, Integer> ocrMap= new HashMap<>();
                    
                    for(int i=0;i<tempCordinate.size();i++){
                        
                        //System.out.println(tempCordinate.get(i).toString());
                        try{
                            
                        FileCopyUtils.copy(fileOCR.getFile().getBytes(),
                            new File(pathToWebImages + File.separator +
                                    fileOCR.getFile().getOriginalFilename()));
                        
                        
                        String x1 = Double.toString(tempCordinate.get(i).getX1());
                        String y1 = Double.toString(tempCordinate.get(i).getY1());
                        String width = Double.toString(tempCordinate.get(i).getWidth());
                        String height = Double.toString(tempCordinate.get(i).getHeight());
                        OCRService.setX1(x1);
                        OCRService.setY1(y1);
                        OCRService.setWidth(width);
                        OCRService.setHeight(height);
                        OCRService.setImageId(fileOCR.getFile().getOriginalFilename());
                        OCRService.setPath(pathToWebImages);
                        OCRService.setDeskew(fileOCR.isFixSkew());
                        resultOCR = OCRService.getocrResult();  
                        String keyword  = tempCordinate.get(i).getTemplate().getInstansi().getNamaInstansi();
                        
                                               
                        String cleanResult = resultOCR.replaceAll("^ +| +$|( )+", "$1").toLowerCase();
                        int templateId    = tempCordinate.get(i).getTemplate().getId();
                        int match         = helper.lock_match(cleanResult,keyword);
                        /*
                        System.out.println("Your Strings are Matched ="+match+"%");  
                        System.out.println("resultOCR : "+ cleanResult);
                        System.out.println("keyword :"+ keyword);
                        System.out.println("Dokumen : " + tempCordinate.get(i).getTemplate().getTemplateName());
                        */
                        // put into hashmap                           
                        ocrMap.put(templateId, match);                        
                        }catch(IOException | TesseractException | ArithmeticException | ArrayIndexOutOfBoundsException | NumberFormatException io){                            
                            System.out.println(io.getMessage());                                                
                        }finally{
                            System.out.println("final");
                        }
                        //System.out.println(tempCordinate.get(i).getTemplate().toString());
                        
                    }
                    
                    //System.out.println(ocrMap);
                    
                    int tempKey = 0;
                    
                    int maxValueInMap = (Collections.max(ocrMap.values()));
                    System.out.println("Value terbesar : " + maxValueInMap);
                    for (Map.Entry<Integer,Integer> entry : ocrMap.entrySet()) { 
                        if (entry.getValue() == maxValueInMap) {
                            tempKey = entry.getKey(); 
                        }
                    } 
                    
                    List<TemplateCordinate> nipCordinate = templateCordinate.findByNameAndTemplate(tempKey,"NIP");
                    //System.out.println("nip size:"+ nipCordinate.size());
                    String x1 = Double.toString(nipCordinate.get(0).getX1());
                    String y1 = Double.toString(nipCordinate.get(0).getY1());
                    String width = Double.toString(nipCordinate.get(0).getWidth());
                    String height = Double.toString(nipCordinate.get(0).getHeight());
                    
                    OCRService.setX1(x1);
                    OCRService.setY1(y1);
                    OCRService.setWidth(width);
                    OCRService.setHeight(height);
                    OCRService.setImageId(fileOCR.getFile().getOriginalFilename());
                    OCRService.setPath(pathToWebImages);
                    OCRService.setDeskew(fileOCR.isFixSkew());
                    
                    try {  
                        resultOCR = OCRService.getocrResult();
                    } catch (TesseractException ex) {
                        Logger.getLogger(OCRController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    //System.out.println("NIP  :"+ resultOCR.replaceAll("[^0-9]", ""));
                    String nip =  resultOCR.replaceAll("[^0-9]", "");       
                    Template temp = tempService.findById(tempKey);                
                    model.addAttribute("template",temp);
                    model.addAttribute("match",maxValueInMap);
                    model.addAttribute("fileName", fileOCR.getFile().getOriginalFilename());
                    model.addAttribute("nip", nip);
                    return "ocrTestResult";
            } 
    }
    
    
        
}
