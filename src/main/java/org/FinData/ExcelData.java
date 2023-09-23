package org.FinData;

// class with structure of ExcelData (Structure of Excel file for parsing)
class ExcelData {
    private final String Denumire;
    private final String CodFiscal;
    private final String ReportDate;
    private final String ActiveImobilizate;
    private final String ActiveCirculante;
    private final String CapitalPropriu;
    private final String DTL;
    private final String DTS;
    private final String Provizioane;

    public ExcelData (String Denumire, String CodFiscal, String ReportDate,
                      String ActiveImobilizate, String ActiveCirculante, String CapitalPropriu,
                      String DTL, String DTS, String Provizioane) {
        this.Denumire = Denumire;
        this.CodFiscal = CodFiscal;
        this.ReportDate = ReportDate;
        this.ActiveImobilizate = ActiveImobilizate;
        this.ActiveCirculante = ActiveCirculante;
        this.CapitalPropriu = CapitalPropriu;
        this.DTL = DTL;
        this.DTS = DTS;
        this.Provizioane = Provizioane;
    }
}
