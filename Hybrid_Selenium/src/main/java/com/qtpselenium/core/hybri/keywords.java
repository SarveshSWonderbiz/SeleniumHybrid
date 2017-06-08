package com.qtpselenium.core.hybri;

import com.qtpselenium.core.hybri.genericKeywords;
import com.qtpselenium.core.hybrid.util.Constants;
import com.qtpselenium.core.hybrid.util.Xls_Reader;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class keywords {
	
	

	ExtentTest test;
	genericKeywords App;

	public keywords(ExtentTest test) {
		this.test = test;
	}

	public void executeTest (String TestName, Xls_Reader xls){
		
		 App =  new genericKeywords(test);
		int rows = xls.getRowCount(Constants.KEYWORDS_SHEETNAME);
		
		for(int rNum=2;rNum<=rows;rNum++)
		{
			String tcid = xls.getCellData(Constants.KEYWORDS_SHEETNAME, Constants.TCID_COLNAME, rNum);
			if(tcid.equals("GmailTest"))
			{
				String Description = xls.getCellData(Constants.KEYWORDS_SHEETNAME,Constants.Description_COLNAME , rNum);
				String Keyword = xls.getCellData(Constants.KEYWORDS_SHEETNAME, Constants.Keyword_COLNAME, rNum);
				String Object = xls.getCellData(Constants.KEYWORDS_SHEETNAME, Constants.Object_COLNAME, rNum);
				String Data = xls.getCellData(Constants.KEYWORDS_SHEETNAME, Constants.Data_COLNAME, rNum);
//				System.out.println(Description+" "+ Keyword+" "+ Object+" "+ Data );
//				test.log(LogStatus.INFO, Description+" "+ Keyword+" "+ Object+" "+ Data);
				App.reportFailure(Description+" "+ Keyword+" "+ Object+" "+ Data);
				if(Keyword.equals("OpenBrowser"))
					App.openBrowser(Data);
				else if(Keyword.equals("navigate"))
					App.navigate(Object);
				else if(Keyword.equals("click"))
						App.click(Object);
				else if (Keyword.equals("input"))
					App.input(Object, Data);
				else if (Keyword.equals("click"))
					App.click(Object);
			}
		}
		
	}
	
	public genericKeywords getgenericKeywords(){
		return App;
	}

}