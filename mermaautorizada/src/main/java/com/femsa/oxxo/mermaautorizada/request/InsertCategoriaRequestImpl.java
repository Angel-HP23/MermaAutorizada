package com.femsa.oxxo.mermaautorizada.request;

import com.femsa.oxxo.mermaautorizada.repository.XxmapCategoriaMermaRepository;
import lombok.Data;

@Data
public class InsertCategoriaRequestImpl extends InsertCategoriaRequest {

    public InsertCategoriaRequestImpl(){

    }

    public InsertCategoriaRequestImpl(InsertCategoriaRequest insertCategoriaRequest) {

        //super.setDivision(insertCategoriaRequest.getDivision());
        super.setMermaAutorizada(insertCategoriaRequest.getMermaAutorizada());
        //super.setRegistroActivo(insertCategoriaRequest.getRegistroActivo());
        super.setCreatedBy(insertCategoriaRequest.getCreatedBy());
        super.setCreationDate(insertCategoriaRequest.getCreationDate());
        super.setModifiedBy(insertCategoriaRequest.getModifiedBy());
        super.setModifiedDate(insertCategoriaRequest.getModifiedDate());

    }//end InsertCategoriaRequestImpl
}//end class
