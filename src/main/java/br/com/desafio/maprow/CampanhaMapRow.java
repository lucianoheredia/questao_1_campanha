package br.com.desafio.maprow;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.desafio.run.model.campanha.Campanha;
import br.com.desafio.run.model.time_coracao.TimeCoracao;
/**
 * 
 * @author Luciano
 *
 */
public class CampanhaMapRow implements RowMapper<Campanha>{

	private transient Campanha campanha;
	
	public CampanhaMapRow(Campanha campanha){
		this.campanha = campanha;
	}
	
	@Override
	public Campanha mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Campanha newCampanha = new Campanha();
		TimeCoracao time = new TimeCoracao();
		newCampanha.setId(rs.getLong("id_campanha"));
		newCampanha.setNome(rs.getString("nome_campanha"));
		newCampanha.setDataIni(rs.getString("data_inicio_vig"));
		newCampanha.setDataFim(rs.getString("data_fim_vig"));
		time.setId(rs.getInt("id_time"));
		time.setNome(rs.getString("nome_time"));
		
		newCampanha.setTimeCoracao(time);
		
		this.campanha = newCampanha;
		
		return this.campanha;
	}

}
