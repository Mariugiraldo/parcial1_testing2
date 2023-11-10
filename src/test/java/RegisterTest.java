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
        registerPage.getUrl("http://testing.ctd.academy/");
    }

    @Test
    @Tag("Registro")
    @Tag("ALL")
    public void RegistroExitosoTest() throws InterruptedException {
        ExtentTest test = extent.createTest("Prueba de Crear Cuenta Exitosa");
        test.log(Status.INFO, "Comienza el Test");
        RegisterPage registerPage = new RegisterPage(driver, wait);

        try {
            registerPage.clickRegistrar();
            Assertions.assertEquals(registerPage.obtenerTituloRegistro(), "Crear cuenta");
            test.log(Status.PASS, "Ingreso a la página de Registro");

            registerPage.escribirNombre("Sergio");
            registerPage.escribirApellido("Pace");
            registerPage.escribirMail("spaceprueba_2@gmail.com");
            registerPage.escribirContraseña("123456");
            registerPage.escribirConfirmarContraseña("123456");
            test.log(Status.PASS, "Completo los datos de registro de forma correcta");

            registerPage.clickRegistrarse();
            test.log(Status.PASS, "Completo el registro");

            Assertions.assertEquals(registerPage.obtenerMensajeExito(), "¡Cuenta registrada con éxito!");
            Assertions.assertEquals(registerPage.obtenerMensajeConfirmarMail(), "Te enviamos un email para confirmar tu cuenta");
            test.log(Status.PASS, "Valido que el registro se haya hecho de forma exitosa");

            registerPage.clickLogo();
            test.log(Status.PASS, "Regreso a la página inicial");
        } catch (AssertionError error) {
            test.log(Status.FAIL, "Fallo la validación: " + error.getLocalizedMessage());
            throw error;
        }
    }

    @Test
    @Tag("Registro")
    @Tag("ALL")
    public void RegistroFallidoTodosTest() throws InterruptedException {
        ExtentTest test = extent.createTest("Prueba de registro fallido - Todos los campos vacios");
        test.log(Status.INFO, "Comienza el Test");
        RegisterPage registerPage = new RegisterPage(driver, wait);

        try {
            registerPage.clickRegistrar();
            Assertions.assertEquals(registerPage.obtenerTituloRegistro(), "Crear cuenta");
            test.log(Status.PASS, "Ingreso a la página de Registro");

            registerPage.clickRegistrarse();
            test.log(Status.PASS, "Presiono el boton registrarse sin completar ningun campo");

            Assertions.assertEquals(registerPage.obtenerMensajeNombreObligatorio(), "Este campo es obligatorio");
            Assertions.assertEquals(registerPage.obtenerMensajeApellidoObligatorio(), "Este campo es obligatorio");
            Assertions.assertEquals(registerPage.obtenerMensajeCorreoObligatorio(), "Este campo es obligatorio");
            Assertions.assertEquals(registerPage.obtenerMensajeContraseñaObligatorio(), "Este campo es obligatorio");
            Assertions.assertEquals(registerPage.obtenerMensajeConfirmarContraseñaObligatorio(), "Este campo es obligatorio");
            test.log(Status.PASS, "Valido que en todos los campos se vea el mensaje de campo obligatorio");

            registerPage.clickLogo();
            test.log(Status.PASS, "Regreso a la página inicial");
        } catch (AssertionError error) {
            test.log(Status.FAIL, "Fallo la validación: " + error.getLocalizedMessage());
            throw error;
        }
    }

    @Test
    @Tag("Registro")
    @Tag("ALL")
    public void RegistroMailRepetidoTest() throws InterruptedException {
        ExtentTest test = extent.createTest("Prueba de Crear una cuenta con un mail repetido");
        test.log(Status.INFO, "Comienza el Test");
        RegisterPage registerPage = new RegisterPage(driver, wait);

        try {
            registerPage.clickRegistrar();
            Assertions.assertEquals(registerPage.obtenerTituloRegistro(), "Crear cuenta");
            test.log(Status.PASS, "Ingreso a la página de Registro");

            registerPage.escribirNombre("Sergio");
            registerPage.escribirApellido("Pace");
            registerPage.escribirMail("spaceprueba_1@gmail.com");
            registerPage.escribirContraseña("123456");
            registerPage.escribirConfirmarContraseña("123456");
            test.log(Status.PASS, "Completo los datos de registro de forma correcta, con un mail usado");

            registerPage.clickRegistrarse();
            test.log(Status.PASS, "Completo el registro");

            Assertions.assertEquals(registerPage.obtenerMensajeCorreoRepetido(), "Ese email ya se encuentra registrado");
            test.log(Status.PASS, "Valido no poder registrarme con un correo repetido");

            registerPage.clickLogo();
            test.log(Status.PASS, "Regreso a la página inicial");
        } catch (AssertionError error) {
            test.log(Status.FAIL, "Fallo la validación: " + error.getLocalizedMessage());
            throw error;
        }
    }

    @AfterEach
    public void cerrar() {
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.close();
    }

    @AfterAll
    public static void reporte() {
        extent.flush();
    }
}
