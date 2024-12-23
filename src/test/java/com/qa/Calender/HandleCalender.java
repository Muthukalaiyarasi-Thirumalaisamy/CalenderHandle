package com.qa.Calender;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleCalender {
static WebDriver driver;
	public static void main(String[] args) {

		 driver = new ChromeDriver();
		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		
		driver.findElement(By.id("datepicker")).click();
		new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='ui-datepicker-div']")));
		String MonthYearVal = driver.findElement(By.className("ui-datepicker-title")).getText();
		System.out.println(MonthYearVal);
		String Month = MonthYearVal.split(" ")[0].trim();
		String Year = MonthYearVal.split(" ")[1].trim();
		System.out.println(Month);
		System.out.println(Year);
	SelectDayMonthYear("18","May","2025");	
	}

	public static void SelectDayMonthYear(String Exday, String ExMonth, String ExYear)
	{
		
		String MonthYearVal = driver.findElement(By.className("ui-datepicker-title")).getText();
		System.out.println(MonthYearVal);
		String Month = MonthYearVal.split(" ")[0].trim();
		String Year = MonthYearVal.split(" ")[1].trim();
		System.out.println(Month);
		System.out.println(Year);
	
while(!(Month.equals(ExMonth) && Year.equals(ExYear)))
{
	driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
	 MonthYearVal = driver.findElement(By.className("ui-datepicker-title")).getText();
	System.out.println(MonthYearVal);

	 Month = MonthYearVal.split(" ")[0].trim();
	 Year = MonthYearVal.split(" ")[1].trim();

	}
driver.findElement(By.xpath("//a[text()='"+Exday+"']"));
System.out.println("date is :"+Exday+" "+ExMonth+" "+ExYear);
}
}