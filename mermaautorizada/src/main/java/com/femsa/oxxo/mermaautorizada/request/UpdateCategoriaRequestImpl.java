package com.femsa.oxxo.mermaautorizada.request;

public class UpdateCategoriaRequestImpl extends UpdateCategoriaRequest {

    public UpdateCategoriaRequestImpl() {

    }

    public UpdateCategoriaRequestImpl (UpdateCategoriaRequest updateCategoriaRequest) {

        super.setDivision(updateCategoriaRequest.getDivision());
        super.setMermaAutorizada(updateCategoriaRequest.getMermaAutorizada());
        super.setRegistroActivo(updateCategoriaRequest.getRegistroActivo());
        super.setCreatedBy(updateCategoriaRequest.getCreatedBy());
        super.setCreationDate(updateCategoriaRequest.getCreationDate());
        super.setModifiedBy(updateCategoriaRequest.getModifiedBy());
        super.setModifiedDate(updateCategoriaRequest.getModifiedDate());
    }//end UpdateCategoriaRequestImpl

}//end class
