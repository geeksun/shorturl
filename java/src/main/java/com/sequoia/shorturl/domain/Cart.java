package com.sequoia.shorturl.domain;

import lombok.Data;

import java.util.List;

/**
 * @Description:
 * @Author: jzq
 * @Create: 2021/12/28
 */
@Data
public class Cart {

    private List<Product> products;
    private double totalAmount;
    private int totalDiscount;

    public boolean isGreaterThanTwoHundered() {
        return totalAmount>200;
    }


}
