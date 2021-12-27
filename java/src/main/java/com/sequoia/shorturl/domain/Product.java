package com.sequoia.shorturl.domain;

import lombok.Data;

/**
 * @Description:
 * @Author: jzq
 * @Create: 2021/12/27
 */
@Data
public class Product {

    public static final String DIAMOND = "DIAMOND";
    public static final String GOLD = "GOLD";
    private String type;
    private int discount;

}
