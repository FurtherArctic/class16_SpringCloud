package com.powernode.service.impl;

import com.powernode.dao.OrdersDao;
import com.powernode.entity.Orders;
import com.powernode.service.OrdersService;
import com.powernode.vo.Goods;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wangjunchen
 */
@Service
@Slf4j
public class OrdersServiceImpl implements OrdersService {
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private OrdersDao ordersDao;

    @Override
    public int doOrder(Integer uid, Integer goodsId, Integer amount) {
        //restTemplate调用商品微服务，查询商品信息，restTemplate内部帮我们做了反序列化
        //这是重点
        Goods goods = restTemplate.getForObject("http://localhost:8120/goods/" + goodsId, Goods.class);
        if (goods != null && goods.getStore() > amount) {
            Date currentTime = new Date();
            //创建订单对象
            Orders orders = Orders.builder().uid(uid)
                    .goodsId(goodsId)
                    .status(0)
                    .createTime(currentTime)
                    .updateTime(currentTime)
                    .buyNum(amount)
                    .buyPrice(goods.getPrice())
                    //订单总金额=商品单价乘以购买数量
                    .orderMoney(goods.getPrice().multiply(new BigDecimal(amount)))
                    .build();
            //调用dao下单
            int result = ordersDao.add(orders);
            //返回下单结果
            return result;
        }
        //下单不成功，返回0
        return 0;
    }
}
