package com.typicode.jsonplaceholder.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        tags = "@GetComments",
        glue = "com.typicode.jsonplaceholder.stepDefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class CommentsRunner {



}
