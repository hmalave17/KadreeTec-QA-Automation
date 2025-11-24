package co.com.kadreeTech.certification.interactions;

import co.com.kadreeTech.certification.models.DataExcel;
import com.google.gson.Gson;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static co.com.kadreeTech.certification.utils.ConstantsSystems.URL_BASE;

public class CreateTokenRequest implements Interaction {

    private final String endpoint;
    private final DataExcel data;

    public CreateTokenRequest(String endpoint, DataExcel data) {
        this.endpoint = endpoint;
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        co.com.kadreeTech.certification.models.request.CreateTokenRequest bodyRequest =
                new co.com.kadreeTech.certification.models.request.CreateTokenRequest(data.getSetDeDatos().get(0));
        Gson gson = new Gson();
        String jsonBody = gson.toJson(bodyRequest);
        actor.whoCan(CallAnApi.at(URL_BASE));
        actor.attemptsTo(
                Post.to(endpoint)
                        .with(request -> request
                                .contentType(ContentType.JSON)
                                .body(jsonBody)
                                .relaxedHTTPSValidation()
                        ));
    }

    public static CreateTokenRequest user(String endpoint, DataExcel data){
        return new CreateTokenRequest(endpoint, data);
    }
}
