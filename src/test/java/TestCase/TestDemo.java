package TestCase;

import PageObject.EditPage;
import PageObject.LoginTest;
import PageObject.ThankYou;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Properties;

public class TestDemo extends BaseTest {

    @Test
    public void register() {
        List<String> testData = excelReader.getData("register");
        driver.findElement(By.xpath("//a[text()='Register']")).click();
        registerForm.fName().sendKeys(testData.get(1));
        registerForm.lName().sendKeys(testData.get(2));
        registerForm.email().sendKeys(testData.get(3));
        registerForm.telephone().sendKeys(testData.get(4));
        registerForm.password().sendKeys(testData.get(5));
        registerForm.confirmPassword().sendKeys(testData.get(6));
        registerForm.newsletter().click();
        registerForm.consent().click();
        registerForm.confirm().click();
        String msg = thankYou.thankYouText().getText();

        Assert.assertEquals(msg,"Your Account Has Been Created!");
    }

    @Test
    public void login() {
        setLogin();
        Assert.assertEquals(driver.findElement(By.xpath("//a[text()='Edit your account information']")).getText(), "Edit your account information");
        editPage.editPage().click();
        String isdisplayed = driver.findElement(By.xpath("//legend[text()='Your Personal Details']")).getText();
        Assert.assertEquals(isdisplayed, "Your Personal Details");
    }
}
