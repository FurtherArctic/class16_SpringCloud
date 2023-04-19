package com.powernode.service;

/**
 * @author wangjunchen
 */
public interface OrdersService {
    /**
     *
     * @param uid 用户id
     * @param goodsId 商品id
     * @param amount 购买数量
     * @return int
     */
    int doOrder(Integer uid,Integer goodsId,Integer amount);
}
