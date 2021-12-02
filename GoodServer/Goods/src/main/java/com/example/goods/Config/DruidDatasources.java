package com.example.goods.Config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DruidDatasources {
    @Value("${spring.datasource.druid.url}")
    private  final String Url=null;
    @Value("${spring.datasource.druid.username}")
    private final String Username=null;
    @Value("${spring.datasource.druid.password}")
    private  final String pwd=null;
    @Value("${spring.datasource.druid.drive}")
    private  final String driveClass=null;
    @Bean
    @ConditionalOnMissingBean
    public DruidDataSource dataSource(){
        DruidDataSource source = new DruidDataSource();
        source.setUrl(Url);
        source.setUsername(Username);
        source.setPassword(pwd);
        source.setDriverClassName(driveClass);
        return source;
    }
}
