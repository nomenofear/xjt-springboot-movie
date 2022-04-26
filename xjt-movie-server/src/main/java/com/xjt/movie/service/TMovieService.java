package com.xjt.movie.service;

import com.xjt.movie.utils.RespBean;

public interface TMovieService {
    RespBean getMoviesByPage(Integer showType, Integer currentPage, Integer pageSize, String name,String category,String country,String release);

    RespBean getMovieById(Integer id);

    RespBean getMovieComments(Integer movieId, Integer num);
}