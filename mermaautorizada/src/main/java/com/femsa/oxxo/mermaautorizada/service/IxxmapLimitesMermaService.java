package com.femsa.oxxo.mermaautorizada.service;

import com.femsa.oxxo.mermaautorizada.model.XxmapLimitesMerma;
import com.femsa.oxxo.mermaautorizada.request.InsertLimiteRequestImpl;

import java.util.List;

public interface IxxmapLimitesMermaService {


    boolean isValidDeleteLimite(Integer limitesMermaId);

    void eliminarLimiteMerma(Integer limitesMermaId) throws Exception;

    List<XxmapLimitesMerma> findAllXxmapLimitesMerma();

     boolean isValidInsertLimite(InsertLimiteRequestImpl insertLimiteRequest) throws Exception;



    XxmapLimitesMerma insertarLimiteMerma(InsertLimiteRequestImpl insertLimiteRequest) throws Exception;



}
 