package com.xjt.movie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xjt.movie.entity.TMovie;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TMovieMapper extends BaseMapper<TMovie> {

}