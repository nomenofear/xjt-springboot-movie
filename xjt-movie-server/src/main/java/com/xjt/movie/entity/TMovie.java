package com.xjt.movie.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 电影表(TMovie)实体类
 *
 * @author makejava
 * @since 2021-12-26 20:35:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class TMovie implements Serializable {
    private static final long serialVersionUID = 629219933297281709L;
    /**
    * 电影id
    */
    @TableId(type = IdType.AUTO)
    private Integer movieId;
    /**
    * 电影中文名
    */
    private String movieCnName;
    /**
    * 电影英文名
    */
    private String movieFgName;
    /**
    * 演员
    */
    private String movieActor;
    /**
    * 导演
    */
    private String movieDirector;
    /**
    * 电影介绍
    */
    private String movieDetail;
    /**
    * 时长
    */
    private String movieDuration;
    /**
    * 分类，1-爱情，2-喜剧，3-动画，4-剧情，5-恐怖，6-科幻，7-动作，8-战争，9-犯罪，10-武侠，11-灾难，12-纪录片，13--其他
    */
    private String movieCategory;
    /**
    * 评分
    */
    private String movieScore;
    /**
    * 票房
    */
    private String movieBoxoffice;
    /**
    * 评论数
    */
    private String movieCommentcount;
    /**
    * 电影封面图
    */
    private String moviePicture;
    /**
    * 国家，1-中国，2-日本，3-韩国，4-美国，5-欧洲，6-印度，7-东南亚，8-俄罗斯，9-其他
    */
    private String movieCountry;
    /**
    * 状态，1-上映中，2-即将上映，3-已下架
    */
    private Integer movieShowType;
    /**
    * 上映时间
    */
    private String movieReleasedate;
    /**
    * 分类排名
    */
    private Integer movieRank;
}