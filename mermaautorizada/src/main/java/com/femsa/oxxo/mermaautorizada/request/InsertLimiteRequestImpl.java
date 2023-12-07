package com.femsa.oxxo.mermaautorizada.request;

import com.femsa.oxxo.mermaautorizada.repository.XxmapLimitesMermaRepository;
import lombok.Data;

@Data
public class InsertLimiteRequestImpl extends InsertLimiteRequest  {

    public InsertLimiteRequestImpl() {

    }


    public InsertLimiteRequestImpl(InsertLimiteRequest insertLimiteRequest){


        super.setRangoInicial(insertLimiteRequest.getRangoInicial());
        super.setRangoFinal(insertLimiteRequest.getRangoFinal());
        super.setMermaAutorizada(insertLimiteRequest.getMermaAutorizada());
        super.setCreatedBy(insertLimiteRequest.getCreatedBy());
        super.setCreationDate(insertLimiteRequest.getCreationDate());
        super.setModifiedBy(insertLimiteRequest.getModifiedBy());
        super.setModifiedDate(insertLimiteRequest.getModifiedDate());

    }
}
