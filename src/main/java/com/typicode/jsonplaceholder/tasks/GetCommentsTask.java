package com.typicode.jsonplaceholder.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static com.typicode.jsonplaceholder.constants.Constants.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetCommentsTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(endPoint)
                        .with( request -> request
                                .queryParam(attribute, parameter))
        );
    }

    public static GetCommentsTask getComments (){
        return instrumented(GetCommentsTask.class);
    }
}
