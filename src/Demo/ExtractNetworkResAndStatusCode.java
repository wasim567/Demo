package Demo;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v95.network.Network;
import org.openqa.selenium.devtools.v95.network.model.Request;
import org.openqa.selenium.devtools.v95.network.model.Response;


public class ExtractNetworkResAndStatusCode {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "E:\\Projects\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		      DevTools devTools=  driver.getDevTools();
		      devTools.createSession();
		      
		      devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		      
		      devTools.addListener(Network.requestWillBeSent() , request ->
		      
		      {
		    	  
		    	      Request req= request.getRequest();
		    	      System.out.println(req.getUrl());
		      });
		      devTools.addListener(Network.responseReceived(), response->
		      {
		    	      Response resp=    response.getResponse();
					
					
					  System.out.println(resp.getUrl()+"  "+resp.
					  getStatus()); 
					 
		    	      } );
		      
		      driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		      driver.manage().window().maximize();
		      Thread.sleep(2000);
		   
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[text()='Library']")).click();
		      
	}

}
