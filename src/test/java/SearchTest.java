
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
        searchPage.getUrl("https://opencart.abstracta.us/index.php?route=product/product&path=57&product_id=49");
    }

    @Test
    @Tag("Busqueda")
    @Tag("ALL")
    public void searchTest_Iphone() throws InterruptedException {
        ExtentTest test = extent.createTest("Prueba de Busqueda producto Ipohne, Exitosa");
        test.log(Status.INFO, "Comienza el Test");
        SearchPage searchPage = new SearchPage(driver, wait);

        searchPage.selectproduct("Iphone");
        searchPage.clickSearch();
        test.log(Status.PASS, "Completar Busqueda de producto Iphone");

        Assertions.assertEquals(searchPage.addedProduct(), " Success: You have added iPhone to your shopping cart!");
        test.log(Status.PASS, "Validación de producto Iphone, Exitosa");
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