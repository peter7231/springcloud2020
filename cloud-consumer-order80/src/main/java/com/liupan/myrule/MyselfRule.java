package com.liupan.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author LiuPan
 * @Since 2020/7/25 10:22
 */
@Configuration
public class MyselfRule {

    @Bean
    public IRule myRule(){
        return  new RandomRule();
    }
}
