package amazon_ui.testClasses;


import amazon_ui.data.searchData;
import framework.init.WebDriverInit;
import org.testng.Assert;
import org.testng.annotations.Test;

import static framework.utils.ExtentInit.createTest;
import static framework.utils.TestLogger.*;


public class SearchTest extends WebDriverInit {

    @Test(dataProvider = "productSearch"  , dataProviderClass = searchData.class)
    public void searchTest(String product){
        logger =  createTest("Searching Product : " + product);
        infoLog("Searching for :" + product);
        dashboardPO.searchProduct(product);
        Assert.assertTrue(dashboardPO.isProductsDisplayed());
        dashboardPO.totalResultsFetched();
    }

}
