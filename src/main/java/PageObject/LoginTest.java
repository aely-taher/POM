package PageObject;

import AbstractComponent.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginTest extends AbstractComponent {

    public LoginTest(WebDriver driver){
           super(driver);
    }

    public WebElement email(){
     return driver.findElement(By.xpath("//input[@id='input-email']"));
    }

    public WebElement password(){
     return driver.findElement(By.xpath("//input[@id='input-password']"));
    }
    public WebElement loginbutton(){
        return driver.findElement(By.xpath("//input[@value='Login']"));
    }

}
