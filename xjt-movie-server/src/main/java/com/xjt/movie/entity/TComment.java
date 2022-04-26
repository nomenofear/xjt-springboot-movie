package com.xjt.movie.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class TComment implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long commentId;

    private Integer userId;
    private String content;
    private Integer movieId;
    private Integer score;
    private Long parentCommentId;
    private Integer style;
    private Timestamp createTime;
}
