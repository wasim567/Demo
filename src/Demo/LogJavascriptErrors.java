package Demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class LogJavascriptErrors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\Projects\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		      
		
		
		 driver.get("https://rahulshettyacademy.com/angularAppdemo/");
	      driver.findElement(By.linkText("Browse Products")).click();
	      driver.findElement(By.linkText("Selenium")).click();
	      driver.findElement(By.cssSelector(".add-to-cart.btn.btn-default")).click();
	      driver.findElement(By.linkText("Cart")).click();
	      driver.findElement(By.id("exampleInputEmail1")).clear();
	      driver.findElement(By.id("exampleInputEmail1")).sendKeys("2");
	      LogEntries entry=driver.manage().logs().get(LogType.BROWSER);
	      List<LogEntry> logs=entry.getAll();
	      for(LogEntry e:logs) {
	    	  
	    	  System.out.println(e.getMessage());
	      }
	      
	}

}
