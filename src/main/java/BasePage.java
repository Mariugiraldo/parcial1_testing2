import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    protected WebElement elementFind(By locator) {
        return driver.findElement(locator);
    }

    protected void sendText(String inputText, By locator) {
        this.elementFind(locator).clear();
        this.elementFind(locator).sendKeys(inputText);
    }

    protected void sendKey(CharSequence key, By locator) {
        this.elementFind(locator).sendKeys(key);
    }

    protected void click(By locator) {
        this.elementFind(locator).click();
    }

    protected String getText(By locator) {
        return this.elementFind(locator).getText();
    }

    protected WebDriverWait getWait(){
        return this.wait;
    }

}


