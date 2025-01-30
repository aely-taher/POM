package PageObject;

import AbstractComponent.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ThankYou extends AbstractComponent {
    public ThankYou(WebDriver driver){
        super(driver);
    }
    public WebElement thankYouText(){
        return driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']"));
    }



}
