package com.proyekOCR.springmvc.service;

import com.proyekOCR.springmvc.dao.BucketFileListDao;
import com.proyekOCR.springmvc.model.BucketFileList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.hibernate.SessionFactory;
import com.proyekOCR.springmvc.util.FillManager;
import com.proyekOCR.springmvc.util.Layouter;
import com.proyekOCR.springmvc.util.Writer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Service for processing Apache POI-based reports
 * 
 * @author Krams at {@link http://krams915@blogspot.com}
 */
@Service("downloadService")
@Transactional
public class DownloadService {
    
    @Autowired
    private BucketFileListService bucketFileListService;

    private static Logger logger = Logger.getLogger("service");
	
    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;
	
	/**
	 * Processes the download for Excel format.
	 * It does the following steps:
	 * <pre>1. Create new workbook
	 * 2. Create new worksheet
	 * 3. Define starting indices for rows and columns
	 * 4. Build layout 
	 * 5. Fill report
	 * 6. Set the HttpServletResponse properties
	 * 7. Write to the output stream
	 * </pre>
	 */
	@SuppressWarnings("unchecked")
	public void downloadXLS(HttpServletResponse response,String instansi,String status,String sdate, String edate) throws ClassNotFoundException {
		logger.debug("Downloading Excel report");
		
		// 1. Create new workbook
		HSSFWorkbook workbook = new HSSFWorkbook();
		
		// 2. Create new worksheet
		HSSFSheet worksheet = workbook.createSheet("POI Worksheet");
		
		// 3. Define starting indices for rows and columns
		int startRowIndex = 0;
		int startColIndex = 0;
		
		// 4. Build layout 
		// Build title, date, and column headers
		Layouter.buildReport(worksheet, startRowIndex, startColIndex);

		// 5. Fill report
		FillManager.fillReport(worksheet, startRowIndex, startColIndex, getDatasource(instansi,status,sdate,edate));
		
		// 6. Set the response properties
		String fileName = "fileList.xls";
		response.setHeader("Content-Disposition", "inline; filename=" + fileName);
		// Make sure to set the correct content type
		response.setContentType("application/vnd.ms-excel");
		
		//7. Write to the output stream
		Writer.write(response, worksheet);
	}
	
	/**
	 * Retrieves the datasource as as simple Java List.
	 * The datasource is retrieved from a Hibernate HQL query.
	 */
	@SuppressWarnings("unchecked")
	private List<BucketFileList> getDatasource(String instansi,String status,String sdate, String edate) {
		
     	    List<BucketFileList> result = bucketFileListService.findAllByDate(instansi,status,sdate,edate);
	    // Return the datasource
	    return result;
	}
}
