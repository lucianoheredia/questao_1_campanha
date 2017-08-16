package br.com.desafio.kafka.impl;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.KafkaConsumer;

public class KafkaConsumerProperties {

	public static KafkaConsumer<String, String> subscribeTopic(final String topic) {
        // Kafka consumer configuration settings
        Properties props = new Properties();

        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "teste");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);

        // Kafka Consumer subscribes list of topics here.
        consumer.subscribe(Arrays.asList(topic));

        // print the topic name
        System.out.println("INICIANDO CONSUMER FILA " + "ENVIO_FILA_CAMP");

        return consumer;
    }
	
}
