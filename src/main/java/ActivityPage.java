import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActivityPage extends BasePage {


    private By accountsOverview = By.xpath("//*[@id=\"leftPanel\"]/ul/li[2]/a");
    private By checkMessageDeposit = By.xpath("//*[@id=\"accountTable\"]/tfoot/tr/td");
    private By accountColumn = By.xpath("//*[@id=\"accountTable\"]/tbody/tr[1]/td[1]/a");
    private By messageAccountDetails = By.xpath("//*[@id=\"rightPanel\"]/div/div[1]/h1");
    private By activityPeriodLink = By.xpath("//*[@id=\"month\"]/option[1]");
    private By activityTypeLink = By.xpath("//*[@id=\"transactionType\"]/option[1]");
    private By goButton = By.xpath("//*[@id=\"rightPanel\"]/div/div[2]/form/table/tbody/tr[3]/td[2]/input");


    public ActivityPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void accountSummaryLink(){
        super.click(accountsOverview);
    }
    public String getMessageSuccessfulDeposits(){
        return this.getText(checkMessageDeposit);
    }

    public void selectColumnAccount(){
        super.click(accountColumn);
    }

    public String getMessageSuccessfulDetailsAccount(){
        return this.getText(messageAccountDetails);
    }

    public void activityPeriodMonthLink(){
        super.click(activityPeriodLink);
    }

    public void activityTypeAccountLink(){
        super.click(activityTypeLink);
    }

    public void clickButtonGo(){
        super.click(goButton);
    }



}
