package com.zxg.controller;

import com.zxg.constants.SystemConstants;
import com.zxg.domain.ResponseResult;
import com.zxg.domain.dto.AddCommentDto;
import com.zxg.domain.entity.Comment;
import com.zxg.service.CommentService;
import com.zxg.utils.BeanCopyUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@Api(tags = "评论接口")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/commentList")
    @ApiOperation(value = "展示评论列表",notes = "展示文章下方评论")
    public ResponseResult commentList(Long articleId, Integer pageNum, Integer pageSize){
        return commentService.commentList(SystemConstants.ARTICLE_COMMENT,articleId,pageNum,pageSize);
    }

    @PostMapping
    @ApiOperation(value = "添加评论",notes = "添加文章下方评论")
    public ResponseResult addComment(@RequestBody AddCommentDto addCommentDto){
        Comment comment = BeanCopyUtils.copyBean(addCommentDto, Comment.class);
        return commentService.addComment(comment);
    }

    @GetMapping("/linkCommentList")
    @ApiOperation(value = "友链评论列表",notes = "获取友链列表评论")
    @ApiImplicitParams({
                    @ApiImplicitParam(name = " pageNum",value = "页号"),
                    @ApiImplicitParam(name = "pageSize",value = "每页的数量")
            })
    public ResponseResult linkCommentList(Integer pageNum,Integer pageSize){
        return commentService.commentList(SystemConstants.LINK_COMMENT,null,pageNum,pageSize);
    }

}