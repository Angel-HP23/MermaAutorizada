package com.femsa.oxxo.mermaautorizada.service;

import com.femsa.oxxo.mermaautorizada.model.XxmapSuperCategoria;
import com.femsa.oxxo.mermaautorizada.request.InsertSuperCategoriaRequestImpl;

import java.util.List;

public interface IxxmapSuperCategoriaService {
    List<XxmapSuperCategoria> findAllXxmapSuperCategoria()//end List<XxmapSuperCategoria>
    ;

    XxmapSuperCategoria insertSuperCategoria(InsertSuperCategoriaRequestImpl insertSuperCategoriaRequest) throws Exception//end insertSuperCategoria
    ;

    boolean isValidDeleteSuperCategoria(Long categoriaId);

    void deleteSuperCategoria(Long categoriaId) throws Exception;
}
