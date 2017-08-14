package br.com.desafio.maprow;

import org.springframework.jdbc.core.RowMapper;

import br.com.desafio.run.model.campanha.Campanha;

public final class MapRowFactory {

	private MapRowFactory() {
		super();
	}

	public static RowMapper<Campanha> getCampanhaRowMapper(Campanha camp) {
		return new CampanhaMapRow(camp);
	}

}
