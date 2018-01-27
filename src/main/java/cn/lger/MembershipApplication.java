package cn.lger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@ServletComponentScan
@Controller
@PropertySource("classpath:emailConfig.properties")
public class MembershipApplication {

    public static void main(String[] args) {
        SpringApplication.run(MembershipApplication.class, args);
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

}
