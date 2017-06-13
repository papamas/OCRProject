package com.proyekOCR.springmvc.controller;

import com.proyekOCR.springmvc.model.BucketFileList;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.proyekOCR.springmvc.model.FileBucket;
import com.proyekOCR.springmvc.model.Instansi;
import com.proyekOCR.springmvc.model.MultiFileBucket;
import com.proyekOCR.springmvc.model.RestFileInfo;
import com.proyekOCR.springmvc.util.FileValidator;
import com.proyekOCR.springmvc.util.MultiFileValidator;
import javax.servlet.ServletContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.proyekOCR.springmvc.model.Template;
import com.proyekOCR.springmvc.service.TemplateService;
import com.proyekOCR.springmvc.service.UserService;
import org.springframework.context.MessageSource;
import com.proyekOCR.springmvc.model.User;
import com.proyekOCR.springmvc.service.BucketFileListService;
import com.proyekOCR.springmvc.service.InstansiService;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Logger;
import org.apache.commons.codec.binary.Base64;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.core.io.InputStreamResource;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.MediaType;


@Controller

public class FileUploadController {
    
    private static final Logger log = Logger.getLogger(FileUploadController.class.getName());
    
        @Autowired
	UserService userService;
        
        @Autowired
	TemplateService templateService;     
        
        
        @Autowired
	MessageSource messageSource;
        
        @Autowired
	FileValidator fileValidator;
	
	
        @Autowired
        ServletContext context; 
        
        @Autowired
	BucketFileListService bucketFileListService;
        
        private static final String UPLOAD_LOCATION="D:/mytemp/";
	
	
	@Autowired
	MultiFileValidator multiFileValidator;
        
        @Autowired
        InstansiService instansiService;
        
        
	
	@InitBinder("fileBucket")
	protected void initBinderFileBucket(WebDataBinder binder) {
	   binder.setValidator(fileValidator);
	}


	@InitBinder("multiFileBucket")
	protected void initBinderMultiFileBucket(WebDataBinder binder) {
	   binder.setValidator(multiFileValidator);
	}
        
        
    
        @ModelAttribute("templateList")
        public Map<String, String>  getTemplate()
        {
            Map<String, String> templateCB = new HashMap<>();
            
            templateCB.put("SK_CPNS", "SK Pengangkatan Sebagai Calon PNS");
            templateCB.put("SK_PNS", "SK Pengangkatan Sebagai PNS");
            templateCB.put("SK_KP", "SK Kenaikan Pangkat");
            templateCB.put("SK_MUTASI", "SK Mutasi Antar Instansi");
            
            return templateCB;
           
        }
        
        @ModelAttribute("instansiList")
        public Map<String, String>  getInstansiList()
        {
            Map<String, String> instansiCB = new HashMap<>();
            
            List<Instansi> instansiList = instansiService.findAll();
            for(int i=0;i<instansiList.size();i++){
                
                instansiCB.put(instansiList.get(i).getKodeInstansi(), instansiList.get(i).getNamaInstansi());
            }
            
            return instansiCB;
           
        }
        
        
        
        
        @RequestMapping(value="/scanner", method = RequestMethod.GET)
	public String getScannerApplet(ModelMap model) {
		
            return "scanner";
	}
        
        @RequestMapping(value="/listTemplate", method = RequestMethod.GET)
	public String getListTemplatePage(ModelMap model) {
            
		List<Template> templates = templateService.findAllTemplates();
		model.addAttribute("templates", templates);
                return "listTemplate";
	}
        
        

        @RequestMapping(value="/newTemplate", method = RequestMethod.GET)
	public String getnewTemplatePage(ModelMap model) {
		
                FileBucket fileModel = new FileBucket();
		model.addAttribute("fileBucket", fileModel);
                model.addAttribute("edit", false);
                    
		return "newTemplate";
	}
        
