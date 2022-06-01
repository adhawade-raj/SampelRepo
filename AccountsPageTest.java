package com.qa.opecart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.utils.Constants;

public class AccountsPageTest extends BaseTest {

	SoftAssert softAssert;
	@BeforeTest
	public void accPageSetup()
	{
	accountPage =loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 2)
	public void accPageTitleTest()
	{
	String actTitle	= accountPage.getAccountPageTitle();
	System.out.println(actTitle);
	
	Assert.assertEquals(actTitle, Constants.ACCOUNT_PAGE_TITLE);
	}
	
	@Test(priority = 1)
	public void accPageHeaderTest()
	{
		String Header = accountPage.getAccountsPageHeader();
		System.out.println(Header);
		
		Assert.assertEquals(Header, Constants.ACCOUNT_PAGE_HEADER);
	}
	
//	Passed
	@Test(priority = 3)
	public void isLogoutExistsTest()
	{
		Assert.assertTrue(accountPage.isLogoutLinkExists());
	}
	
	@Test(priority = 4)
	public void accPageSecTest()
	{
		List<String> accSecList = accountPage.getAccountSecList();
		Assert.assertEquals(accSecList, Constants.getExpectedAccSecList());
	}
	
	@DataProvider
	public Object[][] productData()
	{
	return new Object[][]
	{
		{"MacBook pro"},
		{"MacBook pro"},
		{"MacBook pro"},
	};
	}
	/**
	 * Pending to complete... solve the error
	 * @param productName
	 */
//	@Test(priority =5, dataProvider ="productData")
//	public void SearchTest(String productName)
//	{
//		searchResultsPage = accountPage.doSearch(productName);
//		Assert.assertTrue(searchResultsPage.getProductsListCount()>0);
//	}
	
	@Test(priority = 6)
	public void loginTest()
	{
		accountPage = loginpage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Assert.assertEquals(accountPage.getAccountPageTitle(), Constants.ACCOUNT_PAGE_TITLE);
	}
	
	
	@DataProvider
	public Object[][] ProductSelectData()
	{
		return new Object [][] {
			{"MacBook","MackBook Pro"},
			{"iMac" , "iMac"},
			{"SamSung","Apple cinema 30\""},
			
	};
//
//@Test(Priority =6, dataProvider = "ProductSelectData")
//
//public void selectProductTest(String ProductName, String MainProductName)
//{
//	searchResultsPage = accountPage.doSearch(ProductName);	
//	productInfoPage = searchResultsPage.selectProduct(String MainProductName);
//	Assert.assertTrue(productInfoPage.getProductHeader());
//	
//}

}
}


























