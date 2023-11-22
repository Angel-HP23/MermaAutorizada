package com.femsa.oxxo.mermaautorizada.service.impl;

import com.femsa.oxxo.mermaautorizada.model.XxmapLimitesMerma;
import com.femsa.oxxo.mermaautorizada.repository.XxmapLimitesMermaRepository;
import com.femsa.oxxo.mermaautorizada.service.IxxmapLimitesMermaService;
import org.springframework.stereotype.Service;
import java.util.Date;

import java.util.List;

@Service
public class XxmapLimitesMermaServiceImpl implements IxxmapLimitesMermaService {


    private final XxmapLimitesMermaRepository xxmapLimitesMermaRepository;

    public XxmapLimitesMermaServiceImpl(XxmapLimitesMermaRepository xxmapLimitesMermaRepository) {
        this.xxmapLimitesMermaRepository = xxmapLimitesMermaRepository;
    }

    public XxmapLimitesMerma insertarLimiteMerma(XxmapLimitesMerma xxmapLimitesMerma) throws Exception {

        try {

        Date fechaActual = new Date();
        xxmapLimitesMerma.setCreationDate(fechaActual);

        return xxmapLimitesMermaRepository.save(xxmapLimitesMerma);

       } catch (Exception e) {

         throw new Exception("Error al insertar límite de merma");
       }
    }


    public void eliminarLimiteMerma(Long limitesMermaId) throws Exception{

      // xxmapLimitesMermaRepository.deleteById(limitesMermaId);
      try {
          boolean eliminadoLimiteMerma = xxmapLimitesMermaRepository.findById(limitesMermaId)
                  .map(limiteMerma -> {
                      xxmapLimitesMermaRepository.deleteById(limitesMermaId);
                      return true;
                  })
                  .orElse(false);
      }catch (Exception e){
          throw new Exception("Error al intentar eliminar límite de merma");
      }
    }

    public List<XxmapLimitesMerma> findAllXxmapLimitesMerma() {

        return xxmapLimitesMermaRepository.findAll();
    }




    
}
