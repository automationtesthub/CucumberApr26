package com.vtiger.sptesDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Map;

public class leadsteps extends basesteps {


    @When("click on new lead link")
    public void click_on_new_lead_link() {
        hp.clickNewLead();

    }
    @When("click on new lead link and fill mandatory fields")
    public void fill_mandatory_fields() {

        hp.clickNewLead();
        ldp.createlead(dt.get(TCName).get("Lastname"),dt.get(TCName).get("Company"));
    }
    @Then("click logout")
    public void click_logout() {

      hp.clickLogout();
    }
    @Then("close the browser")
    public void close_the_browser() {
      driver.quit();
    }

    @When("click on new lead link and fill mandatory {string} and {string} fields")
    public void click_on_new_lead_link_and_fill_mandatory_and_fields(String string, String string2, io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        List<Map<String ,String>> dt = dataTable.asMaps();
        for(int i=0;i<dt.size();i++)
        {

            hp.clickNewLead();
            ldp.createlead(dt.get(i).get("lastname"),dt.get(i).get("company"));

        }


    }
}
