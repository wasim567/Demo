package Demo;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v95.emulation.Emulation;

public class Test {
	
	public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "E:\\Projects\\chromedriver_win32\\chromedriver.exe");
			ChromeDriver driver=new ChromeDriver();
			DevTools devTools=driver.getDevTools();
			devTools.createSession();
			devTools.send(Emulation.setDeviceMetricsOverride(350, 600, 75, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
			
			driver.get("https://rahulshettyacademy.com/angularAppdemo/");
			
			driver.findElement(By.cssSelector(".navbar-toggler ")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[text()='Library']")).click();
			
			System.out.println("hello1");
			System.out.println("hello3");
			
			System.out.println("hello2");
			System.out.println("hello4");
			
			System.out.println("hello5");
			
			
		    System.out.println("final");
			
}
}
