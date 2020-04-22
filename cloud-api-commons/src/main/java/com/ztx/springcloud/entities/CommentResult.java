package com.ztx.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentResult<T> {
    private  Integer code = 200;//404类似
    private String message = "成功";
    private T data;
    //自定义俩参数的
    public CommentResult(Integer code , String message){
        this(code,message,null);
    }
}
