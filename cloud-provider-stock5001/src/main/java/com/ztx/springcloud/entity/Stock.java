package com.ztx.springcloud.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * (Stock)实体类
 *
 * @author makejava
 * @since 2020-04-18 20:11:52
 */
public class Stock implements Serializable {
    private static final long serialVersionUID = 201534015001344060L;
    
    private Integer id;
    /**
    * 商品名称
    */
    private String product;
    /**
    * 商品图片
    */
    private String img;
    /**
    * 商品价格
    */
    private Double price;
    /**
    * 商品单位
    */
    private String unit;
    /**
    * 商品标题
    */
    private Object title;
    /**
    * 商品种类
    */
    private Integer typeId;
    /**
    * 商品规格
    */
    private String spec;
    /**
    * 商品库存
    */
    private Integer stock;
    /**
    * 商品装态 1：上架 2下架 3无效
    */
    private Integer status;
    /**
    * 商品二级分类
    */
    private Integer typePid;
    
    private String productno;
    
    private Integer shopsId;
    /**
    * 折扣标志位(1.参与打折 2.不参与打着)
    */
    private Integer discountFlag;
    
    private Integer tjstatus;
    /**
    * 0 不折扣  1  
    */
    private Integer flag;
    /**
    * 一级分类
    */
    private Integer typePpid;
    /**
    * 商品总购买人数
    */
    private Integer buyNumber;
    
    private Object content;
    
    private Double netweight;
    
    private Double grossweight;
    /**
    * 商品简称
    */
    private String productsimple;

    private List<Map<String,Object>> list;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<Map<String, Object>> getList() {
        return list;
    }

    public void setList(List<Map<String, Object>> list) {
        this.list = list;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Object getTitle() {
        return title;
    }

    public void setTitle(Object title) {
        this.title = title;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTypePid() {
        return typePid;
    }

    public void setTypePid(Integer typePid) {
        this.typePid = typePid;
    }

    public String getProductno() {
        return productno;
    }

    public void setProductno(String productno) {
        this.productno = productno;
    }

    public Integer getShopsId() {
        return shopsId;
    }

    public void setShopsId(Integer shopsId) {
        this.shopsId = shopsId;
    }

    public Integer getDiscountFlag() {
        return discountFlag;
    }

    public void setDiscountFlag(Integer discountFlag) {
        this.discountFlag = discountFlag;
    }

    public Integer getTjstatus() {
        return tjstatus;
    }

    public void setTjstatus(Integer tjstatus) {
        this.tjstatus = tjstatus;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getTypePpid() {
        return typePpid;
    }

    public void setTypePpid(Integer typePpid) {
        this.typePpid = typePpid;
    }

    public Integer getBuyNumber() {
        return buyNumber;
    }

    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public Double getNetweight() {
        return netweight;
    }

    public void setNetweight(Double netweight) {
        this.netweight = netweight;
    }

    public Double getGrossweight() {
        return grossweight;
    }

    public void setGrossweight(Double grossweight) {
        this.grossweight = grossweight;
    }

    public String getProductsimple() {
        return productsimple;
    }

    public void setProductsimple(String productsimple) {
        this.productsimple = productsimple;
    }



}