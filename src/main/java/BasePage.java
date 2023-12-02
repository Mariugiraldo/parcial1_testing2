import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

    private static String HOME_URL = "https://parabank.parasoft.com/parabank/index.htm";

    private WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        setUp();
    }

    public void setUp() {
        driver.manage().window().maximize();
    }

    public void getHomeUrl() {
        driver.get(HOME_URL);
    }

    public void close() {
        driver.quit();
    }

    protected void sendText(String inputText, By locator) {
        var element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        element.sendKeys(inputText);
    }

    protected void click(By locator) {
        var element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        element.click();
    }

    protected String getText(By locator) {
        var element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return element.getText();
    }
}


