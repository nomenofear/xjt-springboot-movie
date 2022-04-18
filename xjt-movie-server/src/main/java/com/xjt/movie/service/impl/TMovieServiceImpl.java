package com.xjt.movie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xjt.movie.entity.TMovie;
import com.xjt.movie.entity.TMovieComment;
import com.xjt.movie.mapper.TMovieCommentMapper;
import com.xjt.movie.mapper.TMovieMapper;
import com.xjt.movie.service.TMovieService;
import com.xjt.movie.utils.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class TMovieServiceImpl implements TMovieService {
    @Autowired
    private TMovieMapper tMovieMapper;

    @Autowired
    private TMovieCommentMapper movieCommentMapper;


    @Override
    public RespBean getMoviesByPage(Integer showType, Integer currentPage, Integer pageSize,String name, String category,String country,String release) {
        Page<TMovie> page = new Page<>(currentPage, pageSize);

        QueryWrapper<TMovie> wrapper = new QueryWrapper<TMovie>();
        if(StringUtils.hasText(String.valueOf(showType)) && showType != null){
            wrapper.eq("movie_show_type", showType);
        }

        if(StringUtils.hasText(name)){
            wrapper.like("movie_cn_name", name);
        }
        if(StringUtils.hasText(country)){
            wrapper.like("movie_country", country);
        }
        if(StringUtils.hasText(category)){
            wrapper.like("movie_category", category);
        }
        if(StringUtils.hasText(release)){
            wrapper.like("movie_releaseDate", release);
        }
        wrapper.orderByDesc("movie_rank");

        tMovieMapper.selectPage(page,wrapper);

        if(ObjectUtils.isEmpty(page)){
            return RespBean.error("error");
        }else{
            return RespBean.success("success",page);
        }
    }

    @Override
    public RespBean getMovieById(Integer id) {
        TMovie movie = tMovieMapper.selectOne(new QueryWrapper<TMovie>().eq("movie_id",id));

        if(ObjectUtils.isEmpty(movie)){
            return RespBean.error("error");
        }else{
            return RespBean.success("success",movie);
        }
    }

    @Override
    public RespBean getMovieComments(Integer id, Integer num) {
        QueryWrapper<TMovieComment> wrapper = new QueryWrapper<TMovieComment>();
        wrapper.eq("movie_id", id);
        if(!ObjectUtils.isEmpty(num)){
            wrapper.last("limit "+num);
        }

        List<TMovieComment> movieCommentList = movieCommentMapper.selectList(wrapper);

        if(ObjectUtils.isEmpty(movieCommentList)){
            return RespBean.error("error");
        }else{
            return RespBean.success("success",movieCommentList);
        }
    }

}