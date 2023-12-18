package payloads;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Locale;

public class CreateQuotePayload {

    public static HashMap<String, String> createQuotePayload(String product, String brokerId) {
        HashMap<String, String> quotePayload = new HashMap<>();
        Faker faker = new Faker(Locale.ENGLISH);
        quotePayload.put("userId", String.valueOf(faker.number()));
        quotePayload.put("applicantName", faker.name().toString());
        quotePayload.put("productId", product);
        quotePayload.put("brokerId", brokerId);
        return quotePayload;
    }
}
