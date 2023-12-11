package com.femsa.oxxo.mermaautorizada.service.impl;

import com.femsa.oxxo.mermaautorizada.controllers.XxmapLimitesMermaController;
import com.femsa.oxxo.mermaautorizada.model.XxmapLimitesMerma;
import com.femsa.oxxo.mermaautorizada.repository.XxmapLimitesMermaRepository;
import com.femsa.oxxo.mermaautorizada.request.InsertLimiteRequestImpl;
import com.femsa.oxxo.mermaautorizada.service.IxxmapLimitesMermaService;
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
public class XxmapLimitesMermaServiceImpl implements IxxmapLimitesMermaService {

    private static final Logger logger = LoggerFactory.getLogger(XxmapLimitesMermaController.class);
    private final XxmapLimitesMermaRepository xxmapLimitesMermaRepository;

    public XxmapLimitesMermaServiceImpl(XxmapLimitesMermaRepository xxmapLimitesMermaRepository) {
        this.xxmapLimitesMermaRepository = xxmapLimitesMermaRepository;
    }


    @Override
    public boolean isValidDeleteLimite(Integer limitesMermaId) {

        return xxmapLimitesMermaRepository.existsById(limitesMermaId);
    }
    @Override
    public void eliminarLimiteMerma(Integer limitesMermaId) throws Exception{


        try {
            xxmapLimitesMermaRepository.findById(limitesMermaId)
                    .ifPresent(limiteMerma -> {
                        limiteMerma.setRegistroActivo(0);
                        xxmapLimitesMermaRepository.save(limiteMerma);
                    });
      }catch (Exception e){
          throw new Exception("Error al intentar eliminar límite de merma");
      }
    }

    @Override
    public List<XxmapLimitesMerma> findAllXxmapLimitesMerma() {
        List<XxmapLimitesMerma> limitesMermaActivos = xxmapLimitesMermaRepository.findAll();


        List<XxmapLimitesMerma> listLimiteMerma = limitesMermaActivos.stream()
                .filter(limitesMerma -> limitesMerma.getRegistroActivo() == 1)
                .collect(Collectors.toList());

        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

        listLimiteMerma.forEach(limitesMerma -> {

            String creationDateFormato = formatoFecha.format(limitesMerma.getCreationDate());
            String modifiedDateFormato = formatoFecha.format(limitesMerma.getModifiedDate());

            try {

                limitesMerma.setCreationDate(formatoFecha.parse(creationDateFormato));
                limitesMerma.setModifiedDate(formatoFecha.parse(modifiedDateFormato));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        });

        return listLimiteMerma;

    }



    @Override
    public boolean isValidInsertLimite(InsertLimiteRequestImpl insertLimiteRequest) throws Exception {
        boolean result = true;
        XxmapLimitesMerma nuevoLimiteMerma = new XxmapLimitesMerma();
        Optional<XxmapLimitesMerma> tmp = xxmapLimitesMermaRepository.findByRangoInicialAndRangoFinalAndRegistroActivo(insertLimiteRequest.getRangoInicial(), insertLimiteRequest.getRangoFinal(), nuevoLimiteMerma.getRegistroActivo());
        if(tmp.isPresent()){
            result = false;
        }
        return  result;
    }

    @Override
     public XxmapLimitesMerma insertarLimiteMerma(InsertLimiteRequestImpl insertLimiteRequest) throws Exception {

        try {

            Date fechaActual = new Date();
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            String fechaFormateada = formatoFecha.format(fechaActual);
            Date fechaConvertida = formatoFecha.parse(fechaFormateada);


            XxmapLimitesMerma nuevoLimiteMerma = new XxmapLimitesMerma();

            nuevoLimiteMerma.setRangoInicial(insertLimiteRequest.getRangoInicial());


            nuevoLimiteMerma.setRangoFinal(insertLimiteRequest.getRangoFinal());
            nuevoLimiteMerma.setMermaAutorizada(insertLimiteRequest.getMermaAutorizada());
            nuevoLimiteMerma.setRegistroActivo(1);
            nuevoLimiteMerma.setCreatedBy(insertLimiteRequest.getCreatedBy());
            nuevoLimiteMerma.setCreationDate(fechaConvertida);
            nuevoLimiteMerma.setModifiedBy(insertLimiteRequest.getModifiedBy());
            nuevoLimiteMerma.setModifiedDate(fechaConvertida);

            logger.info("Datos recibidos para inserción: " + nuevoLimiteMerma);

            return xxmapLimitesMermaRepository.save(nuevoLimiteMerma);

        } catch (DataIntegrityViolationException e) {

            throw new DataIntegrityViolationException("Error de integridad al insertar límite de merma: " + e.getMessage(), e);
        } catch (Exception e) {

            throw new Exception("Error al insertar límite de merma: " + e.getMessage(), e);
        }
    }


    
}
