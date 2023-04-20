package com.powernode.service;

public interface GoodsService {
    /**
     * @param id     商品id
     * @param amount 商品数量
     * @return 更新结果
     */
    int updateStoreById(Integer id, Integer amount);
}