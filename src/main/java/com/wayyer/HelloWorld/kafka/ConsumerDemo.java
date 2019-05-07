package com.wayyer.HelloWorld.kafka;

import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.*;

/**
 * @Author: wayyer
 * @Description: the consumer of kafka demo
 * @Program: HelloWorld
 * @Date: 2019.05.06
 */
public class ConsumerDemo {

//    private static ConsumerConnector consumer = null;
    //localhost:2181

    public static void main(String[] a){
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.42.89:9092,192.168.42.89:9093,192.168.42.89:9094");
        props.put("group.id", "dev3-yangyunhe-group001");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        // 使用Confluent实现的KafkaAvroDeserializer
        props.put("value.deserializer", "io.confluent.kafka.serializers.KafkaAvroDeserializer");
        // 添加schema服务的地址，用于获取schema
        props.put("schema.registry.url", "http://192.168.42.89:8081");
        org.apache.kafka.clients.consumer.KafkaConsumer<String, GenericRecord> consumer = new KafkaConsumer<>(props);

        consumer.subscribe(Collections.singletonList("dev3-yangyunhe-topic001"));

        try {
            while (true) {
                ConsumerRecords<String, GenericRecord> records = consumer.poll(1000);
                for (ConsumerRecord<String, GenericRecord> record : records) {
                    GenericRecord user = record.value();
                    System.out.println("value = [user.id = " + user.get("id") + ", " + "user.name = "
                            + user.get("name") + ", " + "user.age = " + user.get("age") + "], "
                            + "partition = " + record.partition() + ", " + "offset = " + record.offset());
                }
            }
        } finally {
            consumer.close();
        }

//        Properties properties = new Properties();
//
//        //zookeeper
//        properties.put("zookeeper.connect", "localhost:2181");
//        properties.put("zookeeper.session.timeout.ms", "200");
//        properties.put("zookeeper.sync.time.ms", "200");
//        properties.put("auto.commit.interval.ms", "1000");
//        properties.put("auto.offset.reset", "smallest");
//
//        properties.put("group.id", "wayyer");
//
//        properties.put("serializer.class", "kafka.serializer.StringEncoder");
//
//        ConsumerConfig config = new ConsumerConfig(properties);
//
//        consumer = Consumer.createJavaConsumerConnector(config);
//        Map<String, Integer> topicCountMap = new HashMap<>();
//        topicCountMap.put("test", new Integer(1));
//        StringDecoder keyDecoder = new StringDecoder(new VerifiableProperties());
//        StringDecoder valueDecoder = new StringDecoder(new VerifiableProperties());
//        Map<String, List<KafkaStream<String, String>>> consumerMap =
//                consumer.createMessageStreams(topicCountMap, keyDecoder, valueDecoder);
//        KafkaStream<String, String> stream = consumerMap.get("test").get(0);
//        ConsumerIterator<String, String> it = stream.iterator();
//        while (it.hasNext())
//            System.out.println(it.next().message());
    }

}
