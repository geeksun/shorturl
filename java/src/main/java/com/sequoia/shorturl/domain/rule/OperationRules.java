package com.sequoia.shorturl.domain.rule;
import org.jeasy.rules.annotation.*;

/**
 * @Description:
 * @Author: jzq
 * @Create: 2022/1/2
 */
/**
 * 定义一个相关的规则
 *
 * @author tony
 * @date 2021/1/14 10:28
 */
//注释以将类标记为规则
@Rule(name = "Operation rule", description = "根据不同的操作进行处理相关事务")
public class OperationRules {

    //将方法标记为规则条件的注释。
    //必须注释任何不带参数的公共方法，并且该方法返回布尔值。
    //@Fact注解：将参数标记为事实的注释。 比对operation这个属性值是否为true，为true将进行action的操作
    @Condition
    public boolean operation(@Fact("operation") boolean operation) {
        return operation;
    }

    //将方法标记为规则操作的注释。
    //必须注释任何不带参数的公共方法。 该方法的返回值将被引擎忽略。
    //注解中的order属性定义action的顺序
    @Action
    public void operationDesc() {
        System.out.println("当操作为true的时候会使用进来");
    }

}

