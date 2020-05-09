package com.ztx.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ztx.springcloud.entities.CommentResult;

/**
 * 自定义异常处理
 */
public class CustomerBlockHandler {
    public  static CommentResult handlerExeception(BlockException e){
        return new CommentResult(4040,"客户自定义异常信息处理："+e.getClass().getName());
    }
    public  static CommentResult handlerExeception2(BlockException e){
        return new CommentResult(4040,"客户自定义异常信息处理2："+e.getClass().getName());
    }
}