        @RequestMapping(value="/newTemplate", method = RequestMethod.POST)
	public String newTemplatePage(@Valid FileBucket fileBucket,
                BindingResult result, ModelMap model) throws IOException {
            
                model.addAttribute("edit", false);

		String pathToWebImages = context.getRealPath(File.separator + "static" + 
                        File.separator + File.separator +
                        "template" );
                  
                //System.out.println(pathToWebImages);
              
                if (result.hasErrors()) {
			System.out.println("validation errors");                
			return "newTemplate";
		} else {
                    
                        System.out.println("Fetching file");
                        Instansi instansi = instansiService.findByKode(fileBucket.getInstansi());

                        
                        if(!templateService.isUnique(fileBucket.getInstansi(),
                                fileBucket.getTemplateName()))
                        {			
                            FieldError templateError =new FieldError("Template","templateName",
                                messageSource.getMessage("non.unique.templateName",
                                new String[]{fileBucket.getTemplateName()}, Locale.getDefault()));
                            
                            FieldError instansiError= new FieldError("Instansi","instansi",
                                messageSource.getMessage("non.unique.instansiName",
                                new String[]{instansi.getNamaInstansi()}, Locale.getDefault()));
                                                              		           
                            result.addError(templateError);
                            result.addError(instansiError);
			
                            return "newTemplate";
		        }
                        
                        
                        MultipartFile multipartFile = fileBucket.getFile();
                        User user = userService.findBySSO(getPrincipal());
                        
                        Template template = new Template();
                        template.setFileName(multipartFile.getOriginalFilename());
                        template.setTemplateName(fileBucket.getTemplateName());
                        template.setActive(fileBucket.isActive());
                        template.setType(multipartFile.getContentType());
                        template.setUser(user);
                        template.setInstansi(instansi);

                        //Now do something with file...
                        FileCopyUtils.copy(fileBucket.getFile().getBytes(),
                                new File(pathToWebImages + File.separator +
                                        fileBucket.getFile().getOriginalFilename()));

                        templateService.saveTemplate(template);

                        List<Template> templates = templateService.findAllTemplates();
                        model.addAttribute("templates", templates);

                        return "listTemplate";
		} 
	}
        
        
        
        @RequestMapping(value = { "/edit-template-{templateId}" }, method = RequestMethod.GET)
	public String editTemplate(@PathVariable int templateId, ModelMap model)  {
		
                Template template = templateService.findById(templateId);
		FileBucket fileModel = new FileBucket();
                                 
                fileModel.setTemplateName(template.getTemplateName());
                fileModel.setActive(template.isActive());
                model.addAttribute("fileBucket", fileModel);
		
                return "updateTemplate";
	}
        
        @RequestMapping(value = { "/edit-template-{templateId}" }, method = RequestMethod.POST)
	public String updateTemplate(@Valid FileBucket filebucket, BindingResult result,
			ModelMap model, @PathVariable int templateId)  {
		
                if (result.hasErrors()) {
	           
                    return "updateTemplate";
		}
                /*
                if(!templateService.isTemplateNameUnique(filebucket.getTemplateName()))
                {			
                    FieldError templateError =new FieldError("Template","templateName",
                                messageSource.getMessage("non.unique.templateName", new String[]{filebucket.getTemplateName()}, Locale.getDefault()));
		           
                    result.addError(templateError);
			
                    return "updateTemplate";
		}

                */
                Template template = new Template();
                template.setId(templateId);
                template.setTemplateName(filebucket.getTemplateName());
                template.setActive(filebucket.isActive());
                
                templateService.updateTemplate(template);
                
                return "redirect:/listTemplate";
	}
        
        
        
        @RequestMapping(value = { "/edit-file-{templateId}" }, method = RequestMethod.GET)
	public String editFile(@PathVariable int templateId, ModelMap model)  {
		
                Template template = templateService.findById(templateId);
		FileBucket fileModel = new FileBucket();
                                 
                fileModel.setTemplateName(template.getTemplateName());
                fileModel.setActive(template.isActive());
                
                model.addAttribute("fileBucket", fileModel);
		
                return "updateFile";
	}
        
        @RequestMapping(value = { "/edit-file-{templateId}" }, method = RequestMethod.POST)
	public String updateFile(@Valid FileBucket fileBucket, BindingResult result,
			ModelMap model, @PathVariable int templateId) throws IOException  {
		
                if (result.hasErrors()) {
	            return "updateFile";
		}
                         
                Template template = new Template();
                MultipartFile multipartFile = fileBucket.getFile();
                
                template.setId(templateId);
                template.setFileName(multipartFile.getOriginalFilename());
                template.setType(multipartFile.getContentType());
                                
                
                String pathToWebImages = context.getRealPath(File.separator + "static" + 
                        File.separator + File.separator +
                        "template" );
                
                 //Now do something with file...
                try{
                    
                     FileUtils.deleteQuietly(new File(pathToWebImages + 
                        File.separator + template.getFileName()));
                    
                FileCopyUtils.copy(fileBucket.getFile().getBytes(),
                        new File(pathToWebImages + File.separator +
                                fileBucket.getFile().getOriginalFilename()));
                                                          
                    templateService.updateFile(template);
                
                }catch(IOException ex){
                    
                    return ex.toString();
                }
                return "redirect:/listTemplate";
	}
        
