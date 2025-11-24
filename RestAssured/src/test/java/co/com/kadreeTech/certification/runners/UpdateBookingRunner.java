package co.com.kadreeTech.certification.runners;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;



import static io.cucumber.core.options.Constants.PLUGIN_PROPERTY_NAME;
import static io.cucumber.core.options.Constants.SNIPPET_TYPE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@ExtendWith(SerenityJUnit5Extension.class)
@Suite
@SelectClasspathResource("features/update_booking.feature")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "co.com.kadreeTech.certification.stepDefinitions, co.com.kadreeTech.certification.hook")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, json:build/reports/serenity/serenity.json")
@ConfigurationParameter(key = SNIPPET_TYPE_PROPERTY_NAME, value = "camelcase")


public class UpdateBookingRunner {
}
