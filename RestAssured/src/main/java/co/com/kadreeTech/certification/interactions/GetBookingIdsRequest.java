package co.com.kadreeTech.certification.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static co.com.kadreeTech.certification.utils.ConstantsSystems.RESOURCE_GET_BOOKING;
import static co.com.kadreeTech.certification.utils.ConstantsSystems.URL_BASE;


public class GetBookingIdsRequest implements Interaction {


    public GetBookingIdsRequest(){}

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.whoCan(CallAnApi.at(URL_BASE));
        actor.attemptsTo(
                Get.to(RESOURCE_GET_BOOKING)
                        .with(request -> request
                        )
        );
    }

    public static GetBookingIdsRequest user() {
        return new GetBookingIdsRequest();
    }

}
