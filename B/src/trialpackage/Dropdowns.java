package trialpackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dropdowns {
	WebDriver driver;
	
	public void  Templatedropdown(){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\patlo\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		// TODO Auto-generated method stub
		driver=new ChromeDriver();
		driver.get("https://www.besttemplates.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("/html/body/header/div/nav/ul/li[1]")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("/html/body/header/div/nav/ul/li[1]/div/ul/li/div[2]/ul/li[1]/a")).click();
		
		driver.findElement(By.xpath("/html/body/header/div/nav/ul/li[1]/div/ul/li/div[1]/a")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		boolean popup=driver.findElement(By.xpath("html/body/main/div[2]/div/div/div/div/div/div")).isDisplayed();
			if (popup==true)
		{
			String popTitle=driver.findElement(By.className("pop-title")).getText();
			String popTitle1=driver.findElement(By.cssSelector("[class='pop-title']")).getText();
			System.out.println("Title is :"+popTitle);
			System.out.println("Title is :"+popTitle1);
				
		}
	}
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dropdowns obj=new Dropdowns();
		obj.Templatedropdown();
		
	}

}
