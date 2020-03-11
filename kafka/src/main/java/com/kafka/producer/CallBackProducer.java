package com.kafka.producer;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/3/11 19:27
 * @Description:
 */
public class CallBackProducer {

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

        //设置自定义分区
        properties.put(ProducerConfig.PARTITIONER_CLASS_CONFIG,"com.kafka.partition.MyPartition");

        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(properties);
        for (int i = 0; i <10 ; i++) {
            //构建消息 编码是utf-8的 window cmd窗口会显示乱码 centos下不会
            ProducerRecord record = new ProducerRecord("frist","xujianhong"+i, i+"messages 有返回值");
            //发送消息
            kafkaProducer.send(record, (metadata, exception) -> {
                //回掉也是异步的  主线程先走完
                if(null != metadata){
                    System.out.println(metadata.offset()+": "+metadata.partition());
                }else{
                    exception.printStackTrace();
                }
            });
        }

        System.out.println("发送完毕");
        //关闭资源
        kafkaProducer.close();
    }
}
