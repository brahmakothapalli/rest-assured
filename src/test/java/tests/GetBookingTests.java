package tests;

import constants.Endpoints;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.HTTPMethods;

import java.util.HashMap;

import static base.BaseClass.BASE_URL;

public class GetBookingTests {

    @Test
    public void testGetBookingIds(){
        Response response = HTTPMethods.getRequest(BASE_URL+ Endpoints.BOOKING, new HashMap<>());
        response.body().prettyPrint();
        Assert.assertEquals(response.statusCode(), 200);
        JsonPath jsonPath = response.jsonPath();
        System.out.println(jsonPath.get("bookingid").toString());
    }
}
