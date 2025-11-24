package runners;

import com.intuit.karate.junit5.Karate;

public class UpdateBookingRunner {
    @Karate.Test
    Karate testUpdateBooking() {
        return Karate.run("classpath:features/booking/update_booking.feature").tags("@UpdateBookingPartial")
                .relativeTo(getClass());
    }
}
