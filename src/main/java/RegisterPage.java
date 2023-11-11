import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends BasePage {

    private By myAccountBtn = By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/");
    private By name = By.id("input-firstname");
    private By lastName = By.id("input-lastname");
    private By eMail = By.id("input-email");
    private By telephone = By.id("input-telephone");
    private By password = By.id("input-password");
    private By passwordConfirm = By.id("input-confirm");
    private By subscribe = By.name("newsletter");
    private By privacePolicy = By.name("agree");
    private By registerAccount = By.xpath("//*[@id=\"content\"]/form/div/div/input[2]");
    private By accountCreated = By.xpath("//*[@id=\"content\"]/h1");
    private By message = By.xpath("//*[@id=\"content\"]/p[1]");
    private By repeatedEmail = By.xpath("//*[@id=\"account-register\"]/div[1]");


    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clicMyAccount() throws InterruptedException {
        click(myAccountBtn);
    }

    public void writeName(String name1) throws InterruptedException {
        sendText(name1, name);
    }

    public void writeLastName(String lastName1) throws InterruptedException {
        sendText(lastName1, lastName);
    }

    public void writeMail(String mail) throws InterruptedException {
        sendText(mail, eMail);
    }

    public void writeTelephone(String phone) throws InterruptedException {
        sendText(phone, telephone);
    }

    public void writePassword(String clue) throws InterruptedException {
        sendText(clue, password);
    }

    public void writePasswordConfirm(String clau) throws InterruptedException {
        sendText(clau, passwordConfirm);
    }

    public void MarkSubscription(String subscription) throws InterruptedException {
        sendText(subscription, subscribe);
    }

    public void MarkprivacePolicy(String subscription) throws InterruptedException {
        sendText(subscription, subscribe);
    }

    public void clickCheckIn() throws InterruptedException {
        click(registerAccount);
    }

    public String getRegister() throws InterruptedException {
        System.out.println("La cuenta ha sido registrada: " + getText(accountCreated));
        return this.getText(accountCreated);
    }

    public String successfulMessage() throws InterruptedException {
        System.out.println("Se creo la cuenta: " + getText(message));
        return this.getText(message);
    }

    public String repeatedEmailMessage() throws InterruptedException {
        System.out.println("Verificar el mensaje de correo repetido: " + getText(repeatedEmail));
        return this.getText(repeatedEmail);
    }


}
