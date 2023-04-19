package com.powernode.dao;

import com.powernode.entity.Orders;

/**
 * @author wangjunchen
 */
public interface OrdersDao {
    /**
     * 添加订单，下订单
     * @param orders
     * @return
     */
    int add(Orders orders);

}
