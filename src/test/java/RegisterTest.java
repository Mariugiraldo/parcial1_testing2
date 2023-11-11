import Reportes.ExtentFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterTest {
    private WebDriver driver;
    private WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/REPORTES/RegisterTest.html");
    static ExtentReports extent;

    @BeforeAll
    public static void crearReporte() {
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.setUp();
        registerPage.getUrl("https://opencart.abstracta.us/index.php?route=product/product&path=57&product_id=49");
    }

    @Test
    @Tag("Registro")
    @Tag("ALL")
    public void SuccessfulRegistrationTest() throws InterruptedException {
        ExtentTest test = extent.createTest("Prueba de Crear Cuenta Exitosa");
        test.log(Status.INFO, "Comienza el Test");
        RegisterPage registerPage = new RegisterPage(driver, wait);

        try {
            registerPage.clickMyAccount();
            registerPage.clickRegister();
            Assertions.assertEquals("Account", registerPage.getRegister());
            test.log(Status.PASS, "Ingreso a pantalla de registro");

            registerPage.writeName("Maria Eugenia");
            registerPage.writeLastName("Giraldo Herrera");
            registerPage.writeMail("mariugiraldo"+Math.random()+"@gmail.com");
            registerPage.writeTelephone("324567");
            registerPage.writePassword("29M@yo");
            registerPage.writePasswordConfirm("29M@yo");
            registerPage.MarkSubscription();
            registerPage.MarkprivacePolicy();

            registerPage.clickRegisterButton();
            test.log(Status.PASS, "registro culminado");

            Assertions.assertEquals("Congratulations! Your new account has been successfully created!", registerPage.successfulMessage());
            test.log(Status.PASS, "los datos se han registrado correctamente");

        } catch (AssertionError error) {
            test.log(Status.FAIL, "Fallo la validación: " + error.getLocalizedMessage());
            throw error;
        }
    }

    @Test
    @Tag("Registro")
    @Tag("ALL")
    public void repeatedEmailTest() throws InterruptedException {
        ExtentTest test = extent.createTest("Prueba de Crear una cuenta con un mail repetido");
        test.log(Status.PASS, "Comienza el Test");
        RegisterPage registerPage = new RegisterPage(driver, wait);

        try {
            registerPage.clickMyAccount();
            registerPage.clickRegister();
            Assertions.assertEquals("Crear cuenta", registerPage.getRegister());
            test.log(Status.INFO, "Ingreso a la página de Registro");

            registerPage.writeName("Maria Eugenia");
            registerPage.writeLastName("Giraldo Herrera");
            registerPage.writeMail("mariugiraldo40@gmail.com");
            registerPage.writeTelephone("324567");
            registerPage.writePassword("29M@yo");
            registerPage.writePasswordConfirm("29M@yo");
            registerPage.MarkSubscription();
            registerPage.MarkprivacePolicy();

            registerPage.clickRegisterButton();
            test.log(Status.PASS, "Completo el registro");

            Assertions.assertEquals("Este email ya está registrado", registerPage.repeatedEmailMessage());
            test.log(Status.PASS, "Valido no poder registrarme con un correo repetido");

        } catch (AssertionError error) {
            test.log(Status.FAIL, "Fallo la validación: " + error.getLocalizedMessage());
            throw error;
        }
    }

    @AfterEach
    public void close() {
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.close();
    }

    @AfterAll
    public static void report() {
        extent.flush();
    }
}
