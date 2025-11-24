package co.com.kadreeTech.certification.questions;

import co.com.kadreeTech.certification.utils.Log;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.logging.Level;

import static co.com.kadreeTech.certification.utils.ConstantsMessages.RESPONSE_MATCHES_EXPECTED_SCHEMAS;
import static co.com.kadreeTech.certification.utils.ConstantsMessages.SCHEMA_VALIDATION_SUCCESSFUL;
import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class SchemeCompliance implements Question<Boolean> {

    private String path;
    private String resource;

    public SchemeCompliance(String path, String resource){
        this.path = path;
        this.resource = resource;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        Response response = SerenityRest.lastResponse();
        assertThat(
                RESPONSE_MATCHES_EXPECTED_SCHEMAS,
                response.getBody().asString(),
                matchesJsonSchemaInClasspath(this.path)
        );
        Log.getLogger().log(Level.INFO, SCHEMA_VALIDATION_SUCCESSFUL, this.resource);
        return true;
    }

    public static SchemeCompliance response(String path, String resource){
        return new SchemeCompliance(path, resource);
    }
}
