package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By header =By.cssSelector("div#logo a");
	private By accountsSections = By.cssSelector("div#content h2");
	private By SearchFiled = By.name("Search");
	private By SearchButton = By.cssSelector("div#search button");
	private By LogoutLLink = By.linkText("Logout");
	
	public AccountsPage(WebDriver driver)
	{
		this.driver=driver;
		eleUtil = new ElementUtil(driver);
	}
	
	public String getAccountPageTitle()
	{
	return eleUtil.doGetTitle(Constants.ACCOUNT_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
}
	
	public String getAccountsPageHeader()
	{
		return eleUtil.doGetText(header);
	}
	
	public boolean isLogoutLinkExists()
	{
		return eleUtil.doIsDisplayed(LogoutLLink);
	}
	
	public void LogOut()
	{
		if(isLogoutLinkExists())
		{
			eleUtil.doClick(LogoutLLink);
		}
	}
	
	public List<String> getAccountSecList()
	{
	
		List<WebElement> accList = eleUtil.WaitForeElementsToBePresent(accountsSections, 10);
		
		List<String> accSecValList = new ArrayList<String>();
		for(WebElement e: accList)
		{
			String text = e.getText();
			accSecValList.add(text);
		}
		return accSecValList;
	}
	
	public boolean isSearchExist()
	{
		return eleUtil.doIsDisplayed(SearchFiled);
	}
	
	public SearchResultPage doSearch(String ProductName)
	{
		System.out.println("Searching the product:" +ProductName);
		eleUtil.doSendKeys(SearchFiled, ProductName);
		eleUtil.doClick(SearchButton);
		return new SearchResultPage(driver);
	}
	

}
