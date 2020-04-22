package com.ztx.springcloud.controller;

import com.ztx.springcloud.entity.Stock;
import com.ztx.springcloud.service.StockService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

}