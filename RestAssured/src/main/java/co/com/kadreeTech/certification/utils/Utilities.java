package co.com.kadreeTech.certification.utils;

import co.com.kadreeTech.certification.exceptions.NotMatchKey;
import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import static co.com.kadreeTech.certification.utils.ConstantsActor.JSON_RESPONSE;
import static co.com.kadreeTech.certification.utils.ConstantsExcel.TRUE_VALUE;

public class Utilities {

    public Utilities() {
    }

    public static String normalize(String value) {
        return (value == null || value.trim().isEmpty()) ? null : value.trim();
    }

    public static Integer parseInteger(String value) {
        return (value == null || value.trim().isEmpty()) ? null : Integer.parseInt(value.trim());
    }

    public static Boolean parseBoolean(String value) {
        return (value == null || value.trim().isEmpty())
                ? null
                : value.trim().equalsIgnoreCase(TRUE_VALUE);
    }

    public static Integer generateRandomNumber() {
        SecureRandom secureRandom = new SecureRandom();
        return secureRandom.nextInt(200);
    }

    public static void saveResponse(Actor actor, Response response){
        String jsonBody = response.getBody().asString();
        actor.remember(JSON_RESPONSE, jsonBody);
    }

    public static Map<String, String> buildPatchData(String updateParameter, Map<String, String> data) {
        Map<String, String> patchData = new HashMap<>();
        data.forEach((key, value) -> {
            if (key.equalsIgnoreCase(updateParameter)) {
                patchData.put(key, value);
            }
        });

        if(patchData.isEmpty()) {
            throw new RuntimeException(NotMatchKey.NOT_MATCH_KEY + updateParameter);
        }
        return patchData;
    }

}
