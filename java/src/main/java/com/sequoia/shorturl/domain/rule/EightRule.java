package com.sequoia.shorturl.domain.rule;
import org.jeasy.rules.annotation.*;

/**
 * @Description:
 * @Author: jzq
 * @Create: 2022/1/2
 */
@Rule(name = "被8整除")
public class EightRule {

    /**
     * 条件
     *
     * @param number
     * @return
     */
    @Condition
    public boolean isEight(@Fact("number") int number) {
        return number % 8 == 0;
    }

    /**
     * 满足条件的动作
     *
     * @param number
     */
    @Action
    public void eightAction(@Fact("number") int number) {
        System.out.println(number + " is eight");
    }

    /**
     * 条件判断的优先级
     *
     * @return
     */
    @Priority
    public int getPriority() {
        return 2;
    }
}
