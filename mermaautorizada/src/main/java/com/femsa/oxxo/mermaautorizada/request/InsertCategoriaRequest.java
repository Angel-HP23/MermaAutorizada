package com.femsa.oxxo.mermaautorizada.request;

import lombok.Data;

import java.util.Date;


@Data
public class InsertCategoriaRequest {
    //private Integer division;
    private Integer mermaAutorizada;
   // private Integer registroActivo;
    private String createdBy;
    private String creationDate;
    private String modifiedBy;
    private String modifiedDate;

    public String validateParams(){
        String result = "";

        if (this.mermaAutorizada == null) {
            result += "mermaAutorizada, ";
        }
        if (this.createdBy == null) {
            result += "createdBy, ";
        }
        if (this.creationDate == null) {
            result += "creationDate, ";
        }
        if (this.modifiedBy == null) {
            result += "modifiedBy, ";
        }
        if (this.modifiedDate == null) {
            result += "modifiedDate, ";
        }
        result = (result == "") ? "-1" : result.substring(0, result.length()-2)
                + " son requeridos.";
        return result;
    }//end validateParams

    public String validateData() {
        String result = "";

        if (this.mermaAutorizada < 0) {
            result += "mermaAutorizada, ";
        }
        if (this.createdBy.trim().isEmpty()) {
            result += "createdBy, ";
        }
        if (this.creationDate.trim().isEmpty()) {
            result += "creationDate, ";
        }
        if (this.modifiedBy.trim().isEmpty()) {
            result += "modifiedBy, ";
        }
        if (this.modifiedDate.trim().isEmpty()) {
            result += "modifiedDate";
        }
        result = (result == "") ? "-1" : result.substring(0, result.length()-2)
                + " estan vacios o con valores negativos.";
        return result.trim();
    }//end validateData
}//end class
