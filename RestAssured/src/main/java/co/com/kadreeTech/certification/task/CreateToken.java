package co.com.kadreeTech.certification.task;

import co.com.kadreeTech.certification.interactions.CreateTokenRequest;
import co.com.kadreeTech.certification.models.DataExcel;
import co.com.kadreeTech.certification.questions.SchemeCompliance;
import net.serenitybdd.annotations.Shared;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static co.com.kadreeTech.certification.utils.ConstantsActor.TOKEN;
import static co.com.kadreeTech.certification.utils.ConstantsMessages.SCHEMAS_SHOULD_TRUE;
import static co.com.kadreeTech.certification.utils.ConstantsSystems.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class CreateToken implements Task {


    @Shared
    DataExcel dataExcel;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(CreateTokenRequest.user(RESOURCE_CREATE_TOKEN, dataExcel));
        boolean schemasValidation = SchemeCompliance
                .response(PATH_SCHEMA_CREATE_TOKEN, RESOURCE_CREATE_TOKEN)
                .answeredBy(actor);
        assertThat(SCHEMAS_SHOULD_TRUE, schemasValidation, is(true));
        String tokenResponse = SerenityRest.lastResponse().jsonPath().get(PATH_TOKEN);
        actor.remember(TOKEN, tokenResponse);
    }

    public static CreateToken user() {
        return Tasks.instrumented(CreateToken.class);
    }
}
