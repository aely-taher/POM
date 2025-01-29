package TestCase;

import PageObject.EditPage;
import PageObject.LoginTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestDemo extends BaseTest {

    @Test
    public void login() {
        editPage.editPage().click();
    }
 }
