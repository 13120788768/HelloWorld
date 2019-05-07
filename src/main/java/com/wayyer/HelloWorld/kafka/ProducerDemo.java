package com.wayyer.HelloWorld.kafka;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 * @Author: wayyer
 * @Description: the producer of kafka
 * @Program: HelloWorld
 * @Date: 2019.05.06
 */
public class ProducerDemo extends Thread {

    public static void main(String[] a) throws Exception{
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        // 使用Confluent实现的KafkaAvroSerializer
        props.put("value.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
        // 添加schema服务的地址，用于获取schema
        props.put("schema.registry.url", "http://localhost:8081");

        Producer<String, GenericRecord> producer = new org.apache.kafka.clients.producer.KafkaProducer<String, GenericRecord>(props);

        Schema.Parser parser = new Schema.Parser();
        Schema schema = parser.parse(new File(""));

        Random rand = new Random();
        int id = 0;

        while(id < 100) {
            id++;
            String name = "name" + id;
            int age = rand.nextInt(40) + 1;
            GenericRecord user = new GenericData.Record(schema);
//            Map<String, Object> user = new HashMap<>();
            user.put("id", id);
            user.put("name", name);
            user.put("age", age);

            ProducerRecord<String, GenericRecord> record = new ProducerRecord<>("test", user);

            producer.send(record);
            Thread.sleep(1000);
        }

        producer.close();

//        Properties pro = new Properties();
//        pro.put("metadata.broker.list", "localhost:8099");
//        pro.put("serializer.class", "kafka.serializer.StringEncoder");
//        pro.put("key.serializer.class", "kafka.serializer.StringEncoder");
//        pro.put("request.required.acks", "1");
//
//
//        ProducerConfig config = new ProducerConfig(pro);
//        Producer<String, String> producer = new Producer<String, String>(config);
//
//        KeyedMessage<String, String> message =
//                new KeyedMessage<>("test", "test-key", "this the test message for local kafka.");
//
//        producer.send(message);
    }





}
