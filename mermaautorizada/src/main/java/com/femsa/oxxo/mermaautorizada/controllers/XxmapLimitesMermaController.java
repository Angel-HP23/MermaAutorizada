package com.femsa.oxxo.mermaautorizada.controllers;

import com.femsa.oxxo.mermaautorizada.model.XxmapLimitesMerma;
import com.femsa.oxxo.mermaautorizada.request.InsertLimiteRequestImpl;
import com.femsa.oxxo.mermaautorizada.service.IxxmapLimitesMermaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/merma")
@CrossOrigin("http://localhost:4200/")
public class XxmapLimitesMermaController {
    private static final Logger logger = LoggerFactory.getLogger(XxmapLimitesMermaController.class);
    private final IxxmapLimitesMermaService ixxmapLimitesMermaService;

    public XxmapLimitesMermaController(IxxmapLimitesMermaService ixxmapLimitesMermaService) {

        this.ixxmapLimitesMermaService = ixxmapLimitesMermaService;
    }



    @GetMapping("/limitesmerma")
    public List<XxmapLimitesMerma> xxmapLimitesMermaList(){
        List<XxmapLimitesMerma> limitesMerma = this.ixxmapLimitesMermaService.findAllXxmapLimitesMerma();
        logger.info("DATOSSSS: ");
        limitesMerma.forEach((listLimites -> logger.info(listLimites.toString())));
        return limitesMerma;
    }


    @PostMapping("/limitesMermaInsert")
    public ResponseEntity<?> xxmapLimitesMermainsert(@RequestBody InsertLimiteRequestImpl insertLimiteRequest) {

        try {

            if (!ixxmapLimitesMermaService.isValidInsertLimite(insertLimiteRequest)) {

                return ResponseEntity.status(HttpStatus.CONFLICT).body("La información ingresada ya existe");
            }
            XxmapLimitesMerma nuevoLimiteMerma = this.ixxmapLimitesMermaService.insertarLimiteMerma(insertLimiteRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoLimiteMerma);
        } catch (Exception e) {
            logger.error("Error al insertar límite de merma: " + e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/limite/{id}")
    public ResponseEntity<String> eliminarLimitePorId(@PathVariable Integer id) {
        try {

            if (ixxmapLimitesMermaService.isValidDeleteLimite(id)) {

                ixxmapLimitesMermaService.eliminarLimiteMerma(id);
                return ResponseEntity.ok("Eliminar límite por ID: " + id + " (Borrado lógico exitoso)");
            } else {
                return ResponseEntity.status(404).body("El límite con ID " + id + " no existe");
            }
        } catch (Exception e) {

            return ResponseEntity.status(500).body("Error al intentar realizar el borrado lógico");
        }
    }
}
