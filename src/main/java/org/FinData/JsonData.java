package org.FinData;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class JsonData {
    @JsonProperty("Denumire")
    private String Denumire;
    @JsonProperty("CodFiscal")
    private String CodFiscal;
    @JsonProperty("ReportDate")
    private String ReportDate;
    @JsonProperty("ActiveImobilizate")
    private String ActiveImobilizate;
    @JsonProperty("ActiveCirculante")
    private String ActiveCirculante;
    @JsonProperty("CapitalPropriu")
    private String CapitalPropriu;
    @JsonProperty("DTL")
    private String DTL;
    @JsonProperty("DTS")
    private String DTS;
    @JsonProperty("Provizioane")
    private String Provizioane;
}