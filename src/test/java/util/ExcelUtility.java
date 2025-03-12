package util;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
public class ExcelUtility {
//	  private static XSSFWorkbook workbook;
//	    private static XSSFSheet sheet;
//
//	    public static String getData(String filePath, String sheetName, String region) throws IOException {
//	        FileInputStream fs = new FileInputStream(filePath);
//	        workbook = new XSSFWorkbook(fs);
//	        sheet = workbook.getSheet(sheetName.toLowerCase());
//
//	        if (sheet == null) {
//	            workbook.close();
//	            fs.close();
//	            throw new IllegalArgumentException("Invalid sheet name: " + sheetName);
//	        }
//
//	        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
//	            String regionName = sheet.getRow(i).getCell(0).toString();
//	            if (regionName.equalsIgnoreCase(region)) {
//	                String link = sheet.getRow(i).getCell(1).toString();
//	                workbook.close();
//	                fs.close();
//	                return link;
//	            }
//	        }
//
//	        workbook.close();
//	        fs.close();
//	        throw new IllegalArgumentException("No URL found for region: " + region);
//	    }
	
	private static XSSFWorkbook workbook;
    private static Sheet sheet;

    // Method to get the link based on the region (from the LinkSheet)
    public static String getLink(String filePath, String sheetName, String region) throws IOException {
        FileInputStream fs = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fs);
        sheet = workbook.getSheet(sheetName.toLowerCase());

        if (sheet == null) {
            workbook.close();
            fs.close();
            throw new IllegalArgumentException("Invalid sheet name: " + sheetName);
        }

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            String regionName = sheet.getRow(i).getCell(0).toString();
            if (regionName.equalsIgnoreCase(region)) {
                String link = sheet.getRow(i).getCell(1).toString();
                workbook.close();
                fs.close();
                return link;
            }
        }

        workbook.close();
        fs.close();
        throw new IllegalArgumentException("No URL found for region: " + region);
    }

    // Method to get form data from Excel for all rows (ignoring the header row)
    public static String[][] getFormData(String filePath, String sheetName) throws IOException {
        FileInputStream fs = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fs);
        sheet = workbook.getSheet(sheetName.toLowerCase());

        if (sheet == null) {
            workbook.close();
            fs.close();
            throw new IllegalArgumentException("Invalid sheet name: " + sheetName);
        }

        int rows = sheet.getPhysicalNumberOfRows();
        int cols = sheet.getRow(0).getPhysicalNumberOfCells(); // Number of columns in the sheet

        String[][] formData = new String[rows-1][cols]; // Initialize a 2D array, excluding the header row

        // Iterate through each row and get the data
        for (int i = 1; i < rows; i++) {  // Start from row 1 to skip the header
            for (int j = 0; j < cols; j++) {
                // Check if the cell is null before accessing its value
                if (sheet.getRow(i).getCell(j) != null) {
                    formData[i-1][j] = sheet.getRow(i).getCell(j).toString();  // Fill data into array
                } else {
                    formData[i-1][j] = "";  // If the cell is null, assign an empty string
                }
            }
        }

        workbook.close();
        fs.close();
        return formData;
    }
    
    public static String[] getLambdaTestCredentials(String filepath,String sheetName) throws IOException {
    	FileInputStream fs = new FileInputStream(filepath);
        workbook = new XSSFWorkbook(fs);
        sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            throw new IllegalArgumentException("Invalid sheet name: " + sheetName);
        }

        String username = null, passkey = null;
        for (Row row : sheet) {
            if (row.getCell(0) != null && row.getCell(1) != null) {
                String key = row.getCell(0).toString().trim().toLowerCase();
                String value = row.getCell(1).toString().trim();

                if (key.equals("username")) {
                    username = value;
                } else if (key.equals("passkey")) {
                    passkey = value;
                }
            }
        }

        if (username == null || passkey == null) {
            throw new IllegalArgumentException("LambdaTest credentials not found in sheet: " + sheetName);
        }

        return new String[]{username, passkey}; // Returning as String array
    }

    // Close workbook
    public void closeWorkbook() throws IOException {
        workbook.close();
    }
}



