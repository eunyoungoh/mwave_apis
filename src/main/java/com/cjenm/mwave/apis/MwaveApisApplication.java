package com.cjenm.mwave.apis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.cjenm.mwave.apis.app.**.mapper")
@SpringBootApplication(scanBasePackages={"com.cjenm.mwave.apis"})
public class MwaveApisApplication {
    static {
        System.setProperty("spring.config.location", "classpath:/config/application.yml, classpath:/config/application-local.yml");
    }

    public static void main(String[] args) {
        SpringApplication.run(MwaveApisApplication.class, args);
    }

}
