
package com.chavezdrive.TP_Integrador_Final_TC.service;

import com.chavezdrive.TP_Integrador_Final_TC.model.Cliente;
import java.util.List;

public interface IClienteService {
    
    //escritura/alta/create
    
    public void saveCliente(Cliente cli);
    
    //baja/delete
    
    public void deleteCliente(Long id);
    
    //lectura/read
    
        //para un cliente en particular
    
        public Cliente findCliente(Long id);
        
        //para traer todos los clientes (lista)
        
        public List<Cliente> findClientes();
    
    
    //actualizacion/edicion/modificacion/update
    
    public void editCliente(Long id_cliente, Long idNueva,
            String nombre, String apellido, String dni);     
}
