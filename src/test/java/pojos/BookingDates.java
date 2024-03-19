package pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class BookingDates {
    private String checkin;
    private String checkout;

    public BookingDates(){
        this.checkin = "2024-08-08";
        this.checkout = "2025-08-08";
    }
}
