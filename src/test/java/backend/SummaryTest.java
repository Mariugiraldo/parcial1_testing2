package backend;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;


public class SummaryTest {

    /**
     * Resumen de las cuentas:
     *      carga de front fallida por falta de autenticacion
     */
    @Test
    public void summaryPageLoadTest() {
        Response getRegister = RestAssured.get("https://parabank.parasoft.com/parabank/overview.htm");
        // el status es 500 debido a que no hay un usuario autenticado para ver el resumen de la cuenta
        org.testng.Assert.assertEquals(getRegister.statusCode(), 500);
    }

    /**
     * Resumen de las cuentas:
     *      servicio de back invocado una vez el usuario esta autenticado
     */
    @Test
    public void getAccountSummaryByCustomerIdTest() {
        // este es el endpoint que se consume una vez dentro del aplicativo con un usuario valido logueado
        Response getSummary = RestAssured.get("https://parabank.parasoft.com/parabank/services/bank/customers/13433/accounts");
        Assert.assertEquals(getSummary.statusCode(), 200);
        Assert.assertTrue(getSummary.getBody().xmlPath().get("accounts.account.customerId").equals("13433"));
    }
}