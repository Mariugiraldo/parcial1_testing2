package backend;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class FundsTest {

    /**
     * Descarga de fondos
     */
    @Test
    public void fundTransferTest() {
        //given
        String fromAccountId = "13566";
        String toAccountId = "13677";
        String amount = "100";

        String url = String.format("https://parabank.parasoft.com/parabank/services/bank/transfer?fromAccountId=%s&toAccountId=%s&amount=%s", fromAccountId, toAccountId, amount);

        Response response = RestAssured.when()
                .post(url);

        Assertions.assertEquals(200, response.getStatusCode());

        Assertions.assertEquals("Successfully transferred $100 from account #13566 to account #13677", response.getBody().asString());
    }
}

