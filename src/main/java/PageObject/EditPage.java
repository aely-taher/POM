package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditPage {
    private WebDriver driver;
    public EditPage(WebDriver driver){
        this.driver = driver;
    }
public WebElement editPage(){
    return driver.findElement(By.xpath("//a[text()='Edit your account information']"));


}
