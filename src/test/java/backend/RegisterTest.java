package backend;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.testng.Assert;




public class RegisterTest {
    /**
     * Carga de la pagina de registro de una nueva cuenta
     */
    @Test
    public void getRegisterPageTest() {
        Response getRegister = RestAssured.get("https://parabank.parasoft.com/parabank/register.htm");
        Assert.assertEquals(getRegister.statusCode(), 200);
    }
}

