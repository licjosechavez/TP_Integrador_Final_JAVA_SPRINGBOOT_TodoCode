
package com.chavezdrive.TP_Integrador_Final_TC.repository;

import com.chavezdrive.TP_Integrador_Final_TC.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long> {
    
}
