package steps;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VeureWishlistSteps {
	
	WebDriver driver;
	
	@Given("el usuari esta en la pagina principal 5")
	public void elUsuariEstaEnLaPaginaPrincipal5()
	{
		System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://opencart.abstracta.us/");
	}
	
	@When("el usuari afegeix un producte a la wishlist")
	public void elUsuariAfegeixUnProducteALaWishlist()
	{
		WebElement productContainer = driver.findElement(By.xpath("//h4/a[text()='MacBook']/ancestor::div[contains(@class, 'product-thumb')]"));
		
		WebElement wishlistButton = productContainer.findElement(By.xpath(".//button[contains(@onclick, 'wishlist.add')]"));
		
	    wishlistButton.click();
	}
	
	@When("el usuari dona click al boto de wishlist")
	public void elUsuariDonaClickAlBotoDeWishlist()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement wishlistElement = wait.until(driver -> {
	        WebElement element = driver.findElement(By.id("wishlist-total"));
	        String title = element.getAttribute("title");
	        return title.contains("Wish List (1)") ? element : null;
	    });
	    
	    wishlistElement.click();
	}
	
	@When("el usuari inicia sesio")
	public void elUsuariIniciaSesio()
	{
		driver.findElement(By.id("input-email")).sendKeys("ruben.garcia@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("1234");
		
		driver.findElement(By.cssSelector("input[type='submit'][value='Login']")).click();
	}
	
	@Then("apareix la wishlist")
	public void apareixLaWishlist()
	{
	    WebElement table = driver.findElement(By.cssSelector(".table.table-bordered.table-hover"));

	    // Obtenemos el primer elemento de la tabla
	    WebElement productRow = table.findElement(By.xpath("//tbody/tr"));
	    String productName = productRow.findElement(By.cssSelector("td.text-left a")).getText();
	    
	    assertEquals("MacBook", productName); // Cambia "MacBook" por el nombre esperado
	}
}
