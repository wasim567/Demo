package Demo;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class CDPMethods {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "E:\\Projects\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		DevTools devTools=driver.getDevTools();
		devTools.createSession();
		Map mp=new HashMap();
		mp.put("width", 600);
		mp.put("height", 400);
		mp.put("deviceScaleFactor", 70);
		mp.put("mobile", true);
		
	       driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", mp);
	       
	       driver.get("https://rahulshettyacademy.com/angularAppdemo/");
	       driver.findElement(By.cssSelector(".navbar-toggler ")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[text()='Library']")).click();
	}

}
