package com.powernode.service.impl;

import com.powernode.dao.GoodsDao;
import com.powernode.dao.OrdersDao;
import com.powernode.entity.Goods;
import com.powernode.entity.Orders;
import com.powernode.service.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

@Service
@Slf4j
public class OrdersServiceImpl implements OrdersService {
    @Resource
    private GoodsDao goodsDao;
    @Resource
    private OrdersDao ordersDao;

    /**
     * @param uid     用户id
     * @param goodsId 商品id
     * @param amount  购买数量
     * @return results 插入结果
     */
    @Override
    public int doOrder(Integer uid, Integer goodsId, Integer amount) {
        //对象名.方法名，调用商品查询信息
        Goods goods = goodsDao.getById(goodsId);
        //该商品存在并且商品库存大于购买数量，允许下单
        if (goods != null && goods.getStore() > amount) {
            Date currentTime = new Date();
            //创建订单对象
            Orders orders = Orders.builder().uid(uid).goodsId(goodsId).status(0).createTime(currentTime).updateTime(currentTime).buyNum(amount).buyPrice(goods.getPrice())
                    //订单总金额=商品单价乘以购买数量
                    .orderMoney(goods.getPrice().multiply(new BigDecimal(amount))).build();
            //调用dao下单
            int result = ordersDao.add(orders);
            log.info("下单成功：" + result);
            //返回下单结果
            return result;
        }
        //下单不成功
        log.info("库存不足");
        return 0;
    }
}