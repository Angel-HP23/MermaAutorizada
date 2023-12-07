package com.femsa.oxxo.mermaautorizada.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "SUPER_CATEGORIAS")
public class XxmapSuperCategoria {
    @Id
    @SequenceGenerator(name = "SUPER_CATEGORIAS_ID_CATEGORIA_SEQ", sequenceName = "SUPER_CATEGORIAS_ID_CATEGORIA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SUPER_CATEGORIAS_ID_CATEGORIA_SEQ")
    @Column(name = "ID_CATEGORIA")
    private Long categoriaId;

    @Column(name = "SUPER_CATEGORIA")
    private String superCategoria;

    @Column(name = "EMPODERAMIENTO_MERMA")
    private String empoderamientoMerma;

}//end class
