package com.powernode.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wangjunchen
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Orders implements Serializable {
    private Integer id;

    private Integer uid;

    private Integer goodsId;

    private Integer buyNum;

    private BigDecimal buyPrice;

    private BigDecimal orderMoney;

    private Date createTime;

    private Date updateTime;

    private Integer status; //默认0 未未支付，1 代表已支付，2代表超时未支付
}
