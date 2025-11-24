package co.com.kadreeTech.certification.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.kadreeTech.certification.utils.ConstantsSystems.PATH_BOOKING_ID;


public class BookingIdNotEmpty implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return !SerenityRest.lastResponse().jsonPath().get(PATH_BOOKING_ID).toString().trim().isEmpty();
    }

    public static BookingIdNotEmpty response(){
        return new BookingIdNotEmpty();
    }
}
