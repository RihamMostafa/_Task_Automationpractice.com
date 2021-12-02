package utils;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static String path;
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;

	public static void setExcelFile(String Path, String SheetName) throws Exception{

		try {
			//Open the Excel file
			path= Path;
			FileInputStream ExcelFile= new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet= ExcelWBook.getSheet(SheetName);

		} catch (Exception e) {
			// TODO: handle exception
			throw(e);
		}
	}

	public static String getCellData(int RowNum, int ColNum) throws Exception{
		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			if (Cell== null) return "";

			String CellData= Cell.getStringCellValue();
			return CellData;

		} catch (Exception e) {
			// TODO: handle exception
			throw(e);
		}
	}

	public static int getNumberOfRows() {

		return ExcelWSheet.getPhysicalNumberOfRows();
	}

	public static int getNumberOfColumns() {

		return ExcelWSheet.getRow(0).getPhysicalNumberOfCells();
	}

}
