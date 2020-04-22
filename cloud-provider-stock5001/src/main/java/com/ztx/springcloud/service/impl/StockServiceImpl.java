package com.ztx.springcloud.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ztx.springcloud.entity.Stock;
import com.ztx.springcloud.dao.StockDao;
import com.ztx.springcloud.service.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * (Stock)表服务实现类
 *
 * @author makejava
 * @since 2020-04-18 20:11:52
 */
@Slf4j
@Service("stockService")
public class StockServiceImpl implements StockService {
    @Resource
    private StockDao stockDao;
    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Stock queryById(Integer id) {
        return this.stockDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Stock> queryAllByLimit(int offset, int limit) {
        return this.stockDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param stock 实例对象
     * @return 实例对象
     */
    @Override
    public Stock insert(Stock stock) {
        this.stockDao.insert(stock);
        return stock;
    }

    /**
     * 修改数据
     *
     * @param stock 实例对象
     * @return 实例对象
     */
    @Override
    public Stock update(Stock stock) {
        this.stockDao.update(stock);
        return this.queryById(stock.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.stockDao.deleteById(id) > 0;
    }

    @Override
    public List<Stock> getStockAll() {
        List<Stock> list = this.stockDao.queryAllByLimit(1,1);
        String listJson = JSON.toJSONString(list);
        Long diff = 10L;//有效期
        redisTemplate.opsForValue().set("listkey",listJson,diff, TimeUnit.SECONDS);//
        redisTemplate.opsForValue().set("mykey",123);
        log.info("参数值："+redisTemplate.opsForValue().get("listkey"));
      return list;
    }
}