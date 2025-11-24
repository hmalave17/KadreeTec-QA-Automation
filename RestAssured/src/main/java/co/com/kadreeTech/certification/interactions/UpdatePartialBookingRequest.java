package co.com.kadreeTech.certification.interactions;

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.util.Map;

import static co.com.kadreeTech.certification.utils.ConstantsActor.TOKEN;
import static co.com.kadreeTech.certification.utils.ConstantsSystems.*;

public class UpdatePartialBookingRequest implements Interaction {

    private Map<String, String> bodyUpdate;

    public UpdatePartialBookingRequest(Map<String, String> bodyUpdate){
        this.bodyUpdate = bodyUpdate;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String endpoint = actor.recall(RESOURCE_BOOKING_UPDATE);
        String token = actor.recall(TOKEN);
        Gson gson = new Gson();
        String jsonBody = gson.toJson(bodyUpdate);
        actor.whoCan(CallAnApi.at(URL_BASE));
        actor.attemptsTo(
                Patch.to(endpoint)
                        .with(request -> request
                                .contentType(ContentType.JSON)
                                .accept(APPLICATION_JSON)
                                .header(COOKIE,TOKEN_HEADER + token)
                                .body(jsonBody)
                                .relaxedHTTPSValidation()
                        ));
    }
    public static UpdatePartialBookingRequest user(Map<String, String> bodyUpdate){
        return new UpdatePartialBookingRequest(bodyUpdate);
    }

}
