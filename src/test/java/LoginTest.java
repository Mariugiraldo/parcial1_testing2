import Reportes.ExtentFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {
    private WebDriver driver;
    private WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/REPORTES/LoginTest.html");
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
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.setUp();
        loginPage.getUrl("http://testing.ctd.academy/");
    }

    @Test
    @Tag("Login")
    @Tag("ALL")
    public void LoginExitosoTest() throws InterruptedException {
        ExtentTest test = extent.createTest("Prueba de Login Exitoso");
        test.log(Status.INFO, "Comienza el Test");
        LoginPage loginPage = new LoginPage(driver, wait);

        try {
            loginPage.clickLogin();
            test.log(Status.PASS, "Ingreso a la página de Login");

            loginPage.escribirMail("prueba3@gmail.com");
            loginPage.escribirContrasena("123456");
            loginPage.clickIngresar();
            test.log(Status.PASS, "Se completan de forma correcta los datos de Login y se loguea");

            Assertions.assertEquals(loginPage.obtenerUsuario(), "Prueba3 Prueba32");
            test.log(Status.PASS, "Validamos que se haya realizado el Login Exitoso");
        } catch (AssertionError error) {
            test.log(Status.FAIL, "Fallo la validación: " + error.getLocalizedMessage());
            throw error;
        }
    }

    @Test
    @Tag("Login")
    @Tag("ALL")
    public void LoginFallidoTest() throws InterruptedException {
        ExtentTest test = extent.createTest("Prueba de Login Fallido por credenciales inválidas");
        test.log(Status.INFO, "Comienza el Test");
        LoginPage loginPage = new LoginPage(driver, wait);

        loginPage.clickLogin();
        test.log(Status.PASS, "Ingreso a la página de Login");

        loginPage.escribirMail("prrrrr@gmail.com");
        loginPage.escribirContrasena("123456");
        loginPage.clickIngresar();
        test.log(Status.PASS, "Se completan con datos inválidos el Login y se intenta loguear");

        if (loginPage.obtenerMensajeError().equals("Sus credenciales son inválidas. Por favor, vuelva a ntentarlo")) {
            test.log(Status.PASS, "Validamos el mensaje de Credenciales inválidas");
        } else {
            test.log(Status.FAIL, "No se pudo validar el mensaje de Login Fallido");
        }
    }

    @AfterEach
    public void cerrar() {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.close();
    }

    @AfterAll
    public static void reporte() {
        extent.flush();
    }
}
