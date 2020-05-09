package com.ztx.springcloud.controller;

import com.ztx.springcloud.entities.CommentResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("stockOrderController")
public class StockOrderController {
    //用户请求进来，生成订单，依据生成订单的次数来控制请求访问量
    public CommentResult<Object> getOrderInfo(){


        return new CommentResult<>();
    }
}
