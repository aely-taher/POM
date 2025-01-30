package PageObject;

import AbstractComponent.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditPage extends AbstractComponent {

    public EditPage(WebDriver driver) {
        super(driver);
    }

    public WebElement editPage() {
        return driver.findElement(By.xpath("//a[text()='Edit your account information']"));


    }
}
