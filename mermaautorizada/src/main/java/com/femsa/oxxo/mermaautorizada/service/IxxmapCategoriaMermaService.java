package com.femsa.oxxo.mermaautorizada.service;

import com.femsa.oxxo.mermaautorizada.model.XxmapCategoriaMerma;
import com.femsa.oxxo.mermaautorizada.request.InsertCategoriaRequestImpl;

import java.util.List;

public interface IxxmapCategoriaMermaService {


    List<XxmapCategoriaMerma> findAllXxmapCategoriaMerma()//end findAllXxmapCategoriaMerma
    ;


    XxmapCategoriaMerma insertCategoriaMerma(InsertCategoriaRequestImpl insertCategoriaRequest) throws Exception//end insertCategoraMerma
    ;

    boolean isValidDeleteCategoria(Long divisionId);

    void deleteCategoriaMerma(Long divisionId) throws Exception//end deleteCategoriaMerma
    ;
}//end IxxmapCategoriaMermaService
