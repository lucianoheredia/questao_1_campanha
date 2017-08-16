package br.com.desafio.kafka.impl;


import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.desafio.run.model.campanha.Campanha;

public class ConsumerMensagemMapRow implements MapRow<Campanha>{

	 static int i = 0;
	
	@Override
	public Campanha mapRow(String str) throws JSONException {
		Campanha camp = new Campanha();
        System.out.println("PROCESSO" + i);
        JSONObject userObject = new JSONObject(str);

        camp.setId(userObject.getLong("id"));

        Iterator<?> keys = userObject.keys();
        
        /*
         * Aqui seria o processo para gravar no banco ou enviar para outro 
         * Serviço , tratamento, entre outras coisas.
         * Qualquer dúvida em como fazer funcionar, favor entrar em contato.
         */
        System.out.println("------------------- INICIO -----------------------");
        while (keys.hasNext()) {
            String key = (String) keys.next();
            userObject.get(key);
            System.out.println("CHAVE: " + key + " - VALOR: " + userObject.get(key));

        }

        System.out.println("-------------------- FIM -------------------------");
        i++;
        return camp;
    }

	



}
