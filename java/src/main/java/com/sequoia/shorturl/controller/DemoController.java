package com.sequoia.shorturl.controller;

import com.sequoia.shorturl.domain.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: usr1999
 * @Create: 2021/12/21
 */
@Tag(name="demo", description = "demo api")
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * Mongodb operate
     * @return
     */
    @Operation(summary = "foo", description = "addMongo")
    @RequestMapping("/addMongo")
    public String addMongo() {
        User user = new User("test", true, "Alan", 23, "233", "sz", new Date());
        mongoTemplate.insert(user);

        return "ok";
    }

    @Operation(summary = "query", description = "query mongodb data")
    @RequestMapping("/query")
    public String query() {
        //User user = new User("aaa", false, "赵六", 18, "123456");
        try {
            List<User> users = mongoTemplate.findAll(User.class);
            System.out.println(users);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "ok";
    }

}
