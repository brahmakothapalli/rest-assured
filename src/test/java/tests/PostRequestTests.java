package tests;

import base.BaseClass;
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
        Map<String, Object> payload = CreateQuotePayload.createQuotePayload(BaseClass.configurationMap.get("productId").toString(), BaseClass.configurationMap.get("brokerId").toString());
        Response response = CreateQuoteWF.createQuote(payload);
        Assert.assertEquals(response.getStatusCode(), 201);
    }
}
