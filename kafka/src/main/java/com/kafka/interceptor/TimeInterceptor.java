package com.kafka.interceptor;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/3/12 0:17
 * @Description: 在消息前添加时间戳的拦截器
 */
public class TimeInterceptor implements ProducerInterceptor<String, String> {

    @Override
    public void configure(Map<String, ?> configs) {

    }


    @Override
    public ProducerRecord<String, String> onSend(ProducerRecord<String, String> record) {
        //没有set方法 只能重构造消息
        return  new ProducerRecord(record.topic(), record.partition(), record.key(), System.currentTimeMillis()+record.value());
    }

    @Override
    public void onAcknowledgement(RecordMetadata metadata, Exception exception) {

    }

    @Override
    public void close() {

    }


}
