package com.femsa.oxxo.mermaautorizada.model;
import java.util.Date;


import javax.persistence.*;

import lombok.Data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "MAP_PERMISO_MERMA_PLAZA")
@Where(clause = "REGISTRO_ACTIVO = '1'")
public class XxmapPermisoMermaPlaza {
    @Id
    @SequenceGenerator(name = "ID_GKEY", sequenceName = "MAP_PERMISO_MERMA_PLAZA_CR_PLAZA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_GKEY")
    @Column(name="ID_PERMISOS", length=50, nullable=true)
    private Integer IDPermisos;

    @Column(name="CR_PLAZA", length=50)
    private String crPlaza;

    @Column(name="MERMA_EMPODERADA")
    private Integer mermaEmpoderada;

    @Column(name="REGISTRO_ACTIVO")
    private Integer registroActivo;

    @Column(name="CREATED_BY", length=50)
    private String createdBy;

    @Column(name="CREATION_DATE" )
    private Date creationDate;

    @Column(name="MODIFIED_BY", length=50 )
    private String modifiedBy;

    @Column(name="MODIFIED_DATE")
    private Date modifiedDate;

    @Column(name="ESTATUS_PLAZA", length=50)
    private String estatusPlaza;

    @Column(name="DEVOLUCION_EMPODERADA", length=50)
    private String devolucionEmpoderada;

    @Column(name="ESTATUS_TIENDA", length=50)
    private String estatusTienda;

    @Column(name="TIENDA", length=50)
    private String tienda;

    @Column(name="IP_CREATED_BY", length=50)
    private String ipCreated;

    @Column(name="IP_MODIFIED_BY", length=50)
    private String ipModified;
}
