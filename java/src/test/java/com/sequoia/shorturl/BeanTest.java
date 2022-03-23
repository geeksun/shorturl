package com.sequoia.shorturl;

import com.sequoia.shorturl.domain.User;
import com.sequoia.shorturl.util.BeanUtils;
import com.sequoia.shorturl.vo.UserVo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: jzq
 * @Create: 2022/2/17
 */
public class BeanTest {

    public static void main(String[] args) {
        List<User> list = new ArrayList();
        User u = new User();
        u.setAge(18);
        u.setName("demo");
        u.setAddress("test112");
        list.add(u);
        u = new User();
        u.setAge(20);
        u.setName("kitty");
        u.setAddress("sz");
        u.setTime(new Date());
        list.add(u);

        List<UserVo> voList = new ArrayList<>();
        BeanUtils.beanCopy(list, voList);

        System.out.println(voList);

        UserVo vo = new UserVo();
        BeanUtils.beanCopy(u, vo);

        System.out.println(vo);
    }


}


