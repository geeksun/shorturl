package com.sequoia.shorturl.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description:
 * @Author: usr1999
 * @Create: 2021/9/11
 */
@Data
public class OrderDetail implements Serializable {
    // 购物车
    Double amount;
    String exCode;
    // Order UUID
    String orderId;
    Double freight;
    String[] itemIds;
    Boolean[] reachables;

    // 商品
    String shopId;
    Long goodsId;
    String skuUuid;
    Integer quantity;


}
