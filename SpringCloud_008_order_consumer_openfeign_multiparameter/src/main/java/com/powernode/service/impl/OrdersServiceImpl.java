package com.powernode.service.impl;

import com.powernode.dao.OrdersDao;
import com.powernode.entity.Orders;
import com.powernode.feign.GoodsFeign;
import com.powernode.service.OrdersService;
import com.powernode.vo.Goods;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
    private OrdersDao ordersDao;

    @Resource
    private GoodsFeign goodsFeign;

    @Override
    public int doOrder(Integer uid, Integer goodsId, Integer amount) {
        //使用接口名.方法名，使用openfeign调用,openfeign作用是发出http请求，接收http响应
        Goods goods = goodsFeign.getByGoodsId(goodsId);
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
            //返回下单结果
            return ordersDao.add(orders);
        }
        //下单不成功，返回0
        return 0;
    }
}
