package Demo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v95.fetch.Fetch;
import org.openqa.selenium.devtools.v95.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v95.network.model.ErrorReason;


public class FailNetworkRequestAPI {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "E:\\Projects\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		      DevTools devTools=  driver.getDevTools();
		      devTools.createSession();
		             Optional<List<RequestPattern>> pattern= Optional.of(Arrays.asList(new RequestPattern(Optional.of("*GetBook*"),Optional.empty(),Optional.empty())));
		      devTools.send(Fetch.enable(pattern, Optional.empty()));
		      
		     devTools.addListener(Fetch.requestPaused(), request-> {
		    	 
		    	 devTools.send(Fetch.failRequest(request.getRequestId(), ErrorReason.FAILED));
		     });
		     
		     driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		      driver.manage().window().maximize();
		      Thread.sleep(2000);
		  
				driver.findElement(By.xpath("//a[text()='Library']")).click();
		      
	}

}