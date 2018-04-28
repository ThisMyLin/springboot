package com.xiaozhai.Action;

import com.alibaba.fastjson.JSONObject;
import com.xiaozhai.Pojo.Goods;
import com.xiaozhai.Service.GoodsService;
import com.xiaozhai.Utils.RedisHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class HelloAction {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private RedisHelper redisHelper;

    @RequestMapping(value = "/query")
    public String query(@RequestParam(value = "goodsId",required = true,defaultValue = "24817") Integer goodsId) throws SQLException {
        String checkGoodsJson = redisHelper.get(goodsId+"");
        if(checkGoodsJson==null || "".equals(checkGoodsJson)){
            Goods goods = goodsService.selectByPrimaryKey(goodsId);
            String goodsJson = JSONObject.toJSONString(goods);
            redisHelper.set(goodsId+"",goodsJson);
            checkGoodsJson = goodsJson;
        }
        return checkGoodsJson;
    }

    @RequestMapping(value = "/del")
    public String delete(@RequestParam(value = "goodsId",required = true,defaultValue = "0") Integer goodsId){
        goodsService.deleteByPrimaryKey(goodsId);
        redisHelper.del(goodsId+"");
        return "200";
    }

    @RequestMapping(value = "/update")
    public String update(Goods goods){
        if(goods==null || goods.getGoodsId()==0) return "400";
        goodsService.updateGoods(goods);
        String goodsJson = JSONObject.toJSONString(goods);
        redisHelper.set(goods.getGoodsId()+"",goodsJson);
        return "200";
    }

    @RequestMapping(value = "/insert")
    public String insert(Goods goods){
        if(goods==null || goods.getGoodsId()==0) return "400";
        goodsService.insertGoods(goods);
        String goodsJson = JSONObject.toJSONString(goods);
        redisHelper.set(goods.getGoodsId()+"",goodsJson);
        return "200";
    }
}
