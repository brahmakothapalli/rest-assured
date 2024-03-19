package restfulbooker;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import payloads.CreateBookingPayload;
import utilities.HTTPMethods;

import java.util.HashMap;

public class CreateBookingTests {

    @Test
    public void testCreateBookingUsingMapPayload(){
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        String baseUrl = "https://restful-booker.herokuapp.com/booking";
        Response response = HTTPMethods.postRequest(baseUrl, CreateBookingPayload.createBookingPayloadUsingMap(), headers);
        response.then().assertThat().statusCode(HttpStatus.SC_OK);
        System.out.println(response.getBody().prettyPrint());
    }

   /* @Test
    public void testCreateBookingUsingPOJOPayload(){
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        String baseUrl = "https://restful-booker.herokuapp.com/booking";
        Response response = HTTPMethods.postRequest(baseUrl, CreateBookingPayload.createBookingPayloadAsPOJO(), headers);
        response.then().assertThat().statusCode(HttpStatus.SC_OK);
        System.out.println(response.getBody().prettyPrint());
    }*/
}
