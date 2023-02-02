package com.powernode.controller;

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

    @PostMapping("/doOrder")
    public String doOrder(Integer goodsId, Integer amount) {
        log.info("进入订单微服务");
        Integer userId = 1002;
        int result = ordersService.doOrder(userId, goodsId, amount);
        if (result > 0) {
            return "success";
        }
        return "fail";
    }
}
