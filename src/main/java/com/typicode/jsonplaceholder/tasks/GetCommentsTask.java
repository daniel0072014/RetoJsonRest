package com.typicode.jsonplaceholder.tasks;

import com.typicode.jsonplaceholder.utils.CallData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetCommentsTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(CallData.extractTo().get(0).get("endPoint"))
                        .with( request -> request
                                .header("Accept","*/*")
                                .contentType("application/json")
                                .queryParam(CallData.extractTo().get(0).get("attribute"), CallData.extractTo().get(0).get("parameter"))
                                .log().all())
        );
    }

    public static GetCommentsTask getComments (){
        return instrumented(GetCommentsTask.class);
    }
}
