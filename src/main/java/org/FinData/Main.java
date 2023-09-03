package org.FinData;

public class Main {

    public static void main (String[] args) {
        // get path to folder with Excel files
        Main path = new Main ();
        String excelFolder = path.GetXlsPath ();

        // Path to folder where JSON files will be saved
        String jsonFolder = "src/Data/json";

        // convert data from .xlsx to JSON.
        xlsWorker worker = new xlsWorker();
        worker.converter (excelFolder, jsonFolder);
        System.out.println ("Fisierele Ecxel au fost procesate");

        // processing Json File
        // JsonWorker JsonObject = new JsonWorker ();
        // JsonObject.jsonProcessor (jsonFolder);
        // System.out.println ("Datele din JSON fisiere au fost salvate in basa de date");

        // Send notification
        // to be developed
    }


    public String GetXlsPath() {
        // aici de a dezvolta functionalul de a introduce in terminal localizarea mapei cu fisiere excel

        // pina cind default path setat fortat
        String xlsPath = "src/Data/xlsx";
        return xlsPath;
    }
}
