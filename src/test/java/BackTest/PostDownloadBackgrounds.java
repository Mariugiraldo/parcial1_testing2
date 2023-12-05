package BackTest;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

public class PostDownloadBackgrounds {

    @Test
    public void dowloandBackground_Test() {
        //given
        String fromAccountId = "24777";
        String toAccountId = "26553";
        String amount = "800";

        String uri = String.format("http://parabank.parasoft.com/parabank/services/bank/transfer/fromAccountId=%s&toAccountId=%s&amount=%shttp://parabank.parasoft.com/parabank/services/bank/transfer?fromAccountId=%s&toAccountId=%s&amount=%s", fromAccountId, toAccountId, amount);

        RestAssured.when()
                .post(uri)
                .then()
                .log().all()
                .statusCode(200);
    }
}
