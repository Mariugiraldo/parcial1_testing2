import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends BasePage {
    private final By searchProduct = By.xpath("//*[@id=\"search\"]/input");
    private final By searchBtn = By.xpath("//*[@id=\"search\"]/span/button/i");
    private final By addProduct = By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[1]");

    public SearchPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void selectproduct(String product) throws InterruptedException {
        Thread.sleep(1000);
        this.sendText(product, searchProduct);
        this.sendKey(Keys.ENTER, searchProduct);
    }

    public void clickSearch() throws InterruptedException {
        Thread.sleep(1000);
        this.click(searchBtn);
    }

    public String addedProduct() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("RESULTADO DE LA BUSQUEDA: " + this.getText(addProduct));
        return this.getText(addProduct);
    }
}
