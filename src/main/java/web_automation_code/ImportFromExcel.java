package web_automation_code;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;
import java.util.*;

public class ImportFromExcel {
	
	private CellType NUMERIC;
	private CellType STRING;
	public List<Integer> create_int_list(int i) {
		
		//List<Integer> number_list = new ArrayList<Integer>(); output_list
		List<Integer> number_list = new ArrayList<Integer>();
		List<Integer> output_list = new ArrayList<Integer>();
		List<Integer> first_departure_years_list = new ArrayList<Integer>();
		List<Integer> first_departure_day_list = new ArrayList<Integer>();
		List<Integer> second_departure_years_list = new ArrayList<Integer>();
		List<Integer> second_departure_day_list = new ArrayList<Integer>();
		List<Integer> adults_amount_list = new ArrayList<Integer>();
		List<Integer> youth_amount_list = new ArrayList<Integer>();
		List<Integer> child_amount_list = new ArrayList<Integer>();
		List<Integer> baby_amount_list = new ArrayList<Integer>();
		
        String excelFilePath = "travel_plans.xlsx";
        int numRows = 0;
        int numCols = 0;
        Sheet sheet = null;
        
        try {
            FileInputStream inputStream = new FileInputStream(excelFilePath);
            Workbook workbook = new XSSFWorkbook(inputStream);
            sheet = workbook.getSheetAt(0);
            numRows = sheet.getLastRowNum() + 1;
            numCols = sheet.getRow(0).getLastCellNum();
            System.out.print(numRows);
            
            for (int y = 1; y < numRows; y++) {
            	Row nextRow = sheet.getRow(y);
            	
                for (int j = 0; j < numCols; j++) {
                	 Cell nextCell = nextRow.getCell(j);
                    if (j == 0 || (j > 6 && j != 9)) {
                    	switch (j) {
                        case 0:
                            int row_number = (int) nextCell.getNumericCellValue();
                            number_list.add(row_number);
                            break;
                        case 7:
                        	int first_departure_year = (int) nextCell.getNumericCellValue();
                        	first_departure_years_list.add(first_departure_year);
                            break;
                        case 8:
                        	int first_departure_day = (int) nextCell.getNumericCellValue();
                        	first_departure_day_list.add(first_departure_day);
                            break;
                        case 10:
                        	int second_departure_year = (int) nextCell.getNumericCellValue();
                        	second_departure_years_list.add(second_departure_year);
                            break;
                        case 11:
                        	int second_departure_day = (int) nextCell.getNumericCellValue();
                        	second_departure_day_list.add(second_departure_day);
                            break;
                        case 12:
                        	int adults_amount = (int) nextCell.getNumericCellValue();
                        	adults_amount_list.add(adults_amount);
                        case 13:
                        	int youth_amount = (int) nextCell.getNumericCellValue();
                        	youth_amount_list.add(youth_amount);
                            break;
                        case 14:
                        	int child_amount = (int) nextCell.getNumericCellValue();
                        	child_amount_list.add(child_amount);
                            break;
                        case 15:
                        	int baby_amount = (int) nextCell.getNumericCellValue();
                        	baby_amount_list.add(baby_amount);
                        }
                    }
                }       

            }
            workbook.close();
            inputStream.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
        switch (i) {
        case 0:
        	output_list = number_list;
            break;
        case 7:
        	output_list = first_departure_years_list;
            break;
        case 8:
        	output_list = first_departure_day_list;
            break;
        case 10:
        	output_list = second_departure_years_list;
            break;
        case 11:
        	output_list = second_departure_day_list;
            break;
        case 12:
        	output_list = adults_amount_list;
        case 13:
        	output_list = youth_amount_list;
            break;
        case 14:
        	output_list = child_amount_list;
            break;
        case 15:
        	output_list = baby_amount_list; 
        	break;
        }
        return output_list;

	}
	
	public List<String> create_string_list(int i) {
		
		//List<Integer> number_list = new ArrayList<Integer>();
		List<String> output_list = new ArrayList<String>();
		List<String> my_class_list = new ArrayList<String>();
		List<String> first_departure_location_list = new ArrayList<String>();
		List<String> first_arrival_location_list = new ArrayList<String>();
		List<String> second_departure_location_list = new ArrayList<String>();
		List<String> final_destination_location_list = new ArrayList<String>();
		List<String> first_departure_month_list = new ArrayList<String>();
		List<String> second_departure_month_list = new ArrayList<String>();
		
        String excelFilePath = "travel_plans.xlsx";
        int numRows = 0;
        int numCols = 0;
        
        try {
            FileInputStream inputStream = new FileInputStream(excelFilePath);
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            numRows = sheet.getLastRowNum() + 1;
            numCols = sheet.getRow(0).getLastCellNum();
            workbook.close();
            inputStream.close();
             
            for (int y = 1; y < numRows; y++) {
            	Row nextRow = sheet.getRow(y);
            	
                for (int j = 0; j < numCols; j++) {
                	Cell nextCell = nextRow.getCell(j);
                    
                    if (j != 0 && j != 7 && j != 8 && j < 10) {
                    	
                    	switch (j) {
                        case 1:
                            String my_class = nextCell.getStringCellValue();
                            my_class_list.add(my_class);
                            break;
                        case 2:
                        	String first_departure_location = nextCell.getStringCellValue();
                        	first_departure_location_list.add(first_departure_location);
                            break;
                        case 3:
                        	String first_arrival_location = nextCell.getStringCellValue();
                        	first_arrival_location_list.add(first_arrival_location);
                            break;
                        case 4:
                        	String second_departure_location = nextCell.getStringCellValue();
                        	second_departure_location_list.add(second_departure_location);
                            break;
                        case 5:
                        	String final_destination_location = nextCell.getStringCellValue();
                        	final_destination_location_list.add(final_destination_location);
                            break;
                        case 6:
                        	String first_departure_month = nextCell.getStringCellValue();
                        	first_departure_month_list.add(first_departure_month);
                            break;
                        case 9:
                        	String second_departure_month = nextCell.getStringCellValue();
                        	second_departure_month_list.add(second_departure_month);
                            break;
                        }
                    }
                }       

            }
             
        } catch (IOException e) {
            e.printStackTrace();
        } 
        
        switch (i) {
        
        case 1:
        	output_list = my_class_list;
            break;
		case 2:
			output_list = first_departure_location_list;
            break;
		case 3:
			output_list = first_arrival_location_list;
            break;
        case 4:
        	output_list = second_departure_location_list;
            break;
        case 5:
        	output_list = final_destination_location_list;
            break;
        case 6:
        	output_list = first_departure_month_list;
            break;
        case 9:
        	output_list = second_departure_month_list;
        	break;

        }
        return output_list;
	}
}
