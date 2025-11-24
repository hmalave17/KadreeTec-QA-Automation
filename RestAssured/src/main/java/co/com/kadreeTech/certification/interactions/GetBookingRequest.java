package co.com.kadreeTech.certification.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static co.com.kadreeTech.certification.utils.ConstantsSystems.*;


public class GetBookingRequest implements Interaction {

    private String id;

    public GetBookingRequest(String id){
        this.id = id;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        String resourceGetBooking = RESOURCE_GET_BOOKING + "/" + id;
        actor.remember(RESOURCE_BOOKING_UPDATE, resourceGetBooking);
        actor.whoCan(CallAnApi.at(URL_BASE));
        actor.attemptsTo(
                Get.to(resourceGetBooking)
                        .with(request -> request
                                .accept(APPLICATION_JSON)
                        )
        );
    }

    public static GetBookingRequest user(String id) {
        return new GetBookingRequest(id);
    }
}
