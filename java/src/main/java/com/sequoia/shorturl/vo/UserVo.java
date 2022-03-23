package com.sequoia.shorturl.vo;

import lombok.Data;

/**
 * @Description:
 * @Author: jzq
 * @Create: 2022/2/17
 */
@Data
public class UserVo {

    private String name;

    private boolean working;

    private String aboutMe;

    private int age;

    private String email;

    private String gender;

    private String time;
}
