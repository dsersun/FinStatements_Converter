package org.FinData;

// class with structure of ExcelData (Structure of Excel file for parsing)
class ExcelData {
    private String Denumire;
    private String CodFiscal;
    private String ReportDate;
    private String ActiveImobilizate;
    private String ActiveCirculante;
    private String CapitalPropriu;
    private String DTL;
    private final String DTS;
    private String Provizioane;

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
