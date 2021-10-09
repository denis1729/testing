package com.automation.ui;

import com.automation.ui.category.DressesPage;
import com.automation.ui.category.TopsPage;
import com.automation.ui.category.WomanPage;
import com.automation.ui.category.subcategory.CasualDresses;
import com.automation.ui.category.subcategory.EveningDresses;
import com.automation.ui.category.subcategory.SummerDresses;
import com.automation.ui.category.subcategory.TShirts;
import com.automation.ui.category.subcategory.Blouses;
import com.automation.ui.order.PayBankCheck;
import com.automation.ui.order.PayCheck;
import com.automation.ui.order.PaymentPage;

public class PageFactory {

    //****************************************************************
    // Pages
    //****************************************************************

    public static WomanPage getCategory(final String category) {
        switch (category) {
            case "dresses":
                return new DressesPage();

            default:
                return new TopsPage();
        }
    }

    public static TopsPage getTops(final String subCategory) {
        switch (subCategory) {
            case "t-shirts":
                return new TShirts();
            default:
                return new Blouses();
        }
    }

    public static DressesPage getDresses(final String subCategory) {
        switch (subCategory) {
            case "casual dresses":
                return new CasualDresses();
            case "evening dresses":
                return new EveningDresses();
            default:
                return new SummerDresses();
        }
    }

    public static PaymentPage getPayment(String payment) {
        switch (payment) {
            case "bank wire":
                return new PayBankCheck();
            default:
                return new PayCheck();
        }
    }
}
