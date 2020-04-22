package com.ztx.springcloud.comments;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 消息交换机配置  可以配置多个
 * @author ztx
 * @date 2018/5/25 15:40
 */
@Configuration
public class ExchangeConfig {

    /** 消息交换机1的名字*/
    public final static String EXCHANGE_01 = "first_exchange";
    
    public final  static String EXCHANGE_04 = "infants_message_exchang";

    /**
     *   1.定义direct exchange，绑定first_exchange
     *   2.durable="true" 持久化交换机， rabbitmq重启的时候不需要创建新的交换机
     *   3.direct交换器相对来说比较简单，匹配规则为：如果路由键匹配，消息就被投送到相关的队列
     *     fanout交换器中没有路由键的概念，他会把消息发送到所有绑定在此交换器上面的队列中。
     *     topic交换器你采用模糊匹配路由键的原则进行转发消息到队列中
     */
     @Bean
    public DirectExchange directExchange(){
        DirectExchange directExchange = new DirectExchange(EXCHANGE_01,true,false);
        return directExchange;
    } 
    /* @Bean
     public DirectExchange directExchange01(){
         DirectExchange directExchange = new DirectExchange(EXCHANGE_04,true,false);
         return directExchange;
     } */
   //声明交换机
    /* @Bean(name=EXCHANGE_04)
     public Exchange topicExchange(){
         //声明了一个Topic类型的交换机，durable是持久化（重启rabbitmq这个交换机不会被自动删除）
         return ExchangeBuilder.topicExchange(EXCHANGE_04).durable().build();
     }*/
    /*  @Bean
    public DirectExchange directExchange04(){
        DirectExchange directExchange = new DirectExchange(EXCHANGE_04,true,false);
        return directExchange;
    }*/
    //广播模式
 /*   @Bean
    public FanoutExchange fanoutExchange04(){
    	FanoutExchange directExchange = new FanoutExchange(EXCHANGE_04,true,false);
        return directExchange;
    }*/
    
    /**
     *     exchange是交换机交换机的主要作用是接收相应的消息并且绑定到指定的队列.交换机有四种类型,分别为Direct,topic,headers,Fanout.
     *
     * 　　Direct是RabbitMQ默认的交换机模式,也是最简单的模式.即创建消息队列的时候,指定一个BindingKey.当发送者发送消息的时候,指定对应的Key.当Key和消息队列的BindingKey一致的时候,消息将会被发送到该消息队列中.
     *
     * 　　topic转发信息主要是依据通配符,队列和交换机的绑定主要是依据一种模式(通配符+字符串),而当发送消息的时候,只有指定的Key和该模式相匹配的时候,消息才会被发送到该消息队列中.
     *
     * 　　headers也是根据一个规则进行匹配,在消息队列和交换机绑定的时候会指定一组键值对规则,而发送消息的时候也会指定一组键值对规则,当两组键值对规则相匹配的时候,消息会被发送到匹配的消息队列中.
     *
     * 　　Fanout是路由广播的形式,将会把消息发给绑定它的全部队列,即便设置了key,也会被忽略.
    */
   @Bean
    public TopicExchange directExchange01() {
        // 参数1为交换机的名称
        return new TopicExchange(EXCHANGE_04);
    } 
    /**
     * //配置广播路由器
     * @return FanoutExchange
   
    @Bean
    public FanoutExchange fanoutExchange() {
        // 参数1为交换机的名称
        return new FanoutExchange( EXCHANGE_03);
    }  */
}
