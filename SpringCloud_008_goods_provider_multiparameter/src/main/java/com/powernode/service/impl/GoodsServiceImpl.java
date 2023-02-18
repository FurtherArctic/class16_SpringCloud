package com.powernode.service.impl;

import com.powernode.dao.GoodsDao;
import com.powernode.entity.Goods;
import com.powernode.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wangjunchen
 */
@Service
@Slf4j
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsDao goodsDao;

    @Override
    public Goods getById(Integer id) {
        return goodsDao.getById(id);
    }
}
