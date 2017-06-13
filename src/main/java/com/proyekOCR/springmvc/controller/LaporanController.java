package com.proyekOCR.springmvc.controller;

import com.proyekOCR.springmvc.model.Laporan;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.proyekOCR.springmvc.service.DownloadService;
import com.proyekOCR.springmvc.service.InstansiService;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles download requests
 * 
 * @author Krams at {@link http://krams915@blogspot.com}
 */
@Controller
@RequestMapping("/laporan")
public class LaporanController {

	private static Logger logger = Logger.getLogger(LaporanController.class.getName());
	
	@Resource(name="downloadService")
	private DownloadService downloadService;

        @Autowired
        InstansiService instansiService;
    
	/**
	 * Downloads the report as an Excel format. 
	 * <p>
	 * Make sure this method doesn't return any model. Otherwise, you'll get 
	 * an "IllegalStateException: getOutputStream() has already been called for this response"
	 */
        @RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String getLaporan(ModelMap model) {
		Laporan laporan = new Laporan();
		model.addAttribute("laporan", laporan);
                model.addAttribute("instansiList",instansiService.findAll());
		return "laporan";
	}
        
        @RequestMapping(value = { "/" }, method = RequestMethod.POST)
	public String PostLaporan(@Valid Laporan laporan,BindingResult result, ModelMap model) throws ParseException {
            if (result.hasErrors()) 
            {    
                model.addAttribute("instansiList",instansiService.findAll());  
                return "laporan";
            }
            
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            
            String d1 = format.format(laporan.getCreatedDate());
            String d2 = format.format(laporan.getUpdateDate());
            String instansi = laporan.getInstansi();
            String status   = laporan.getStatus();
            
            List<NameValuePair> urlParameters = new ArrayList<>();
            urlParameters.add( new BasicNameValuePair("instansi", instansi));
            urlParameters.add( new BasicNameValuePair("status", status));
            urlParameters.add( new BasicNameValuePair("sdate", d1));
            urlParameters.add( new BasicNameValuePair("edate", d2));            
            
            String queryString = URLEncodedUtils.format(urlParameters, "UTF-8");
            
            return "redirect:/laporan/generate/?type=xls&"+queryString;
	}
        
    /**
     *
     * @param response
     * @param type
     * @param model
     * @throws ClassNotFoundException
     */
    @RequestMapping(value = "/generate", method = RequestMethod.GET)
        public void getXLS(HttpServletResponse response,
                @RequestParam(value="type", required=true)  String type,
                @RequestParam(value="instansi", required=true)  String instansi,
                @RequestParam(value="status", required=true)  String status,                
                @RequestParam(value="sdate", required=true)  String sdate,
                @RequestParam(value="edate", required=true)  String edate,
                
                ModelMap model) throws ClassNotFoundException {
    	logger.debug("Received request to download report as an XLS");
    	
    	    // Delegate to downloadService. Make sure to pass an instance of HttpServletResponse 
    	    downloadService.downloadXLS(response,instansi,status,sdate,edate);
	}
}
