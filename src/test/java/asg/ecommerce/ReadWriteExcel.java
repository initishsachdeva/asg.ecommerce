package asg.ecommerce;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
//import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWriteExcel {
	public static int flag = 0;

	public String readExcel(int row, int col, String data1, String inputfile) throws IOException {

		try {

			File file = new File(inputfile);
			FileInputStream inputStream = new FileInputStream(file);

			@SuppressWarnings("resource")
			Workbook TestWorkbook = new XSSFWorkbook(inputStream);
			Sheet TestSheet;
			if (data1.equals("signin")) {
				TestSheet = TestWorkbook.getSheetAt(1);
				Row rowdata = TestSheet.getRow(row);
				if ((row == 4 || row == 5 || row == 7 || row == 11 || row == 13) && (col == 2)) {
					int data = (int) rowdata.getCell(col).getNumericCellValue();

					return Integer.toString(data);
				} else {
					return rowdata.getCell(col).getStringCellValue();
				}
			} else {
				TestSheet = TestWorkbook.getSheetAt(0);
				Row rowdata = TestSheet.getRow(row);
				if ((row == 4 || row == 5 || row == 7 || row == 11 || row == 13) && (col == 2)) {
					int data = (int) rowdata.getCell(col).getNumericCellValue();

					return Integer.toString(data);
				} else {
					return rowdata.getCell(col).getStringCellValue();
				}
			}

		} catch (Exception e) {
			return "" + e + "Read Error";
		}
	}
   public void createfile(String outputfile) throws IOException 
   {
	   XSSFWorkbook wb=new XSSFWorkbook();
		Sheet sheet=wb.createSheet("Product");
		Sheet sheet1=wb.createSheet("Price");
		Sheet sheet2=wb.createSheet("Registration");
		Sheet sheet3=wb.createSheet("Order Confirmation");
		Sheet sheet4=wb.createSheet("Order History");
		FileOutputStream fileOut = new FileOutputStream(outputfile);
		wb.write(fileOut);
		fileOut.close();
		wb.close();
   }
	public void write(List<String> msg, String data, String outputfile) throws IOException, InvalidFormatException {
		InputStream inp = new FileInputStream(outputfile);
		
		Workbook wb = WorkbookFactory.create(inp);
		CellStyle cs = wb.createCellStyle();

		cs.setAlignment(HorizontalAlignment.CENTER);
		cs.setWrapText(true); // Wrapping text
		Sheet sheet;
		@SuppressWarnings("unused")
		Cell cell;
		if (data.equals("Product")) {
			cs.setAlignment(HorizontalAlignment.CENTER);
		    sheet=wb.getSheet(data);
		    Row rowhead=sheet.createRow((short)0);
			rowhead.createCell(0).setCellValue("Name");
			rowhead.createCell(1).setCellValue("Color");
			rowhead.createCell(2).setCellValue("Sku");
			rowhead.createCell(3).setCellValue("Size");
			rowhead.createCell(4).setCellValue("Qty");
			rowhead.createCell(5).setCellValue("Price");
			int num = sheet.getLastRowNum();
			Row row = sheet.createRow(num + 1);
			row.createCell(0).setCellValue(msg.get(0));
			row.createCell(1).setCellValue(msg.get(1));
			row.createCell(2).setCellValue(msg.get(2));
			row.createCell(3).setCellValue(msg.get(3));
			row.createCell(4).setCellValue(msg.get(4));
			row.createCell(5).setCellValue(msg.get(5));

		} else if (data.equals("Price")) {
			cs.setAlignment(HorizontalAlignment.CENTER);
			 sheet = wb.getSheet(data);
			 //sheet1 = wb.createSheet(data);
			Row row=sheet.createRow((short)0);
			row.createCell(0).setCellValue("Row Number");
			row.createCell(1).setCellValue("Total Products");
			row.createCell(2).setCellValue("Total Shipping");
			row.createCell(3).setCellValue("Total");
			int num = sheet.getLastRowNum();
			row = sheet.createRow(num + 1);
			row.createCell(0).setCellValue(num + 1);
			row.createCell(1).setCellValue(msg.get(0));
			row.createCell(2).setCellValue(msg.get(1));
			row.createCell(3).setCellValue(msg.get(2));

		} else if (data.equals("Registration")) {
			cs.setAlignment(HorizontalAlignment.CENTER);
			List<String> details = new ArrayList<String>();
			details.add("First Name");
			details.add("Last Name");
			details.add("Address");
			details.add("City");
			details.add("State");
			details.add("Postal Code");
			details.add("Country");
			details.add("Mobile");
			sheet = wb.getSheet(data);
			Row row=sheet.createRow((short)0);
			row.createCell(0).setCellValue("Row Number");
			row.createCell(1).setCellValue("Registration Output");
			row.createCell(2).setCellValue("Registration Values");
			
			//Sheet sheet = wb.getSheetAt(2);
			for (int i = 0; i < msg.size(); i++) {
				int num = sheet.getLastRowNum();
				 row = sheet.createRow(num + 1);
				row.createCell(0).setCellValue(num + 1);
				row.createCell(1).setCellValue(details.get(i));
				row.createCell(2).setCellValue(msg.get(i));
			}
			details.clear();

		} else if (data.equals("Order Confirmation")) {
			cs.setAlignment(HorizontalAlignment.CENTER);
			sheet= wb.getSheet(data);
			//wb.setSheetOrder(data, 3);
			Row row=sheet.createRow((short)0);
			row.createCell(0).setCellValue("Row Number");
			row.createCell(1).setCellValue("Amount");
			//Sheet sheet = wb.getSheetAt(3);
			int num = sheet.getLastRowNum();
			row = sheet.createRow(num + 1);
			row.createCell(0).setCellValue(num + 1);
			row.createCell(1).setCellValue(msg.get(0));

		} else if (data.equals("Order History")) {
			cs.setAlignment(HorizontalAlignment.CENTER);
			List<String> details = new ArrayList<String>();
			details.add("Order Reference");
			details.add("Date");
			details.add("Total Price");
			details.add("Payment");
			details.add("Status");
			sheet = wb.getSheet(data);
			//wb.setSheetOrder(data, 4);
			Row row=sheet.createRow((short)0);
			row.createCell(0).setCellValue("Row Number");
			row.createCell(1).setCellValue("Order History Attributes");
			row.createCell(2).setCellValue("Order History Values");
			//Sheet sheet = wb.getSheetAt(4);
			for (int i = 0; i < msg.size(); i++) {
				int num = sheet.getLastRowNum();
				 row = sheet.createRow(num + 1);
				row.createCell(0).setCellValue(num + 1);
				row.createCell(1).setCellValue(details.get(i));
				row.createCell(2).setCellValue(msg.get(i));
			}
			details.clear();

		}

		// Now this Write the output to a file
		FileOutputStream fileOut = new FileOutputStream(outputfile);
		wb.write(fileOut);
		fileOut.close();
		wb.close();
	}

}