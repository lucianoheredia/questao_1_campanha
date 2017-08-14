package br.com.desafio.run.controller.campanha;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.desafio.run.model.campanha.Campanha;
import br.com.desafio.run.services.campanha.CampanhaService;
import br.com.desafio.run.util.RestDesafioErrorType;
/**
 * 
 * @author Luciano
 *
 */
@RestController
@RequestMapping("/api")
public class RestDesafioCampanhaController {

	/**
	 * Log
	 */
	public static final Logger logger = LoggerFactory.getLogger(RestDesafioCampanhaController.class);

	/**
	 * Injeção do Spring
	 */
	@Autowired
	CampanhaService campService;

	/**
	 * Busca todas as Campanhas
	 * 
	 * @return
	 */

	@RequestMapping(value = "/Campanha/", method = RequestMethod.GET)
	public ResponseEntity<List<Campanha>> listAllCampanhas() throws Exception {
		List<Campanha> campanhas = campService.findAllCampanhas();
		if (campanhas.isEmpty()) {
			
			return new ResponseEntity(
					new RestDesafioErrorType("Não existem Campanhas cadastradas!"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Campanha>>(campanhas, HttpStatus.OK);
	}

	/**
	 * Busca Campanha por Id
	 * 
	 * @param id
	 * @return
	 */

	@RequestMapping(value = "/Campanha/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getCampanha(@PathVariable("id") Long id) {
		logger.info("Campanha id {}", id);
		Campanha Campanha = campService.findById(id);
		if (Campanha == null) {
			logger.error("Campanha com o id não existe .", id);
			return new ResponseEntity(
					new RestDesafioErrorType("Campanha com o id - " + id + " não existe !"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Campanha>(Campanha, HttpStatus.OK);
	}

	/**
	 * Insere uma nova Campanha
	 * 
	 * @param Campanha
	 * @return
	 */
	@RequestMapping(value = "/Campanha/", method = RequestMethod.POST)
	public ResponseEntity<?> createCampanha(@RequestBody Campanha campanha, UriComponentsBuilder builder) {
		logger.info("Criando Campanha : {}", campanha);
		campService.saveCampanha(campanha);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/api/Campanha/{id}").buildAndExpand(campanha.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	/**
	 * Altera Campanha pelo Id
	 * 
	 * @param id
	 * @param Campanha
	 * @return
	 */
	@RequestMapping(value = "/Campanha/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateCampanha(@PathVariable("id") Long id, @RequestBody Campanha campanha,  UriComponentsBuilder builder) {
		logger.info("Update Campanha com o id {}", id);
		campService.updateCampanha(id, campanha);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/api/Campanha/{id}").buildAndExpand(id).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.OK);
	}

	/**
	 * Deleta a Camapanha pelo Id
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/Campanha/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteCampanha(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting Campanha with id {}", id);

		Campanha Campanha = campService.findById(id);
		if (Campanha == null) {
			logger.error("Campanha com o id não existe .", id);
			return new ResponseEntity(
					new RestDesafioErrorType("Campanha com o id - " + id + " não existe !"),
					HttpStatus.NOT_FOUND);
		}
		campService.deleteCampanhaId(id);
		return new ResponseEntity<Campanha>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/Camp", produces = MediaType.APPLICATION_JSON_VALUE,  method = RequestMethod.GET)
	public String getCampanhasJSON(Model model) throws Exception 
	{
	    return campService.findAllCampanhas().toString();
	}
	
	@RequestMapping(value = "/Camp/Associar/{id}", method = RequestMethod.PUT)
	public void associarClienteCampanhas(@PathVariable("id") Long id, UriComponentsBuilder builder) 
	{
		campService.associarClienteCampanha(id);
	    
	}
	
}
