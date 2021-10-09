package com.automation.steps;

import com.automation.config.UsersConfigReader;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import com.automation.entities.User;
import org.apache.log4j.Logger;
import com.automation.ui.LoginPage;
import com.automation.ui.PageTransporter;
import com.automation.ui.ProfilePage;
import com.automation.ui.HomePage;

import java.net.MalformedURLException;

import static org.testng.Assert.assertTrue;

public class loginSteps {
    private PageTransporter pageTransporter;
    private Logger log = Logger.getLogger(getClass());

    //Pages
    private LoginPage loginPage;
    private HomePage homePage;
    private ProfilePage profilePage;

    // Entities
    private User user;

    public loginSteps(User user) {
        this.pageTransporter = new PageTransporter();
        this.user = user;
    }

    //****************************************************************
    //Login Step Definitions
    //****************************************************************
    @Given("^I navigate to Login page$")
    public void iNavigateToLoginPage() throws MalformedURLException {
        //Use this step for login feature scenarios
        homePage = pageTransporter.navigateToHomePage();
        loginPage = homePage.goToLoginPage();
    }

    @When("^I login as \"(.*?)\" with password \"(.*?)\"$")
    public void iLoginAsWithPassword(String email, String password) {
        //Use this step for login feature scenarios
        profilePage = loginPage.login(email, password);
    }

    @And("^I go to Home page$")
    public void iGoToHomePage() {
        homePage = profilePage.goHomePage();
    }

    @Then("^I should login successfully with a \"(.*?)\"$")
    public void iShouldLoginSuccessfullyWithA(String fullName) {
        String actual = profilePage.getUserName(fullName).toLowerCase();
        assertTrue(fullName.toLowerCase().equals(actual), "full name the user is showed");

    }

    @Given("^I (?:am logged in|login) as \"(.*?)\" User$")
    public void loginAsUser(final String userAlias) {
        user = UsersConfigReader.getInstance().getUserByAlias(userAlias);
        iLoginAsWithPassword(user.getUserEmail(), user.getPassword());
    }
}

