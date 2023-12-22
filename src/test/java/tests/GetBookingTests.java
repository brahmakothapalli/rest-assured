package tests;

import base.BaseTest;
import constants.Endpoints;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utilities.HTTPMethods;

import java.util.HashMap;

import static base.BaseTest.BASE_URL;

public class GetBookingTests {

    @Test
    public void testGetBookingIds(){
        Response response = HTTPMethods.getRequest(BASE_URL+ Endpoints.BOOKING, new HashMap<>());
        response.body().prettyPrint();
    }
}
