package Demo;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v95.network.Network;

import com.google.common.collect.ImmutableList;

public class BlockingUnwantedNetworkRequest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "E:\\Projects\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		      DevTools devTools=  driver.getDevTools();
		      devTools.createSession();
		      
		      devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		    devTools.send(Network.setBlockedURLs(ImmutableList.of("*jpg","*css")));
		      long st=System.currentTimeMillis();
		      driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		      driver.findElement(By.linkText("Browse Products")).click();
		      driver.findElement(By.linkText("Selenium")).click();
		      driver.findElement(By.cssSelector(".add-to-cart.btn.btn-default")).click();
		      System.out.println(driver.findElement(By.tagName("p")).getText());
		      long et=System.currentTimeMillis();
		      System.out.println(et-st);
		      
		      
		      
	}

}
