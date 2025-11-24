package co.com.kadreeTech.certification.interactions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class Put extends RestInteraction {

    private static final Logger LOGGER = LoggerFactory.getLogger(Put.class);
    private final String resource;

    public Put(String resource) {
        this.resource = resource;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("start the request {}", resource);
        rest().given().log().all().when().put(as(actor).resolve(resource));
        LOGGER.info("start the response {}", resource);
        SerenityRest.lastResponse().prettyPeek();
    }

    public static Put to(String resource) {
        return new Put(resource);
    }

}