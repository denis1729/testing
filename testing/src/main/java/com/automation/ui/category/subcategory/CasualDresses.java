package com.automation.ui.category.subcategory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.automation.ui.PageFactory;
import com.automation.ui.category.DressesPage;
import com.automation.ui.category.WomanPage;

public class CasualDresses extends DressesPage {
    @FindBy(xpath = "//*[@id='subcategories']//child::a[text()='Casual Dresses']")
    private WebElement dressesBtn;

    private void clickTopsButton() {
        driverTools.clickElement(dressesBtn);
    }

    @Override
    public void goToPage() {
        clickTopsButton();
    }

    @Override
    public WomanPage goToSubcategoryPage(String subcategory) {
        return PageFactory.getDresses(subcategory);
    }
}
