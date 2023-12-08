package com.femsa.oxxo.mermaautorizada.controllers;


import com.femsa.oxxo.mermaautorizada.model.BodyPlazas;
import com.femsa.oxxo.mermaautorizada.model.XxmapPermisoMermaPlaza;
import com.femsa.oxxo.mermaautorizada.service.IxxmapPermisoMermaPlazaService;
import com.femsa.oxxo.mermaautorizada.service.impl.XxmapPermisoMermaPlazaImpl;

import lombok.AllArgsConstructor;


import java.util.ArrayList;
import java.util.List;

import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/Permisos")
@AllArgsConstructor
@CrossOrigin("http://localhost:4200/")
public class XxmapPermisoMermaPlazaController {

    @Autowired
    private IxxmapPermisoMermaPlazaService PlazaService;

    @GetMapping("/Plzas")
    public List<XxmapPermisoMermaPlaza> listar(){
        return PlazaService.GetAllPlazas();
    }


    @GetMapping("/AllPlazas")
    public ResponseEntity<BodyPlazas<List<XxmapPermisoMermaPlaza>>> GetPlazasPermisos(){
        List<XxmapPermisoMermaPlaza> permisoplaza = new ArrayList<XxmapPermisoMermaPlaza>();
        BodyPlazas<List<XxmapPermisoMermaPlaza>> body;
        try {
            permisoplaza = this.PlazaService.GetAllPlazas();
            body = new BodyPlazas<List<XxmapPermisoMermaPlaza>>(200,"successful", permisoplaza);
            return new ResponseEntity<BodyPlazas<List<XxmapPermisoMermaPlaza>>>(body, HttpStatus.OK);
        } catch(Exception e){
            e.printStackTrace();
            body = new BodyPlazas<List<XxmapPermisoMermaPlaza>>(500, "Error", null);
            return new ResponseEntity<BodyPlazas<List<XxmapPermisoMermaPlaza>>>(body, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping(value = "add/newPermiso")
    public ResponseEntity<BodyPlazas<String>> PutPlazaPermisos(@RequestBody XxmapPermisoMermaPlaza Permiso ) throws Exception {
        BodyPlazas<String> body;
        System.out.println("here");
        System.out.println(Permiso);
        try{
            this.PlazaService.addPermiso(Permiso);
            body = new BodyPlazas<String>(200, "Successful", "Se agrego nuevo producto");
            return new ResponseEntity<BodyPlazas<String>>(body,HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            body = new BodyPlazas<String>(500, "No se pudo guardar o actualizar el producto", null);
            return new ResponseEntity<BodyPlazas<String>>(body, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping(value= "delete/PlazaPermsio/{id}")
    public ResponseEntity<BodyPlazas<String>> eliminarPermisoPlaza(@PathVariable(name = "id") Integer id){
        BodyPlazas<String> body;
        try {
            if (PlazaService.ValiddeletePermiso(id)){
                PlazaService.desactivaPermisoRest(id);
                body = new BodyPlazas<String>(200, "Successful", "Permiso Eliminado");
                return new ResponseEntity<BodyPlazas<String>>(body, HttpStatus.OK);
            }else {
                body = new BodyPlazas <String>(500, "Imposible eliminar, El id del permiso no existe ", null);
                return new ResponseEntity<BodyPlazas<String>>(body, HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } catch (Exception e){
            e.printStackTrace();
            body = new BodyPlazas <String>(500, "No se pudo eliminar el registro", null);
            return new ResponseEntity<BodyPlazas<String>>(body, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }






}
