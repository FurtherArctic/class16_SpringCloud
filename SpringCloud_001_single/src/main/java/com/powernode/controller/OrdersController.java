package com.powernode.controller;

import com.powernode.service.OrdersService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wangjunchen
 */
@RestController
public class OrdersController {
    @Resource
    private OrdersService ordersService;

    @PostMapping("/doOrder")
    public String doOrders(Integer goodsId, Integer amount) {
        Integer userId = 1;
        int result = ordersService.doOrder(userId, goodsId, amount);

        if (result > 0) {
            return "success";
        } else {
            return "fail";
        }
    }

}
