package Pages;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.Iterator;

public class Xls_Reader {
    public static XSSFWorkbook wb;
    public static String brandName;
    public static XSSFSheet sheet;
    public static int currRow;
    DifferencesPage dp = new DifferencesPage();


    public void loadExcel(String brand) throws IOException {
//Works based on creating a different sheet per brand in workbook
//        wb = new XSSFWorkbook(System.getProperty("user.dir") + "\\data\\Brand_urls.xlsx");

        //Works based on creating a different Workbook per brand
        wb = new XSSFWorkbook(System.getProperty("user.dir") + "\\data\\" + brand + ".xlsx");

    }

    public int  loadurls(String env) throws IOException, InterruptedException {
        int rowCount = sheet.getLastRowNum();

        System.out.println("total number of rows is --" + rowCount);
        if (env.contains("dev")) {
            for (int i = 1; i <= rowCount; i++) {
                System.out.println("Value of the cell is ******" + sheet.getRow(i).getCell(0).getStringCellValue());
                dp.loadUrl(sheet.getRow(i).getCell(0).getStringCellValue());
                currRow=i;
            }
        } else if (env.contains("prod")) {
            for (int i = 1; i <= rowCount; i++) {
                dp.loadUrl(sheet.getRow(i).getCell(1).getStringCellValue());
               currRow=i;
            }
//            wb.close();
        }
        System.out.println( "current row is *****"+currRow);
        wb.close();
        return  currRow;
    }

    public  void writeResult(String result) throws IOException {
        readBrandExcel(brandName);

        sheet.getRow(currRow).getCell(2).setCellValue(result);
        wb.close();
    }

    //    Loads the specific sheet based on the argument
    public void readBrandExcel(String arg0) throws IOException {

        loadExcel(arg0);
//        sheet = wb.getSheet(arg0);
        sheet = wb.getSheetAt(0);
        brandName = arg0.toLowerCase();
        System.out.println("*************************************************************************" + "\n");
        System.out.println("\n" + "The brand is *****************" + brandName + "\n");

    }


}