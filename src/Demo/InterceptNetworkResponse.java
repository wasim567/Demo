package Demo;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v95.fetch.Fetch;

public class InterceptNetworkResponse {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "E:\\Projects\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		      DevTools devTools=  driver.getDevTools();
		      devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));
		      
		      devTools.addListener(Fetch.requestPaused(), request->
		      {
		    	     if(request.getRequest().getUrl().contains("shetty")) {
		    	    	 
		    	    	String newUrl= request.getRequest().getUrl().replace("=shetty", "=BadGuy");
		    	    	System.out.println(newUrl);
		    	    	
		    	    	devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(newUrl), Optional.of(request.getRequest().getMethod()), Optional.empty(), Optional.empty(), Optional.empty()));
		    	    	
		    	    	
		    	     }
		    	     else {
			    	    	devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(request.getRequest().getUrl()), Optional.of(request.getRequest().getMethod()), Optional.empty(), Optional.empty(), Optional.empty()));

		    	     }

		    	  
		      });
		      
		      driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		      driver.manage().window().maximize();
		      Thread.sleep(2000);
		  
				driver.findElement(By.xpath("//a[text()='Library']")).click();
	}

}
