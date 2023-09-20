package com.zxg.controller;

import com.zxg.domain.ResponseResult;
import com.zxg.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author gxhhhh
 * @create 2023/9/15 19:24
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

//    @GetMapping("/list")
//    public List<Article> test(){
//        return articleService.list();
//    }
@GetMapping("/hotArticleList")
public ResponseResult hotArticleList(){
//查询热门文章，封装成ResponseResult
    ResponseResult result =  articleService.hotArticleList();
    return result;
}

    @GetMapping("/articleList")
    public ResponseResult articleList(Integer pageNum,Integer pageSize,Long categoryId){
        return articleService.articleList(pageNum,pageSize,categoryId);
    }
    @GetMapping("/{id}")
    public ResponseResult getArticleDetail(@PathVariable("id") Long id){
        return articleService.getArticleDetail(id);
    }

    @PutMapping("/updateViewCount/{id}")
    public ResponseResult updateVoewCount(@PathVariable("id") Long id){
        return articleService.updateVoewCount(id);
    }
}
