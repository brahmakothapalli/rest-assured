package tests;

import base.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import payloads.CreateQuotePayload;
import workflows.CreateQuoteWF;

import java.util.Map;

public class PostRequestTests {

    /**
     * Post Request
     * Require - Header (Content Type), Auth and Body
     */
    @Test
    public void createQuoteTest(){
        Map<String, Object> payload = CreateQuotePayload.createQuotePayload(BaseTest.configurationMap.get("productId").toString(), BaseTest.configurationMap.get("brokerId").toString());
        Response response = CreateQuoteWF.createQuote(payload);
        Assert.assertEquals(response.getStatusCode(), 201);
    }
}
