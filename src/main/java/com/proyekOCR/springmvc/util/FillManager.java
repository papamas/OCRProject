package com.proyekOCR.springmvc.util;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.CellStyle;
import com.proyekOCR.springmvc.model.BucketFileList;

public class FillManager {

	/**
	 * Fills the report with content
	 * 
	 * @param worksheet
	 * @param startRowIndex starting row offset
	 * @param startColIndex starting column offset
	 * @param datasource the data source
	 */
	public static void fillReport(HSSFSheet worksheet, int startRowIndex, int startColIndex, List<BucketFileList> datasource) {
		// Row offset
		startRowIndex += 2;
		
		// Create cell style for the body
		HSSFCellStyle bodyCellStyle = worksheet.getWorkbook().createCellStyle();
		bodyCellStyle.setAlignment(CellStyle.ALIGN_CENTER);
		bodyCellStyle.setWrapText(true);
		int no = 1;
			
		// Create body
		for (int i=startRowIndex; i+startRowIndex-2< datasource.size()+2; i++) {
			// Create a new row
			HSSFRow row = worksheet.createRow((short) i+1);
                        // Retrieve the id value
			HSSFCell cell1 = row.createCell(startColIndex+0);
			cell1.setCellValue(no);
			cell1.setCellStyle(bodyCellStyle);

			// Retrieve the brand value
			HSSFCell cell2 = row.createCell(startColIndex+1);
			cell2.setCellValue(datasource.get(i-2).getNip());
			cell2.setCellStyle(bodyCellStyle);

			// Retrieve the model value
			HSSFCell cell3 = row.createCell(startColIndex+2);
			cell3.setCellValue(datasource.get(i-2).getJenisDoc());
			cell3.setCellStyle(bodyCellStyle);

			// Retrieve the maximum power value
			HSSFCell cell4 = row.createCell(startColIndex+3);
			cell4.setCellValue(datasource.get(i-2).getInstansi());
			cell4.setCellStyle(bodyCellStyle);

                        String status = null;
			// Retrieve the price value
                        switch (datasource.get(i-2).getStatus()) {
                            case "0":
                               status = "NEW";
                            break;
                            case "1":
                               status = "IMS";
                            break;
                            case "2":
                               status = "DMS";
                            break;
                            case "3":
                               status = "SAPK";
                            break;
                        }
			HSSFCell cell5 = row.createCell(startColIndex+4);
			cell5.setCellValue(status);
			cell5.setCellStyle(bodyCellStyle);
		
			// Retrieve the efficiency value
			HSSFCell cell6 = row.createCell(startColIndex+5);
			cell6.setCellValue(datasource.get(i-2).getdmsFile());
			cell6.setCellStyle(bodyCellStyle);
                        
                        HSSFCell cell7 = row.createCell(startColIndex+6);
			cell7.setCellValue(datasource.get(i-2).getCreatedDate().toString());
			cell7.setCellStyle(bodyCellStyle);
                        
                        HSSFCell cell8 = row.createCell(startColIndex+7);
			cell8.setCellValue(datasource.get(i-2).getUpdateDate().toString());
			cell8.setCellStyle(bodyCellStyle);
                        
                        no++;
		}
	}
}
