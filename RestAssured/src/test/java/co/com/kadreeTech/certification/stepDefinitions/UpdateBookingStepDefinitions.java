package co.com.kadreeTech.certification.stepDefinitions;

import co.com.kadreeTech.certification.exceptions.UnexpectedBodyResponse;
import co.com.kadreeTech.certification.exceptions.UnexpectedSchemasResponse;
import co.com.kadreeTech.certification.exceptions.UnexpectedStatusCode;
import co.com.kadreeTech.certification.questions.CompareJsonChanges;
import co.com.kadreeTech.certification.questions.CompareJsonResponse;
import co.com.kadreeTech.certification.questions.SchemeCompliance;
import co.com.kadreeTech.certification.task.CreateToken;
import co.com.kadreeTech.certification.task.UpdateBooking;
import co.com.kadreeTech.certification.task.SetDataTest;
import co.com.kadreeTech.certification.task.UpdatePartialBooking;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;

import static co.com.kadreeTech.certification.enums.StatusCodeResponse.SUCCESSFUL;
import static co.com.kadreeTech.certification.utils.ConstantsExcel.CREATE_BOOKING_SUCCESSFUL;
import static co.com.kadreeTech.certification.utils.ConstantsExcel.SHEET_UPDATE_BOOKING;
import static co.com.kadreeTech.certification.utils.ConstantsSystems.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class UpdateBookingStepDefinitions {

    @Given("that a user is authenticated")
    public void thatAUserIsAuthenticated() {
        theActorInTheSpotlight().attemptsTo(SetDataTest.user(SHEET_UPDATE_BOOKING, CREATE_BOOKING_SUCCESSFUL));
        theActorInTheSpotlight().attemptsTo(CreateToken.user());
    }

    @When("updating a booking")
    public void updatingABooking() {
        theActorInTheSpotlight().attemptsTo(UpdateBooking.user());
    }

    @When("updating partial booking {string}")
    public void updatingPartialBooking(String updateParameter) {
        theActorInTheSpotlight().attemptsTo(UpdatePartialBooking.user(updateParameter));
    }

    @Then("the system displays the update")
    public void theSystemDisplaysTheUpdate() {
        theActorInTheSpotlight().should(
                seeThat(SchemeCompliance.response(PATH_SCHEMA_UPDATE_BOOKING, RESOURCE_BOOKING_UPDATE), equalTo(true)
                ).orComplainWith(Error.class, UnexpectedSchemasResponse.UNEXPECTED_SCHEMAS_RESPONSE),
                seeThat(STATUS_CODE, actor -> SerenityRest.lastResponse().statusCode(), equalTo(SUCCESSFUL.getStatusCode())
                ).orComplainWith(Error.class, UnexpectedStatusCode.UNEXPECTED_STATUS_CODE),
                seeThat(CompareJsonResponse.booking(), equalTo(true)
                ).orComplainWith(Error.class, UnexpectedBodyResponse.UNEXPECTED_BODY_RESPONSE)
        );
    }

    @Then("booking is partially updated {string}")
    public void bookingIsPartiallyUpdated(String updateParameter) {
        theActorInTheSpotlight().should(
                seeThat(SchemeCompliance.response(PATH_SCHEMA_UPDATE_BOOKING, RESOURCE_BOOKING_UPDATE), equalTo(true)
                ).orComplainWith(Error.class, UnexpectedSchemasResponse.UNEXPECTED_SCHEMAS_RESPONSE),
                seeThat(STATUS_CODE, actor -> SerenityRest.lastResponse().statusCode(), equalTo(SUCCESSFUL.getStatusCode())
                ).orComplainWith(Error.class, UnexpectedStatusCode.UNEXPECTED_STATUS_CODE),
                seeThat(CompareJsonChanges.booking(updateParameter), equalTo(true)
                ).orComplainWith(Error.class, UnexpectedBodyResponse.UNEXPECTED_BODY_RESPONSE)
        );
    }
}
