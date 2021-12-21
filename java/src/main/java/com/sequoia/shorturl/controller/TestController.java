package com.sequoia.shorturl.controller;

import com.sequoia.shorturl.common.Result;
import com.sequoia.shorturl.domain.User;
import com.sequoia.shorturl.exception.DefinitionException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Api(value = "Short url service")
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @ApiOperation(value = "Get a short url based on a long url", notes = "")
    @RequestMapping("/url")
    public String url(HttpServletRequest request) {
        String url = request.getRequestURL().toString();
        System.out.printf("Request access url --> %s\n", url);

        int i = 8 / 0;

        return "ok";
    }

    @RequestMapping("/getDeException")
    public Result DeException() {
        throw new DefinitionException("400", "我出错了");
    }

    /**
     * Mongodb operate
     * @return
     */
    @RequestMapping("/addMongo")
    public String addMongo() {
        User user = new User("aaa", false, "赵六", 18, "123456");
        mongoTemplate.insert(user);

        return "ok";
    }

    @RequestMapping("/query")
    public String query() {
        //User user = new User("aaa", false, "赵六", 18, "123456");
        try {
            List<User> users = this.mongoTemplate.findAll(User.class);
            System.out.println(users);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "ok";
    }

}
