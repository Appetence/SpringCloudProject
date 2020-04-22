package com.ztx.springcloud.comments;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
/**
 * 创建队列
 *
 */
@Configuration
public class QueueConfig {

    /*对列名称*/
    public static final String QUEUE_NAME1 = "first_queue";
    public static final String QUEUE_NAME2 = "second-queue";
    public static final String QUEUE_NAME3 = "third-queue";
    public static final String QUEUE_NAME4 = "messageQueue";
    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
        //设置忽略声明异常
        rabbitAdmin.setIgnoreDeclarationExceptions(true);
        return rabbitAdmin;
    }
    /**
     * 短信发送
     * @return
     */
    @Bean
    public Queue firstQueue() {
        /**
         durable="true" 持久化消息队列 ， rabbitmq重启的时候不需要创建新的队列
         auto-delete 表示消息队列没有在使用时将被自动删除 默认是false
         exclusive  表示该消息队列是否只在当前connection生效,默认是false
         */
        return new Queue(QUEUE_NAME1,true,false,false);
    }

    @Bean
    public Queue secondQueue() {
        return new Queue(QUEUE_NAME2,true,false,false);
    }

    @Bean
    public Queue thirdQueue() {
        // 配置 自动删除
        Map<String, Object> arguments = new HashMap<>();
        arguments.put("x-message-ttl", 60000);//60秒自动删除
        return new Queue(QUEUE_NAME3,true,false,true,arguments);
    }
    
    
    @Bean
    public Queue fourthQueue() {
        return new Queue(QUEUE_NAME4,true,false,false);
    }
}
