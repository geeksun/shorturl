package com.sequoia.shorturl.service.impl;

import com.sequoia.shorturl.mapper.UserMapper;
import com.sequoia.shorturl.po.User;
import com.sequoia.shorturl.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: jzq
 * @Create: 2022/2/18
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Transactional
    @Override
    public void foo() {
        User user = new User();
        user.setAge(18);
        user.setName("test");
        user.setEmail("test@gamil.com");
        userMapper.insert(user);

        if (true) {
            throw new RuntimeException("Save 抛异常了");
        }
    }

}


