package br.com.desafio.repository.campanha;

import java.util.List;

import br.com.desafio.run.model.campanha.Campanha;
/**
 * 
 * @author Luciano
 *
 */
public interface CampanhaRepository {

	public static final String SELECT_CAMPANHA = ""
			+ "  SELECT  "
			+ "  CAMP.ID_CAMPANHA,"
			+ "	 CAMP.NOME_CAMPANHA ,  "
			+ "  TC.NOME_TIME AS NOME_TIME,  "
			+ "  CAMP.DATA_INICIO_VIG ,  "
			+ "  CAMP.DATA_FIM_VIG , "
	     	+ "	 TC.ID_TIME AS ID_TIME " 
			+ "	FROM CAMPANHA CAMP, TIME_CORACAO TC "
			+ "	WHERE CAMP.ID_TIME = TC.ID_TIME "			
			+ "	AND :dataAtual BETWEEN CAMP.DATA_INICIO_VIG AND CAMP.DATA_FIM_VIG ";

	public static final String SELECT_CAMPANHA_ID = "SELECT "
			+ "  CAMP.ID_CAMPANHA,"
			+ "	 CAMP.NOME_CAMPANHA ,  "
			+ "  TC.NOME_TIME AS NOME_TIME,  "
			+ "  CAMP.DATA_INICIO_VIG ,  "
			+ "  CAMP.DATA_FIM_VIG , "
	     	+ "	 TC.ID_TIME AS ID_TIME " 
			+ "  FROM CAMPANHA CAMP, TIME_CORACAO TC "
			+ "  WHERE CAMP.ID_CAMPANHA = :id AND CAMP.ID_TIME = TC.ID_TIME ";

	public static final String SELECT_CAMPANHA_VALIDATION = "SELECT "
			+ "  CAMP.ID_CAMPANHA,"
			+ "	 CAMP.NOME_CAMPANHA ,  "
			+ "  TC.NOME_TIME AS NOME_TIME,  "
			+ "  CAMP.DATA_INICIO_VIG ,  "
			+ "  CAMP.DATA_FIM_VIG , "
	     	+ "	 TC.ID_TIME AS ID_TIME " 
			+ "	 FROM CAMPANHA CAMP, TIME_CORACAO TC  "
			+ "  WHERE (CAMP.DATA_INICIO_VIG BETWEEN :dataInicioVigencia AND :dataFimVigencia) "
			+ "  AND CAMP.ID_TIME = TC.ID_TIME ";

	public static final String INSERT_CAMPANHA = "INSERT INTO CAMPANHA "
			+ "  ( NOME_CAMPANHA, DATA_INICIO_VIG, DATA_FIM_VIG, ID_TIME ) " + " VALUES "
			+ "  ( :nomeCampanha , :dataInicioVigencia, :dataFimVigencia, :id_time  ) ";

	public static final String UPDATE_CAMPANHA_DT_FIM = "UPDATE CAMPANHA "
			+ "  SET DATA_FIM_VIG = :dataFimVigencia  WHERE id_campanha = :id  ";

	public static final String DELETE_CAMPANHA_ID = "DELETE FROM CAMPANHA " + "  WHERE id_campanha = :id  ";

	public static final String UPDATE_CAMPANHA = " UPDATE CAMPANHA SET " 
			+ "  	NOME_CAMPANHA = :nomeCampanha ," 
			+ "		DATA_INICIO_VIG = :dtInicioVig,	" 
			+ "		DATA_FIM_VIG = :dtFimVig, "
			+ "		ID_TIME = :id_time" 
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
