package com.kafka.interceptor;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

/**
 * @Tile:
 * @Autor: xujianhong
 * @Date: 2020/3/12 0:23
 * @Description:
 */
public class CountInterceptor implements ProducerInterceptor {

    private int successCount;
    private int  failCount;

    @Override
    public void configure(Map<String, ?> configs) {

    }

    @Override
    public ProducerRecord onSend(ProducerRecord record) {
        return record;
    }

    @Override
    public void onAcknowledgement(RecordMetadata metadata, Exception exception) {
             if(null != metadata){
                 //成功后加1
                 successCount++;
             }else{
                 //失败后加1
                 failCount++;
             }
    }

    @Override
    public void close() {
        System.out.println("成功:"+successCount+"条消息");
        System.out.println("失败:"+failCount+"条消息");

    }


}
