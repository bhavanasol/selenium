package trialpackage;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class launchbrowser {
	
	WebDriver driver;
	
	public void  Invokebrowser(){
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\patlo\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		// TODO Auto-generated method stub
		driver=new ChromeDriver();
		driver.get("https://www.besttemplates.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String Title=driver.getTitle();
		System.out.println("Title of page is :"+Title);
	}
	public void StartDownloading() 
	{
		driver.findElement(By.className("download-now-btn")).click();
		Set <String> s = driver.getWindowHandles();
		Iterator <String> It = s.iterator();
		String parentWindowId=It.next();
		System.out.println("Parent Id is:"+parentWindowId);
		String childWindowId=It.next();
		System.out.println("Parent Id is:"+childWindowId);
		driver.switchTo().window(childWindowId);
		String newTitle=driver.getTitle();
		System.out.println(newTitle);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.switchTo().defaultContent();
		//driver.switchTo().firstWindow();
	}
	public void SignIn()
	{
		String Username="bhavanasolipuram@gmail.com";
		String Password="Template*99";
		try {
			
			driver.findElement(By.xpath("/html/body/header/div/ul/li/span[1]")).click();
			///html/body/header/div/ul/li/span[1]
			//driver.findElement(By.xpath("//header[@class='white-head'] //span[@class='sign-text']")).click();
			Assert.assertTrue(driver.findElement(By.className("popup-screen")).isDisplayed());
			boolean popupscreen = driver.findElement(By.className("popup-screen")).isDisplayed();
			if (popupscreen==true) 
				System.out.println("Sign in form displayed");
			else
				System.out.println("Sign in form not dsplayed");
			boolean email=driver.findElement(By.id("username")).isDisplayed();
			if(email==true)
				driver.findElement(By.id("username")).sendKeys(Username);
			boolean password=driver.findElement(By.id("upassword")).isDisplayed();
			if(password==true)
				driver.findElement(By.id("upassword")).sendKeys(Password);
			boolean submit=driver.findElement(By.id("login-submit")).isDisplayed();
			if(submit==true)
				driver.findElement(By.id("login-submit")).click();
			String profilename=driver.findElement(By.className("profile-name")).getText();
			System.out.println(profilename);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.quit();
	}	
		
	public static void main(String[] args) 
	{
		launchbrowser obj=new launchbrowser();
		obj.Invokebrowser();
		obj.StartDownloading();
		obj.SignIn();
	}
	
}