        @RequestMapping(value = { "/delete-template-{templateId}" }, method = RequestMethod.GET)
	public String deleteDocument(@PathVariable int templateId) {
            
                Template template = templateService.findById(templateId);
                
                String pathToWebImages = context.getRealPath(File.separator + "static" + 
                        File.separator + File.separator +
                        "template" );
                try{
                    templateService.deleteById(templateId);
                    FileUtils.deleteQuietly(new File(pathToWebImages + 
                        File.separator + template.getFileName()));            
                }catch(Exception ex){
                    return ex.toString();
                }
                
                    
		return "redirect:/listTemplate";
	}
        
        

	@RequestMapping(value="/singleUpload", method = RequestMethod.GET)
	public String getSingleUploadPage(ModelMap model) {
		FileBucket fileModel = new FileBucket();
		model.addAttribute("fileBucket", fileModel);
		return "newTemplate";
	}
        
        

	@RequestMapping(value="/singleUpload", method = RequestMethod.POST)
	public String singleFileUpload(@Valid FileBucket fileBucket,
                BindingResult result, ModelMap model) throws IOException {

		//return "newTemplate";
                
                String pathToWebImages = context.getRealPath(File.separator + "static" + 
                        File.separator + File.separator +
                        "template" );
                  
                //System.out.println(pathToWebImages);
              
                if (result.hasErrors()) {
			System.out.println("validation errors");
			return "newTemplate";
		} else {			
			System.out.println("Fetching file");
                        
                        MultipartFile multipartFile = fileBucket.getFile();

			//Now do something with file...
			FileCopyUtils.copy(fileBucket.getFile().getBytes(), new File(pathToWebImages + File.separator + fileBucket.getFile().getOriginalFilename()));
			
			String fileName = multipartFile.getOriginalFilename();
			
                        model.addAttribute("fileName", fileName);
			return "ocrPage";
		}

                
	}
        /* 
        @RequestMapping(value="/getContent-{docId}", method = RequestMethod.GET)
	public void getDocumentcontent(@PathVariable String docId) throws IOException {
	    /*	
            byte[] encoding = Base64.encodeBase64(("okmAdmin:admin").getBytes(StandardCharsets.UTF_8));
            String auth = Base64.encodeBase64String(encoding);
            log.info("get content document via rest client");
            String url = "http://localhost:8080/proyekOCR/services/rest/document/getContent";
            
            HttpClient client = HttpClientBuilder.create().build();       
            List<NameValuePair> urlParameters = new ArrayList<>();
            urlParameters.add( new BasicNameValuePair("docId", docId));
            String queryString = URLEncodedUtils.format(urlParameters, "UTF-8");
	    url += ("?" + queryString);
            HttpGet get = new HttpGet(url);            
            get.setHeader("Accept", "application/json");
            get.addHeader("Authorization", "Basic " + auth);
            HttpResponse response = client.execute(get);      
            int statusCode = response.getStatusLine().getStatusCode();            
            log.info(String.valueOf(statusCode));
            HttpHeaders headers = new HttpHeaders();
            headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
            headers.add("Pragma", "no-cache");
            headers.add("Expires", "0");

            HttpEntity entity =  response.getEntity();
            InputStream is = entity.getContent();
            
            
            return ResponseEntity
            .ok()
            .headers(headers)
            .contentLength(entity.getContentLength())
            .contentType(MediaType.parseMediaType("application/pdf"))
            .body(new InputStreamResource(is));
            
            try {
           
            URL url = new URL("http://localhost:8080/OpenKM/services/rest/document/getContent?docId=" + docId);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
 
            Authenticator.setDefault(new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("okmAdmin", "admin".toCharArray());
                }
            });
 
            if (conn.getResponseCode() == 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
                System.out.println("Output from Server .... \n");
                String output;
 
                while ((output = br.readLine()) != null) {
                    System.out.println(output);
                }
            } else {
                System.err.println("Failed : HTTP error code : " + conn.getResponseCode());
            }
 
            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     */   
    /*    
    @RequestMapping(value = "/getContent-{docId}", method = RequestMethod.GET, 
            produces ={ "application/pdf"})
        public ResponseEntity<InputStreamResource> download(@PathVariable("docId") String docId) throws IOException {
        System.out.println("Calling Download:- " + docId);
        //ClassPathResource pdfFile = new ClassPathResource("downloads/" + fileName);
        String url = "http://localhost:8080/proyekOCR/services/rest/document/getContent";
        byte[] encoding = Base64.encodeBase64(("okmAdmin:admin").getBytes(StandardCharsets.UTF_8));
        String auth = Base64.encodeBase64String(encoding);
                
        HttpClient client = HttpClientBuilder.create().build();       
        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add( new BasicNameValuePair("docId", docId));
        String queryString = URLEncodedUtils.format(urlParameters, "UTF-8");
        url += ("?" + queryString);
        HttpGet get = new HttpGet(url);            
        get.addHeader("Authorization", "Basic " + auth);
        
        HttpResponse response = client.execute(get);      
        int statusCode = response.getStatusLine().getStatusCode();            
        System.out.println(statusCode);
        HttpEntity entity =  response.getEntity();
        
            
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        headers.add("Content-Disposition", "filename=" + docId);
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        headers.setContentLength(entity.getContentLength());
        ResponseEntity<InputStreamResource> respons = new ResponseEntity<>(
          new InputStreamResource(entity.getContent()), headers, HttpStatus.OK);
        return respons;

    }

    */    
        
