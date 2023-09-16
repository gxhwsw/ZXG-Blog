package com.zxg.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxg.domain.entity.Article;
import com.zxg.mapper.ArticleMapper;
import com.zxg.service.ArticleService;
import org.springframework.stereotype.Service;

/**
 * @author gxhhhh
 * @create 2023/9/15 19:20
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

}
