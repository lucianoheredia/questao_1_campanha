package br.com.desafio.run.services.campanha;

import java.util.List;

import br.com.desafio.run.model.campanha.Campanha;
/**
 * 
 * @author Luciano
 *
 */
public interface CampanhaService {

	void saveCampanha(Campanha campanha);
     
	void updateCampanha(Long id, Campanha campanha);
     
    void deleteCampanhaId(long id);
 
    List<Campanha> findAllCampanhas() throws Exception;

	Campanha findById(Long id);
	
	void associarClienteCampanha(Long id);

	    
}
