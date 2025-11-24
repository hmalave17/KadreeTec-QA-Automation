package co.com.kadreeTech.certification.interactions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Get extends RestInteraction {

    private final String resource;
    private static final Logger LOGGER = LoggerFactory.getLogger(Get.class);

    public Get(String resource) {
        this.resource = resource;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("start the request {}", resource);
        rest().given().log().all().when().get(as(actor).resolve(resource));
        LOGGER.info("start the response {}", resource);
        SerenityRest.lastResponse().prettyPeek();
    }
    public static Get to(String resource) {
        return new Get(resource);
    }

}
