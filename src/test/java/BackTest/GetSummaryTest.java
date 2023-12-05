package BackTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;


public class GetSummaryTest {
    @Test
    public void getSummary_Test_StatusCode() {
        Response getSummary = RestAssured.get("https://parabank.parasoft.com/parabank/services/bank/customers/13433/accounts");
        System.out.println("El código obtenido es: " + getSummary.statusCode());
        System.out.println("Se tardo: " + getSummary.getTime() + " milisegundos");

        Assert.assertEquals(getSummary.statusCode(), 200);
    }
}

