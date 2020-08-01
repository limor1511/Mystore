package mystore.tests;

import org.testng.annotations.Test;
import mystore.pageobjects.ApplicationPage;
import mystore.pageobjects.HomePage;
import mystore.pageobjects.SearchProductPage;

public class SearchProductTest extends BaseTest {

	@Test( description="Search Product")
	public void e01_SearchProduct() {
		ApplicationPage ap = new HomePage(driver);
		ap.searchProduct("dress");
		SearchProductPage spp = new SearchProductPage(driver);
		spp.chooseProduct("Printed Chiffon Dress");
	}
}

