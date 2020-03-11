package com.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Future;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/3/12 0:26
 * @Description: 有拦截器的生产者
 */
public class InterceptorProducer {


    public static void main(String[] args)  throws Exception{
        //kafka配置信息
        Properties properties = new Properties();

        //kafka集群信息
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.1.5:9092,192.168.1.5:9093,192.168.1.5:9094");

        //ack三种方式 0  1 和-1
        properties.put(ProducerConfig.ACKS_CONFIG,"all");

        //发送消息失败后的重试次数
        properties.put(ProducerConfig.RETRIES_CONFIG,3);

        //批次大小 单位字节 16m
        properties.put(ProducerConfig.BATCH_SIZE_CONFIG,16384);

        //未达到要送的批次的大小后 最多的等待时间  单位ms  在这个等待时间后会发送已有的消息
        properties.put(ProducerConfig.LINGER_MS_CONFIG, 3);

        //当消息发送者发送消息过快  broker处理不来的时候 可以用的缓存 [RecordAccumulator缓冲区的大小]
        properties.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);

        //key的序列化器
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");

        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");

        //添加拦截器配置
        List<String> interceptors = new ArrayList<>();
        interceptors.add("com.kafka.interceptor.CountInterceptor");
        interceptors.add("com.kafka.interceptor.TimeInterceptor");

        properties.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, interceptors);




        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(properties);
        for (int i = 0; i <10 ; i++) {
            //构建消息 编码是utf-8的 window cmd窗口会显示乱码 centos下不会
            ProducerRecord record = new ProducerRecord("frist","xujianhong"+i, i+"messages 中国");
            //发送消息
            kafkaProducer.send(record);
        }

        System.out.println("关闭资源");

        //关闭资源（关闭资源的时候还会调用 close方法）
        kafkaProducer.close();
    }
}
