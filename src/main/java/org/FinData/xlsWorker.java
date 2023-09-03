package org.FinData;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class xlsWorker {

    public void converter(String xlsFolder, String ResultFolder ) {
        try {
            // Create a Gson object to serialize to JSON
            Gson gson = new GsonBuilder ().setPrettyPrinting ().create ();

            File excelDir = new File (xlsFolder);
            File[] excelFiles = excelDir.listFiles ((dir, name) -> name.endsWith (".xlsx"));

            if (excelFiles != null) {
                // with a non-empty folder, it processes each file in a loop
                for (File excelFile : excelFiles) {
                    // Create Workbook from Excel File
                    FileInputStream excelStream = new FileInputStream (excelFile);
                    Workbook workbook = new XSSFWorkbook (excelStream);

                    /* Read specific cells from Excel and save them to a list of objects */
                    /* Defining an empty excelDataList array and a Workbook sheet from an Excel file */
                    /* thus erasing the data from the past excelDataList */

                    List<ExcelData> excelDataList = new ArrayList<> ();
                    Sheet sheet = workbook.getSheetAt (0); // The data is assumed to be on the first sheet

                    //   Select cells B1, B2 and up to B9 to read data
                    Cell cellB1 = sheet.getRow (0).getCell (1); // B1
                    Cell cellB2 = sheet.getRow (1).getCell (1); // B2
                    Cell cellB3 = sheet.getRow (2).getCell (1); // B3
                    Cell cellB4 = sheet.getRow (3).getCell (1); // B4
                    Cell cellB5 = sheet.getRow (4).getCell (1); // B5
                    Cell cellB6 = sheet.getRow (5).getCell (1); // B6
                    Cell cellB7 = sheet.getRow (6).getCell (1); // B7
                    Cell cellB8 = sheet.getRow (7).getCell (1); // B8
                    Cell cellB9 = sheet.getRow (8).getCell (1); // B9

                    // Assigning to variables the string value of their Excel cells.
                    // We get the data using our getCellValueAsString(x) function, defined below...

                    String cell1Value = getCellValueAsString (cellB1);
                    String cell2Value = getCellValueAsString (cellB2);
                    String cell3Value = getCellValueAsString (cellB3);
                    String cell4Value = getCellValueAsString (cellB4);
                    String cell5Value = getCellValueAsString (cellB5);
                    String cell6Value = getCellValueAsString (cellB6);
                    String cell7Value = getCellValueAsString (cellB7);
                    String cell8Value = getCellValueAsString (cellB8);
                    String cell9Value = getCellValueAsString (cellB9);

                    // Adding to the collection of collected data
                    excelDataList.add (new ExcelData (cell1Value, cell2Value, cell3Value, cell4Value,
                            cell5Value, cell6Value, cell7Value, cell8Value, cell9Value));

                    // Create a JSON file and write data to it
                    String jsonFileName = ResultFolder + File.separator + excelFile.getName ().replace (".xlsx", ".json");
                    try (Writer writer = new FileWriter (jsonFileName)) {
                        // inserting and writing to JSON data from excelDataList
                        gson.toJson (excelDataList, writer);
                    }

                    // Close Workbook and Stream for Excel File
                    excelStream.close ();
                    workbook.close ();
                }
            } else {
                // if the folder is empty
                System.out.println ("In selected folder don't exist *.xlsx files");

                // stop program? or may be got new correct path?
            }
        } catch (Exception e) {
            // throw exceptions
            e.printStackTrace();
        }
    }

    // Method definitions for getting string values
    private static String getCellValueAsString (Cell cell) {
        // check for null value
        if (cell == null) {
            return "";
        }
        // Getting data depending on the type of data. All data transform in String format
        return switch (cell.getCellType ()) {
            case STRING -> cell.getStringCellValue ();
            case NUMERIC -> String.valueOf (cell.getNumericCellValue ());
            default -> "";
        };
    }
}