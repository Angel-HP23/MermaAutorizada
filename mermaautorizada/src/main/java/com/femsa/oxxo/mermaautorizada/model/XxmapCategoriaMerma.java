package com.femsa.oxxo.mermaautorizada.model;

import lombok.Data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="MAP_CATEGORIA_MERMA")
public class XxmapCategoriaMerma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="DIVISON")
    private Long divisionId;

    @Column(name="MEMERMA_AUTORIZADA", nullable=false)
    private Integer mermaAutorizada;

    @Column(name="REGISTRO_ACTIVO", nullable=false)
    private Integer registroActivo;

    @Column(name="CREATED_BY", length=50 ,nullable=false)
    private String createdBy;

    @Column(name="CREATION_DATE", nullable=false)
    private Date creationDate;

    @Column(name="MODIFIED_BY",length=50, nullable=false)
    private String modifiedBy;

    @Column(name="MODIFIED_DATE", nullable=false)
    private Date modifiedDate;
}
