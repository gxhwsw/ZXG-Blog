package com.zxg.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zxg.domain.ResponseResult;
import com.zxg.domain.entity.Comment;


/**
 * 评论表(Comment)表服务接口
 *
 * @author makejava
 * @since 2023-09-19 14:27:20
 */
public interface CommentService extends IService<Comment> {

    ResponseResult commentList(Long articleId, Integer pageNum, Integer pageSize);
}

