package com.automation.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.automation.ui.HomePage;
import com.automation.ui.PageFactory;

import com.automation.ui.category.WomanPage;
import com.automation.ui.order.*;

import static org.testng.Assert.assertTrue;

public class buyProductSteps {
    private HomePage homePage;
    private WomanPage womanPage;
    private Cart cart;
    private AddressPage addressPage;
    private ShoppingSummary shoppingSummary;
    private ShippingPage shippingPage;
    private PaymentPage paymentPage;

    public buyProductSteps(HomePage homePage) {
        this.homePage = homePage;

    }

    @When("^I go to the women's category$")
    public void iGoToTheWomenSCategory() {
        homePage.goToWomenPage();
    }

    @And("^I select the product \"(.*?)\" with the subcategory of \"(.*?)\"$")
    public void iSelectTheProductWithTheSubcategoryOf(String category, String subcategory) {
        womanPage = PageFactory.getCategory(category);
        womanPage.goToPage();
        womanPage = womanPage.goToSubcategoryPage(subcategory);
        womanPage.goToPage();
    }

    @And("^I add one product to the cart$")
    public void iAddTheProductToTheCart() {
        cart = womanPage.selectProduct();
        cart.addItemToCart();
        shoppingSummary = cart.proceedCheckoutShopping();
        addressPage = shoppingSummary.proceedCheckoutAddress();
        shippingPage = addressPage.proceedCheckoutShipping();
        shippingPage.agreeCheckbox();
        shippingPage.proceedCheckoutShipping();
    }

    @And("^I proceed to pay the product with \"(.*?)\"$")
    public void iProceedToPayTheProductWith(String payment) {
        paymentPage = PageFactory.getPayment(payment);
        paymentPage.selectMethodPay();
        paymentPage.clickConfirmButton();

    }

    @Then("^I should buy the product successfully and show the \"(.*?)\"$")
    public void iShouldBuyTheProductSuccessfullyAndShowThe(String message) {
        String actual = paymentPage.getBuyMessage();
        assertTrue(message.equals(actual), "full name the user is showed");
    }
}
