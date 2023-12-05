package backend;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class AccountTest {
    /**
     * Actividad de la cuenta mensual
     */
    @Test
    public void getTransactionsByAccountTest() {
        given()
                .when()
                .get("https://parabank.parasoft.com/parabank/services/bank/accounts/17562/transactions/month/All/type/All")
                .then()
                .statusCode(200);
    }

    /**
     * Abrir una nueva cuenta
     */
    @Test
    public void openAccountTest() {
        //given
        String customerId = "14876";
        String accountType = "1";
        String fromAccountId = "17562";

        String url = String.format("https://parabank.parasoft.com/parabank/services/bank/createAccount?customerId=%s&newAccountType=%s&fromAccountId=%s", customerId, accountType, fromAccountId);

        RestAssured.when()
                .post(url)
                .then()
                .log().all()
                .statusCode(200);
    }
}
