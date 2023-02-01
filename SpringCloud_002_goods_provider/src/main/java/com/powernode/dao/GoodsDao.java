package com.powernode.dao;

import com.powernode.entity.Goods;
import org.apache.ibatis.annotations.Param;

/**
 * @author wangjunchen
 */
public interface GoodsDao {
    /**
     * 根据id获取商品详情
     * @param id
     * @return
     */
    Goods getById(@Param("id") Integer id);

    /**
     * 根据商品id更新该商品的库存
     * @param id
     * @param amount
     * @return
     */
    int updateStoreById(@Param("id") Integer id, @Param("amount") Integer amount);
}
