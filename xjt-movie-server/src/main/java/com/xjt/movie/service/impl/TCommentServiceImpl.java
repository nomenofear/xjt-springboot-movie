package com.xjt.movie.service.impl;

import com.xjt.movie.mapper.TMovieCommentMapper;
import com.xjt.movie.service.TCommentService;
import com.xjt.movie.utils.RespBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class TCommentServiceImpl implements TCommentService {
    @Autowired
    private TMovieCommentMapper movieCommentMapper;

    //存放迭代找出的所有子代回复的集合
    private List<Map<String, Object>> tempReplys = new ArrayList<>();

    @Override
    public RespBean getAllCommentsByMovieId(String movie_id) {
        //1、查找所有父节点（对博客的直接评论）
        List<Map<String, Object>> levelOneCommentList = movieCommentMapper.selectAllCommentsByMovieId(movie_id, "-1");

        for (Map<String, Object> levelOneComment : levelOneCommentList) {
            //一级评论的id
            String cid = String.valueOf(levelOneComment.get("comment_id"));
            String username = String.valueOf(levelOneComment.get("username"));

            //一级回复（对评论的直接回复）
            List<Map<String, Object>> levelOneReplysList = movieCommentMapper.selectAllCommentsByMovieId(movie_id, cid);

            if(levelOneReplysList.size() > 0){
                //循环找出子评论的id
                for(Map<String, Object> levelOneReply : levelOneReplysList){
                    levelOneReply.put("parent_comment_nickname",username);
                    String username2 = String.valueOf(levelOneReply.get("username"));
                    tempReplys.add(levelOneReply);
                    String childId = String.valueOf(levelOneReply.get("comment_id"));

                    //查询出子二级评论
                    recursively(movie_id, childId,username2);
                }
            }

            levelOneComment.put("replyComments",tempReplys);
            tempReplys = new ArrayList<>();
        }

        return RespBean.success("ok",levelOneCommentList);
    }

    private void recursively(String movieId, String childId,String parentNickname) {
        //根据子一级回复的id找到子二级回复
        List<Map<String, Object>> replayComments = movieCommentMapper.selectAllCommentsByMovieId(movieId, childId);

        if(replayComments.size() > 0){
            for(Map<String, Object> replayComment : replayComments){
                String replayId = String.valueOf(replayComment.get("comment_id"));
                replayComment.put("parent_comment_nickname",parentNickname);
                String username = String.valueOf(replayComment.get("username"));
                tempReplys.add(replayComment);

                recursively(movieId,replayId,username);
            }
        }
    }
}
