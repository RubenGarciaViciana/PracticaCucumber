package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ModifyCartQuantitySteps {

	WebDriver driver;
	
	@Given("el usuari esta en la pagina principal 9")
	public void elUsuariEstaEnLaPaginaPrincipal9()
	{
		System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://opencart.abstracta.us/");
	}
	
	@When("^el usuari fa click a afegir al carrito (.*)")
	public void elUsuariFaClickAAfegirAlCarrito(String producte)
	{
		WebElement productContainer = driver.findElement(By.xpath("//h4/a[text()='" + producte + "']/ancestor::div[contains(@class, 'product-thumb')]"));
		
		WebElement addToCartButton = productContainer.findElement(By.xpath(".//button[contains(@onclick, 'cart.add')]"));
		
		addToCartButton.click();
	}
	
	@When("^el usuari navega al carrito 2")
	public void elUsuariNavegaAlCarrito2()
	{
		driver.findElement(By.cssSelector("li a[title='Shopping Cart']")).click();
	}
	
	@When("^el usuari modifica la quantitat")
	public void elUsuariModificaLaQuantitat() {
		WebElement inputField = driver.findElement(By.cssSelector("input[name^='quantity']"));
		inputField.clear();
		inputField.sendKeys("2");
		
		WebElement updateButton = driver.findElement(By.cssSelector("button.btn.btn-primary"));
        updateButton.click();
	}

	@Then("^la quantitat ha augmentat")
	public void laQuantitatHaAugmentat()
	{
		WebElement inputField = driver.findElement(By.cssSelector("input[name^='quantity']"));
		String updatedValue = inputField.getAttribute("value");
		Assert.assertEquals(updatedValue, "2");
	}
	
	
	

}