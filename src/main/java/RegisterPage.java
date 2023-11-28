import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends BasePage {


    private By usernameBtn = By.xpath("//*[@id=\"loginPanel\"]/form/div[1]/input");
    private By passwordBtn = By.xpath("//*[@id=\"loginPanel\"]/form/div[2]/input");
    private By register = By.xpath("//*[@id=\"loginPanel\"]/p[2]/a");

//   private By messageSesion = By.xpath("//*[@id=\"rightPanel\"]/h1");
    private By firstName = By.xpath("//*[@id=\"customer.firstName\"]");
    private By lastName = By.id("customer.lastName");
    private By address = By.xpath("//*[@id=\"customer.address.street\"]");
    private By city = By.id("customer.address.city");
    private By state = By.id("customer.address.state");
    private By zipCode = By.id("customer.address.zipCode");
    private By phone = By.id("customer.phoneNumber");
    private By ssn = By.xpath("//*[@id=\"customer.ssn\"]");
    private By username = By.xpath("//*[@id=\"customer.username\"]");
    private By password = By.xpath("//*[@id=\"customer.password\"]");
    private By passwordConfirm = By.xpath("//*[@id=\"repeatedPassword\"]");
    private By registerButton = By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input");
    private By createRegister = By.xpath("//*[@id=\"rightPanel\"]/h1");
    private By registerMessage = By.xpath("//*[@id=\"rightPanel\"]/p");



    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void writeUsernameBtn(String userNameBtn1) {
        sendText(userNameBtn1, usernameBtn);
    }

    public void writePasswordBtn(String passwordBtn1) {
        sendText(passwordBtn1, passwordBtn);
    }

    public void clickRegister() {
        click(register);
    }

//    public String message () {
//        return this.getText(messageSesion);
//    }

    public void writeFirstName(String name1) {
        sendText(name1, firstName);
    }

    public void writeLastName(String lastName1) {
        sendText(lastName1, lastName);
    }

    public void writeAddress(String address1) {
        sendText(address1, address);
    }

    public void writeCity(String city1) {
        sendText(city1, city);
    }

    public void writeState(String state1) {
        sendText(state1, state);
    }

    public void writeZipCode(String zipCode1) {
        sendText(zipCode1, zipCode);
    }

    public void writeTelephone(String phone1) {
        sendText(phone1, phone);
    }

    public void writeSsn(String ssn1) {
        sendText(ssn1, ssn);
    }

   public void writeUsername(String username1) {
      sendText(username1, username);
  }
  public void writePassword(String password) {
     sendText(password, this.password);
 }

    public void writePasswordConfirm(String password) {
        sendText(password, passwordConfirm);
    }

    public void clickRegisterButton() {
        click(registerButton);
    }

    public String successfulMessage() {
        return this.getText(registerMessage);
    }

    public String getRegister() {
        return this.getText(createRegister);

    }

    public String getUsername() {
        return this.getText(usernameBtn);
    }

    public String getPassword() {
        return this.getText(passwordBtn );

    }

}
