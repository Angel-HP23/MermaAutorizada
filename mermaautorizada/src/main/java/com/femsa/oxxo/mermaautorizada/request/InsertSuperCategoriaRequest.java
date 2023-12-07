package com.femsa.oxxo.mermaautorizada.request;

import lombok.Data;

@Data
public class InsertSuperCategoriaRequest {

    private String superCategoria;

    private String empoderamientoMerma;

    public String validateParams(){

        String result = "";

        if (this.superCategoria == null) {
            result += "superCategoria";
        }
        if (this.empoderamientoMerma == null) {
            result += "empoderamientoMerma";
        }
        return result;
    }

    public String validateData() {
        String result = "";

        if (this.superCategoria.trim().isEmpty()) {
            result += "superCategoria, ";
        }
        if (this.empoderamientoMerma.trim().isEmpty()) {
            result += "empoderamientoMerma, ";
        }

        return result;
    }
}//end class
