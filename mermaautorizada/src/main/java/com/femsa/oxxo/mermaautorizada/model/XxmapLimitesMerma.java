package com.femsa.oxxo.mermaautorizada.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "MAP_LIMITES_MERMA")
public class XxmapLimitesMerma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LIMITES_MERMA_ID")
    private Long limitesMermaId;

    @Column(name="RANGO_INICIAL", nullable= false)
    private Integer rangoIncial;

    @Column(name="RANGO_FINAL", nullable= false)
    private Integer rangoFinal;

    @Column(name="MERMA_AUTORIZADA", nullable= false)
    private Integer mermaAutorizada;

    @Column(name="REGISTRO_ACTIVO", nullable= false)
    private Integer registroActivo;

    @Column(name="CREATED_BY", length= 50, nullable= false)
    private String createdBy;

    @Column(name="CREATION_DATE", nullable= false)
    private Date creationDate;

    @Column(name="modifiedBy", length=50, nullable= false)
    private String modifiedBy;

    @Column(name="MODIFIED_DATE", nullable= false)
    private Date modifiedDate;
}
