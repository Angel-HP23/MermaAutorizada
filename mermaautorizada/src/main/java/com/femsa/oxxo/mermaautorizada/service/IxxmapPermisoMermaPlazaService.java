package com.femsa.oxxo.mermaautorizada.service;
import java.util.List;

import  com.femsa.oxxo.mermaautorizada.model.XxmapPermisoMermaPlaza;

public interface IxxmapPermisoMermaPlazaService {
    XxmapPermisoMermaPlaza insertPermiso(XxmapPermisoMermaPlaza PermisoMermaPlaza) throws Exception;

    //public List<XxmapPermisoMermaPlaza> findAllPlazas() throws Exception;

    public  List<XxmapPermisoMermaPlaza> GetAllPlazas();

    public boolean ValiddeletePermiso(Integer idPermiso);

    public void  desactivaPermisoRest(Integer idPermiso) throws Exception;

    public  void  addPermiso(XxmapPermisoMermaPlaza Permiso) throws Exception;





}
