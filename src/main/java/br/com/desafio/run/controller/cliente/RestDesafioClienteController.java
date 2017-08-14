package br.com.desafio.run.controller.cliente;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestDesafioClienteController {

//	/**
//	 * Log
//	 */
//	public static final Logger logger = LoggerFactory.getLogger(RestDesafioClienteController.class);
//
//	@Autowired
//	ClienteService clienteService;
//
//	/**
//     * Busca todas as Clientes
//     * @return
//     */
// 
//    @RequestMapping(value = "/Cliente/", method = RequestMethod.GET)
//    public ResponseEntity<List<Cliente>> listAllClientes() {
//        List<Cliente> Clientes = clienteService.findAllClientes();
//        if (Clientes.isEmpty()) {
//            return new ResponseEntity(HttpStatus.NO_CONTENT);
//            // You many decide to return HttpStatus.NOT_FOUND
//        }
//        return new ResponseEntity<List<Cliente>>(Clientes, HttpStatus.OK);
//    }
// 
//    /**
//     * Busca Cliente por Id
//     * @param id
//     * @return
//     */
// 
//    @RequestMapping(value = "/Cliente/{id}", method = RequestMethod.GET)
//    public ResponseEntity<?> getCliente(@PathVariable("id") long id) {
//        logger.info("Fetching Cliente with id {}", id);
//        Cliente Cliente = clienteService.findById(id);
//        if (Cliente == null) {
//            logger.error("Cliente with id {} not found.", id);
//            return new ResponseEntity(new RestDesafioErrorType("Cliente with id " + id 
//                    + " not found"), HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<Cliente>(Cliente, HttpStatus.OK);
//    }
// 
//    /**
//     * Insere uma nova Cliente
//     * @param Cliente
//     * @return
//     */
//    @RequestMapping(value = "/Cliente/", method = RequestMethod.POST)
//    public ResponseEntity<?> createCliente(@RequestBody Cliente Cliente, UriComponentsBuilder ucBuilder) {
//        logger.info("Creating Cliente : {}", Cliente);
// 
//        if (clienteService.isClienteExist(Cliente)) {
//            logger.error("Unable to create. A Cliente with name {} already exist", Cliente.getName());
//            return new ResponseEntity(new RestDesafioErrorType("Unable to create. A Cliente with name " + 
//            Cliente.getName() + " already exist."),HttpStatus.CONFLICT);
//        }
//        clienteService.saveCliente(Cliente);
// 
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(ucBuilder.path("/api/Cliente/{id}").buildAndExpand(Cliente.getId()).toUri());
//        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
//    }
// 
//   
//    /**
//     * Altera Cliente pelo Id
//     * @param id
//     * @param Cliente
//     * @return
//     */
//    @RequestMapping(value = "/Cliente/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<?> updateCliente(@PathVariable("id") long id, @RequestBody Cliente Cliente) {
//        logger.info("Updating Cliente with id {}", id);
// 
//        Cliente currentCliente = clienteService.findById(id);
// 
//        if (currentCliente == null) {
//            logger.error("Unable to update. Cliente with id {} not found.", id);
//            return new ResponseEntity(new RestDesafioErrorType("Unable to upate. Cliente with id " + id + " not found."),
//                    HttpStatus.NOT_FOUND);
//        }
// 
//        currentCliente.setName(Cliente.getName());
//         
//        clienteService.updateCliente(currentCliente);
//        return new ResponseEntity<Cliente>(currentCliente, HttpStatus.OK);
//    }
// 
//    
//    /**
//     * Deleta a Camapanha pelo Id
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/Cliente/{id}", method = RequestMethod.DELETE)
//    public ResponseEntity<?> deleteCliente(@PathVariable("id") long id) {
//        logger.info("Fetching & Deleting Cliente with id {}", id);
// 
//        Cliente Cliente = clienteService.findById(id);
//        if (Cliente == null) {
//            logger.error("Unable to delete. Cliente with id {} not found.", id);
//            return new ResponseEntity(new RestDesafioErrorType("Unable to delete. Cliente with id " + id + " not found."),
//                    HttpStatus.NOT_FOUND);
//        }
//        clienteService.deleteClienteById(id);
//        return new ResponseEntity<Cliente>(HttpStatus.NO_CONTENT);
//    }
// 
//    /**
//     * Deletar todas as Clientes
//     * @return
//     */
//    @RequestMapping(value = "/Cliente/", method = RequestMethod.DELETE)
//    public ResponseEntity<Cliente> deleteAllClientes() {
//        logger.info("Deleting All Clientes");
// 
//        clienteService.deleteAllClientes();
//        return new ResponseEntity<Cliente>(HttpStatus.NO_CONTENT);
//    }
//	
	
}
