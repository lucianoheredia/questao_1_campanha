package br.com.desafio.kafka.impl;

public interface InterfaceKafkaConsumer {

	    public void sendConsumer(String settlementMovement) throws Exception;

	    public void close() throws Exception;
	
}
