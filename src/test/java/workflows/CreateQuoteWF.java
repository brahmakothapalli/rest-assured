package workflows;

import base.BaseTest;
import utilities.HTTPMethods;
import io.restassured.response.Response;
import payloads.CreateQuotePayload;

import java.util.HashMap;
import java.util.Map;

public class CreateQuoteWF {

    public static Response createQuote(Map<String, Object> payload1){
        String baseUrl = BaseTest.configurationMap.get("baseUrl").toString();
        Map<String, String> header = new HashMap<>();
        header.put("Authorization", "Bearer "+BaseTest.configurationMap.get("token").toString());
        String product = BaseTest.configurationMap.get("productId").toString();
        String brokerId = BaseTest.configurationMap.get("brokerId").toString();
        Map<String, Object> payload = CreateQuotePayload.createQuotePayload(product, brokerId);
        return HTTPMethods.postRequest(baseUrl, payload, header);
    }
}
