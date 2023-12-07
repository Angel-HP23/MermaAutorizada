package com.femsa.oxxo.mermaautorizada.service.impl;

import com.femsa.oxxo.mermaautorizada.model.XxmapCategoriaMerma;
import com.femsa.oxxo.mermaautorizada.repository.XxmapCategoriaMermaRepository;
import com.femsa.oxxo.mermaautorizada.request.InsertCategoriaRequestImpl;
import com.femsa.oxxo.mermaautorizada.request.UpdateCategoriaRequestImpl;
import com.femsa.oxxo.mermaautorizada.service.IxxmapCategoriaMermaService;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class XxmapCategoriaMermaServiceImpl implements IxxmapCategoriaMermaService {
    private final XxmapCategoriaMermaRepository xxmapCategoriaMermaRepository;

    private static final Logger logger = LoggerFactory.getLogger(XxmapCategoriaMermaServiceImpl.class);

    public XxmapCategoriaMermaServiceImpl(XxmapCategoriaMermaRepository xxmapCategoriaMermaRepository) {
        this.xxmapCategoriaMermaRepository = xxmapCategoriaMermaRepository;
    }

    /**
    public void eliminarCategoriaMerma(Long divisionId) throws Exception {

        try {
            xxmapCategoriaMermaRepository.findById(divisionId)
                    .ifPresent(categoriaMerma-> {
                        categoriaMerma.setRegistroActivo(0);
                        xxmapCategoriaMermaRepository.save(categoriaMerma);
                    });
        } catch (Exception e){
            throw new Exception("Error al elminar categoria de merma");
        }
    }//end eliminarCategoriaMerma
    **/

    @Override
    public List<XxmapCategoriaMerma> findAllXxmapCategoriaMerma() {
        List<XxmapCategoriaMerma> categoriaMermaActivas = xxmapCategoriaMermaRepository.findAll();

        List<XxmapCategoriaMerma> listCategoriaMerma = categoriaMermaActivas.stream()
                .filter(categoriasMerma -> categoriasMerma.getRegistroActivo() == 1)
                .collect(Collectors.toList());

        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

        listCategoriaMerma.forEach(categoriasMerma ->{
            String creationDateFormato = formatoFecha.format(categoriasMerma.getCreationDate());
            String modifiedDateFormato = formatoFecha.format(categoriasMerma.getModifiedDate());

            try {
                categoriasMerma.setCreationDate(formatoFecha.parse(creationDateFormato));
                categoriasMerma.setModifiedDate(formatoFecha.parse(modifiedDateFormato));

            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        });

        return listCategoriaMerma;
    }//end findAllXxmapCategoriaMerma

    @Override
    public XxmapCategoriaMerma insertCategoriaMerma(InsertCategoriaRequestImpl insertCategoriaRequest) throws Exception {
       try {

           Date fechaActual = new Date();
           SimpleDateFormat formatoFecha =new SimpleDateFormat("yyyy-MM-dd");
           String fechaFormateada = formatoFecha.format(fechaActual);
           Date fechaConvertida = formatoFecha.parse(fechaFormateada);

           XxmapCategoriaMerma nuevaCategoriaMerma = new XxmapCategoriaMerma();

           nuevaCategoriaMerma.setMermaAutorizada(insertCategoriaRequest.getMermaAutorizada());
           nuevaCategoriaMerma.setRegistroActivo(1);
           nuevaCategoriaMerma.setCreatedBy(insertCategoriaRequest.getCreatedBy());
           nuevaCategoriaMerma.setCreationDate(fechaConvertida);
           nuevaCategoriaMerma.setModifiedBy(insertCategoriaRequest.getModifiedBy());
           nuevaCategoriaMerma.setModifiedDate(fechaConvertida);

           logger.info("Datos recibidos correctamente: " + nuevaCategoriaMerma);

           return xxmapCategoriaMermaRepository.save(nuevaCategoriaMerma);

       } catch (DataIntegrityViolationException e) {
           throw new DataIntegrityViolationException("Error de integridad al insertar categoria: " + e.getMessage(), e);
       } catch (Exception e) {
           throw new Exception("Error al insertar categoria: " + e.getMessage(), e);
       }
    }//end insertCategoraMerma

    @Override
    public boolean isValidDeleteCategoria(Long divisionId) {
        return xxmapCategoriaMermaRepository.existsById(divisionId);
    }//end isValidDeleteCategoria

    @Override
    public void deleteCategoriaMerma(Long divisionId) throws Exception {
        try {
            xxmapCategoriaMermaRepository.findById(divisionId)
                    .ifPresent(categoriaMerma -> {
                        categoriaMerma.setRegistroActivo(0);
                        xxmapCategoriaMermaRepository.save(categoriaMerma);
                    });
        } catch (Exception e) {
            throw new Exception("Error al eliminar categoria merma");
        }
    }//end deleteCategoriaMerma


    public XxmapCategoriaMerma updateCategoriaMerma(UpdateCategoriaRequestImpl updateCategoriaRequest, Long divisionId) throws Exception {
        try {
            Optional<XxmapCategoriaMerma> categoriaMermaOptional = xxmapCategoriaMermaRepository.findById(divisionId);

            if (categoriaMermaOptional.isPresent()) {
                XxmapCategoriaMerma actualizaCategoriaMerma = categoriaMermaOptional.get();

                Date fechaActual = new Date();
                SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
                String fechaFormateada = formatoFecha.format(fechaActual);
                Date fechaConvertida = formatoFecha.parse(fechaFormateada);

                actualizaCategoriaMerma.setMermaAutorizada(updateCategoriaRequest.getMermaAutorizada());
                actualizaCategoriaMerma.setModifiedBy(updateCategoriaRequest.getModifiedBy());
                actualizaCategoriaMerma.setModifiedDate(fechaConvertida);

                logger.info("Datos actualizados correctamente: " + actualizaCategoriaMerma);

                return xxmapCategoriaMermaRepository.save(actualizaCategoriaMerma);
            } else {
                throw new Exception("La categoría de merma con ID " + divisionId + " no se encontró");
            }
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Error de integridad al actualizar la categoría: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new Exception("Error al actualizar la categoría: " + e.getMessage(), e);
        }
    }//end updateCategoriaMerma



}//end class
