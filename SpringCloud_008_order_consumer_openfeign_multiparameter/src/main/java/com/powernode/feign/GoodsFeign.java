package com.powernode.feign;

import com.powernode.vo.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wangjunchen
 */
@FeignClient(value = "GOODS-PROVIDER")
public interface GoodsFeign {
    /**
     * 根据商品id查询商品信息，方法名和形参名随意取，但路径和请求方法不能改变
     *
     * @param goodsId 商品id
     * @return 商品信息
     */
    @GetMapping("/goods/{id}")
    Goods getByGoodsId(@PathVariable("id") Integer goodsId);
}
