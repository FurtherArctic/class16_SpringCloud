package com.powernode.service.impl;

import com.powernode.dao.GoodsDao;
import com.powernode.entity.Goods;
import com.powernode.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsDao goodsDao;

    /**
     * @param id     商品id
     * @param amount 商品数量
     * @return 更新结果
     */
    @Override
    public int updateStoreById(Integer id, Integer amount) {
        //对象名.方法名，调用商品查询信息
        Goods goods = goodsDao.getById(id);
        //该商品存在并且商品库存大于购买数量，允许下单
        if (goods != null && goods.getStore() > amount) {
            int result = goodsDao.updateStoreById(id, amount);
            log.info("更新库存成功：" + result);
            return result;
        } else {
            log.info("库存不足");
            return 0;
        }
    }
}