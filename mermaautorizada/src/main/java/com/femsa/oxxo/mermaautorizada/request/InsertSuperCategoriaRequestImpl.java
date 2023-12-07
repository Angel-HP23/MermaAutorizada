package com.femsa.oxxo.mermaautorizada.request;

import lombok.Data;

@Data
public class InsertSuperCategoriaRequestImpl extends InsertSuperCategoriaRequest {

    public InsertSuperCategoriaRequestImpl() {

    }

    public InsertSuperCategoriaRequestImpl (InsertSuperCategoriaRequest insertSuperCategoriaRequest) {

        super.setSuperCategoria(insertSuperCategoriaRequest.getSuperCategoria());
        super.setEmpoderamientoMerma(insertSuperCategoriaRequest.getEmpoderamientoMerma());

    }
}//end class
