package br.com.desafio.run.services.cliente;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import br.com.desafio.run.model.cliente.Cliente;

public class ClienteServiceImpl implements ClienteService{

private static final AtomicLong counter = new AtomicLong();
    
    private static List<Cliente> Clientes;
     
    static{
        Clientes= populateDummyClientes();
    }
 
    public List<Cliente> findAllClientes() {
        return Clientes;
    }
     
    public Cliente findById(long id) {
        for(Cliente Cliente : Clientes){
            if(Cliente.getId() == id){
                return Cliente;
            }
        }
        return null;
    }
     
    public Cliente findByName(String name) {
        for(Cliente Cliente : Clientes){
            if(Cliente.getName().equalsIgnoreCase(name)){
                return Cliente;
            }
        }
        return null;
    }
     
    public void saveCliente(Cliente Cliente) {
        Cliente.setId(counter.incrementAndGet());
        Clientes.add(Cliente);
    }
 
    public void updateCliente(Cliente Cliente) {
        int index = Clientes.indexOf(Cliente);
        Clientes.set(index, Cliente);
    }
 
    public void deleteClienteById(long id) {
         
        for (Iterator<Cliente> iterator = Clientes.iterator(); iterator.hasNext(); ) {
            Cliente Cliente = iterator.next();
            if (Cliente.getId() == id) {
                iterator.remove();
            }
        }
    }
 
    public boolean isClienteExist(Cliente Cliente) {
        return findByName(Cliente.getName())!=null;
    }
     
    public void deleteAllClientes(){
        Clientes.clear();
    }
 
    private static List<Cliente> populateDummyClientes(){
        List<Cliente> Clientes = new ArrayList<Cliente>();
        Clientes.add(new Cliente(counter.incrementAndGet(),"Cliente_1"));
        Clientes.add(new Cliente(counter.incrementAndGet(),"Cliente_2"));
        Clientes.add(new Cliente(counter.incrementAndGet(),"Cliente_3"));
        Clientes.add(new Cliente(counter.incrementAndGet(),"Cliente_4"));
        return Clientes;
    }


}
