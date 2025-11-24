package co.com.kadreeTech.certification.interactions;

import co.com.kadreeTech.certification.models.DataExcel;
import co.com.kadreeTech.certification.utils.ConstantsActor;
import com.google.gson.Gson;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static co.com.kadreeTech.certification.utils.ConstantsSystems.*;

public class UpdateBookingRequest implements Interaction {
    private DataExcel data;
    public UpdateBookingRequest(DataExcel data){
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String endpoint = actor.recall(RESOURCE_BOOKING_UPDATE);
        String token = actor.recall(ConstantsActor.TOKEN);
        co.com.kadreeTech.certification.models.request.CreateBookingRequest bodyRequest =
                new co.com.kadreeTech.certification.models.request.CreateBookingRequest(data.getSetDeDatos().get(0));
        Gson gson = new Gson();
        String jsonBody = gson.toJson(bodyRequest);
        actor.whoCan(CallAnApi.at(URL_BASE));
        actor.attemptsTo(
                Put.to(endpoint)
                        .with(request -> request
                                .contentType(ContentType.JSON)
                                .accept(APPLICATION_JSON)
                                .header(COOKIE,TOKEN_HEADER + token)
                                .body(jsonBody)
                                .relaxedHTTPSValidation()
                        ));
    }
    public static UpdateBookingRequest user(DataExcel data){
        return new UpdateBookingRequest(data);
    }
}
