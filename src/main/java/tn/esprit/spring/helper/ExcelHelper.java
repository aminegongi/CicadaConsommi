package tn.esprit.spring.helper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
/*import org.apache.poi.xssf.usermodel.XSSFWorkbook;*/

import tn.esprit.spring.entity.Stock;


public class ExcelHelper {
 /* public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
  static String[] HEADERs = { "Id", "Amount", "Stock In", "Stock Out" ,"ProduitId" };
  static String SHEET = "Stocks";

  public static ByteArrayInputStream tutorialsToExcel(List<Stock> stocks) {

    try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
      Sheet sheet = workbook.createSheet(SHEET);

      // Header
      Row headerRow = sheet.createRow(0);

      for (int col = 0; col < HEADERs.length; col++) {
        Cell cell = headerRow.createCell(col);
        cell.setCellValue(HEADERs[col]);
      }

      int rowIdx = 1;
      for (Stock stock : stocks) {
        Row row = sheet.createRow(rowIdx++);

        row.createCell(0).setCellValue(stock.getId());
        row.createCell(1).setCellValue(stock.getAmount());
        row.createCell(2).setCellValue(stock.getQtee());
        row.createCell(3).setCellValue(stock.getQtes());
        row.createCell(4).setCellValue(stock.getP().getId_produit());
        
      }

      workbook.write(out);
      return new ByteArrayInputStream(out.toByteArray());
    } catch (IOException e) {
      throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
    }
  }*/
}
