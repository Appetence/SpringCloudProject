package com.ztx.springcloud.controller;

import com.netflix.appinfo.InstanceInfo;
import com.ztx.springcloud.entities.CommentResult;
import com.ztx.springcloud.entities.Payment;
//自定义loadbalance负载
import com.ztx.springcloud.loadBal.LoadBalance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Set;

@RestController
@Slf4j
public class OrderController {
    @Resource
    public RestTemplate restTemplate;
    @Resource
    public DiscoveryClient discoveryClient;
    //@Resource//自定义loadbalance
    //public LoadBalance loadBalance;
    @Resource//自定义loadbalance
    public LoadBalance loadBalance;
    // public static final String PAYMENT_URL="http://localhost:8001/payment";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @RequestMapping("payment/create")
    public CommentResult<Payment> create(@RequestBody Payment payment) {
        log.info("进来啦：{}", payment);
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommentResult.class);
    }

    @RequestMapping("getPaymentById/get/{id}")
    public CommentResult<Payment> getPaymentById(@PathVariable(name = "id") Long id) {
        log.info("进来啦getPaymentById：{}", id);
        return restTemplate.getForObject(PAYMENT_URL + "/payment/getPaymentById/get/" + id, CommentResult.class);
    }

    @RequestMapping("/getDiscovery")
    public Object getDiscovery() {
        List<String> list = discoveryClient.getServices();
        for (String s : list) {
            log.info("set:" + s);//获取服务信息
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance si : instances) {
            log.info(">>>>:" + si.getInstanceId() + "\t" + si.getHost() + "\t" + si.getScheme() + "\t" + si.getServiceId() + "\t" + si.getUri());
        }
        return this.discoveryClient;
    }
    //discoveryClient

    /**
     * 采用json方式传输数据，getforEntity如果说调用失败或其他原因，返回错误码
     *
     * @param id
     * @return
     */
    @RequestMapping("getPaymentById/getEntity/{id}")
    public CommentResult<Payment> getEntityById(@PathVariable(name = "id") Long id) {
        log.info("进来啦getEntity：{}", id);
        //return restTemplate.getForObject(PAYMENT_URL + "/payment/getPaymentById/get/" + id, CommentResult.class);
        ResponseEntity<CommentResult> resultResponseEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/getPaymentById/get/" + id, CommentResult.class);
        if (resultResponseEntity.getStatusCode().is2xxSuccessful()) {
            return resultResponseEntity.getBody();
        } else {
            return new CommentResult<>(499, "处理结果错误");
        }
    }

    @RequestMapping("loadBalance")
    public String getLoadBalance() {
        //获取指定名称的服务的集群信息
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances != null && instances.size() > 0) {
             ServiceInstance serviceInstance = loadBalance.instance(instances);
             URI url = serviceInstance.getUri();
             log.info("本机走了uri：{},instanceId:{},scheme:{},metadat:{}",url,serviceInstance.getInstanceId(),serviceInstance.getScheme(),serviceInstance.getMetadata());
             return  restTemplate.getForObject(url+"/payment/getprot",String.class);
        }else {
            return  null;
        }

    }
}
