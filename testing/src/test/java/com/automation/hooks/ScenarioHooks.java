package com.automation.hooks;

import com.automation.config.AutomationSFDC;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import com.automation.entities.User;
import org.apache.log4j.Logger;
import com.automation.ui.HomePage;


public class ScenarioHooks {
    private Logger log = Logger.getLogger(getClass());
    private HomePage homePage;
    private User user;

    public ScenarioHooks(User user) {
        this.user = user;
    }

    @Before(order = 101)
    public void initializeConfiguration() {
        log.info("Initializing configuration before all hooks...");
        AutomationSFDC.getInstance().startUp();
    }

    //****************************************************************
    //Hooks for @Login scenarios
    //****************************************************************
    @After(value = "@Logout")
    public void logoutSession() {
        log.info("After hook @Login");
        //homePage = new HomePage().logout();
        AutomationSFDC.getInstance().shutDown();

    }
}