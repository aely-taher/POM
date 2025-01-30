package TestCase;
import AbstractComponent.ExcelReader;
import AbstractComponent.AbstractComponent;
import PageObject.EditPage;
import PageObject.LoginTest;
import PageObject.RegisterForm;
import PageObject.ThankYou;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    protected WebDriver driver;
    public LoginTest login;
    public EditPage editPage;
    public AbstractComponent abstractComponent;
    public RegisterForm registerForm;
    public ThankYou thankYou;
    public ExcelReader excelReader;


    private String browser;
    private String url;
    private String email;
    private String password;


    public void initDriver() throws IOException {

        Properties prop = new Properties();
        String propFileName = "D:\\selenium\\Pom\\src\\main\\resources\\Globaldata.Properties";
        FileInputStream fis = new FileInputStream(propFileName);
        prop.load(fis);

        browser = prop.getProperty("browser");
        url = prop.getProperty("url");
        email = prop.getProperty("email");
        password = prop.getProperty("password");
//        System.out.println("Browser: " + browser);
//        System.out.println("URL: " + url);
//        System.out.println("Email: " + email);
//        System.out.println("Password: " + password);

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
    public void openBrowser () throws IOException {
            initDriver();
            registerForm = new RegisterForm(driver);
            login = new LoginTest(driver);
            editPage = new EditPage(driver);
            abstractComponent = new AbstractComponent(driver);
            thankYou = new ThankYou(driver);
            excelReader = new ExcelReader();  // Correct way
            driver.get(url); //get url
            driver.manage().window().maximize();
            driver.findElement(By.xpath("//a[@title='My Account']")).click();

    }

    public void setLogin() {
        driver.findElement(By.xpath("//a[text()='Login']")).click();
        login.email().sendKeys(email);
        login.password().sendKeys(password);
        login.loginbutton().click();
    }




    //@AfterMethod
        //public void quit () {
        //    driver.quit();}



}



