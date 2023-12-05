package frontend;

import pages.*;
import reportes.ExtentFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import helpers.DataHelper;
import helpers.User;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@TestMethodOrder(MethodOrderer.DisplayName.class)
public class TestSuiteFront {
    private WebDriver driver;
    private WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/REPORTES/RegisterTest.html");
    static ExtentReports extent;

    private final User user = DataHelper.createRandomUser();

    private RegisterPage registerPage;
    private AccountPage accountPage;
    private SummaryPage summaryPage;
    private TransferPage transferPage;

    private ActivityPage activityPage;


    @BeforeAll
    public static void crearReporte() {
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        registerPage = new RegisterPage(driver, wait);
        registerPage.getHomeUrl();

        accountPage = new AccountPage(driver, wait);
        summaryPage = new SummaryPage(driver, wait);
        transferPage = new TransferPage(driver, wait);
        activityPage = new ActivityPage(driver, wait);

    }

    @Test
    @Tag("Registro")
    @Tag("ALL")
    @DisplayName("1. register new user")
    public void successfulRegistrationTest() {
        ExtentTest test = extent.createTest("Prueba de registro", "Crear una nueva cuenta en el sistema de manera exitosa");
        System.out.println("Comienza el Test");

        registerPage.registerUser(user);
        test.log(Status.PASS, "Completo los datos de registro de forma correcta");

        Assertions.assertEquals("Your account was created successfully. You are now logged in.", registerPage.successfulMessage());
        test.log(Status.PASS, "los datos se han registrado correctamente");
    }


    @Test
    @Tag("Account")
    @Tag("ALL")
    @DisplayName("2. open new savings account")
    public void openNewAccountTest() {
        ExtentTest test = extent.createTest("Abrir nueva cuenta", "Seleccionar savings y abrir la nueva cuenta");
        System.out.println("Comienza el Test");

        accountPage.openSavingsAccount(user.getUsername(), user.getPassword());

        Assertions.assertEquals("Congratulations, your account is now open.", accountPage.successfulMessage());
        test.log(Status.PASS, "La cuenta ha sido creada correctamente");
    }

    @Test
    @Tag("summary")
    @Tag("ALL")
    @DisplayName("3. successful summary test")
    public void SuccessfulRegistrationSummary_Test() {
        ExtentTest test = extent.createTest("Prueba de resumen", "resumen exitoso");
        System.out.println("Comienza el Test");

        accountPage.login(user.getUsername(), user.getPassword());
        summaryPage.clickAccountOverview();
        test.log(Status.INFO, "Ingreso a pantalla de resumen");

        Assertions.assertEquals("*Balance includes deposits that may be subject to holds", summaryPage.successfulMessage());
        test.log(Status.PASS, "El resumen de la cuenta esta correcto");

    }

    @Test
    @Tag("transfer")
    @Tag("ALL")
    @DisplayName("4. transfer funds test")
    public void SuccessfulRegistrationTransfer_Test() throws InterruptedException {
        ExtentTest test = extent.createTest("Prueba de transferencia", "transferencia exitosa");
        System.out.println("Comienza el Test");

        accountPage.login(user.getUsername(), user.getPassword());

        String amount = "100";
        transferPage.transferFundsFromOneAccountToAnother(amount);

        test.log(Status.INFO, "Ingreso a la pantalla de trasnferencia de fondos");

        Assertions.assertTrue(transferPage.getSuccessfulMessage().startsWith("$100.00 has been transferred from account"));
        test.log(Status.PASS, "El resumen de la cuenta esta correcto");

    }

    @Test
    @Tag("activity")
    @Tag("ALL")
    @DisplayName("5. successful activity account test")
    public void SuccessfulRegistrationActivityAccount_Test() {
        ExtentTest test = extent.createTest("Prueba de actividad de la cuenta", "cuenta exitosa");
        System.out.println("Comienza el Test");

        accountPage.login(user.getUsername(), user.getPassword());
        activityPage.accountSummaryLink();
        test.log(Status.INFO, "Ingreso a pantalla de actividad de cuenta");

        Assertions.assertEquals("*Balance includes deposits that may be subject to holds", activityPage.getMessageSuccessfulDeposits());
        test.log(Status.PASS, "El resumen de la cuenta esta correcto");

        activityPage.selectColumnAccount();
        Assertions.assertEquals("Account Details", activityPage.getMessageSuccessfulDetailsAccount());
        test.log(Status.PASS, "El mensaje esta correcto");

        activityPage.activityPeriodMonthLink();
        activityPage.activityTypeAccountLink();
        activityPage.clickButtonGo();

    }
    @AfterEach
    public void close() {
        registerPage.close();
        accountPage.close();
        summaryPage.close();
        transferPage.close();
        activityPage.close();
    }

    @AfterAll
    public static void report() {
        extent.flush();
    }
}