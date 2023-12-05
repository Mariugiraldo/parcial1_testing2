package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SummaryPage extends BasePage{


    private By accountsOverview = By.xpath("//*[@id=\"leftPanel\"]/ul/li[2]/a");
    private By message = By.xpath("//*[@id=\"accountTable\"]/tfoot/tr/td");

    public SummaryPage(WebDriver driver, WebDriverWait wait) {super(driver, wait);}

    public void clickAccountOverview() {
        click(accountsOverview);
    }

    public String successfulMessage() {
        return this.getText(message);
    }

}
