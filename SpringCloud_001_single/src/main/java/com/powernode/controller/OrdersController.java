package com.powernode.controller;

import com.powernode.service.GoodsService;
import com.powernode.service.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wangjunchen
 */
@RestController
@Slf4j
public class OrdersController {
    @Resource
    private OrdersService ordersService;
    @Resource
    private GoodsService goodsService;

    @PostMapping("/doOrder")
    public String doOrders(Integer goodsId, Integer amount) {
        Integer userId = 1;
        int orderResult = ordersService.doOrder(userId, goodsId, amount);
        int updateResult = goodsService.updateStoreById(goodsId, amount);
        if (orderResult > 0 && updateResult > 0) {
            log.info("下单成功，库存更新成功");
            return "success";
        } else {
            log.info("下单失败");
            return "fail";
        }
    }

}