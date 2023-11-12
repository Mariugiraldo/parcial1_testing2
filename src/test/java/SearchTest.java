import Reportes.ExtentFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchTest {
    public WebDriver driver;
    private WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/REPORTES/SearchTest.html");
    static ExtentReports extent;

    private SearchPage searchPage;

    @BeforeAll
    public static void crearReporte() {
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
    }

    @BeforeEach
    public void inicio() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(10));
        searchPage = new SearchPage(driver, wait);
        searchPage.getHomeUrl();
    }


    @Test
    @Tag("Busqueda")
    @Tag("ALL")
    public void searchTest_Iphone() {
        ExtentTest test = extent.createTest("Prueba agregar producto a canastea de compras", "Buscar un producto Iphone y agregarlo a la canasta de compras");
        test.log(Status.INFO, "Comienza el Test");
        SearchPage searchPage = new SearchPage(driver, wait);

        searchPage.selectProduct("Iphone");
        searchPage.clickSearch();
        String result = searchPage.addedProduct();
        test.log(Status.INFO, "Completar Busqueda de producto Iphone");

        Assertions.assertTrue(result.contains("Success: You have added iPhone to your shopping cart!"));
        test.pass( "Validación de producto Iphone, Exitosa");
    }

    @Test
    @Tag("Busqueda")
    @Tag("ALL")
    public void searchTest_notFound() {
        ExtentTest test = extent.createTest("Prueba busqueda producto inexistente", "Buscar un producto que no exista en el sistema");
        test.log(Status.INFO, "Comienza el Test");
        SearchPage searchPage = new SearchPage(driver, wait);

        searchPage.selectProduct("producto inexistente");
        searchPage.clickSearch();
        try {
            searchPage.clickOnProduct();
            test.fail("El producto no debe existir");
            Assertions.assertTrue(false);
        } catch (NoSuchElementException e){
            test.pass("El producto no existe");
        }
    }

    @AfterEach
    public void quit() {
        searchPage.close();
    }

    @AfterAll
    public static void reporte() {
        extent.flush();
    }
}