package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage extends BasePage {

    private By usernameBtn = By.xpath("//*[@id=\"loginPanel\"]/form/div[1]/input");
    private By passwordBtn = By.xpath("//*[@id=\"loginPanel\"]/form/div[2]/input");
    private final By openNewAccount = By.xpath("//*[@id=\"leftPanel\"]/ul/li[1]/a");
    private final By accountType = By.xpath("//*[@id=\"type\"]/option[2]");
    private final By openAccount = By.xpath("//input[@type='submit']");
    private final By message = By.xpath("//*[@id=\"rightPanel\"]/div/div/p[1]");

    private By loginBtn = By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input");


    public AccountPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void writeUsername(String userNameBtn1) {
        super.sendText(userNameBtn1, usernameBtn);
    }

    public void writePassword(String passwordBtn1) {
        sendText(passwordBtn1, passwordBtn);
    }

    public void clickOpenNewAccountLink() {
        super.click(openNewAccount);
    }

    public void clickOpenAccountButton() {
        super.click(openAccount);
    }

    public void selectSavingsAccountType() {
        super.click(accountType);
    }

    public String successfulMessage() {
        return this.getText(message);
    }

    public void login(String username, String password) {
        writeUsername(username);
        writePassword(password);
        click(loginBtn);
    }

    public void openSavingsAccount(String username, String password) {
        login(username, password);
        clickOpenNewAccountLink();
        selectSavingsAccountType();
        clickOpenAccountButton();
    }
}



