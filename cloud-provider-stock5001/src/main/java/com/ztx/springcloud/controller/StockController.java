package com.ztx.springcloud.controller;

import com.ztx.springcloud.entities.CommentResult;
import com.ztx.springcloud.entity.Stock;
import com.ztx.springcloud.service.StockService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Stock)表控制层
 *
 * @author makejava
 * @since 2020-04-18 20:11:52
 */
@RestController
@RequestMapping("stock")
public class StockController {
    /**
     * 服务对象
     */
    @Resource
    private StockService stockService;
    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Stock selectOne(Integer id) {
        return this.stockService.queryById(id);
    }
    @GetMapping("getStockAll")
    public  List<Stock> getStockAll(){
        return this.stockService.getStockAll();
    };
    @PostMapping("createOrder")
    public CommentResult createOrder(@RequestBody Stock stock){

        stockService.insert(stock);
        //新增商品维护
        redisTemplate.opsForValue().set("stock:"+stock.getId(),stock);
        return new CommentResult(200,"成功了");
    }

/*    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("key",12);
        map.put("key",13);
        System.out.println(  map.put("key",12));
    }*/
}