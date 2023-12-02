package BackTest;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;



public class PostAccountTest {
    @Test
    public void OpenAccountTest() {
        //given
        String customerId = "17540";
        String accountType = "1";
        String fromAccountId = "19227";

        String uri = String.format("https://parabank.parasoft.com/parabank/services/bank/createAccount?customerId=%s&newAccountType=%s&fromAccountId=%s", customerId, accountType, fromAccountId);

        RestAssured.when()
                .post(uri)
        .then()
                .log().all()
                .statusCode(200);

    }
}

