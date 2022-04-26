package com.xjt.movie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xjt.movie.entity.TMovieComment;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TMovieCommentMapper extends BaseMapper<TMovieComment> {

    List<Map<String, Object>> selectAllCommentsByMovieId(String movieId, String parentId);
}
