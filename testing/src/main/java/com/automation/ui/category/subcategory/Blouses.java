package com.automation.ui.category.subcategory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.automation.ui.category.TopsPage;

public class Blouses extends TopsPage {

    @FindBy(xpath = "//*[@id='subcategories']//child::a[text()='Blouses']")
    private WebElement blousesBtn;

    private void clickBlousesButton() {
        driverTools.clickElement(blousesBtn);
    }

    @Override
    public void goToPage() {
        clickBlousesButton();
    }
}
