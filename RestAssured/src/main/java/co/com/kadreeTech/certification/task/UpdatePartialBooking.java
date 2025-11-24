package co.com.kadreeTech.certification.task;

import co.com.kadreeTech.certification.interactions.GetBookingIdsRequest;
import co.com.kadreeTech.certification.interactions.GetBookingRequest;
import co.com.kadreeTech.certification.interactions.UpdatePartialBookingRequest;
import co.com.kadreeTech.certification.models.DataExcel;
import co.com.kadreeTech.certification.utils.Utilities;
import net.serenitybdd.annotations.Shared;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.Map;

import static co.com.kadreeTech.certification.utils.ConstantsSystems.PATH_BOOKING;
import static co.com.kadreeTech.certification.utils.Utilities.buildPatchData;
import static co.com.kadreeTech.certification.utils.Utilities.saveResponse;

public class UpdatePartialBooking implements Task {

    private String parameterUpdate;

    @Shared
    DataExcel dataExcel;

    public UpdatePartialBooking(String parameterUpdate){
        this.parameterUpdate = parameterUpdate;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(GetBookingIdsRequest.user());
        String arrayNumber = Integer.toString(Utilities.generateRandomNumber());
        String id = Integer.toString(SerenityRest.lastResponse().path(String.format(PATH_BOOKING, arrayNumber)));
        actor.attemptsTo(GetBookingRequest.user(id));
        saveResponse(actor, SerenityRest.lastResponse());
        Map<String, String> bodyUpdate = buildPatchData(this.parameterUpdate, dataExcel.getSetDeDatos().get(0));
        actor.attemptsTo(UpdatePartialBookingRequest.user(bodyUpdate));
    }
    public static UpdatePartialBooking user(String parameterUpdate){
        return Tasks.instrumented(UpdatePartialBooking.class, parameterUpdate);
    }
}
