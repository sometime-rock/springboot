package com.yan.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringbootApplication {
    @Value("${book.name}")
    public String bookname;
    @Value("${book.date}")
    public String bookdate;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }
    @RequestMapping("/")
    public String index(){
        return "Hello Springboot " +bookdate +"  ;"+bookname;
    }

}
