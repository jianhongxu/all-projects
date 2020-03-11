package com.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/3/11 23:03
 * @Description: 消费者
 */
public class MyConsumer {

    public static void main(String[] args) {
        //1 创建消费者的配置信息
        Properties properties = new Properties();

        //2 给配置信息
        //链接kafka的集群信息
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.1.5:9092,192.168.1.5:9093,192.168.1.5:9094");

        //设置消费者组 如果不这是会默认分配一个组
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "bigdata-3");

        //从头开始消费  两种情况 一种是服务端没有offset记录（offset是由组、topic和partition 三个因素组成的） 二是有的offset在服务器上不存在了(offset服务器上被删除 7天)
        //取值两种 earliest  从最早的 latest最新的(默认)
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        //设置自动提交为true
        //properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);

        //第一次启动的时候会从服务器拿一个offset 拿到后第二次会直接用本地的内存的offset
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);


        //设置自动提交的最大等待时间 5秒 单位是毫秒
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, 5000);

        //key的序列化器
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");

        //value的序列化器
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");


        //3  创建kafka消费的客户端
        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(properties);

        //订阅主题  多个
        kafkaConsumer.subscribe(Arrays.asList("frist","seconde"));

        //拉取消息
        while(true) {
            //拉取消息时 如果拉到空消息 就等待1秒钟后继续拉取 主要是提高性能
            ConsumerRecords<String, String> consumerRecords = kafkaConsumer.poll(1000);
            for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
                System.out.println(consumerRecord.key() + "----" + consumerRecord.value());
            }
        }

        //关闭资源
        //kafkaConsumer.close();
    }

}
