package br.com.desafio.run.services.campanha;

import java.text.ParseException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.com.desafio.repository.campanha.CampanhaRepository;
import br.com.desafio.rules.CampanhaRules;
import br.com.desafio.run.model.campanha.Campanha;

/**
 * 
 * @author Luciano
 *
 */
@Service("campanhaService")
public class CampanhaServiceImpl implements CampanhaService {

	@Inject
	private transient CampanhaRepository repository;

	@Inject
	private transient CampanhaRules rules;

	/*
	 * 
	 * @see br.com.desafio.run.services.campanha.CampanhaService#findAllCampanhas()
	 */
	public List<Campanha> findAllCampanhas() throws Exception {
		return this.repository.findAllCampanhas();
	}

	/*
	 * Método Responsável por consultar campanhas pelo ID
	 * @see br.com.desafio.run.services.campanha.CampanhaService#findById(java.lang.Long)
	 */
	public Campanha findById(Long id) {
		return this.repository.findById(id);
	}

	/*
	 * Método Responsável por inserir campanhas
	 * O método ainda faz uma requisição nas regras de negócio para poder verificar se 
	 * a campanha que está sendo inserida está correta.
	 * @see br.com.desafio.run.services.campanha.CampanhaService#saveCampanha(br.com.desafio.run.model.campanha.Campanha)
	 */
	public void saveCampanha(Campanha campanha) {
		boolean saveBool = false;
		try {
			this.rules.campanhaValidation(campanha);
			saveBool = true;
		} catch (ParseException e) {
			saveBool = false;
			e.printStackTrace();
		}

		if (saveBool) {
			this.repository.saveCampanha(campanha);
		}

	}

	/*
	 * Não inseri nenhuma regra de negócio na alteração
	 * Na documentação dizia apenas referente ao insert.
	 * Método Responsável por alterar campanhas.
	 */
	public void updateCampanha(Long id, Campanha campanha) {
		this.repository.updateCampanhaId(id, campanha);
	}

	/*
	 * Método Responsável por deletar campanhas.
	 * @see br.com.desafio.run.services.campanha.CampanhaService#deleteCampanhaId(long)
	 */
	public void deleteCampanhaId(long id) {
		this.repository.deleteById(id);
	}

	@Override
	public void associarClienteCampanha(Long id) {
		this.repository.associarClienteCampanha(id);
	}

}
