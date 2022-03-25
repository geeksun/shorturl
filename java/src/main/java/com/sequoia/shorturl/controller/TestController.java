package com.sequoia.shorturl.controller;

import com.sequoia.shorturl.common.Result;
import com.sequoia.shorturl.domain.User;
import com.sequoia.shorturl.exception.DefinitionException;
/*import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;*/
import com.sequoia.shorturl.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

//@Api(value = "Short url service")
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Resource
    private UserService userService;

    //@ApiOperation(value = "Get a short url based on a long url", notes = "")
    @RequestMapping("/url")
    public String url(HttpServletRequest request) {
        String url = request.getRequestURL().toString();
        System.out.printf("Request access url --> %s\n", url);

        int i = 8 / 0;

        return "ok";
    }

    /**
     * @return 自定义异常
     */
    @RequestMapping("/getDefineException")
    public Result getDefineException() {
        throw new DefinitionException("400", "我出错了");
    }

    @RequestMapping("/test")
    public String test() {
        // userService.foo();

        try {
            StopWatch sw = new StopWatch();
            sw.start("A");
            Thread.sleep(500);
            sw.stop();
            sw.start("B");
            Thread.sleep(300);
            sw.stop();
            sw.start("C");
            Thread.sleep(200);
            sw.stop();
            log.info("各方法耗时: {}", sw.prettyPrint());
        } catch (Exception e){
            log.error("方法执行异常", e);
        }

        return "ok";
    }

}

