package com.xiaozhai.Action;

import com.alibaba.fastjson.JSONObject;
import com.xiaozhai.Enum.EnumResponse;
import com.xiaozhai.Exception.Responses;
import com.xiaozhai.Pojo.Category;
import com.xiaozhai.Pojo.Goods;
import com.xiaozhai.Service.CategoryService;
import com.xiaozhai.Service.GoodsService;
import com.xiaozhai.Utils.JMSProducer;
import com.xiaozhai.Utils.RedisHelper;
import com.xiaozhai.test01.Service.Category2Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloAction {

    private Logger logger = LoggerFactory.getLogger(HelloAction.class);

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private RedisHelper redisHelper;

    @Autowired
    private JMSProducer jmsProducer;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private Category2Service category2Service;

    @RequestMapping(value = "hello.do")
    public String hello(){
        //jmsProducer.send("springboot","hello");
        Category category1 = category2Service.selectByPrimaryKey(1240);
        Category category = categoryService.selectByPrimaryKey(1240);
        String categoryJson = JSONObject.toJSONString(category);
        String categoryJson1 = JSONObject.toJSONString(category1);
        logger.info("1.103："+categoryJson);
        logger.info("10.128："+categoryJson1);
        return "index";
    }


    @RequestMapping(value = "/query")
    @ResponseBody
    public Responses query(@RequestParam(value = "goodsId",required = true,defaultValue = "3022145") Integer goodsId) throws Exception {
        Responses<String> responses = new Responses();
        String checkGoodsJson = redisHelper.get(goodsId+"");
        if(checkGoodsJson==null || "".equals(checkGoodsJson)){
            Goods goods = goodsService.selectByPrimaryKey(goodsId);
            String goodsJson = JSONObject.toJSONString(goods);
            redisHelper.set(goodsId+"",goodsJson);
            checkGoodsJson = goodsJson;
        }
        responses.setCode(EnumResponse.CODESUCCESS.getCode());
        responses.setMsg(EnumResponse.CODESUCCESS.getMsg());
        responses.setData(checkGoodsJson);
        return responses;
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
