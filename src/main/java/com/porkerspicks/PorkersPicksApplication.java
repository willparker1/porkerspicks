package com.porkerspicks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PorkersPicksApplication {

    public static void main(String[] args) {
        SpringApplication.run(PorkersPicksApplication.class, args);
    }
/*
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http       //other configure params.
                .csrf().disable();
    }
*/
}
