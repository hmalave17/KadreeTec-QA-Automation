package co.com.kadreeTech.certification.questions;

import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static co.com.kadreeTech.certification.utils.ConstantsActor.JSON_RESPONSE;

public class CompareJsonChanges implements Question<Boolean> {

    private final String updateParameter;

    public CompareJsonChanges(String updateParameter){
        this.updateParameter = updateParameter;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        String oldJson = actor.recall(JSON_RESPONSE);
        String newJson = SerenityRest.lastResponse().getBody().asString();
        Map<String, Object> oldData = JsonPath.from(oldJson).getMap("$");
        Map<String, Object> newData = JsonPath.from(newJson).getMap("$");

        Map<String, Object> differences = new HashMap<>();

        for (Map.Entry<String, Object> entry : oldData.entrySet()) {
            String key = entry.getKey();
            Object oldValue = entry.getValue();
            Object newValue = newData.get(key);

            if (!Objects.equals(oldValue, newValue)) {
                differences.put(key, newValue);
            }
        }
        return differences.size() == 1 && differences.containsKey(updateParameter);
    }

    public static CompareJsonChanges booking(String updateParameter){
        return new CompareJsonChanges(updateParameter);
    }
}
