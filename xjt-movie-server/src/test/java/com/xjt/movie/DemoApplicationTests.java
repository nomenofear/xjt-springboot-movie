package com.xjt.movie;

import com.xjt.movie.utils.MyMailUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        String mailCode = MyMailUtil.sendMail("1351655382@qq.com");
        System.out.println(mailCode);
    }

}
