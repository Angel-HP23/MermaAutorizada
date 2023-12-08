package com.femsa.oxxo.mermaautorizada.service.impl;


import com.femsa.oxxo.mermaautorizada.service.IxxmapPermisoMermaPlazaService;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.femsa.oxxo.mermaautorizada.model.XxmapPermisoMermaPlaza;
import com.femsa.oxxo.mermaautorizada.repository.XxmapPermisoMermaPlazaRepository;

@Service
@Slf4j
public class XxmapPermisoMermaPlazaImpl implements  IxxmapPermisoMermaPlazaService {

    @Autowired
    XxmapPermisoMermaPlazaRepository PermisopRepo;

    @Override
    public List<XxmapPermisoMermaPlaza> GetAllPlazas() {
        return PermisopRepo.findAll();
    }

    @Override
    public boolean ValiddeletePermiso(Integer idPermiso) {
        return PermisopRepo.existsById(idPermiso);
    }

    @Override
    public void desactivaPermisoRest(Integer idPermiso) throws Exception{
        try {
            PermisopRepo.findById(idPermiso).ifPresent(PermisosM -> {
                PermisosM.setRegistroActivo(0);
                PermisopRepo.save(PermisosM);
            });
        }catch (Exception e){
            throw new Exception("Error al Eliminar Reguistro");
        }
    }

    @Override
    public void addPermiso(XxmapPermisoMermaPlaza Permiso) throws Exception {
        try {
            Date fechaResiente =  new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String fechaFormateada = format.format(fechaResiente);
            Date fechaCom = format.parse(fechaFormateada);

            XxmapPermisoMermaPlaza newPermisos = new XxmapPermisoMermaPlaza();

            newPermisos.setCrPlaza(Permiso.getCrPlaza());
            newPermisos.setMermaEmpoderada(Permiso.getMermaEmpoderada());
            newPermisos.setRegistroActivo(1);
            newPermisos.setCreatedBy(Permiso.getCreatedBy());
            newPermisos.setCreationDate(fechaCom);
            newPermisos.setModifiedBy(Permiso.getModifiedBy());
            newPermisos.setModifiedDate(fechaCom);
            newPermisos.setEstatusPlaza(Permiso.getEstatusPlaza());
            newPermisos.setDevolucionEmpoderada(Permiso.getDevolucionEmpoderada());
            newPermisos.setEstatusTienda(Permiso.getEstatusTienda());
            newPermisos.setTienda(Permiso.getTienda());
            newPermisos.setIpCreated(Permiso.getIpCreated());
            newPermisos.setIpModified(Permiso.getIpModified());

            System.out.println("IMP");
            this.PermisopRepo.save(newPermisos);
            System.out.println(Permiso);
        }catch (Exception e){
            throw new Exception("Error al agregar el Permiso"+e.getMessage());
        }
    }

    @Override
    public XxmapPermisoMermaPlaza insertPermiso(XxmapPermisoMermaPlaza PermisoMermaPlaza) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

}
