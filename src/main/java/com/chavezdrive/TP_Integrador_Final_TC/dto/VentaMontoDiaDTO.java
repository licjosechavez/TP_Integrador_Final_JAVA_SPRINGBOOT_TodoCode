package com.chavezdrive.TP_Integrador_Final_TC.dto;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VentaMontoDiaDTO {
    
    private LocalDate fecha;
    private Double sumaTotal;
    private Double cantidadDeVentas;

    public VentaMontoDiaDTO() {
    }

    public VentaMontoDiaDTO(LocalDate fecha, Double sumaTotal, Double cantidadDeVentas) {
        this.fecha = fecha;
        this.sumaTotal = sumaTotal;
        this.cantidadDeVentas = cantidadDeVentas;
    }
    
}
