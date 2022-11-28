package tatacliq;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class tatacliq{
public static String url="https://www.tatacliq.com";
	
	WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeTest
	public void beforetest() throws InterruptedException
	{
		htmlReporter = new ExtentHtmlReporter("extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		WebDriverManager.edgedriver().setup();	
		driver=new EdgeDriver();	
		driver.get(url);	
		driver.manage().window().maximize();	
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test(enabled=true,priority = 0)
	public void test_case_1() throws InterruptedException //Checking the functionality of Search feature
	{	
	test = extent.createTest("Checking the functionality of Search feature");
	test.pass("you are in tatacliq website");
	WebElement ele = driver.findElement(By.xpath("//*[@type='search']"));
	ele.sendKeys("Sandisk Memory Card");
	Actions action = new Actions(driver);
	ele.sendKeys(Keys.ENTER);	
	test.pass("user is in search page");
}
	@Test(enabled=true,priority = 1)
	public void test_case_2() throws InterruptedException //Checking the functionality of Sort feature after searching for any product
	{	
	test = extent.createTest("Checking the functionality of Sort feature after searching for any product");
    driver.findElement(By.xpath("//div[@class='SortDesktop__base']")).click();
    Thread.sleep(3000);	
    test.pass("user is able to see all the sort options");
	}
	
	@Test(enabled=true,priority = 2)
	public void test_case_3() throws InterruptedException //Checking the functionality of Price Low to High (sort )feature
	{	
	test = extent.createTest("Checking the functionality of Price Low to High (sort )feature");
    WebElement ele =  driver.findElement(By.xpath("//div[@class='SortDesktop__base']"));
    Actions action = new Actions(driver);
    action.click(ele).build().perform();
	action.sendKeys(ele,Keys.ARROW_DOWN).click().build().perform();
	action.sendKeys(ele,Keys.ENTER).click().build().perform();	
    Thread.sleep(3000);	
    test.pass("user is able to see all the products sorted as low to high");
	} 
	
	@Test(enabled=true,priority = 3)
	public void test_case_4() throws InterruptedException //Checking the functionality of Price High to Low (sort )feature
	{	
	test = extent.createTest("Checking the functionality of Price High to Low (sort )feature");
    WebElement ele =  driver.findElement(By.xpath("//div[@class='SortDesktop__base']"));
    Actions action = new Actions(driver);
    action.click(ele).build().perform();
	action.sendKeys(ele,Keys.ARROW_DOWN).click().build().perform();
	action.sendKeys(ele,Keys.ARROW_DOWN).click().build().perform();
	action.sendKeys(ele,Keys.ENTER).click().build().perform();	
    Thread.sleep(3000);	
    test.pass("user is able to see all the products sorted as high to low");  
	}
	
	@Test(enabled=true,priority = 4)
	public void test_case_5() throws InterruptedException //Checking the functionality of New Arrivals (sort )feature
	{	
	test = extent.createTest("Checking the functionality of New Arrivals (sort )feature");
    WebElement ele =  driver.findElement(By.xpath("//div[@class='SortDesktop__base']"));
    Actions action = new Actions(driver);
    action.click(ele).build().perform();
	action.sendKeys(ele,Keys.ARROW_DOWN).click().build().perform();
	action.sendKeys(ele,Keys.ARROW_DOWN).click().build().perform();
	action.sendKeys(ele,Keys.ARROW_DOWN).click().build().perform();
	action.sendKeys(ele,Keys.ENTER).click().build().perform();	
    Thread.sleep(3000);	
    test.pass("user is able to see all the products sorted as new arrivals first");
	}
	
	@Test(enabled=true,priority = 5)
	public void test_case_6() throws InterruptedException //Checking the functionality of Discounts (sort )feature
	{	
	test = extent.createTest("Checking the functionality of Discounts (sort )feature");
    WebElement ele =  driver.findElement(By.xpath("//div[@class='SortDesktop__base']"));
    Actions action = new Actions(driver);
    action.click(ele).build().perform();
	action.sendKeys(ele,Keys.ARROW_DOWN).click().build().perform();
	action.sendKeys(ele,Keys.ARROW_DOWN).click().build().perform();
	action.sendKeys(ele,Keys.ARROW_DOWN).click().build().perform();
	action.sendKeys(ele,Keys.ARROW_DOWN).click().build().perform();
	action.sendKeys(ele,Keys.ENTER).click().build().perform();	
    Thread.sleep(3000);	
    test.pass("user is able to see all the products sorted as higher discounts first");
	}
	@Test(enabled=true,priority = 6)
	public void test_case_7() throws InterruptedException //Checking the functionality of add to bag feature
	{	
	test = extent.createTest("Checking the functionality of add to bag feature");
    driver.findElement(By.xpath("//*[@class='ProductModule__dummyDiv']")).click();
    Thread.sleep(6000);	
    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	int s=tabs.size();
	System.out.println(s);
    driver.switchTo().window(tabs.get(1));	
    JavascriptExecutor js = ((JavascriptExecutor)driver);
    js.executeScript("window.scrollTo(0,400)");
    driver.findElement(By.xpath("//*[@class='ProductDescriptionPage__buttonWrapper']/div[2]")).click();
    Thread.sleep(3000);	
    test.pass("item is added to mybag");
	}
	@Test(enabled=true,priority = 7)
	public void test_case_8() throws InterruptedException //Checking the functionality of buy now feature
	{	
	test = extent.createTest("Checking the functionality of buy now feature");
	driver.findElement(By.xpath("//*[@class='ProductDescriptionPage__buttonWrapper']/div[1]")).click();
	test.pass("user is navigated to mybag");
	}
	@Test(enabled=true,priority = 8)
	public void test_case_9() throws InterruptedException //Checking the user interface of brands
	{
	test = extent.createTest("Checking the user interface of brands");
	ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	int s=tabs.size();
	System.out.println(s);
	driver.switchTo().window(tabs.get(0));		
	Actions actions = new Actions(driver);
	WebElement brands = driver.findElement(By.xpath("*//div[contains(text(),'Brands')]"));
	actions.moveToElement(brands).build().perform();
	Thread.sleep(3000);
	test.pass("user is able to see various categories of brands");
	}
	@Test(enabled=false,priority = 9)
	public void test_case_10() throws InterruptedException //Checking the user interface of jewellery
	{	
	test = extent.createTest("Checking the user interface of jewellery");
	Actions actions = new Actions(driver);
	WebElement jew = driver.findElement(By.xpath("*//div[contains(text(),'Jewellery')]"));
	actions.moveToElement(jew).build().perform();
	Thread.sleep(3000);
	test.pass("user is able to see various brands of jewellery");
	}
	@AfterTest(enabled=true)
    public void aftertest() {
	driver.quit();
	test.info("you closed the browser");
	extent.flush();
}	
}