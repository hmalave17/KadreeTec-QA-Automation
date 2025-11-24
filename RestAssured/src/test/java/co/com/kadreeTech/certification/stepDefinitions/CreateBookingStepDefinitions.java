package co.com.kadreeTech.certification.stepDefinitions;

import co.com.kadreeTech.certification.exceptions.UnexpectedBodyResponse;
import co.com.kadreeTech.certification.exceptions.UnexpectedSchemasResponse;
import co.com.kadreeTech.certification.exceptions.UnexpectedStatusCode;
import co.com.kadreeTech.certification.questions.BookingIdNotEmpty;
import co.com.kadreeTech.certification.questions.SchemeCompliance;
import co.com.kadreeTech.certification.task.CreateBookingUser;
import co.com.kadreeTech.certification.task.SetDataTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;

import static co.com.kadreeTech.certification.enums.StatusCodeResponse.INTERNAL_ERROR_SERVER;
import static co.com.kadreeTech.certification.enums.StatusCodeResponse.SUCCESSFUL;
import static co.com.kadreeTech.certification.utils.ConstantsExcel.*;
import static co.com.kadreeTech.certification.utils.ConstantsSystems.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CreateBookingStepDefinitions {


    @Given("user into her data")
    public void userIntoHerData() {
        theActorInTheSpotlight().attemptsTo(SetDataTest.user(SHEET_SUCCESSFUL, CREATE_BOOKING_SUCCESSFUL));
    }

    @Given("user doesnot into her data complete {string}")
    public void userDoesnotIntoHerDataCompleteIdTest(String idTest) {
        theActorInTheSpotlight().attemptsTo(SetDataTest.user(SHEET_FAILED, idTest));
    }

    @When("user consume the services")
    public void userConsumeTheServices() {
        theActorInTheSpotlight().attemptsTo(CreateBookingUser.with());
    }

    @Then("systems create the booking")
    public void systemsCreateTheBooking() {
        theActorInTheSpotlight().should(
                seeThat(STATUS_CODE, actor -> SerenityRest.lastResponse().statusCode(), equalTo(SUCCESSFUL.getStatusCode())
                ).orComplainWith(Error.class, UnexpectedStatusCode.UNEXPECTED_STATUS_CODE),
                seeThat(BookingIdNotEmpty.response(), equalTo(true)
                ).orComplainWith(Error.class, UnexpectedBodyResponse.UNEXPECTED_BODY_RESPONSE),
                seeThat(SchemeCompliance.response(PATH_SCHEMA_CREATE_BOOKING, RESOURCE_CREATE_BOOKING), equalTo(true)
                ).orComplainWith(Error.class, UnexpectedSchemasResponse.UNEXPECTED_SCHEMAS_RESPONSE)
        );
    }

    @Then("system shows error")
    public void systemShowsError() {
        theActorInTheSpotlight().should(
                seeThat(STATUS_CODE, actor -> SerenityRest.lastResponse().statusCode(), equalTo(INTERNAL_ERROR_SERVER.getStatusCode())
                ).orComplainWith(Error.class, UnexpectedStatusCode.UNEXPECTED_STATUS_CODE)
        );
    }
}
