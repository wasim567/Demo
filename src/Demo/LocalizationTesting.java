package Demo;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v95.emulation.Emulation;

public class LocalizationTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "E:\\Projects\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		      DevTools devTools=  driver.getDevTools();
		      devTools.createSession();
		      Map<String, Object> mp=new HashMap<String,Object>();
		      mp.put("latitude", 40);
		      mp.put("longitude", 3);
		      mp.put("accuracy", 1);
		      driver.executeCdpCommand("Emulation.setGeolocationOverride", mp);
		      driver.get("https://www.google.co.in/");
		      driver.findElement(By.name("q")).sendKeys("netflix",Keys.ENTER);
		      driver.findElements(By.cssSelector("div[class='yuRUbf'] h3")).get(0).click();
		      System.out.println(driver.findElement(By.cssSelector(".our-story-card-title")).getText());
		      
	}

}
