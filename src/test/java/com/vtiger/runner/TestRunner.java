package com.vtiger.runner;


import io.cucumber.java.es.Cuando;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features/",
        glue = "com.vtiger.sptesDefinitions",
        plugin = {
                "pretty",
                "html:target/cucumber-report.html","json:target/cucumber.json"
        },
        dryRun = false,
       // monochrome = true,
        tags = "@acc"


)
public class TestRunner {
}
