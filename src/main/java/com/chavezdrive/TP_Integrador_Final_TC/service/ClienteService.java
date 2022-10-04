
package com.chavezdrive.TP_Integrador_Final_TC.service;

import com.chavezdrive.TP_Integrador_Final_TC.model.Cliente;
import com.chavezdrive.TP_Integrador_Final_TC.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService {
    
    @Autowired
    private IClienteRepository repoCliente;

    @Override
    public void saveCliente(Cliente cli) {
        repoCliente.save(cli);
    }

    @Override
    public void deleteCliente(Long id) {
        repoCliente.deleteById(id);
    }

    @Override
    public Cliente findCliente(Long id) {
        return repoCliente.findById(id).orElse(null);
    }

    @Override
    public List<Cliente> findClientes() {
        return repoCliente.findAll();
    }

    @Override
    public void editCliente(Long id_cliente, Long idNueva, String nombre, String apellido,
            String dni) {
        //obtengo el cliente buscado por su id
        Cliente cli = this.findCliente(id_cliente);
        
        //seteo los campos nuevos
        cli.setId_cliente(idNueva);
        cli.setNombre(nombre);
        cli.setApellido(apellido);
        cli.setDni(dni);
        
        //guardo los cambios efectuados
        this.saveCliente(cli);
    }

   
    
  
}
