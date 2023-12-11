package com.femsa.oxxo.mermaautorizada.model;

import java.util.Date;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "MAP_LIMITES_MERMA")
public class XxmapLimitesMerma {
    @Id
    @SequenceGenerator(name = "MAP_LIMITES_MERMA_LIMITES_MERMA_ID_SEQ", sequenceName = "MAP_LIMITES_MERMA_LIMITES_MERMA_ID", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MAP_LIMITES_MERMA_LIMITES_MERMA_ID_SEQ")
    @Column(name = "LIMITES_MERMA_ID")
    private Integer limitesMermaId;

    @Column(name="RANGO_INICIAL", nullable= false)
    private Integer rangoInicial;

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

    @Column(name="MODIFIED_BY", length=50, nullable= false)
    private String modifiedBy;

    @Column(name="MODIFIED_DATE", nullable= false)
    private Date modifiedDate;
}