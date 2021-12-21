package com.sequoia.shorturl.param;

//import io.swagger.annotations.ApiModelProperty;

//import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotBlank;

/**
 * @Description:
 * @Author: usr1999
 * @Create: 2021/11/25
 */
public class OrderParam {

    @NotBlank(message = "产品名称不能为空")
    //@ApiModelProperty(value = "产品名称")
    //@Schema(name = "产品名称", title = "productName")
    private String productName;

}
