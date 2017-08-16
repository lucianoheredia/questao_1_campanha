package br.com.desafio.kafka.impl;

import com.google.gson.Gson;

import br.com.desafio.kafka.TopicProducer;

public class MensagemConsumer implements InterfaceKafkaConsumer{

	protected final Gson gson = new Gson();

    protected TopicProducer producer = null;

    public MensagemConsumer() throws Exception {
        // producer da proxima fila
        this.producer = new TopicProducer("ENVIO_FILA_CAMP");
    }

    @Override
    public void sendConsumer(final String message) throws Exception {
        // conversão
        ConsumerMensagemMapRow mapper = new ConsumerMensagemMapRow();
        mapper.mapRow(message);
       
    }

    @Override
    public void close() throws Exception {
        this.producer.close();
    }

 }
