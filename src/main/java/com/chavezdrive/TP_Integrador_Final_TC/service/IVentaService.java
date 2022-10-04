package com.chavezdrive.TP_Integrador_Final_TC.service;

import com.chavezdrive.TP_Integrador_Final_TC.dto.MayorVentaDTO;
import com.chavezdrive.TP_Integrador_Final_TC.dto.VentaMontoDiaDTO;
import com.chavezdrive.TP_Integrador_Final_TC.dto.VentaProductoDTO;
import com.chavezdrive.TP_Integrador_Final_TC.model.Cliente;
import com.chavezdrive.TP_Integrador_Final_TC.model.Producto;
import com.chavezdrive.TP_Integrador_Final_TC.model.Venta;
import java.time.LocalDate;
import java.util.List;

public interface IVentaService {
    
    //escritura/alta/create
    
    public void saveVenta(Venta ven);
    
    //baja/delete
    
    public void deleteVenta(Long id);
    
    //lectura/read
    
        //para una venta en particular
    
        public Venta findVenta(Long id);
        
        //para traer todas los ventas (lista)
        
        public List<Venta> findVentas();
    
        //actualizacion/edicion/modificacion/update
     
        public void editVenta(Venta vent);
        
        //Punto 5: Obtener lista de productos de una determinada venta
        public VentaProductoDTO productosPorVenta(Long codigo_venta);
        
        //Punto 6: Obtener la sumatoria del monto y también cantidad total de ventas de un determinado dia
        public String ventaMontoDia(LocalDate fecha_venta);
        
        //Punto 7: Obtener el codigo_venta, el total, la cantidad de productos, el nombre y apellido del cliente y el
        //de la venta con el monto más alto de todas. 
        public MayorVentaDTO getMayorVenta();
}
