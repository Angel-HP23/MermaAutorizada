package com.femsa.oxxo.mermaautorizada.model;

import lombok.Data;

import java.util.Date;

import javax.persistence.*;

@Data
@Entity
@Table(name="MAP_CATEGORIA_MERMA")
public class XxmapCategoriaMerma {
    @Id
    @SequenceGenerator(name = "MAP_CATEGORIA_MERMA_DIVSION_SEQ", sequenceName = "MAP_CATEGORIA_MERMA_DIVSION", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MAP_CATEGORIA_MERMA_DIVSION_SEQ")
    @Column(name="DIVISION")
    private Long divisionId;

    @Column(name="MERMA_AUTORIZADA", nullable=false)
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

}//end class
