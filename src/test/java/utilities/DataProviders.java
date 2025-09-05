package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders 
{
	@DataProvider(name = "LoginData")
	public String [][] getData() throws IOException
	{
		String path=".//testData//openCart_LoginData.xlsx";
		
		ExcelUtilityNew xutils=new ExcelUtilityNew(path);
		
		//ExcelUtility xutils =new ExcelUtility(path);
		
		int totalRow=xutils.getRowCount("Sheet1");
		int totalCell=xutils.getCellCount("Sheet1", 1);
		
		String logindata[][] = new String [totalRow][totalCell];
		
		for(int i=1; i<=totalRow; i++)
		{
			for(int j=0;j<totalCell; j++)
			{
				 logindata[i-1][j]=xutils.getCellData("Sheet1", i, j);
			}
		}
		return logindata;
		
		
	}

	
}
