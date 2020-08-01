package mystore.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import mystore.pageobjects.AddProductPage;
import mystore.pageobjects.ApplicationPage;
import mystore.pageobjects.AuthenticationPage;
import mystore.pageobjects.CreateAnAccountPage;
import mystore.pageobjects.HomePage;
import mystore.pageobjects.ProductPage;
import mystore.pageobjects.SearchProductPage;
import mystore.pageobjects.ShoppingCart1SummaryPage;
import mystore.pageobjects.ShoppingCart2SignInPage;
import mystore.pageobjects.ShoppingCart3AddressPage;
import mystore.pageobjects.ShoppingCart4ShippingPage;
import mystore.pageobjects.ShoppingCart5PaymentPage;

public class E2ETest extends BaseTest {

	@Test ( description="Add Product To Cart after sign in")
	public void e01_Sanity() {
		// sign in
		ApplicationPage ap = new HomePage(driver);
		ap.signInBtn();
		AuthenticationPage aut = new AuthenticationPage(driver);
		aut.alreadyRegistered("limatti1@gmail.com", "12345");
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
		ShoppingCart1SummaryPage sc1 = new ShoppingCart1SummaryPage(driver) ;
		sc1.proceedToCheckout();
		ShoppingCart3AddressPage sc3 = new ShoppingCart3AddressPage(driver) ;
		sc3.proceedToCheckout();
		ShoppingCart4ShippingPage sc4 = new ShoppingCart4ShippingPage(driver) ;
		sc4.AgreeCB();
		sc4.proceedToCheckout();
		ShoppingCart5PaymentPage sc5 = new ShoppingCart5PaymentPage(driver) ;
		sc5.payByBankWire();
		sc5.confirmMyOrder();
		//Assert
		String actual= sc5.confirmationMsg();
		String expected=("Your order on My Store is complete.");
		Assert.assertEquals(actual, expected);
//		ap.signOutBtn();
	}

	@Test ( description="Add Product To Cart before sign in with an account")
	public void e02_Sanity() {
		ApplicationPage ap = new HomePage(driver);
		//search product
		ap.searchProduct("casual");
		SearchProductPage spp = new SearchProductPage(driver);
		spp.chooseProduct("Blouse");
		ProductPage pp=new ProductPage(driver);
		pp.addProductToCart();
		AddProductPage adp = new AddProductPage(driver);
		adp.proceedToCheckoutBtn();
		ShoppingCart1SummaryPage sc1 = new ShoppingCart1SummaryPage(driver) ;
		sc1.proceedToCheckout();
		ShoppingCart2SignInPage sc2 = new ShoppingCart2SignInPage(driver) ;
		sc2.alreadyRegistered("limatti20@gmail.com", "12345");
		ShoppingCart3AddressPage sc3 = new ShoppingCart3AddressPage(driver) ;
		sc3.proceedToCheckout();
		ShoppingCart4ShippingPage sc4 = new ShoppingCart4ShippingPage(driver) ;
		sc4.AgreeCB();
		sc4.proceedToCheckout();
		ShoppingCart5PaymentPage sc5 = new ShoppingCart5PaymentPage(driver) ;
		sc5.payByBankCheck();
		sc5.confirmMyOrder();
		//Assert
		String actual= sc5.confirmationMsgByCheck();
		String expected=("Your order on My Store is complete.");
		Assert.assertEquals(actual, expected);
//		ap.signOutBtn();
	}

	@Test ( description="Add Product To Cart before sign in without an account")
	public void e03_Sanity() {
		ApplicationPage ap = new HomePage(driver);
		//search product
		ap.searchProduct("casual");
		SearchProductPage spp = new SearchProductPage(driver);
		spp.chooseProduct("Blouse");
		ProductPage pp= new ProductPage(driver);
		pp.addProductToCart();
		AddProductPage adp = new AddProductPage(driver);
		adp.proceedToCheckoutBtn();
		ShoppingCart1SummaryPage sc1 = new ShoppingCart1SummaryPage(driver) ;
		sc1.proceedToCheckout();
		ShoppingCart2SignInPage sc2 = new ShoppingCart2SignInPage(driver) ;
		sc2.createAnAccount("limatti460@gmail.com");
		ap.signInBtn();
		AuthenticationPage aut = new AuthenticationPage(driver);
		aut.createAnAccount("limatti460@gmail.com");
		CreateAnAccountPage crt = new CreateAnAccountPage(driver);
		crt.fillForm("limor", "ha","limatti460@gmail.com" , "12345", "15", "12", "1980", "limor", "ha", "data+", "emek", "ayalon", "Miami", "Florida", "75365", "United States", "testing", "035050505", "0505050505", "Israel");
		sc1.proceedToCheckout();
		ShoppingCart3AddressPage sc3 = new ShoppingCart3AddressPage(driver) ;
		sc3.proceedToCheckout();
		ShoppingCart4ShippingPage sc4 = new ShoppingCart4ShippingPage(driver) ;
		sc4.AgreeCB();
		sc4.proceedToCheckout();
		ShoppingCart5PaymentPage sc5 = new ShoppingCart5PaymentPage(driver) ;
		sc5.payByBankCheck();
		sc5.confirmMyOrder();
		//Assert
		String actual= sc5.confirmationMsgByCheck();
		String expected=("Your order on My Store is complete.");
		Assert.assertEquals(actual, expected);
//		ap.signOutBtn();
	}

	@Test ( description="Choose product from a list then signin")
	public void e04_Sanity() {
		HomePage hp = new HomePage(driver);
		hp.choosePopularProduct("Blouse");
		ProductPage pp= new ProductPage(driver);
		pp.addProductToCart();
		AddProductPage adp = new AddProductPage(driver);
		adp.proceedToCheckoutBtn();
		ShoppingCart1SummaryPage sc1 = new ShoppingCart1SummaryPage(driver) ;
		sc1.proceedToCheckout();
		ShoppingCart2SignInPage sc2 = new ShoppingCart2SignInPage(driver) ;
		sc2.alreadyRegistered("limatti@gmail.com", "12345");
		ShoppingCart3AddressPage sc3 = new ShoppingCart3AddressPage(driver) ;
		sc3.proceedToCheckout();
		ShoppingCart4ShippingPage sc4 = new ShoppingCart4ShippingPage(driver) ;
		sc4.AgreeCB();
		sc4.proceedToCheckout();
		ShoppingCart5PaymentPage sc5 = new ShoppingCart5PaymentPage(driver) ;
		sc5.payByBankCheck();
		sc5.confirmMyOrder();
		//Assert
		String actual= sc5.confirmationMsgByCheck();
		String expected=("Your order on My Store is complete.");
		Assert.assertEquals(actual, expected);
		ApplicationPage ap = new HomePage(driver);
//		ap.signOutBtn();
	}
}

