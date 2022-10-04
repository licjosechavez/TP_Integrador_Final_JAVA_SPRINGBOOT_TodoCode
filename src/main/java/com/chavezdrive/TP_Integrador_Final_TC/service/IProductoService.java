
package com.chavezdrive.TP_Integrador_Final_TC.service;


import com.chavezdrive.TP_Integrador_Final_TC.model.Producto;
import com.chavezdrive.TP_Integrador_Final_TC.model.Venta;
import java.util.List;


public interface IProductoService {
    
    //escritura/alta/create
    
    public void saveProducto(Producto pro);
    
    //baja/delete
    
    public void deleteProducto(Long id);
    
    //lectura/read
    
        //para un producto en particular
    
        public Producto findProducto(Long id);
        
        //para traer todos los productos (lista)
        
        public List<Producto> findProductos();
    
        //actualizacion/edicion/modificacion/update
    
        public void editProducto(Long codigo_producto, Long idNueva,
            String nombre, String marca, Double costo, Double cantidad_disponible);
        
        //Punto 4: Obtener todos los productos cuya cantidad sea < a 5
        public List<Producto> getFaltaStock();
    
}
