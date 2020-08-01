package mystore.tests;

import org.testng.annotations.Test;
import mystore.pageobjects.AddProductPage;
import mystore.pageobjects.ApplicationPage;
import mystore.pageobjects.AuthenticationPage;
import mystore.pageobjects.HomePage;
import mystore.pageobjects.ProductPage;
import mystore.pageobjects.SearchProductPage;

public class AddProductToCartTest extends BaseTest {

	@Test( description="Add Product To Cart after sign in")
	public void e01_AddProductToCart()  {
		// sign in
		ApplicationPage ap = new HomePage(driver);
		ap.signInBtn();
		AuthenticationPage aut = new AuthenticationPage(driver);
		aut.alreadyRegistered("limatti@gmail.com", "12345");
		//search product
		ap.searchProduct("dress");
		SearchProductPage spp = new SearchProductPage(driver);
		spp.chooseProduct("Printed Chiffon Dress");
		//add 1 product to cart
		ProductPage pp=new ProductPage(driver);
		pp.addProductToCart();
		AddProductPage adp =new AddProductPage(driver);
		adp.continueShopping();
		//add 2 product to cart
		pp.selectSize("M");
		pp.chooseColorGreen();
		pp.addProductToCart();
		adp.continueShopping();
		//add 3 product to cart
		ap.searchProduct("casual");
		spp.chooseProduct("Blouse");
		pp.addProductToCart();
		adp.proceedToCheckoutBtn();
	}
}

