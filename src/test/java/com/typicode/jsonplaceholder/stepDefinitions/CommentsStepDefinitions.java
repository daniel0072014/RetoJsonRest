package com.typicode.jsonplaceholder.stepDefinitions;

import com.typicode.jsonplaceholder.tasks.GetCommentsTask;
import com.typicode.jsonplaceholder.utils.CallData;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.*;

public class CommentsStepDefinitions {

    public String restBaseUrl;
    public EnvironmentVariables environmentVariables;
    public Actor admin;

    @Before
    public void setUpBaseUrl(){
        restBaseUrl = environmentVariables.optionalProperty("restapi.baseurl").orElse(CallData.extractTo().get(0).get("baseUrl"));
        admin=Actor.named("admin").whoCan(
                CallAnApi.at(restBaseUrl)
        );
    }

    @When("the administrator consumes the GET endpoint for comments with query parameter")
    public void theAdministratorConsumesTheGETEndpointForComments() {
        admin.attemptsTo(GetCommentsTask.getComments());
    }

    @Then("the comments should appear successfully")
    public void theCommentsShouldAppearSuccessfully() {
        admin.should(
                seeThatResponse(
                        "The first post's email is " + CallData.extractTo().get(0).get("answer"),
                        res -> res.body("email", hasItem(CallData.extractTo().get(0).get("answer")))
                )
       );
    }
}