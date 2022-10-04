
package com.chavezdrive.TP_Integrador_Final_TC.controller;


import com.chavezdrive.TP_Integrador_Final_TC.dto.MayorVentaDTO;
import com.chavezdrive.TP_Integrador_Final_TC.dto.VentaMontoDiaDTO;
import com.chavezdrive.TP_Integrador_Final_TC.dto.VentaProductoDTO;
import com.chavezdrive.TP_Integrador_Final_TC.model.Venta;
import com.chavezdrive.TP_Integrador_Final_TC.service.IVentaService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VentaController {
    
    @Autowired
    private IVentaService servVenta;
    
    //crear venta
    
    @PostMapping("/ventas/crear")
    public String saveVenta(@RequestBody Venta ven){
        servVenta.saveVenta(ven);
        return "Venta agregada correctamente.-";
    }
    
    //traer listado de ventas
    
    @GetMapping("/ventas")
    public List<Venta> findVentas(){
        List<Venta> listaVentas = servVenta.findVentas();
        return listaVentas;
    }
    
    //traer una venta en particular
    
    @GetMapping("/ventas/{codigo_venta}")
    public Venta findVenta(@PathVariable Long codigo_venta){
        Venta venta = servVenta.findVenta(codigo_venta);
        return venta;
    }
    
    //eliminar una venta
    
    @DeleteMapping("/ventas/eliminar/{codigo_venta}")
    public String deleteVenta(@PathVariable Long codigo_venta){
        servVenta.deleteVenta(codigo_venta);
        return "Venta eliminada correctamente.-";
    }
          
    //editar una venta por objeto
    
    @PutMapping("/ventas/editar")
    public String editVenta(@RequestBody Venta vent) {

        servVenta.editVenta(vent);
        return "La venta fue editada correctamente";
    }
    
    //Punto 5: Obtener lista de productos de una determinada venta
    
    @GetMapping ("/ventas/productos/{codigo_venta}")
    public VentaProductoDTO productosPorVenta (@PathVariable Long codigo_venta) {
        return servVenta.productosPorVenta(codigo_venta);
    
    }
    
    // Punto 6:  Obtener la sumatoria del monto y también cantidad total de ventas de un determinado dia
        
    @GetMapping("/ventas/total/{fecha_venta}")
    @ResponseBody
    public String ventaMontoDia(@PathVariable String fecha_venta){
        LocalDate fecha = LocalDate.parse(fecha_venta);
        return servVenta.ventaMontoDia(fecha);
    }
    
    
    // Punto 7:  Obtener el codigo_venta, el total, la cantidad de productos, el nombre y apellido del cliente y el
    //de la venta con el monto más alto de todas.
    
    @GetMapping ("/ventas/mayor_venta")
    public MayorVentaDTO getMayorVenta(){
        
        return servVenta.getMayorVenta();
    }
    
    
    
}
