package com.xjt.movie;

import com.xjt.movie.service.impl.TCommentServiceImpl;
import com.xjt.movie.utils.MyMailUtil;
import com.xjt.movie.utils.RespBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private TCommentServiceImpl commentService;

    @Test
    void contextLoads() {
        RespBean allCommentsByMovieId = commentService.getAllCommentsByMovieId("1291543");
        System.out.println(allCommentsByMovieId);
    }

}
