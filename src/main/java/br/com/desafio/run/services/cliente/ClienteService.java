package br.com.desafio.run.services.cliente;

import java.util.List;

import br.com.desafio.run.model.cliente.Cliente;

public interface ClienteService {

	Cliente findById(long id);
    
    Cliente findByName(String name);
     
    void saveCliente(Cliente Cliente);
     
    void updateCliente(Cliente Cliente);
     
    void deleteClienteById(long id);
 
    List<Cliente> findAllClientes();
     
    void deleteAllClientes();
     
    boolean isClienteExist(Cliente Cliente);
}
