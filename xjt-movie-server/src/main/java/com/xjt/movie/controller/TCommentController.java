package com.xjt.movie.controller;

import com.xjt.movie.service.TCommentService;
import com.xjt.movie.utils.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class TCommentController {
    @Autowired
    private TCommentService tCommentService;

    /*通过movie_id 获取所有评论*/
    @GetMapping("/getAllByMoiveId")
    public RespBean getAllCommentsByMovieId(@RequestParam("movie_id") String movie_id) {
        return tCommentService.getAllCommentsByMovieId(movie_id);
    }

}

