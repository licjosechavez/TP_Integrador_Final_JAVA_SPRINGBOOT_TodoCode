
package com.chavezdrive.TP_Integrador_Final_TC.controller;

import com.chavezdrive.TP_Integrador_Final_TC.model.Producto;
import com.chavezdrive.TP_Integrador_Final_TC.model.Venta;
import com.chavezdrive.TP_Integrador_Final_TC.service.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {
    
    @Autowired
    private IProductoService servProducto;
    
    //crear Producto
    @PostMapping("/productos/crear")
    public String saveProducto(@RequestBody Producto pro){
        servProducto.saveProducto(pro);
        return "Producto agregado correctamente.-";
    }
    
    //traer listado de productos
    @GetMapping("/productos")
    public List<Producto> findProductos(){
        List<Producto> listaproductos = servProducto.findProductos();
        return listaproductos;
    }
    
    //traer un producto en particular
    @GetMapping("/productos/{codigo_producto}")
    public Producto findProducto(@PathVariable Long codigo_producto){
        Producto producto = servProducto.findProducto(codigo_producto);
        return producto;
    }
    
    //eliminar un producto
    @DeleteMapping("/productos/eliminar/{codigo_producto}")
    public String deleteProducto(@PathVariable Long codigo_producto){
        servProducto.deleteProducto(codigo_producto);
        return "Producto eliminado correctamente.-";
    }
    
    //editar un producto por paramatros
       
    @PutMapping("/productos/editar/{codigo_producto}")
    public Producto editProducto(@PathVariable Long codigo_producto,
            @RequestParam(required = false, name = "codigo_producto") Long idNueva,
            @RequestParam(required = false, name = "nombre") String nuevoNombre,
            @RequestParam(required = false, name = "marca") String nuevaMarca,
            @RequestParam(required = false, name = "costo") Double nuevoCosto,
            @RequestParam(required = false, name = "cantidad_disponible") Double nuevaCantidadDisponible)
            {
                
        servProducto.editProducto(codigo_producto, idNueva, nuevoNombre, nuevaMarca,
                nuevoCosto, nuevaCantidadDisponible);
        Producto pro = servProducto.findProducto(idNueva);
        return pro;
    }
    
    //4. Obtener todos los productos cuya cantidad_disponible sea menor a 5
    //Lista Stock faltante
    @GetMapping("/productos/falta_stock")
    public List<Producto> getStock(){
        
        return servProducto.getFaltaStock();
    }
 
}
