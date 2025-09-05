package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilityNew 
{
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook wb;
	public XSSFSheet ws;
	public XSSFRow row;
	public XSSFCell cell;
	String path;
	
	public ExcelUtilityNew(String path)
	{
		this.path=path;
	}
	
	public int getRowCount(String xlSheet) throws IOException
	{
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlSheet);
		int row=ws.getLastRowNum();
		wb.close();
		fi.close();
		return row;
	}

	public int getCellCount(String xlSheet, int rowNum) throws IOException
	{
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlSheet);
		row= ws.getRow(rowNum);
		int cellCount=row.getLastCellNum();
		wb.close();
		fi.close();
		return cellCount;
	}
	
	
	public String getCellData(String xlSheet, int rowNum, int cellNum) throws IOException
	{
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlSheet);
		row=ws.getRow(rowNum);
		cell=row.getCell(cellNum);
		
		
		String data;
		
		try {
			//data=cell.toString();
			data = cell.toString();
		}
		   
		catch(Exception e)
		{
			data="";
		}
	
		wb.close();
		fi.close();
		return data;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
