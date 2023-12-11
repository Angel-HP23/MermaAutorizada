package com.femsa.oxxo.mermaautorizada.controllers;

import com.femsa.oxxo.mermaautorizada.model.XxmapSuperCategoria;
import com.femsa.oxxo.mermaautorizada.request.InsertSuperCategoriaRequestImpl;
import com.femsa.oxxo.mermaautorizada.service.IxxmapSuperCategoriaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/supercategoria")
@CrossOrigin("http://localhost:4200/")
public class XxmapSuperCategoriaController {

    private static final Logger logger = LoggerFactory.getLogger(XxmapSuperCategoriaController.class);

    private final IxxmapSuperCategoriaService ixxmapSuperCategoriaService;

    public XxmapSuperCategoriaController(IxxmapSuperCategoriaService ixxmapSuperCategoriaService) {
        this.ixxmapSuperCategoriaService = ixxmapSuperCategoriaService;
    }

    @GetMapping("/supercategorias")
    public List<XxmapSuperCategoria> xxmapSuperCategoriasList() {
        List<XxmapSuperCategoria> categoriasS = this.ixxmapSuperCategoriaService.findAllXxmapSuperCategoria();
        logger.info("Super Categrias: ");
        categoriasS.forEach((categoria ->  logger.info(categoria.toString())));
        return categoriasS;
    }

    @PostMapping("/intsupercategorias")
    public ResponseEntity<XxmapSuperCategoria> xxmapSuperCategoriInsert(@RequestBody InsertSuperCategoriaRequestImpl insertSuperCategoriaRequest) {
        try {
            logger.info("Datos recibidos: " + insertSuperCategoriaRequest);
            XxmapSuperCategoria nuevaSuper = this.ixxmapSuperCategoriaService.insertSuperCategoria(insertSuperCategoriaRequest);
            return new ResponseEntity<>(nuevaSuper, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Error al insertar categoria: " + e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> xxmapSuperCategoriaDelete(@PathVariable Long id) {
        try {
            if (ixxmapSuperCategoriaService.isValidDeleteSuperCategoria(id)) {
                ixxmapSuperCategoriaService.deleteSuperCategoria(id);

                return ResponseEntity.ok("Eliminar super categoria con ID " + id + " (Borrado lógico con exito)");
            } else {
                return ResponseEntity.status(400).body("La super categoria con ID " + id + " no existe");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al intentar realizar el borrado lógico");
        }
    }
}//end class
