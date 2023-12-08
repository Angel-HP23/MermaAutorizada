package com.femsa.oxxo.mermaautorizada.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class  BodyPlazas<T> {
    private Integer status;
    private String mensaje;
    private T Body;
}
