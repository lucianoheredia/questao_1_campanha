package br.com.desafio.kafka.impl;

import org.json.JSONException;

public interface MapRow<T> {

	T mapRow(String str) throws JSONException;
}
