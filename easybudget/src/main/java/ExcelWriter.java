/* This class writes to the user's bank account and expense data to an excel file.
    Some parts of this class are from this tutorial: https://www.callicoder.com/java-write-excel-file-apache-poi/
 */

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ExcelWriter {

    private static String[] columns = {"Date", "Name", "Total Assets", "Usable Assets", "Total Expenses",
            "Assets After Payment"};

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        EasyBudget userEB = new EasyBudget();
        // Get the user's data using the EasyBudget methods
        userEB.init(sc);
        userEB.budgetAssets();
        userEB.budgetExpenses();
        userEB.payExpenses();
        System.out.println(userEB.toString());

        //Create an excel workbook
        Workbook workbook = new XSSFWorkbook();
        //Used to create instances independent of format
        CreationHelper creationHelper = workbook.getCreationHelper();
        //Create an excel sheet
        Sheet sheet = workbook.createSheet("Buget");

        //Create font for header cells
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.BLACK.getIndex());

        //Create a CellStyle with font
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        //Create a row
        Row headerRow = sheet.createRow(0);

        //Create cells
        for(int i = 0; i < columns.length; i++){
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        //Create date with format
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();

        //Create other rows and cells with budget data
        int rowNum = 1;
        Row row = sheet.createRow(rowNum);
        //Create cells and populate with user data
        row.createCell(0).setCellValue(dateFormat.format(date));
        row.createCell(1).setCellValue(userEB.getUserName());
        row.createCell(2).setCellValue(userEB.getTotalAssets());
        row.createCell(3).setCellValue(userEB.getUsableAssets());
        row.createCell(4).setCellValue(userEB.getTotalExpenses());
        row.createCell(5).setCellValue(userEB.getAssetsAfterPayment());

        //Resize all columns to fit the content size
        for(int i = 0; i < columns.length; i++){
            sheet.autoSizeColumn(i);
        }

        //Write output to a file, catch any exceptions
        try{
            FileOutputStream fileOut = new FileOutputStream("Budget.xlsx");
            workbook.write(fileOut);
            fileOut.close();
            //Close the workbook
            workbook.close();
        }catch(IOException e){
            e.getStackTrace();
        }
    }
}
