import helpers.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TransferPage extends BasePage {


    private By transferFundsLink = By.xpath("//*[@id=\"leftPanel\"]/ul/li[3]/a");
    private By amountInputField= By.id("amount");
    private By fromAccountId = By.xpath("//*[@id=\"fromAccountId\"]/option");
    private By toAccountId = By.xpath("//*[@id=\"toAccountId\"]/option[2]");
    private By transferButton = By.xpath("//*[@id=\"rightPanel\"]/div/div/form/div[2]/input");
    private By transferCompletedMessage = By.xpath("//*[@id=\"rightPanel\"]/div/div/p");


    public TransferPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void transferFundsFromOneAccountToAnother(String amount) throws InterruptedException {
        click(transferFundsLink);
        Thread.sleep(200); //waits for dropdowns to get populated
        sendText(amount, amountInputField);
        click(fromAccountId);
        click(toAccountId);
        click(transferButton);
    }

    public String getSuccessfulMessage(){
        return this.getText(transferCompletedMessage);
    }

}
