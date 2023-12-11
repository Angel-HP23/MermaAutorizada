package com.femsa.oxxo.mermaautorizada.controllers;

import com.femsa.oxxo.mermaautorizada.model.XxmapCategoriaMerma;
import com.femsa.oxxo.mermaautorizada.request.InsertCategoriaRequestImpl;
import com.femsa.oxxo.mermaautorizada.service.IxxmapCategoriaMermaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/merma")
@CrossOrigin("http://localhost:4200/")
public class XxmapCategoriaMermaController {
    private static final Logger logger = LoggerFactory.getLogger(XxmapCategoriaMermaController.class);

    private final IxxmapCategoriaMermaService ixxmapCategoriaMermaService;

    public XxmapCategoriaMermaController(IxxmapCategoriaMermaService ixxmapCategoriaMermaService) {
        this.ixxmapCategoriaMermaService = ixxmapCategoriaMermaService;
    }

    @GetMapping("/categoriasmerma")
    public List<XxmapCategoriaMerma> xxmapCategoriaMermaList() {
        List<XxmapCategoriaMerma> categorias = this.ixxmapCategoriaMermaService.findAllXxmapCategoriaMerma();
        logger.info("Categorias: ");
        categorias.forEach((categoria -> logger.info(categoria.toString())));
        return categorias;
    }

    @PostMapping("/intcategoria")
    public ResponseEntity<XxmapCategoriaMerma> xxmapCategoriaMermaInsert(@RequestBody InsertCategoriaRequestImpl insertCategoriaRequest) {

        try {
            logger.info("Datos recibidos: " + insertCategoriaRequest);
            XxmapCategoriaMerma nuevaCategoria = this.ixxmapCategoriaMermaService.insertCategoriaMerma(insertCategoriaRequest);
            return new ResponseEntity<>(nuevaCategoria, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Error al insertar categoria: " + e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/categoria/{id}")
    public ResponseEntity<String> xxmapDeleteCategoriaById(@PathVariable Long id) {
        try {
            if (ixxmapCategoriaMermaService.isValidDeleteCategoria(id)) {
                ixxmapCategoriaMermaService.deleteCategoriaMerma(id);
                return ResponseEntity.ok("Eliminar categoria con ID " + id + "(Borrado lógico con exito)");
            } else {
                return ResponseEntity.status(404).body("La categoria con ID " + id + " no existe");
            }
        } catch (Exception e ) {
            return ResponseEntity.status(500).body("Error al intentar realizar el borrado lógico");
        }
    }

}//end class
