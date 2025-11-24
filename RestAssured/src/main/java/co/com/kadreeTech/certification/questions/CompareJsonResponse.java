package co.com.kadreeTech.certification.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.kadreeTech.certification.utils.ConstantsActor.JSON_RESPONSE;

public class CompareJsonResponse implements Question<Boolean> {

    public CompareJsonResponse(){}
    @Override
    public Boolean answeredBy(Actor actor) {
        String previousJSON = actor.recall(JSON_RESPONSE);
        String actualJSON = SerenityRest.lastResponse().getBody().toString();
        return !previousJSON.equalsIgnoreCase(actualJSON);
    }

    public static CompareJsonResponse booking(){
        return new CompareJsonResponse();
    }
}
