import Reportes.ExtentFactory;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchTest {
    public WebDriver driver;
    private WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/REPORTES/SearchTest.html");
    static ExtentReports extent;

    @BeforeAll
    public static void crearReporte() {
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
    }

    @BeforeEach
    public void inicio() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        SearchPage searchPage = new SearchPage(driver, wait);
        searchPage.setUp();
        searchPage.getUrl("http://testing.ctd.academy/");
    }

    @Test
    @Tag("Busqueda")
    @Tag("ALL")
    public void testBusqueda_Uruguay() throws InterruptedException {
        ExtentTest test = extent.createTest("Prueba de Busqueda Ciudad Uruguay Exitosa");
        test.log(Status.INFO, "Comienza el Test");
        SearchPage searchPage = new SearchPage(driver, wait);

        searchPage.seleccionarCiudad("Punta del este");
        searchPage.clickBuscar();
        test.log(Status.PASS, "Completar Busqueda de Punta del este");

        Assertions.assertEquals(searchPage.obtenerRecomendacion(), "CASA DE PLAYA\nVilla Kantounes Studio Ostria");
        test.log(Status.PASS, "Validación de Recomendación Punta del este Exitosa");
    }

    @Test
    @Tag("Busqueda")
    @Tag("ALL")
    public void testBusqueda_Grecia() throws InterruptedException {
        ExtentTest test = extent.createTest("Prueba de Busqueda Ciudad Grecia Exitosa");
        test.log(Status.INFO, "Comienza el Test");
        SearchPage searchPage = new SearchPage(driver, wait);

        searchPage.seleccionarCiudad("Paros");
        searchPage.clickBuscar();
        test.log(Status.PASS, "Completar Busqueda de Paros");

        Assertions.assertEquals(searchPage.obtenerRecomendacion(), "CASA DE PLAYA\nLa Paloma");
        test.log(Status.PASS, "Validación de Recomendación Paros Exitosa");
    }

    @AfterEach
    public void quit() {
        SearchPage searchPage = new SearchPage(driver, wait);
        searchPage.close();
    }

    @AfterAll
    public static void reporte() {
        extent.flush();
    }
}