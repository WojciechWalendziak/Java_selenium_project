// PROJECT NOT COMPLETED YET :-)

package web_automation_code;

import org.openqa.selenium.chrome.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import web_automation_code.ImportFromExcel;
import web_automation_code.screenhot_code;

public class WebAutomation {
	
	public static void main(String[] args) throws InterruptedException {
		

	int i = 0;
	int q = 0;
	int size = 0;
	int size_bis = 0;
	int check = 0;
	int count = 0;
	int searched_year = 0;
	int first_departure_year = 0;
	int searched_day = 0;
	int first_departure_day = 0;
	int second_departure_year = 0;
	int second_departure_day = 0;
	int adults_amount = 0;
	int youth_amount = 0;
	int child_amount = 0;
	int baby_amount = 0;
	int int_searched_month = 0;
	String my_class = "";
	String searched_month = "";
	String first_departure_location = "";
	String first_arrival_location = "";
	String second_departure_location = "";
	String final_destination_location = "";
	String first_departure_month = "";
	String second_departure_month = "";
	String current_month_string = "";
	String current_year_string = "";
	
	ImportFromExcel import_from_excel = new ImportFromExcel();

	//import_from_excel.create_lists();
    
	//ArrayList<Integer> list = retClass.myFun();
	List<Integer> number_list = import_from_excel.create_int_list(0);
	List<String> my_class_list = import_from_excel.create_string_list(1);
	List<String> first_departure_location_list = import_from_excel.create_string_list(2);
	List<String> first_arrival_location_list = import_from_excel.create_string_list(3);
	List<String> second_departure_location_list = import_from_excel.create_string_list(4);
	List<String> final_destination_location_list = import_from_excel.create_string_list(5);
	List<String> first_departure_month_list = import_from_excel.create_string_list(6);
	List<Integer> first_departure_years_list = import_from_excel.create_int_list(7);
	List<Integer> first_departure_day_list = import_from_excel.create_int_list(8);
	List<String> second_departure_month_list = import_from_excel.create_string_list(9);
	List<Integer> second_departure_years_list = import_from_excel.create_int_list(10);
	List<Integer> second_departure_day_list = import_from_excel.create_int_list(11);
	List<Integer> adults_amount_list = import_from_excel.create_int_list(12);
	List<Integer> youth_amount_list = import_from_excel.create_int_list(13);
	List<Integer> child_amount_list = import_from_excel.create_int_list(14);
	List<Integer> baby_amount_list = import_from_excel.create_int_list(15);
	
	size = number_list.size();

		// TODO Auto-generated method stub
    		for (i = 0; i < size; i++) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\wojci\\Documents\\KODOWANIE\\chromedriver\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver(); 
		
	    try{
	        driver.get("https://www.esky.pl/tanie-loty?gclid=EAIaIQobChMIx4jzwvnU_gIVyAqiAx0M9ATbEAAYAiAAEgKxNPD_BwE");
	        Thread.sleep(5);
	    }
	    finally{
	    	System.out.print("page loading failed");
	    }
	    
	    try{
	    	WebElement cookie_box = driver.findElement(By.id("CybotCookiebotDialog"));
	    	WebElement cookie_button = cookie_box.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"));
	    	cookie_button.click();
	    	Thread.sleep(3);
	    }
	    finally{
	    	System.out.print("cookie window not found");
	    }
	    WebElement form_box;
	    try{
	    	WebElement outer_form_box = driver.findElement(By.id("multiQsfFlights"));
	    	form_box = outer_form_box.findElement(By.tagName("form"));
	    }
	    finally{
	    	System.out.print("form box not found");
	    }
	    WebElement form_top;
	    WebElement main_class;
	    try{
			form_top = form_box.findElement(By.className("top"));
	    	main_class = form_box.findElement(By.className("main"));
	    }
	    finally{
	    	System.out.print("top & main class not found");
	    }
	    Select trip_type_list;
	    try{
	    	trip_type_list = new Select(form_top.findElement(By.id("serviceClass")));
	    }
	    finally{
	    	System.out.print("class selector not found");
	    }
	    
	    try{
	    	trip_type_list.selectByValue(my_class_list.get(i));
	    	Thread.sleep(5);
	    }
	    finally{
	    	System.out.print("selecting " + (my_class_list.get(i)).toString() + " option from dropdown failed");
	    }
	    
	    try {
	    	WebElement new_trip_type_list = form_top.findElement(By.className("trip-type-list"));
	    }
	    finally{
	    	System.out.print("trip_type_list class not found");
	    }
	    
	    try {
	    	List<WebElement> li_tags = trip_type_list.findElements(By.tagName("li"));
	    	size_bis = li_tags.size();
	        for (q = 0; i < size_bis; q++) {
	            try {
	            	WebElement demanded_li = li_tags.get(q).findElement(By.id("TripTypeMulticity"));
	                demanded_li.click();
	                Thread.sleep(3);
	            }
	        	finally{
	                continue;
	            }
	        }
	    }
	    finally{
	    	System.out.print("travel type not selected");
	    }
	    WebElement tm;
	    try {
	    	tm = main_class.findElement(By.id("tm"));
	    }
	    finally{
	    	System.out.print("tm block not found");
	    }
	    
	    try {
	    	WebElement departure_location_0 = tm.findElement(By.id("departureMulticity0"));
	    	departure_location_0.sendKeys(first_departure_location);
	    	WebElement arrival_location_0 = tm.findElement(By.id("arrivalMulticity0"));
	    	arrival_location_0.sendKeys(first_arrival_location);
	    	WebElement departure_location_1 = tm.findElement(By.id("departureMulticity1"));
	    	departure_location_1.sendKeys(second_departure_location);
	    	WebElement arrival_location_1 = tm.findElement(By.id("arrivalMulticity1"));
	    	arrival_location_1.sendKeys(final_destination_location);
	    }
	    finally{
	    	System.out.print("arrivals and/or departures locations not found");
	    }
	    List<WebElement> departure_dates;
	    try {
	    	departure_dates = tm.findElements(By.className("trip-dates"));
	    }
	    finally{
	    	System.out.print("trip-dates not found");
	    }
	    count = 0;
	    size_bis = departure_dates.size();
	    
	    for (q = 0; i < size_bis; i++) {
	        try {
	        	WebElement date_button = departure_dates.get(q).findElement(By.tagName("button"));
	            date_button.click();
	            Thread.sleep(3);
	            check = 1;
	            count = count + 1;
	        }
	        finally{
	            check = 0;
	        }

	        if (check == 1) {
	        	
	            check = 0;
	            if (count < 2) {
	                searched_month = first_departure_month_list.get(i);
	                searched_year = first_departure_years_list.get(i);
	                searched_day = first_departure_day_list.get(i);
	            }
	            else {
	            	searched_month = second_departure_month_list.get(i);
	                searched_year = second_departure_years_list.get(i);
	                searched_day = second_departure_day_list.get(i);
	            }
	            count = count + 1;
	            WebElement date_selection_box;
	            WebElement date_selection_box_header;
	            WebElement current_month_and_year_box;
	            while (check == 0) {
	                try {
	                	date_selection_box = driver.findElement(By.id("ui-datepicker-div"));
	                }
	                finally{
	                	System.out.print("ui-datepicker-div not found");
	                }
	                try {
	                	date_selection_box_header = date_selection_box.findElement(By.className("ui-datepicker-header"));
	                }
	                finally{
	                	System.out.print("ui - datepicker - header not found");
	                }
	                WebElement move_to_next_month_button;
	                try {
	                	move_to_next_month_button = date_selection_box_header.findElement(By.className("ui-datepicker-next"));
	                }
	                finally{
	                	System.out.print("ui-datepicker-next not found");
	                }
	                try {
	                	current_month_and_year_box = date_selection_box_header.findElement(By.className("ui-datepicker-title"));
	                }
	                finally {
	                	System.out.print("ui-datepicker-title not found");
	                }
	                WebElement current_month;
	                try {
	                	current_month = current_month_and_year_box.findElement(By.className("ui-datepicker-month"));
	                    current_month_string = current_month.getAttribute("innerHTML").strip();
	                }
	                finally {
	                	System.out.print("ui-datepicker-month not found");
	                }
	                WebElement current_year;
	                try {
	                	current_year = current_month_and_year_box.findElement(By.className("ui-datepicker-year"));
	                    current_year_string = current_year.getAttribute("innerHTML").strip();
	                }
	                finally {
	                	System.out.print("ui-datepicker-year not found");
	                }

	                if (current_month_string == searched_month.toString() && current_year_string == searched_year.toString())
	                {
	                    check = 1;
	                    switch (searched_month) {
	                        case "Styczeń":
	                            int_searched_month = 1;
	                            break;
	                        case "Luty":
	                            int_searched_month = 2;
	                        case "Marzec":
	                            int_searched_month = 3;
	                        case "Kwiecień":
	                            int_searched_month = 4;
	                        case "Maj":
	                            int_searched_month = 5;
	                        case "Czerwiec":
	                            int_searched_month = 6;
	                        case "Lipiec":
	                            int_searched_month = 7;
	                        case "Sierpień":
	                            int_searched_month = 8;
	                        case "Wrzesień":
	                            int_searched_month = 9;
	                        case "Październik":
	                            int_searched_month = 10;
	                        case "Listopad":
	                            int_searched_month = 11;
	                        case "Grudzień":
	                            int_searched_month = 12;
	                    }
	                    WebElement date_selection_box_table;
	                    try {
	                    	date_selection_box_table = date_selection_box.findElement(By.className("ui-datepicker-calendar"));
	                    }
	                    finally {
	                    	System.out.print("ui-datepicker-calendar not found");
	                    }
	                    WebElement date_selection_box_table_body;
	                    try {
	                    	date_selection_box_table_body = date_selection_box_table.findElement(By.tagName("tbody");
	                    }
	                    finally {
	                        System.out.print("tbody not found");
	                    }
	                    try {
	                        // data1 = date_selection_box_table_body.findElement(By.XPATH, f"//td[@data-month="" + {str(int_searched_month)} + ""]/a[text()="" + {str(searched_day)} + ""]")
	                    	List<WebElement> days_list = date_selection_box_table_body.findElements(By.className("ui-state-default"));
	                    	size_bis = days_list.size();
	                    	for (q = 0; q < size_bis; q++) {
	                            String day_number = days_list.get(q).getAttribute("innerHTML").strip();
	                            if (day_number.toString() == String.valueOf(searched_day))
	                            {
	                            	days_list.get(q).click();
	                                Thread.sleep(3);
	                                break;
	                            }
	                    	}
	                    }
	                    finally {
	                        System.out.print("click failed");
	                    }
	                    Thread.sleep(3);
	                }
	                else {
	                    // pickers = date_selection_box_header.findElements(By.className("ui-datepicker-prev")
	                    System.out.print("current month is:" + current_month.toString() + " my month is:" + searched_month.toString());
	                    System.out.print("current year is:" + String.valueOf(current_year) + " my year is:" + String.valueOf(searched_year));
	                    
	                    try {
	                        move_to_next_month_button.click();
	                    }
	                    finally {
	                        System.out.print("arrow button not found");
	                    }
	                    Thread.sleep(3);
	                }
	            }
	        }
	        else {
	            System.out.print("33");
	        }
	    }
	    // passenger block
	    WebElement passenger_number_div;
    	WebElement passenger_number_selctor;
	    try {
	    	passenger_number_div = form_box.findElement(By.className("right-data"));
	    	passenger_number_selctor = passenger_number_div.findElement(By.className("trip-paxes"));
	    	passenger_number_selctor.click();
	    	Thread.sleep(3);
	    }
	    finally {
	    	System.out.print("passenger number div not found");
	    }

	    WebElement passenger_types_dropdown_list = driver.findElement(By.className("pax-i"));
	    // Adults numbers
	    WebElement adult_number;
	    try {
	    	adult_number = passenger_types_dropdown_list.findElement(By.className("adult"));
	    }
	    finally {
	    	System.out.print("adult class not found");
	    }
	    check = 0;
	    WebElement current_number;
	    WebElement current_number_increment;
	    String current_number_string = "";
	    int current_number_int = 0;
	    while (check == 0) {
	        try {
	            current_number = adult_number.findElement(By.className("pax-number"));
	            current_number_string = current_number.getAttribute("innerHTML").strip();
	        }
	        finally {
	        	System.out.print("adult pax not found");
	        }
	        try{
	            current_number_int = Integer.parseInt(current_number_string);
	        }
	        catch (NumberFormatException ex){
	            ex.System.out.printStackTrace();
	        }
	        if (current_number_int < adults_amount_list.get(i)) {
	            try {
	                current_number_increment = adult_number.findElement(By.className("plus"))
	            }
	            finally {
	            	System.out.print("increment not found");
	            }
	            try {
	                current_number_increment.click()
	            }
	            finally {
	            	System.out.print("increment not clicked");
	            }
	            Thread.sleep(3);
	        }
	        else {
	            check = 1;
	        }
	    }
	    // Youth numbers
	    WebElement youth_number;
	    youth_number = passenger_types_dropdown_list.findElement(By.className("youth"));
	    check = 0;
	    while (check == 0)
	    {
	    	current_number = youth_number.findElement(By.className("pax-number"));
	    	current_number_string = current_number.getAttribute("innerHTML").strip();
	    	try{
	            current_number_int = Integer.parseInt(current_number_string);
	        }
	        catch (NumberFormatException ex){
	            ex.System.out.printStackTrace();
	        }
	        if (current_number_int < youth_amount_list.get(i))
	        {
	              current_number_increment = youth_number.findElement(By.className("plus"));
	              current_number_increment.click();
	              Thread.sleep(3);
	        }
	        else
	        {
	              check = 1;
	        }
	     }
	    // Child numbers
	    WebElement child_number;
	    check = 0;
	    try {
	        child_number = passenger_types_dropdown_list.findElement(By.className("child"));
	        check = 0;
	        while (check == 0)
	        {
	            current_number = child_number.findElement(By.className("pax-number"));
	            current_number_string = current_number.getAttribute("innerHTML").strip();
	            try{
		            current_number_int = Integer.parseInt(current_number_string);
		        }
		        catch (NumberFormatException ex){
		            ex.System.out.printStackTrace();
		        }
	            if (current_number_int < child_amount_list.get(i))
	            {
	                current_number_increment = child_number.findElement(By.className( "plus"));
	                current_number_increment.click();
	                Thread.sleep(3);
	            }
	            else {
	                check = 1;
	            }
	        }
	    }
	    finally {
	        System.out.print("child passenger i not found")
	    }
	    // Babies numbers
	    WebElement baby_number;
	    check = 0;
	    try {
	        baby_number = passenger_types_dropdown_list.findElement(By.className("infant"));
	        check = 0;
	        while (check == 0)
	        {
	            current_number = baby_number.findElement(By.className("pax-number"));
	            current_number_string = current_number.getAttribute("innerHTML").strip();
	            try{
		            current_number_int = Integer.parseInt(current_number_string);
		        }
		        catch (NumberFormatException ex){
		            ex.System.out.printStackTrace();
		        }
	            if (current_number_int < baby_amount_list.get(i))
	            {
	                current_number_increment = baby_number.findElement(By.className("plus"));
	                current_number_increment.click();
	                Thread.sleep(3);
	            }
	            else
	            {
	                check = 1;
	            }
	        }
	    }
	    finally {
	        System.out.print("baby passenger i not found");
	    }
	    // click form
	    WebElement button_gotowe;
	    WebElement search_button;
	    WebElement button_name;
	    String button_name_string = "";
	    try {
	        button_gotowe = passenger_types_dropdown_list.findElement(By.className("close-pax-i"));
	    }
	    finally {
	        System.out.print("close-pax-i not found");
	    }
	    try {
	        button_gotowe.click();
	    }
	    finally {
	        System.out.print("failed to click Gotowe button");
	    }
	    // wyszukujemy lot
	    try {
	        //search_button_outer_box = form_box.findElement(By.className"close-pax-i")
	        search_button = passenger_number_div.findElement(By.className("transaction"));
	    }
	    finally {
	        System.out.print("transaction not found");
	    }
	    try {
	        button_name = search_button.findElement(By.className("text"));
	        button_name_string = button_name.getAttribute("innerHTML").strip();
	    }
	    finally {
	        System.out.print("no button name found in form");
	    }

	    if (button_name_string == "Szukaj lotu")
	    {
	        try {
	            search_button.click();
	            Thread.sleep(3);
	        }
	        finally {
	            System.out.print("failed to click button");
	        }
	    }
	    else
	    {
	        System.out.print(button_name);
	    }

	    i = i + 1;
	    		
	    // Wykonujemy System.out.print screen
	    try {
	    		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
	    		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	    	    driver.save_screenshot("screenshot"+ String.valueOf(i) + ".jpg");
	    }
	    finally {
	    	    System.out.print("failed to save a screenshot");
	    	    driver.quit();
	    }
	}

}
