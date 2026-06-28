package com.vtiger.sptesDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Map;

public class accountsteps extends basesteps {



    @When("click on new account link and fill mandatory fields")
    public void fill_account_mandatory_fields() {
//
        System.out.println("Seema has to do something");
        hp.clickNewAccount();
        acp.createaccount(dt.get(TCName).get("AccountName"));

    }



    }

