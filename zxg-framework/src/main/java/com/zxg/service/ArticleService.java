package com.zxg.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zxg.domain.ResponseResult;
import com.zxg.domain.entity.Article;

/**
 * @author gxhhhh
 * @create 2023/9/15 19:19
 */
public interface ArticleService extends IService<Article> {
    ResponseResult hotArticleList();

        ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId);

    ResponseResult getArticleDetail(Long id);
}
