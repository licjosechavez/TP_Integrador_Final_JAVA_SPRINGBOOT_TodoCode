
package com.chavezdrive.TP_Integrador_Final_TC.service;

import com.chavezdrive.TP_Integrador_Final_TC.model.Producto;
import com.chavezdrive.TP_Integrador_Final_TC.model.Venta;
import com.chavezdrive.TP_Integrador_Final_TC.repository.IProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {
    
    @Autowired
    private IProductoRepository repoProducto;

    @Override
    public void saveProducto(Producto pro) {
        repoProducto.save(pro);

    }

    @Override
    public void deleteProducto(Long id) {
        repoProducto.deleteById(id);

    }

    @Override
    public Producto findProducto(Long id) {
        return repoProducto.findById(id).orElse(null);

    }

    @Override
    public List<Producto> findProductos() {
        return repoProducto.findAll();
    }

    @Override
    public void editProducto(Long codigo_producto, Long idNueva, String nombre,
            String marca, Double costo, Double cantidad_disponible) {
        
        Producto pro = this.findProducto(codigo_producto);
        
        pro.setCodigo_producto(idNueva);
        pro.setNombre(nombre);
        pro.setMarca(marca);
        pro.setCosto(costo);
        pro.setCantidad_disponible(cantidad_disponible);
        
        
        this.saveProducto(pro);
        
    }
    
    //Punto 4: Obtener todos los productos cuya cantidad_disponible sea menor a 5

    @Override
    public List<Producto> getFaltaStock() {
        
        List<Producto> listaProductos = this.findProductos();
        List<Producto> listaStockMenorA5 = new ArrayList<Producto>();
        
        for(Producto pro : listaProductos){
            if(pro.getCantidad_disponible() < 5){
                listaStockMenorA5.add(pro);
            }
        }
        return listaStockMenorA5;

    }

    
    
}
