package br.com.desafio.rules;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;

import br.com.desafio.kafka.TopicProducer;
import br.com.desafio.repository.campanha.CampanhaRepository;
import br.com.desafio.run.model.campanha.Campanha;

public class BaseRules {

	@Autowired
	CampanhaRepository resitory;

	protected TopicProducer producer = null;
    protected final Gson gson = new Gson();
	
	protected Boolean validationRequest(Campanha camp) {
		return camp != null;
	}

	protected List<Campanha> isCampanhaExist(Campanha campanha) {
		return this.resitory.findCampanhaValidation(campanha);
	}

	protected void updateList(List<Campanha> campanha) {
		this.resitory.updateList(campanha);
	}

	protected String adicionarUmDiaData(String data) throws ParseException {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date dataCamp = new Date(format.parse(data).getTime());

		Calendar cal = Calendar.getInstance();
		cal.setTime(dataCamp);
		cal.add(cal.DAY_OF_MONTH, +1);

		return format.format(cal.getTime());

	}

	protected List<Campanha> validarSeContemDtRepetida(List<Campanha> campanhas) throws ParseException {

		for (int i = 0; i < campanhas.size(); i++) {
			for (int j = 0; j < campanhas.size() - 1; j++) {
				if (campanhas.get(i).getDataFim().equals(campanhas.get(j + 1).getDataFim())) {
					System.out.println(campanhas.get(i).getDataFim() + " - " + campanhas.get(j + 1).getDataFim());
					campanhas.get(i+1).setDataFim(adicionarUmDiaData(campanhas.get(i+1).getDataFim()));
					System.out.println("A camp.add(campanhas.get(j+1));- " + campanhas.get(j + 1).getDataFim());
				}
				i++;
			}

		}

		return campanhas;
	}

}
