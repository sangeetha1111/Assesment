package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

public class Findelements {
	
	public WebDriver driver;
	
	public Findelements(WebDriver w)
	{
		
		driver=w;
		PageFactory.initElements(w, this);
	}
	
	@FindBy(xpath="//li[@data-id='users']")
	@CacheLookup
	WebElement button;
	
	@FindBy(xpath="//span[contains(text(),'/api/users?page=2')]")
	@CacheLookup
	WebElement req;
	
	@FindBy(xpath="//span[contains(text(),'200')]")
	@CacheLookup
	WebElement res;
	
	@FindBy(xpath="//a[contains(text(),'Support ReqRes')]")
	@CacheLookup
	WebElement button1;
	
	@FindBy(xpath="//input[@id='supportOneTime']")
	@CacheLookup
	WebElement radiobutton1;
	
	@FindBy(xpath="//input[@id='supportRecurring']")
	@CacheLookup
	WebElement radiobutton2;
	
	@FindBy(xpath="//input[@id='supportRecurring']")
	@CacheLookup
	WebElement upgrade;
	
	
	public void click()
	{
		button.click();
	}
	
	public String verifyreq()
	{
		String str=req.getText();
		return str;
	}
	
	public String verifyres() 
	{
	/*	WebDriverWait wt=new WebDriverWait(driver, 100);
		wt.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'404')]")));*/
		String s1=res.getText();
		return s1;
	}
	
	
	public Boolean supportbutton()
	{
		
		Boolean b=button1.isDisplayed();
		//button1.click();
		return b;
		
	}
	
	public Boolean Onetimepayment()
	
	{
		button1.click(); 
		Boolean b1=radiobutton1.isDisplayed();
		return b1;
	}
	
	public Boolean Monthlysupport()
	{
		Boolean b2=radiobutton2.isDisplayed();
		return b2;
	}
	
	public Boolean upgrade()
	{
		Boolean b3=upgrade.isDisplayed();
		return b3;
	}
	
}