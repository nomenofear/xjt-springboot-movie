package com.xjt.movie.service;

import com.xjt.movie.utils.RespBean;

public interface TCommentService {

    public RespBean getAllCommentsByMovieId(String movie_id);
}
