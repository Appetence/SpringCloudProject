package com.ztx.springcloud.controller;

import com.ztx.springcloud.entities.CommentResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("stockOrderController")
public class StockOrderController {

    public CommentResult<Object> getOrderInfo(){


        return new CommentResult<>();
    }
}
