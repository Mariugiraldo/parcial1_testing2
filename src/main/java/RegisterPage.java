import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends BasePage {

    private By myAccountBtn = By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a");
    private By register = By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a");
    private By name = By.id("input-firstname");
    private By lastName = By.id("input-lastname");
    private By eMail = By.id("input-email");
    private By telephone = By.id("input-telephone");
    private By password = By.id("input-password");
    private By passwordConfirm = By.id("input-confirm");
    private By subscriptionNoCheckbox = By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input");
    private By privacyPolicy = By.xpath("//*[@id=\"content\"]/form/div/div/input[1]");
    private By registerButton = By.xpath("//*[@id=\"content\"]/form/div/div/input[2]");
    private By accountCreated = By.xpath("//*[@id=\"content\"]/h1");
    private By registerMessage = By.xpath("//*[@id=\"content\"]/p[1]");
    private By repeatedEmail = By.xpath("//*[@id=\"account-register\"]/div[1]");


    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickMyAccount() {
        click(myAccountBtn);
    }

    public void clickRegister() {
        click(register);
    }

    public void writeName(String name1) {
        sendText(name1, name);
    }

    public void writeLastName(String lastName1) {
        sendText(lastName1, lastName);
    }

    public void writeMail(String mail) {
        sendText(mail, eMail);
    }

    public void writeTelephone(String phone) {
        sendText(phone, telephone);
    }

    public void writePassword(String password) {
        sendText(password, this.password);
    }

    public void writePasswordConfirm(String password) {
        sendText(password, passwordConfirm);
    }

    public void markSubscription() {
        click(subscriptionNoCheckbox);
    }

    public void markPrivacyPolicy() {
        click(privacyPolicy);
    }

    public void clickRegisterButton() {
        click(registerButton);
    }

    public String getRegister() {
        return this.getText(accountCreated);
    }

    public String successfulMessage() {
        return this.getText(registerMessage);
    }

    public String repeatedEmailMessage() {
        return this.getText(repeatedEmail);
    }


}
