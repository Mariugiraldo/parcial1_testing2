import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage extends BasePage {
    private final By searchProduct = By.xpath("//*[@id=\"search\"]/input");
    private final By searchBtn = By.xpath("//*[@id=\"search\"]/span/button/i");
    private final By addProduct = By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[1]");
    private final By addedMessage = By.xpath("//*[@id=\"product-search\"]/div[1]");
    private final By productThumb = By.xpath("//*[@id=\"content\"]/div[2]/div[1]");

    public SearchPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void selectProduct(String product) {
        this.click(searchProduct);
        this.sendText(product, searchProduct);
    }

    public void clickSearch() {
        this.click(searchBtn);
    }

    public String addedProduct() {
        try {
            this.click(addProduct);
            Thread.sleep(1000);
            return this.getText(addedMessage);
        } catch (InterruptedException e) {
            return "";
        }
    }

    public void clickOnProduct() {
        this.click(productThumb);
    }
}
