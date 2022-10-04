
package com.chavezdrive.TP_Integrador_Final_TC.service;
import com.chavezdrive.TP_Integrador_Final_TC.dto.MayorVentaDTO;
import com.chavezdrive.TP_Integrador_Final_TC.dto.VentaMontoDiaDTO;
import com.chavezdrive.TP_Integrador_Final_TC.dto.VentaProductoDTO;
import com.chavezdrive.TP_Integrador_Final_TC.model.Cliente;
import com.chavezdrive.TP_Integrador_Final_TC.model.Producto;
import com.chavezdrive.TP_Integrador_Final_TC.model.Venta;
import com.chavezdrive.TP_Integrador_Final_TC.repository.IVentaRepository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService {
    
    @Autowired
    private IVentaRepository repoVenta;
    
    @Autowired
    private IProductoService servProducto;
    
    //Alta de una venta
    @Override
    public void saveVenta(Venta ven) {
        repoVenta.save(ven);
    }
    
    //Eliminar una venta por id
    @Override
    public void deleteVenta(Long id) {
        repoVenta.deleteById(id);
    }
    
    //Traer una venta por id
    @Override
    public Venta findVenta(Long id) {
        return repoVenta.findById(id).orElse(null);
    }
    
    //Traer todas las ventas
    @Override
    public List<Venta> findVentas() {
        return repoVenta.findAll();
    }
    
    
    
    //Editar una venta por Objeto
    @Override
    public void editVenta(Venta vent) {
        this.saveVenta(vent);
    }
    
    //Punto 5: Obtener lista de productos de una determinada venta
    
    @Override
    public VentaProductoDTO productosPorVenta(Long codigo_venta) {
        VentaProductoDTO venProDTO = new VentaProductoDTO ();
        Venta venta = this.findVenta(codigo_venta);
        
        venProDTO.setCodigo_venta(venta.getCodigo_venta());
        venProDTO.setLista_productos(venta.getLista_productos());
        
        
        return venProDTO;
    }
    
    // Punto 6:  Obtener la sumatoria del monto y también cantidad total de ventas de un determinado dia

    @Override
    public String ventaMontoDia(LocalDate fecha_venta) {
        List<Venta> listaVentas = this.findVentas();
        double monto = 0;
        int cantidad = 0;

        for (Venta venta : listaVentas) {
            if (venta.getFecha_venta().equals(fecha_venta)) {
                monto = monto + venta.getTotal();
                cantidad++;
            }
        }
        return "La cantidad de ventas del dia " + fecha_venta + " es de: " + cantidad + ", con un monto total de: " + monto;
    }
    
    // Punto 7:  Obtener el codigo_venta, el total, la cantidad de productos, el nombre y apellido del cliente y el
    //de la venta con el monto más alto de todas.
    @Override
    public MayorVentaDTO getMayorVenta() {
        List<Venta> listaVentas = this.findVentas();
        MayorVentaDTO mayorDTO = new MayorVentaDTO();
        Double total = 0.0;
        Double temp = 0.0;
        Double contador = 0.0;
        for(Venta mayorVen : listaVentas){
            temp = mayorVen.getTotal();
            if(temp > total){
                total = temp;
                Double roundTotal = Math.round(total*100.0)/100.0;
                mayorDTO.setTotal(roundTotal);
                mayorDTO.setCodigo_venta(mayorVen.getCodigo_venta());
                mayorDTO.setNombre_cliente(mayorVen.getUnCliente().getNombre());
                mayorDTO.setApellido_cliente(mayorVen.getUnCliente().getApellido());
                mayorDTO.setListaProductos(mayorVen.getLista_productos());
                
                for(int i=0; i < mayorDTO.getListaProductos().size(); i++){
                    contador = contador + 1;
                    mayorDTO.setCantidad_productos(contador);
                }
            }
        }
           return mayorDTO;
    }

   
}
