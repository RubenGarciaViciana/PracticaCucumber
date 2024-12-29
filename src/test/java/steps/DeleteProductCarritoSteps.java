package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteProductCarritoSteps {

	WebDriver driver;
	
	@Given("el usuari esta en la pagina principal 11")
	public void elUsuariEstaEnLaPaginaPrincipal11()
	{
		System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://opencart.abstracta.us/");
	}
	
	@When("^el usuari fa click en Add to Cart (.*)")
	public void elUsuariFaClickEnAddToCarttDe(String producte)
	{
		WebElement productContainer = driver.findElement(By.xpath("//h4/a[text()='" + producte + "']/ancestor::div[contains(@class, 'product-thumb')]"));
		
		WebElement addToCartButton = productContainer.findElement(By.xpath(".//button[contains(@onclick, 'cart.add')]"));
		
		addToCartButton.click();
	}
	
	@When("^el usuari navega al carrito")
	public void elUsuariNavegaAlCarrito()
	{
		driver.findElement(By.cssSelector("li a[title='Shopping Cart']")).click();
	}
	
	@When("^fa click a eliminar producte$")
	public void faClickAEliminarProducte() {
		driver.findElement(By.cssSelector("button.btn.btn-danger[data-original-title='Remove']")).click();
	}

	@Then("^el carrito està buit")
	public void elCarritoEstaBuit()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement messageElement = wait.until(driver -> {
            WebElement element = driver.findElement(By.xpath("//div[@id='content']/p"));
            String text = element.getText();
            return text.contains("Your shopping cart is empty!") ? element : null;
        });

        String actualMessage = messageElement.getText();
        Assert.assertTrue(actualMessage.contains("Your shopping cart is empty!"));
	}
	
	
	

}