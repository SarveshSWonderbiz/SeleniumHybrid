package com.qtpselenium.core.hybrid.testecases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.qtpselenium.core.hybri.keywords;
import com.qtpselenium.core.hybrid.util.Constants;
import com.qtpselenium.core.hybrid.util.ExtentManager;
import com.qtpselenium.core.hybrid.util.Xls_Reader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Gmail_Test {
	keywords App;
	ExtentReports rep = ExtentManager.getInstance();
	
	String testName = "GmailTest";
	ExtentTest test ;
	@Test
	public void doLogin()
	{
		test =  rep.startTest(testName);
		test.log(LogStatus.INFO, "Started Gmail Login Test");
		Xls_Reader xls = new Xls_Reader(Constants.SUIATEA_XLS);
		
		keywords app = new keywords(test);
		test.log(LogStatus.INFO, "Executing Keywords");
		
		app.executeTest(testName,xls);
		App.getgenericKeywords().reportFailure("Failure Message");
		
		
	}
	
	@AfterTest
	public void quit()
	{
		rep.endTest(test);
		rep.flush();
	}

}
