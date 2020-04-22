package com.ztx.springcloud.dao.impl;

import com.ztx.springcloud.dao.StockDao;
import com.ztx.springcloud.entity.Stock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Slf4j
@Repository
public class StockDaoImpl implements StockDao {
    @Resource
    private JdbcTemplate jdbcTemplate;



    @Override
    public Stock queryById(Integer id) {
        String sql = "select * from stock";
        List<Map<String, Object>>  list=  jdbcTemplate.queryForList(sql,id);
        log.info(list.toString());
        Stock stock = new Stock();
        stock.setList(list);
        return stock;
    }

    @Override
    public List<Stock> queryAllByLimit(int offset, int limit) {
        String sql = "select * from stock";
        List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);
        List<Stock> stockList = new ArrayList<>();
        Stock stock = new Stock();
        stock.setList(list);
        stockList.add(stock);
        return stockList;
    }

    @Override
    public List<Stock> queryAll(Stock stock) {
        return null;
    }

    @Override
    public int insert(Stock stock) {
        return 0;
    }

    @Override
    public int update(Stock stock) {
        return 0;
    }

    @Override
    public int deleteById(Integer id) {
        return 0;
    }
}
