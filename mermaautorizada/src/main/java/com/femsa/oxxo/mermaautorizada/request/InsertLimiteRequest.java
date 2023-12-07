package com.femsa.oxxo.mermaautorizada.request;

import lombok.Data;

import java.util.Objects;

@Data
public class InsertLimiteRequest {
//private Integer limiteMermaId;
private Integer rangoInicial;
private Integer rangoFinal;
private Integer mermaAutorizada;
//private Integer registroActivo;
private String createdBy;
private String creationDate;
private String modifiedBy;
private String modifiedDate;

 public String validateParams(){
     String result = "";
     if(rangoInicial == null ) {result+= "rangoInicial, ";}
     if(rangoFinal == null ) {result+= "division, ";}
     if(mermaAutorizada == null ) {result+= "division, ";}
     if(createdBy == null ) {result+= "division, ";}
     if(creationDate == null ) {result+= "division, ";}
     if(modifiedBy == null ) {result+= "division, ";}
     if(modifiedDate == null ) {result+= "division, ";}

     result = (result == "" ) ? "-1": result.substring(0, result.length() -2)+ " son requeridos." ;
     return result;
 }

    public String validateData(){
        String result = "";
        if(rangoInicial < 0 ) {result+= "rangoInicial, ";}
        if(rangoFinal < 0  ) {result+= "rangoFinal, ";}
        if(mermaAutorizada < 0 ) {result+= "mermaAutorizada, ";}
        if(createdBy.trim().isEmpty() ) {result+= "createdBy, ";}
        if(creationDate.trim().isEmpty() ) {result+= "creationDate, ";}
        if(modifiedBy.trim().isEmpty() ) {result+= "modifiedBy, ";}
        if(modifiedDate.trim().isEmpty() ) {result+= "modifiedDate, ";}

        result = (result == "" ) ? "-1": result.substring(0, result.length() -2)+ " estan vacios o con valores negativos." ;
        return result.trim();
    }



}
