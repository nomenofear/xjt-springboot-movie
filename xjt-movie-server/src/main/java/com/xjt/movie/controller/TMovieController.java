package com.xjt.movie.controller;

import com.xjt.movie.service.TMovieService;
import com.xjt.movie.utils.RespBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 电影表(TMovie)表控制层
 *
 * @author makejava
 * @since 2021-12-26 20:35:42
 */
@Slf4j
@RestController
@RequestMapping("movie")
public class TMovieController {
    @Autowired
    private TMovieService tMovieService;

    /**
     * 正在上映  /getMoviesByPage?showType=1&currentPage=1&pageSize=20&name='天'&category='动作'&release='2012'
     */
    @GetMapping("/getMoviesByPage")
    public RespBean getMoviesByPage(
            @RequestParam(value = "showType", required = false) Integer showType,
            @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "category", required = false) String category,
            @RequestParam(value = "country", required = false) String country,
            @RequestParam(value = "release", required = false) String release,
            HttpServletRequest request
    ) {
        log.warn("showType===>"+showType);
        log.warn("currentPage===>"+currentPage);
        log.warn("pageSize===>"+pageSize);
        log.warn("name===>"+name);
        log.warn("category===>"+category);
        log.warn("country===>"+country);
        log.warn("release===>"+release);
        System.out.println(request.getParameter("currentPage"));
        return this.tMovieService.getMoviesByPage(showType, currentPage, pageSize, name, category,country, release);
    }

    @GetMapping("/getById")
    public RespBean getMovieById(@RequestParam(value = "id") Integer id) {
        return this.tMovieService.getMovieById(id);
    }

    @GetMapping("/getComments")
    public RespBean getMovieComments(@RequestParam(value = "movieId") Integer movieId,
                                     @RequestParam(value = "num") Integer num) {
        return this.tMovieService.getMovieComments(movieId,num);
    }


}