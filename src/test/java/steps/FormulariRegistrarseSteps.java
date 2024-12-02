package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FormulariRegistrarseSteps {

	WebDriver driver;
	
	@Given("the user is in the index page")
	public void theUserIsInTheIndexPage()
	{
		System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://automationexercise.com");
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	        WebElement consentButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("p.fc-button-label")));
	        consentButton.click();
	        System.out.println("Botón de consentimiento aceptado.");
	    } catch (Exception e) {
	        System.out.println("No se encontró el botón de consentimiento o ya fue aceptado: " + e.getMessage());
	    }
	}
	
	@When("the user clicks the products option")
	public void theUserClicksTheProductsOption()
	{
		driver.findElement(By.partialLinkText("Products")).click();
	}
	
	@When("^the user enters (.*) in the search bar")
	public void theUserEntersDressInTheSearchBar(String article)
	{
		driver.findElement(By.id("search_product")).sendKeys(article);
	}
	
	@When("the user clicks the search button")
	public void theUserClicksTheSearchButton()
	{
		driver.findElement(By.id("submit_search")).click();
	}
	
	@Then("^the (.*) list appears")
	public void theDressListAppears(String article)
	{
		String title = driver.findElement(By.className("features_items")).getText();
		Assert.assertTrue(title.contains("SEARCHED PRODUCTS"));
	}
}
