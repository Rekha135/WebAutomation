package Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PageObjects {
	
	public By acceptCookies = By.xpath("//button[normalize-space()='Allow all cookies']");
	 public By servicesTab = By.xpath("(//span[contains(text(),'Services')])[1]");
	 public By automation = By.xpath("//a[contains(@class,'subMenuLink')][normalize-space()='Automation']");
	 public By selectedAutomation = By.xpath("(//li[contains(@class,'current expanded')])[1]");
	 public By firstNameField = By.id("4ff2ed4d-4861-4914-86eb-87dfa65876d8");
	 public By lastNameField = By.id("11ce8b49-5298-491a-aebe-d0900d6f49a7");
}
