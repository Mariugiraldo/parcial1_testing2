package BackTest;

import org.junit.jupiter.api.Test;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;



public class GetRegisterTest {
    @Test
    public void GetRegisterUrl_Test() {
        Response getRegister = RestAssured.get("https://parabank.parasoft.com/parabank/register.htm");
        System.out.println("el status obtenido es:" + getRegister.statusCode());
        System.out.println(getRegister.getBody().asString());
        Assert.assertEquals(getRegister.statusCode(), 200);
    }
}

