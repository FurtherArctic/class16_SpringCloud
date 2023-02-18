package com.powernode.controller;

import com.powernode.vo.UserAndMember;
import com.powernode.vo.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author wangjunchen
 */
@RestController
@Slf4j
public class ParameterController {
    /**
     * 传2个或多个基本参数（int string long boolean ....）
     *
     * @param id id
     * @param phone phone
     * @return success/fail
     */
    @GetMapping("/service1")
    public String service1(int id, String phone) {
        log.info("goods2 --> id= " + id + ", phone = " + phone);
        return "success";
    }

    /**
     * 传一个自定义对象参数（user、order）
     * {@code @RequestBody只能传json} {"id":10,"name":"zhangsan","phone":"12345678"}
     * 不加@RequesteBody id=10&name=zhangsan&phone=12345678
     * 如果使用@RequestBody ，不能使用Get请求，因为get请求没有请求体
     *
     * @param users
     * @return
     */
    @PostMapping("/service2")
    public String service2(@RequestBody Users users) {
        log.info("users= " + users);
        return "success";
    }

    //    @PostMapping("/service3")
//    public String service3(@RequestBody Users users, @RequestBody Member member) {
//        log.info("users= {}", users);
//        log.info("member-->{}", member);
//        return "success";
//    }
    @PostMapping("/service4")
    public String service4(@RequestBody UserAndMember userAndMember) {
        log.info("userAndMember= {}", userAndMember);
        return "success";
    }

    /**
     * 传一个集合（List，Map...）
     *
     * @param usersList
     * @return
     */
    @PostMapping("/service5")
    public String service5(@RequestBody List<Users> usersList) {
        log.info("usersList= " + usersList);
        return "success";
    }

    //传两个或多个集合（List，Map...） -- (不行，会报错)
    /*@Override
    public Object product6(List<Users> usersList, Map<String, Orders> ordersMap) {
        System.out.println("goods6 --> usersList= " + usersList + ", ordersMap = " + ordersMap);
        return null;
    }*/

    /**
     * 传一个对象，一个或多个基本参数
     *
     * @param users
     * @param id
     * @param phone
     * @return
     */
    @PostMapping("/service7")
    public String service7(@RequestBody Users users, int id, String phone) {
        log.info("users= " + users + ", phone = " + phone + ",id=" + id);
        return "success";
    }

    //uri路径传参数 /param/{id}
    //http://localhost:8080/service8/500?goodsId=900
    @GetMapping("/service8/{goodsId}")
    public String product8(@PathVariable("goodsId") Integer goodsId) {
        log.info(" goodsId= " + goodsId);
        return "success";
    }

    /**
     * 传一个日期参数
     *
     * @param date
     * @return
     */
    @PostMapping("/service9")
    public String product9(@RequestBody Date date) {
        log.info("date= " + date);
        return "success";
    }
}
