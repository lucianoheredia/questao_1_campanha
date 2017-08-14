package br.com.desafio.repository.campanha;

import java.util.List;

import br.com.desafio.run.model.campanha.Campanha;
/**
 * 
 * @author Luciano
 *
 */
public interface CampanhaRepository {

	public static final String SELECT_CAMPANHA = "SELECT * FROM CAMPANHA WHERE :dataAtual BETWEEN DATA_INICIO_VIG AND DATA_FIM_VIG";

	public static final String SELECT_CAMPANHA_ID = "SELECT * FROM CAMPANHA WHERE id_campanha = :id";

	public static final String SELECT_CAMPANHA_VALIDATION = "SELECT * FROM CAMPANHA "
			+ "  WHERE DATA_INICIO_VIG BETWEEN :dataInicioVigencia AND :dataFimVigencia ";

	public static final String INSERT_CAMPANHA = "INSERT INTO CAMPANHA "
			+ "  ( NOME_CAMPANHA, DATA_INICIO_VIG, DATA_FIM_VIG ) " + " VALUES "
			+ "  ( :nomeCampanha , :dataInicioVigencia, :dataFimVigencia ) ";

	public static final String UPDATE_CAMPANHA_DT_FIM = "UPDATE CAMPANHA "
			+ "  SET DATA_FIM_VIG = :dataFimVigencia  WHERE id_campanha = :id  ";

	public static final String DELETE_CAMPANHA_ID = "DELETE FROM CAMPANHA " + "  WHERE id_campanha = :id  ";

	public static final String UPDATE_CAMPANHA = " UPDATE CAMPANHA SET " 
			+ "  	NOME_CAMPANHA = :nomeCampanha ," 
			+ "		DATA_INICIO_VIG = :dtInicioVig,	" 
			+ "		DATA_FIM_VIG = :dtFimVig " 
			+ "   WHERE id_campanha = :id ";
	
	public static final String ASSOCIAR_CAMPANHA_CLIENTE = " "
			+ " INSERT INTO CAMPANHA_CLIENTE (ID_CAMPANHA, ID_CLIENTE)"
			+ " SELECT CAMP.ID_CAMPANHA, CLI.ID_CLIENTE FROM CAMPANHA CAMP "
			+ " JOIN CLIENTE CLI ON (CLI.ID_TIME_CORACAO = CAMP.ID_TIME) "
			+ " WHERE CLI.ID_CLIENTE = :id";
	;
	
	List<Campanha> findAllCampanhas() throws Exception;

	List<Campanha> findCampanhaValidation(Campanha campanha);

	void saveCampanha(Campanha campanha);

	Campanha findById(Long id);

	void updateList(List<Campanha> campanha);

	void deleteById(Long id);

	void updateCampanhaId(Long id, Campanha camp);
	
	void associarClienteCampanha(Long id);
}
