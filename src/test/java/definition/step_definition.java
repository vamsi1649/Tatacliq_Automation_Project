package definition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class step_definition {
	public static String url="https://www.tatacliq.com";
	WebDriver driver;
	
	@Given("user should go to the Home page of TataCliq")
	public void user_should_go_to_the_home_page_of_tata_cliq()   {
		WebDriverManager.edgedriver().setup();	
		driver=new EdgeDriver();	
		driver.get(url);	
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@When("user mouseover onto jewellery in brands")
	public void user_had_to_mouseover_onto_jewellery_in_brands() throws InterruptedException {
		Actions actions = new Actions(driver);
		WebElement brands = driver.findElement(By.xpath("*//div[contains(text(),'Brands')]"));
		actions.moveToElement(brands).build().perform();
		WebElement jew = driver.findElement(By.xpath("*//div[contains(text(),'Jewellery')]"));
		actions.moveToElement(jew).build().perform();
		Thread.sleep(3000);
	}
	
	@Then("user is able to see various brands of jewellery")
	public void user_is_able_to_see_various_brands_of_jewellery() {
		driver.quit();
	}

}
