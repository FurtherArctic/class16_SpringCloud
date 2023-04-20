package com.powernode.service;

public interface OrdersService {
    /**
     * @param uid     用户id
     * @param goodsId 商品id
     * @param amount  购买数量
     * @return int 插入结果
     */
    int doOrder(Integer uid, Integer goodsId, Integer amount);
}