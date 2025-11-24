package co.com.kadreeTech.certification.hook;

import co.com.kadreeTech.certification.utils.ParameterReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.io.IOException;

public class Setup {
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("User");
    }

    @Before
    public void setup() throws IOException {
        ParameterReader.addPropertiesSource("src/test/resources/automation.properties");
    }

    @After
    public void cleanUp() {
        OnStage.drawTheCurtain();
    }
}
