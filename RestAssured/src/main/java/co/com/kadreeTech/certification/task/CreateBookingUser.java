package co.com.kadreeTech.certification.task;

import co.com.kadreeTech.certification.interactions.CreateBookingRequest;
import co.com.kadreeTech.certification.models.DataExcel;
import co.com.kadreeTech.certification.utils.ParameterReader;
import net.serenitybdd.annotations.Shared;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class CreateBookingUser implements Task {

    public static final String RESOURCE_CREATE_BOOKING = ParameterReader.getProperty("endpoint.createBooking");


    @Shared
    DataExcel dataExcel;
    public CreateBookingUser(){}

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(CreateBookingRequest.user(RESOURCE_CREATE_BOOKING, dataExcel));
    }
    public static CreateBookingUser with(){
        return Tasks.instrumented(CreateBookingUser.class);
    }
}
