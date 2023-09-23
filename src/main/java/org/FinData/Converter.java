package org.FinData;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Converter {
    Gson gson = new GsonBuilder ().setPrettyPrinting ().create ();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern ("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now ();

    private static String getCellValueAsString (Cell cell) {
        // check for null value
        if (cell == null) {
            return "";
        } else {
            return switch (cell.getCellType ()) {
                case STRING -> cell.getStringCellValue ();
                case NUMERIC -> String.valueOf (cell.getNumericCellValue ());
                default -> "";
            };
        }
    }


    public void converter (String xlsFolder, String ResultFolder) {
        try {
            File excelDir = new File (xlsFolder);
            File[] excelFiles = excelDir.listFiles ((dir, name) -> name.endsWith (".xlsx"));

            assert excelFiles != null;
            for (File excelFile : excelFiles) {
                FileInputStream excelStream = new FileInputStream (excelFile);
                Workbook workbook = new XSSFWorkbook (excelStream);
                List<ExcelData> excelDataList = new ArrayList<> ();
                Sheet sheet = workbook.getSheetAt (0); // The data is assumed to be on the first sheet

                Cell cellB1 = sheet.getRow (0).getCell (1); // B1 in first sheet
                Cell cellB2 = sheet.getRow (1).getCell (1); // B2 ...
                Cell cellB3 = sheet.getRow (2).getCell (1); // B3
                Cell cellB4 = sheet.getRow (3).getCell (1); // B4
                Cell cellB5 = sheet.getRow (4).getCell (1); // B5
                Cell cellB6 = sheet.getRow (5).getCell (1); // B6
                Cell cellB7 = sheet.getRow (6).getCell (1); // B7
                Cell cellB8 = sheet.getRow (7).getCell (1); // B8
                Cell cellB9 = sheet.getRow (8).getCell (1); // B9

                String cell1Value = getCellValueAsString (cellB1);
                String cell2Value = getCellValueAsString (cellB2);
                String cell3Value = getCellValueAsString (cellB3);
                String cell4Value = getCellValueAsString (cellB4);
                String cell5Value = getCellValueAsString (cellB5);
                String cell6Value = getCellValueAsString (cellB6);
                String cell7Value = getCellValueAsString (cellB7);
                String cell8Value = getCellValueAsString (cellB8);
                String cell9Value = getCellValueAsString (cellB9);

                try (Connection conn = DB_Connector.getConnection ()) {
                    Statement stmt = conn != null ? conn.createStatement () : null;

                    //  SQL statement for add data in database.
                    String insertStatement =
                            "INSERT INTO `finstatements`.`finstatements` (`present_time`, `denumire`," +
                                    " `cod_fiscal`, `report_date`, `active_imobilizate`, `active_circulante`, " +
                                    "`capital_propriu`, `DTL`, `DTS`, `provizioane`) " +
                                    "VALUES ('" + dtf.format (now) + "','" + cell1Value + "','" + cell2Value + "','" +
                                    cell3Value + "','" + cell4Value + "','" + cell5Value + "','" + cell6Value +
                                    "','" + cell7Value + "','" + cell8Value + "','" + cell9Value + "')";

                    assert stmt != null;
                    stmt.executeUpdate (insertStatement);

                } catch (SQLException e) {
                    throw new RuntimeException (e);
                }

                // save in json
                excelDataList.add (new ExcelData (cell1Value, cell2Value, cell3Value, cell4Value,
                        cell5Value, cell6Value, cell7Value, cell8Value, cell9Value));
                String jsonFileName = ResultFolder + File.separator + excelFile.getName ().replace (".xlsx", ".json");

                try (Writer writer = new FileWriter (jsonFileName)) {
                    gson.toJson (excelDataList, writer);
                }

                excelStream.close ();
                workbook.close ();
                excelFile.delete (); // processed *.xlsx file will be deleted
            }
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }
}
