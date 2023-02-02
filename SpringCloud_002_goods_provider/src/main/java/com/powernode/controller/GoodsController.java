package com.powernode.controller;

import com.powernode.entity.Goods;
import com.powernode.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wangjunchen
 */
@RestController
@Slf4j
public class GoodsController {
    @Resource
    private GoodsService goodsService;

    @GetMapping("/goods/{id}")
    public Goods getById(@PathVariable("id") Integer goodsId) {
        return goodsService.getById(goodsId);
    }
}
