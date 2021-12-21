package com.sequoia.shorturl.param;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * @Description:
 * @Author: usr1999
 * @Create: 2021/11/25
 */
public class OrderParam {

    @NotBlank(message = "产品名称不能为空")
    @ApiModelProperty(value = "产品名称")
    private String productName;

}
