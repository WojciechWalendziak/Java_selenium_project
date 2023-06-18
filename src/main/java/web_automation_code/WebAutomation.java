// PROJECT NOT COMPLETED YET :-)

package web_automation_code;

import org.openqa.selenium.chrome.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import web_automation_code.ImportFromExcel;
import web_automation_code.Screenshot_code;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.NoSuchElementException;


public class WebAutomation {
	
	public static void main(String[] args) throws InterruptedException {
		

	int size = 0;
	int departure_dates_size = 0;
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
	Screenshot_code screenshot_code_obj = new Screenshot_code();

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
	//System.out.print(size);

		// TODO Auto-generated method stub
    for (int i = 0; i < size; i++) {
    	//System.out.print("AKCJA");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\wojci\\Documents\\KODOWANIE\\chromedriver\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver(); 
		
	    try{
	        driver.get("https://www.esky.pl/tanie-loty?gclid=EAIaIQobChMIx4jzwvnU_gIVyAqiAx0M9ATbEAAYAiAAEgKxNPD_BwE");
	        Thread.sleep(5);
	    }
	    catch (IllegalArgumentException | WebDriverException ex) {
            ex.printStackTrace();
	    }
	    
	    try{
	    	WebElement cookie_box = driver.findElement(By.id("CybotCookiebotDialog"));
	    	WebElement cookie_button = cookie_box.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"));
	    	cookie_button.click();
	    	Thread.sleep(3);
	    }
	    catch (IllegalArgumentException | WebDriverException ex) {
            ex.printStackTrace();
	    }
	    WebElement form_box = null;
	    try{
	    	WebElement outer_form_box = driver.findElement(By.id("multiQsfFlights"));
	    	form_box = outer_form_box.findElement(By.tagName("form"));
	    }
	    catch (IllegalArgumentException | WebDriverException ex) {
            ex.printStackTrace();
	    }
	    WebElement form_top = null;
	    WebElement main_class = null;
	    try{
			form_top = form_box.findElement(By.className("top"));
	    	main_class = form_box.findElement(By.className("main"));
	    }
	    catch (IllegalArgumentException | WebDriverException ex) {
            ex.printStackTrace();
	    }
	    Select trip_type_list = null;
	    WebElement trip_type_list_bis = null;
	    try{
	    	trip_type_list = new Select(form_top.findElement(By.id("serviceClass")));
	    	trip_type_list_bis = form_top.findElement(By.id("serviceClass"));
	    }
	    catch (IllegalArgumentException | WebDriverException ex) {
            ex.printStackTrace();
	    }
	    try{
	    	trip_type_list.selectByValue(my_class_list.get(i));
	    	Thread.sleep(5);
	    }
	    catch (IllegalArgumentException | WebDriverException ex) {
            ex.printStackTrace();
	    }
	    WebElement new_trip_type_list = null;
	    try {
	    	new_trip_type_list = form_top.findElement(By.className("trip-type-list"));
	    }
	    catch (IllegalArgumentException | WebDriverException ex) {
            ex.printStackTrace();
	    }
	    try {
	    	WebElement demanded_li = new_trip_type_list.findElement(By.id("TripTypeMulticity"));
	        demanded_li.click();
	        Thread.sleep(3);
	        System.out.print("CLICK");
	    }
	    catch (IllegalArgumentException | WebDriverException ex) {
            ex.printStackTrace();
	    }
	    WebElement tm = null;
	    try {
	    	tm = main_class.findElement(By.id("tm"));
	    	Thread.sleep(5);
	    }
	    catch (IllegalArgumentException | WebDriverException ex) {
            ex.printStackTrace();
	    }
	    
	    first_departure_location = first_departure_location_list.get(i);
	    first_arrival_location = first_arrival_location_list.get(i);
	    second_departure_location = second_departure_location_list.get(i);
	    final_destination_location = final_destination_location_list.get(i);
	    		
	    try {
	    	WebElement departure_location_0 = tm.findElement(By.id("departureMulticity0"));
	    	Thread.sleep(5);
	    	departure_location_0.sendKeys(first_departure_location);
	    	Thread.sleep(5);
	    	WebElement arrival_location_0 = tm.findElement(By.id("arrivalMulticity0"));
	    	Thread.sleep(5);
	    	arrival_location_0.sendKeys(first_arrival_location);
	    	Thread.sleep(5);
	    	WebElement departure_location_1 = tm.findElement(By.id("departureMulticity1"));
	    	Thread.sleep(5);
	    	departure_location_1.sendKeys(second_departure_location);
	    	Thread.sleep(5);
	    	WebElement arrival_location_1 = tm.findElement(By.id("arrivalMulticity1"));
	    	Thread.sleep(5);
	    	arrival_location_1.sendKeys(final_destination_location);
	    	Thread.sleep(5);
	    }
	    catch (IllegalArgumentException | WebDriverException ex) {
            ex.printStackTrace();
	    }
	    List<WebElement> departure_dates = null;
	    try {
	    	departure_dates = tm.findElements(By.className("trip-dates"));
	    }
	    catch (IllegalArgumentException | WebDriverException ex) {
            ex.printStackTrace();
	    }
	    count = 0;
	    departure_dates_size = departure_dates.size();
	    //System.out.print(departure_dates_size);
    	//System.out.print("\n");
    	WebElement date_button = null;
    	
	    for (int q = 0; q < departure_dates_size; q++) {
	        try {
	        	date_button = departure_dates.get(q).findElement(By.tagName("button"));
	            date_button.click();
	            Thread.sleep(3);
	            check = 1;
	            count = count + 1;
	        }
	        catch (IllegalArgumentException | WebDriverException ex) {
	            ex.printStackTrace();
		    }
	        String searched_month_string = "";
	        String searched_day_string = "";
	        if (check == 1) {
	            check = 0;
	            if (count < 2) {
	                searched_month = first_departure_month_list.get(i);
	                searched_month_string = searched_month.toString();
	                searched_year = first_departure_years_list.get(i);
	                searched_day = first_departure_day_list.get(i);
	                searched_day_string = String.valueOf(searched_day);
	            }
	            else {
	            	searched_month = second_departure_month_list.get(i);
	            	searched_month_string = searched_month.toString();
	                searched_year = second_departure_years_list.get(i);
	                searched_day = second_departure_day_list.get(i);
	                searched_day_string = String.valueOf(searched_day);
	            }
	            count = count + 1;
	            WebElement date_selection_box = null;
	            WebElement date_selection_box_header = null;
	            WebElement current_month_and_year_box = null;
	            while (check == 0) {
	                try {
	                	date_selection_box = driver.findElement(By.id("ui-datepicker-div"));
	                }
	                catch (IllegalArgumentException | WebDriverException ex) {
	                    ex.printStackTrace();
	        	    }
	                try {
	                	date_selection_box_header = date_selection_box.findElement(By.className("ui-datepicker-header"));
	                }
	                catch (IllegalArgumentException | WebDriverException ex) {
	                    ex.printStackTrace();
	        	    }
	                WebElement move_to_next_month_button = null;
	                try {
	                	move_to_next_month_button = date_selection_box_header.findElement(By.className("ui-datepicker-next"));
	                }
	                catch (IllegalArgumentException | WebDriverException ex) {
	                    ex.printStackTrace();
	        	    }
	                try {
	                	current_month_and_year_box = date_selection_box_header.findElement(By.className("ui-datepicker-title"));
	                }
	                catch (IllegalArgumentException | WebDriverException ex) {
	                    ex.printStackTrace();
	        	    }
	                WebElement current_month = null;
	                Thread.sleep(3);
	                try {
	                	current_month = current_month_and_year_box.findElement(By.className("ui-datepicker-month"));
	                    current_month_string = current_month.getAttribute("innerHTML").strip();
	                }
	                catch (IllegalArgumentException | WebDriverException ex) {
	                    ex.printStackTrace();
	        	    }
	                WebElement current_year = null;
	                try {
	                	current_year = current_month_and_year_box.findElement(By.className("ui-datepicker-year"));
	                    current_year_string = current_year.getAttribute("innerHTML").strip();
	                }
	                catch (IllegalArgumentException | WebDriverException ex) {
	                    ex.printStackTrace();
	        	    }
	                if (current_month_string.equals(searched_month_string))
	                	{
	                	if(String.valueOf(current_year_string).equals(String.valueOf(searched_year)))
	                {
	                	//System.out.print(int_searched_month);
	                	//System.out.print("\n");
		                check = 1;
		                switch (searched_month) {
		                	case "Styczeń":
		                		int_searched_month = 1;
		                        break;
		                    case "Luty":
		                        int_searched_month = 2;
		                        break;
		                    case "Marzec":
		                        int_searched_month = 3;
		                        break;
		                    case "Kwiecień":
		                        int_searched_month = 4;
		                        break;
		                    case "Maj":
		                        int_searched_month = 5;
		                        break;
		                    case "Czerwiec":
		                        int_searched_month = 6;
		                        break;
		                    case "Lipiec":
		                        int_searched_month = 7;
		                        break;
		                    case "Sierpień":
		                        int_searched_month = 8;
		                        break;
		                    case "Wrzesień":
		                        int_searched_month = 9;
		                        break;
		                    case "Październik":
		                        int_searched_month = 10;
		                        break;
		                    case "Listopad":
		                        int_searched_month = 11;
		                        break;
		                    case "Grudzień":
		                        int_searched_month = 12;
		                        break;
		                }
		                WebElement date_selection_box_table = null;
		                try {
		                	date_selection_box_table = date_selection_box.findElement(By.className("ui-datepicker-calendar"));
		                }
		                catch (IllegalArgumentException | WebDriverException ex) {
		                	ex.printStackTrace();
		            	}
		                WebElement date_selection_box_table_body = null;
		                try {
		                	date_selection_box_table_body = date_selection_box_table.findElement(By.tagName("tbody"));
		                }
		                catch (IllegalArgumentException | WebDriverException ex) {
		                	ex.printStackTrace();
		            	}
		                try {
		                	// data1 = date_selection_box_table_body.findElement(By.XPATH, f"//td[@data-month="" + {str(int_searched_month)} + ""]/a[text()="" + {str(searched_day)} + ""]")
		                	List<WebElement> days_list = date_selection_box_table_body.findElements(By.className("ui-state-default"));
		                    int size_days_list = days_list.size();
		                    for (int p = 0; p < size_days_list; p++) {
		                    	String day_number = days_list.get(p).getAttribute("innerHTML").strip();
		                        if ((day_number.toString()).equals(searched_day_string))
		                        {
		                        	days_list.get(p).click();
		                            Thread.sleep(3);
		                            break;
		                        }
		                    }
		                }
		                catch (IllegalArgumentException | WebDriverException ex) {
		                	ex.printStackTrace();
		            	}
		                Thread.sleep(3);
	            	}
	                else {
	                    System.out.print("current year is:" + String.valueOf(current_year_string) + " my year is:" + String.valueOf(searched_year));
	                    System.out.print("\n");
	                	}
	                	}
	                else {
	                    // pickers = date_selection_box_header.findElements(By.className("ui-datepicker-prev")
	                    System.out.print("current month is:" + current_month_string.toString() + " my month is:" + searched_month_string);
	                    System.out.print("\n");
	                    
	                    try {
	                    	Thread.sleep(3);
	                        move_to_next_month_button.click();
	                    }
	                    catch (IllegalArgumentException | WebDriverException ex) {
	                        ex.printStackTrace();
	            	    }
	                    Thread.sleep(3);
	                }
	            }
	        }
	        else {
	            System.out.print("next step");
	        }
	    }
	    // passenger block
	    WebElement passenger_number_div = null;
    	WebElement passenger_number_selctor = null;
	    try {
	    	passenger_number_div = form_box.findElement(By.className("right-data"));
	    	passenger_number_selctor = passenger_number_div.findElement(By.className("trip-paxes"));
	    	passenger_number_selctor.click();
	    	Thread.sleep(3);
	    }
	    catch (IllegalArgumentException | WebDriverException ex) {
            ex.printStackTrace();
	    }
	    WebElement passenger_types_dropdown_list = null;
	    try {
	    	passenger_types_dropdown_list = driver.findElement(By.className("pax-counter"));
	    }
	    catch (IllegalArgumentException | WebDriverException ex) {
            ex.printStackTrace();
	    }
	    // Adults numbers
	    WebElement adult_number = null;
	    try {
	    	adult_number = passenger_types_dropdown_list.findElement(By.className("adult"));
	    }
	    catch (IllegalArgumentException | WebDriverException ex) {
            ex.printStackTrace();
	    }
	    check = 0;
	    WebElement current_number = null;
	    WebElement current_number_increment = null;
	    String current_number_string = "";
	    int current_number_int = 0;
	    while (check == 0) {
	        try {
	            current_number = adult_number.findElement(By.className("pax-number"));
	            current_number_string = current_number.getAttribute("innerHTML").strip();
	        }
	        catch (IllegalArgumentException | WebDriverException ex) {
	            ex.printStackTrace();
		    }
	        try{
	            current_number_int = Integer.parseInt(current_number_string);
	        }
	        catch (NumberFormatException ex){
	            ex.printStackTrace();
	        }
	        if (current_number_int < adults_amount_list.get(i)) {
	            try {
	                current_number_increment = adult_number.findElement(By.className("plus"));
	            }
	            catch (IllegalArgumentException | WebDriverException ex) {
	                ex.printStackTrace();
	    	    }
	            try {
	                current_number_increment.click();
	            }
	            catch (IllegalArgumentException | WebDriverException ex) {
	                ex.printStackTrace();
	    	    }
	            Thread.sleep(3);
	        }
	        else {
	            check = 1;
	        }
	    }
	    // Youth numbers
	    WebElement youth_number = null;
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
	            ex.printStackTrace();
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
	    WebElement child_number = null;
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
		            ex.printStackTrace();
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
	    catch (IllegalArgumentException | WebDriverException ex) {
            ex.printStackTrace();
	    }
	    // Babies numbers
	    WebElement baby_number = null;
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
		            ex.printStackTrace();
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
	    catch (IllegalArgumentException | WebDriverException ex) {
            ex.printStackTrace();
	    }
	    // click form
	    WebElement button_gotowe = null;
	    WebElement search_button = null;
	    WebElement button_name = null;
	    String button_name_string = "";
	    try {
	        button_gotowe = passenger_types_dropdown_list.findElement(By.className("close-pax-counter"));
	    }
	    catch (IllegalArgumentException | WebDriverException ex) {
            ex.printStackTrace();
	    }
	    try {
	        button_gotowe.click();
	    }
	    catch (IllegalArgumentException | WebDriverException ex) {
            ex.printStackTrace();
	    }
	    // wyszukujemy lot
	    try {
	        //search_button_outer_box = form_box.findElement(By.className"close-pax-i")
	        search_button = passenger_number_div.findElement(By.className("transaction"));
	    }
	    catch (IllegalArgumentException | WebDriverException ex) {
            ex.printStackTrace();
	    }
	    try {
	        button_name = search_button.findElement(By.className("text"));
	        button_name_string = button_name.getAttribute("innerHTML").strip();
	    }
	    catch (IllegalArgumentException | WebDriverException ex) {
            ex.printStackTrace();
	    }

	    if (button_name_string == "Szukaj lotu")
	    {
	        try {
	            search_button.click();
	            Thread.sleep(3);
	        }
	        catch (IllegalArgumentException | WebDriverException ex) {
	            ex.printStackTrace();
		    }
	    }
	    else
	    {
	        System.out.print(button_name);
	    }

	    i = i + 1;
	    		
	    // Wykonujemy System.out.print screen
	    try {
            // Capture the screen
            Robot robot = new Robot();
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage screenCapture = robot.createScreenCapture(screenRect);

            // Save the screenshot as an image file
            File screenshotFile = new File("screenshot.jpg");
            ImageIO.write(screenCapture, "jpg", screenshotFile);

            System.out.println("Screenshot saved successfully.");
        } catch (AWTException | IOException ex) {
            ex.printStackTrace();
        }
	    finally {
	    	    System.out.print("failed to save a screenshot");
	    	    driver.quit();
	    }
	    System.out.print("DONE 1");
	}
    System.out.print("DONE 2");
  }
}
