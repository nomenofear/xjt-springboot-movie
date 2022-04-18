package com.xjt.movie.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class TMovieComment {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer movieId;
    private String audience;
    private Double rate;
    private String content;
    private Timestamp createTime;

}
