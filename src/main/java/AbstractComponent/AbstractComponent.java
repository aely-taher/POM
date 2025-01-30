package AbstractComponent;

import org.openqa.selenium.WebDriver;

public class AbstractComponent {
protected WebDriver driver;
public AbstractComponent(WebDriver driver) {
    this.driver = driver;
}
}
