package co.com.kadreeTech.certification.interactions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class Post extends RestInteraction {

    private static final Logger LOGGER = LoggerFactory.getLogger(Post.class);
    private final String resource;

    public Post(String resource) {
        this.resource = resource;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        LOGGER.info("start the request {}", resource);
        rest().given().log().all().when().post(as(actor).resolve(resource));
        LOGGER.info("start the response {}", resource);
        SerenityRest.lastResponse().prettyPeek();
    }
    public static Post to(String resource) {
        return new Post(resource);
    }
}
