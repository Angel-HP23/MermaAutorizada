package com.femsa.oxxo.mermaautorizada.repository;

import com.femsa.oxxo.mermaautorizada.model.XxmapLimitesMerma;
import com.femsa.oxxo.mermaautorizada.request.InsertLimiteRequestImpl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface XxmapLimitesMermaRepository extends JpaRepository<XxmapLimitesMerma, Integer> {


    XxmapLimitesMerma save(InsertLimiteRequestImpl insertLimiteRequest);

    Optional<XxmapLimitesMerma> findByRangoIncialAndRangoFinalAndRegistroActivo(Integer rangoInicial, Integer rangoFinal, Integer registroActivo);


}
