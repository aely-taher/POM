package TestCase;

import PageObject.EditPage;
import PageObject.LoginTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;
    public LoginTest login;
    public EditPage editPage;


    public String browser = "chrome";

    public void initDriver() {
        if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            WebDriverManager.chromedriver().setup(); //driver set up
            driver = new ChromeDriver();
        }
    }

    @BeforeMethod
    public void openBrowser () {
            initDriver();
            login = new LoginTest(driver);
            editPage = new EditPage(driver);
            driver.get("https://tutorialsninja.com/demo/index.php"); //get url
            driver.manage().window().maximize();
            driver.findElement(By.xpath("//a[@title='My Account']")).click();
            driver.findElement(By.xpath("//a[text()='Login']")).click();

        //login
        login.email().sendKeys("aelytaher@gmail.com");
        login.password().sendKeys("aely1234");
        login.loginbutton().click();
    }
        //@AfterMethod
        //public void quit () {
        //    driver.quit();}



}



