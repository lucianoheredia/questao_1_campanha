package br.com.desafio.repository.campanha;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.desafio.infra.DataSourceConfig;
import br.com.desafio.maprow.MapRowFactory;
import br.com.desafio.run.model.campanha.Campanha;
/**
 * 
 * @author Luciano
 *
 */
@Repository
public class CampanhaRepositoryImpl implements CampanhaRepository {

	private NamedParameterJdbcTemplate config;

	public CampanhaRepositoryImpl() {
		this.config = DataSourceConfig.jdbcTemplate();
	}

	@Override
	public List<Campanha> findAllCampanhas() throws Exception {
		Date novo = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String data = format.format(novo.getTime());
		Campanha camp = new Campanha();
		ConcurrentHashMap<String, Object> paramMap = new ConcurrentHashMap<String, Object>();
		paramMap.put("dataAtual", data);
		return this.config.query(SELECT_CAMPANHA, paramMap, MapRowFactory.getCampanhaRowMapper(camp));
	}

	@Override
	public List<Campanha> findCampanhaValidation(Campanha campanha) {
		Campanha camp = new Campanha();
		ConcurrentHashMap<String, Object> paramMap = new ConcurrentHashMap<String, Object>();
		paramMap.put("dataInicioVigencia", campanha.getDataIni());
		paramMap.put("dataFimVigencia", campanha.getDataFim());
		return this.config.query(SELECT_CAMPANHA_VALIDATION, paramMap, MapRowFactory.getCampanhaRowMapper(camp));
	}

	@Override
	public void saveCampanha(Campanha campanha) {
		ConcurrentHashMap<String, Object> paramMap = new ConcurrentHashMap<String, Object>();
		paramMap.put("nomeCampanha", campanha.getNome());
		paramMap.put("dataInicioVigencia", campanha.getDataIni());
		paramMap.put("dataFimVigencia", campanha.getDataFim());
		paramMap.put("id_time", campanha.getTimeCoracao().getId());
		this.config.update(INSERT_CAMPANHA, paramMap);
	}

	@Override
	public Campanha findById(Long id) {
		Campanha camp = new Campanha();
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("id", id);
		try {
			camp = (Campanha) this.config.queryForObject(SELECT_CAMPANHA_ID, parameters,
					MapRowFactory.getCampanhaRowMapper(camp));
		} catch (Exception e) {
			camp = null;
			e.printStackTrace();
		}
		
		return camp;
	}

	@Override
	public void updateList(List<Campanha> camp) {

		for (Campanha campanha : camp) {
			ConcurrentHashMap<String, Object> paramMap = new ConcurrentHashMap<String, Object>();
			paramMap.put("dataFimVigencia", campanha.getDataFim());
			paramMap.put("id", campanha.getId());
			this.config.update(UPDATE_CAMPANHA_DT_FIM, paramMap);
		}

	}

	@Override
	public void deleteById(Long id) {
		ConcurrentHashMap<String, Object> paramMap = new ConcurrentHashMap<String, Object>();
		paramMap.put("id", id);
		this.config.update(DELETE_CAMPANHA_ID, paramMap);
	}

	@Override
	public void updateCampanhaId(Long id, Campanha campanha) {
		ConcurrentHashMap<String, Object> paramMap = new ConcurrentHashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("nomeCampanha", campanha.getNome());
		paramMap.put("dtInicioVig", campanha.getDataIni());
		paramMap.put("dtFimVig", campanha.getDataFim());
		paramMap.put("id_time", campanha.getTimeCoracao().getId());
		
		this.config.update(UPDATE_CAMPANHA, paramMap);
		
	}

	@Override
	public void associarClienteCampanha(Long id) {
		ConcurrentHashMap<String, Object> paramMap = new ConcurrentHashMap<String, Object>();
		paramMap.put("id", id);
		this.config.update(ASSOCIAR_CAMPANHA_CLIENTE, paramMap);
	}

}
