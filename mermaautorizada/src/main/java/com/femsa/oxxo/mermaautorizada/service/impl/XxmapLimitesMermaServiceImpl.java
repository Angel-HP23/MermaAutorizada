package com.femsa.oxxo.mermaautorizada.service.impl;

import com.femsa.oxxo.mermaautorizada.model.XxmapLimitesMerma;
import com.femsa.oxxo.mermaautorizada.repository.XxmapLimitesMermaRepository;
import com.femsa.oxxo.mermaautorizada.service.IxxmapLimitesMermaService;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;

@Service
public class XxmapLimitesMermaServiceImpl implements IxxmapLimitesMermaService {


    private final XxmapLimitesMermaRepository xxmapLimitesMermaRepository;

    public XxmapLimitesMermaServiceImpl(XxmapLimitesMermaRepository xxmapLimitesMermaRepository) {
        this.xxmapLimitesMermaRepository = xxmapLimitesMermaRepository;
    }

    @Override
    public XxmapLimitesMerma insertarLimiteMerma(XxmapLimitesMerma xxmapLimitesMerma) throws Exception {

        try {

        Date fechaActual = new Date();
        xxmapLimitesMerma.setCreationDate(fechaActual);
        xxmapLimitesMerma.setRegistroActivo(1);

        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        String fechaFormateada = formatoFecha.format(fechaActual);

        xxmapLimitesMerma.setCreationDate(formatoFecha.parse(fechaFormateada));

        return xxmapLimitesMermaRepository.save(xxmapLimitesMerma);

       } catch (Exception e) {

         throw new Exception("Error al insertar límite de merma");
       }
    }


    public void eliminarLimiteMerma(Long limitesMermaId) throws Exception{

      
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

    public List<XxmapLimitesMerma> findAllXxmapLimitesMerma() {

        return xxmapLimitesMermaRepository.findAll();
    }




    
}
