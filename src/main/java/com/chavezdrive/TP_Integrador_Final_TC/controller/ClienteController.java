
package com.chavezdrive.TP_Integrador_Final_TC.controller;

import com.chavezdrive.TP_Integrador_Final_TC.model.Cliente;
import com.chavezdrive.TP_Integrador_Final_TC.service.IClienteService;
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
public class ClienteController {
    
    @Autowired
    private IClienteService servCliente;
    
    //crear cliente
    @PostMapping("/clientes/crear")
    public String saveCliente(@RequestBody Cliente cli){
        servCliente.saveCliente(cli);
        return "Cliente agregado correctamente.-";
    }
    
    //traer listado de clientes
    @GetMapping("/clientes")
    public List<Cliente> findClientes(){
        List<Cliente> listaClientes = servCliente.findClientes();
        return listaClientes;
    }
    
    //traer un cliente en particular
    @GetMapping("/clientes/{id_cliente}")
    public Cliente findCliente(@PathVariable Long id_cliente){
        Cliente cliente = servCliente.findCliente(id_cliente);
        return cliente;
    }
    
    //eliminar un cliente
    @DeleteMapping("/clientes/eliminar/{id_cliente}")
    public String deleteCliente(@PathVariable Long id_cliente){
        servCliente.deleteCliente(id_cliente);
        return "Cliente eliminado correctamente.-";
    }
    
    //editar un cliente
    @PutMapping("/clientes/editar/{id_cliente}")
    public Cliente editCliente(@PathVariable Long id_cliente,
            @RequestParam(required = false, name = "id_cliente") Long idNueva,
            @RequestParam(required = false, name = "nombre") String nuevoNombre,
            @RequestParam(required = false, name = "apellido") String nuevoApellido,
            @RequestParam(required = false, name = "dni") String nuevoDni)
            {
                
        servCliente.editCliente(id_cliente, idNueva, nuevoNombre, nuevoApellido, nuevoDni);
        Cliente cli = servCliente.findCliente(idNueva);
        return cli;
    }
    
}
