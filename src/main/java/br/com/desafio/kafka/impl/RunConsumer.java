package br.com.desafio.kafka.impl;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.context.ConfigurableApplicationContext;

public class RunConsumer implements Runnable {

    protected InterfaceKafkaConsumer consumer;

    protected String topic;

    protected String jobXml;

    public RunConsumer(final InterfaceKafkaConsumer consumer, final String topic) {
        this.consumer = consumer;
        this.topic = "ENVIO_FILA_CAMP";
        
    }

    private void execute() {
        KafkaConsumer<String, String> consumer = null;
        ConfigurableApplicationContext context = null;
        try {
            // polling na fila
            consumer = KafkaConsumerProperties.subscribeTopic(this.topic);

            // poll na fila e execução do consumidor
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(100);
                for (ConsumerRecord<String, String> record : records) {
                    // consome a mensagem da fila
                    this.consumer.sendConsumer(record.value());
                }

            }

        } catch (final Exception e) {
            e.printStackTrace();

        } finally {
            if (context != null) {
                context.close();
            }
            if (consumer != null) {
                consumer.close();
            }
        }

    }

    @Override
    public void run() {
        this.execute();
    }
}
