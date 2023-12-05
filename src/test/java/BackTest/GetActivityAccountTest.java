package BackTest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetActivityAccountTest {
    @Test
    public void testStatusCode() {
        given()
                .when()
                .get("http://parabank.parasoft.com/parabank/services/bank/accounts/17562/transactions")
                .then()
                .statusCode(200);
    }
}
