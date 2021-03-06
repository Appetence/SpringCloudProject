package com.ztx.springcloud.service.impl;

import com.ztx.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;
/**
 * @author liuhao
 */
@Slf4j
@EnableBinding(Source.class)//消息的推送管道
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;
    @Override
    public String send() {
       String serail =  UUID.randomUUID().toString();
       log.info("serail："+serail);
       output.send(MessageBuilder.withPayload(serail).build());
        return serail;
    }
}