    @ResponseBody
    @RequestMapping(value = "getContent-{docId}", headers="Accept=*/*", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> getPdfContractById(@PathVariable("docId") String docId) throws IOException{
           
            String url = "http://localhost:8080/OpenKM/services/rest/document/getContent/";
            String originalInput = "okmAdmin:admin";
            Base64 base64 = new Base64();
            String auth = new String(base64.encode(originalInput.getBytes()));
            HttpClient client = HttpClientBuilder.create().build();       
            List<NameValuePair> urlParameters = new ArrayList<>();
            urlParameters.add( new BasicNameValuePair("docId", docId));
            String queryString = URLEncodedUtils.format(urlParameters, "UTF-8");
            url += ("?" + queryString);
            
            HttpGet get = new HttpGet(url);            
            get.addHeader("Authorization", "Basic " + auth);
            
            HttpResponse response = client.execute(get);      
            int statusCode = response.getStatusLine().getStatusCode();            
            log.info("http response : " +  String.valueOf(statusCode));     
            
            // Set the input stream
            HttpEntity entity = response.getEntity();
            HttpHeaders headers = new HttpHeaders();
                        
            headers.setContentType(MediaType.parseMediaType("application/pdf"));
            headers.add("Content-Disposition", "filename=" + docId);
            headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
            headers.add("Pragma", "no-cache");
            headers.add("Expires", "0");
            headers.setContentLength(entity.getContentLength());
 
            ResponseEntity<InputStreamResource> respon = new ResponseEntity<>(
            new InputStreamResource(entity.getContent()), headers, HttpStatus.OK);
        return respon;   
    }   
       
    @RequestMapping(value = "/fileupload", headers=("content-type=multipart/*"), 
    method = RequestMethod.POST)
    public ResponseEntity<RestFileInfo> upload(@RequestParam("file") MultipartFile inputFile) {
        RestFileInfo fileInfo = new RestFileInfo();
        HttpHeaders headers = new HttpHeaders();
        if (!inputFile.isEmpty()) {
            try {
                String originalFilename = inputFile.getOriginalFilename();
                File destinationFile = new File(context.getRealPath("/static/file-bucket/original")+  File.separator + originalFilename);
                inputFile.transferTo(destinationFile);
                fileInfo.setFileName(destinationFile.getPath());
                fileInfo.setFileSize(inputFile.getSize());

                BucketFileList bucketFileList = new BucketFileList();
                bucketFileList.setOriginalFile(originalFilename);
                bucketFileList.setStatus(String.valueOf(0));
                bucketFileListService.save(bucketFileList);
                headers.add("File Uploaded Successfully - ", originalFilename);
                return new ResponseEntity<RestFileInfo>(fileInfo, headers, HttpStatus.OK);

            } catch (Exception e) { 
                System.out.println(e.getMessage());

                return new ResponseEntity<RestFileInfo>(HttpStatus.BAD_REQUEST);
            }
        }else{

            return new ResponseEntity<RestFileInfo>(HttpStatus.BAD_REQUEST);
        }
    }

        
    @RequestMapping(value="/multiUpload", method = RequestMethod.GET)
    public String getMultiUploadPage(ModelMap model) {
            MultiFileBucket filesModel = new MultiFileBucket();
            model.addAttribute("multiFileBucket", filesModel);
            return "multiFileUploader";
    }

    @RequestMapping(value="/multiUpload", method = RequestMethod.POST)
    public String multiFileUpload(@Valid MultiFileBucket multiFileBucket, BindingResult result, ModelMap model) throws IOException {


            if (result.hasErrors()) {
                    System.out.println("validation errors in multi upload");
                    return "multiFileUploader";
            } else {			
                    System.out.println("Fetching files");

                    List<String> fileNames= new ArrayList<String>();

                    //Now do something with file...
                    for(FileBucket bucket : multiFileBucket.getFiles()){
                            FileCopyUtils.copy(bucket.getFile().getBytes(), new File(UPLOAD_LOCATION + bucket.getFile().getOriginalFilename()));
                            fileNames.add(bucket.getFile().getOriginalFilename());
                    }

                    model.addAttribute("fileNames", fileNames);

                    return "multiSuccess";
            }
    }
        
        
    /**
     * This method returns the principal[user-name] of logged-in user.
     */
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
