package com.femsa.oxxo.mermaautorizada.repository;

import com.femsa.oxxo.mermaautorizada.model.XxmapCategoriaMerma;
import com.femsa.oxxo.mermaautorizada.request.InsertCategoriaRequestImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface XxmapCategoriaMermaRepository extends JpaRepository<XxmapCategoriaMerma, Long> {


}
