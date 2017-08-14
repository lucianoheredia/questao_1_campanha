package br.com.desafio.rules;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.desafio.kafka.TopicProducer;
import br.com.desafio.run.model.campanha.Campanha;
/**
 * 
 * @author Luciano
 *
 */

@Service
@Qualifier("CampanhaRules")
public class CampanhaRules extends BaseRules {
	
	public CampanhaRules() throws Exception{
		 this.producer = new TopicProducer("ENVIO_FILA");
	}

	public Campanha campanhaValidation(Campanha campanha) throws ParseException {

		final Boolean req = this.validationRequest(campanha);

		if (!req) {
			return campanha;
		}

		List<Campanha> listCamp = this.isCampanhaExist(campanha);
		List<Campanha> listCampUpdate = new ArrayList<>();
		List<Campanha> listCampRep = new ArrayList<>();

		if (listCamp != null) {
			Collections.sort(listCamp);

			/**
			 * No cadastramento de uma nova campanha, deve-se verificar se já
			 * existe uma campanha ativa para aquele período (vigência), caso
			 * exista uma campanha ou N campanhas associadas naquele período, o
			 * sistema deverá somar um dia no término da vigência de cada
			 * campanha já existente.
			 */
			for (Campanha campRule : listCamp) {
				campRule.setDataFim(adicionarUmDiaData(campRule.getDataFim()));
				listCampUpdate.add(campRule);
			}

			/**
			 * A data final da vigência seja igual a outra campanha, deverá ser
			 * acrescido um dia a mais;
			 */
			for (Campanha campRule : listCamp) {
				if (campRule.getDataFim().equals(campanha.getDataFim())) {
					campRule.setDataFim(adicionarUmDiaData(campRule.getDataFim()));
					listCampUpdate.add(campRule);
				}

			}

			/**
			 * De forma que as campanhas não tenham a mesma data de término de
			 * vigência
			 */
			listCampRep = this.validarSeContemDtRepetida(listCampUpdate);

			/**
			 * Atualização das Campanhas Existentes.
			 * Depois de todas as validações.
			 */
			this.updateList(listCampRep);
			
			/**
			 * Postar na fila FOMATO JSON para informar outros Sistemas; 
			 * Utilizando KAFKA da APACHE.
			 */
			this.producer.send(this.gson.toJson(listCampRep));

			/**
			 * Cadastro da nova Campanha
			 */
			return campanha;
		} else {
			return campanha;
		}

	}
		
}
