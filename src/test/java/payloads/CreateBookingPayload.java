package payloads;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pojos.BookingDates;

import java.util.HashMap;
import java.util.Locale;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateBookingPayload {

    private String firstname;
    private String lastname;
    private Integer totalprice;
    private Boolean depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;
    public static HashMap<String, Object> createBookingPayloadUsingMap(){
        HashMap<String, Object> bookingPayload = new HashMap<>();
        HashMap<String, Object> bookingDates = new HashMap<>();
        bookingDates.put("checkin", "2024-04-04");
        bookingDates.put("checkout", "2024-05-04");
        Faker faker = new Faker(Locale.ENGLISH);
        bookingPayload.put("firstname", faker.name().firstName());
        bookingPayload.put("lastname", faker.name().lastName());
        bookingPayload.put("totalprice", faker.number().digits(3));
        bookingPayload.put("depositpaid", true);
        bookingPayload.put("bookingdates", bookingDates);
        bookingPayload.put("additionalneeds", faker.food().fruit());
        return bookingPayload;
    }

    public static CreateBookingPayload createBookingPayloadAsPOJO(){
        Faker faker = new Faker(Locale.ENGLISH);
        return CreateBookingPayload.builder()
                .firstname(faker.name().firstName())
                .lastname(faker.name().lastName())
                .totalprice(faker.number().numberBetween(2, 4))
                .bookingdates(new BookingDates())
                .additionalneeds(faker.food().fruit())
                .build();
    }
}
