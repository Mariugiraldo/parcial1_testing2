package BackTest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


public class PostDownloadBackgrounds {

    @Test
    public void dowloandBackground_Test() {

        given().
                queryParam("fromAccountId", "18006").
                queryParam("amount", "200").
                queryParam("toAccountId", "17673").

                when().
                get("http://parabank.parasoft.com/parabank/services/bank/transfer/fromAccountId=%s&toAccountId=%s&amount=%shttp://parabank.parasoft.com/parabank/services/bank/transfer?fromAccountId=%s&toAccountId=%s&amount=%s").
                then().
                assertThat().
                statusCode(200);
    }
}

