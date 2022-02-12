package com.sequoia.shorturl.domain.rule;
import org.jeasy.rules.annotation.*;

/**
 * @Description:
 * @Author: jzq
 * @Create: 2022/1/2
 */
@Rule(name = "weather rule", description = "if it rains then take an umbrella" )
public class WeatherRule {
    @Condition
    public boolean itRains(@Fact("rain") boolean rain) {
        return rain;
    }

    @Action
    public void takeAnUmbrella() {
        System.out.println("It rains, take an umbrella!");
    }

}