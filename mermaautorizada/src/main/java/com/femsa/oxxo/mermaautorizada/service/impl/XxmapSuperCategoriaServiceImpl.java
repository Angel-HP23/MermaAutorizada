package com.femsa.oxxo.mermaautorizada.service.impl;

import com.femsa.oxxo.mermaautorizada.model.XxmapSuperCategoria;
import com.femsa.oxxo.mermaautorizada.repository.XxmapSuperCategoriaRepository;
import com.femsa.oxxo.mermaautorizada.request.InsertSuperCategoriaRequestImpl;
import com.femsa.oxxo.mermaautorizada.service.IxxmapSuperCategoriaService;
import org.apache.http.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XxmapSuperCategoriaServiceImpl implements IxxmapSuperCategoriaService {
    private final XxmapSuperCategoriaRepository xxmapSuperCategoriaRepository;
    public XxmapSuperCategoriaServiceImpl(XxmapSuperCategoriaRepository xxmapSuperCategoriaRepository) {
        this.xxmapSuperCategoriaRepository = xxmapSuperCategoriaRepository;
    }

    private static final Logger logger = LoggerFactory.getLogger(XxmapSuperCategoriaServiceImpl.class);

    @Override
    public List<XxmapSuperCategoria> findAllXxmapSuperCategoria() {
        try {
            return xxmapSuperCategoriaRepository.findAll();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }//end List<XxmapSuperCategoria>


    @Override
    public XxmapSuperCategoria insertSuperCategoria(InsertSuperCategoriaRequestImpl insertSuperCategoriaRequest) throws Exception {
        try {
            XxmapSuperCategoria nuevaSuperCategoria = new XxmapSuperCategoria();

            nuevaSuperCategoria.setSuperCategoria(insertSuperCategoriaRequest.getSuperCategoria());
            nuevaSuperCategoria.setEmpoderamientoMerma(insertSuperCategoriaRequest.getEmpoderamientoMerma());

            logger.info("Datos recibidos correctamente: " + nuevaSuperCategoria);

            return xxmapSuperCategoriaRepository.save(nuevaSuperCategoria);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Error de integridad al insertar categoria: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new Exception("Error al insertar categoria: " + e.getMessage(), e);
        }
    }//end insertSuperCategoria

}//end class
