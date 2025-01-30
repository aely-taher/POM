package PageObject;

import AbstractComponent.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterForm extends AbstractComponent {
    public RegisterForm(WebDriver driver){
        super(driver);
    }
    public WebElement fName(){
        return driver.findElement(By.xpath("//input[@id='input-firstname']"));
    }
    public WebElement lName(){
        return driver.findElement(By.xpath("//input[@id='input-lastname']"));
    }

    public WebElement email(){
        return driver.findElement(By.xpath("//input[@id='input-email']"));
    }
    public WebElement telephone(){
        return driver.findElement(By.xpath("//input[@id='input-telephone']"));
    }

    public WebElement password(){
        return driver.findElement(By.xpath("//input[@id='input-password']"));
    }
    public WebElement confirmPassword(){
        return driver.findElement(By.xpath("//input[@id='input-confirm']"));
    }
    public WebElement newsletter(){
        return driver.findElement(By.xpath("//input[@name='newsletter' and @value='1']"));
    }
    public WebElement consent(){
        return driver.findElement(By.xpath("//input[@name='agree']"));
    }
    public WebElement confirm(){
        return  driver.findElement(By.xpath("//input[@type='submit']"));
    }

}
