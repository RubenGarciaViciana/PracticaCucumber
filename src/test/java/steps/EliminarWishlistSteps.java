package steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EliminarWishlistSteps {

	WebDriver driver;
	
	@Given("el usuari esta en la pagina principal 6")
	public void elUsuariEstaEnLaPaginaPrincipal6()
	{
		System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://opencart.abstracta.us/");
	}
	
	@When("el usuari afegeix un producte a la wishlist 2")
	public void elUsuariAfegeixUnProducteALaWishlist2()
	{
		WebElement productContainer = driver.findElement(By.xpath("//h4/a[text()='MacBook']/ancestor::div[contains(@class, 'product-thumb')]"));
		
		WebElement wishlistButton = productContainer.findElement(By.xpath(".//button[contains(@onclick, 'wishlist.add')]"));
		
	    wishlistButton.click();
	}
	
	@When("el usuari dona click al boto de wishlist 2")
	public void elUsuariDonaClickAlBotoDeWishlist2()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement wishlistElement = wait.until(driver -> {
	        WebElement element = driver.findElement(By.id("wishlist-total"));
	        String title = element.getAttribute("title");
	        return title.contains("Wish List (1)") ? element : null;
	    });
	    
	    wishlistElement.click();
	}
	
	@When("el usuari inicia sesio 2")
	public void elUsuariIniciaSesio2()
	{
		driver.findElement(By.id("input-email")).sendKeys("ruben.garcia@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("1234");
		
		driver.findElement(By.cssSelector("input[type='submit'][value='Login']")).click();
	}
	
	@When("apareix element en la wishlist 2")
	public void apareixElementEnLaWishlist2()
	{
	    WebElement table = driver.findElement(By.cssSelector(".table.table-bordered.table-hover"));

	    // Obtenemos el primer elemento de la tabla
	    WebElement productRow = table.findElement(By.xpath("//tbody/tr"));
	    String productName = productRow.findElement(By.cssSelector("td.text-left a")).getText();
	    
	    assertEquals("MacBook", productName);
	}
	
	@When("elimino el element de la wishlist")
	public void eliminoElElementDeLaWishlist()
	{
	    WebElement table = driver.findElement(By.cssSelector(".table.table-bordered.table-hover"));

	    // Le doy al boton de eliminar
	    WebElement productRow = table.findElement(By.xpath("//tbody/tr"));
	    WebElement removeButton = productRow.findElement(By.cssSelector("td.text-right a.btn-danger"));
	    removeButton.click();
	}
	
	@Then("no esta el element en la wishlist")
	public void noEstaElElementEnLaWishlist()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // Verificar que el mensaje aparece
	    WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert.alert-success")));
	    String messageText = successMessage.getText();
	    assertTrue(messageText.contains("Success: You have modified your wish list!"));

	}
}
