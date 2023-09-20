package com.zxg.runner;

import com.zxg.constants.SystemConstants;
import com.zxg.domain.entity.Article;
import com.zxg.mapper.ArticleMapper;
import com.zxg.utils.RedisCache;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class ViewCountRunner implements CommandLineRunner {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private RedisCache redisCache;

    @Override
    public void run(String... args) throws Exception {
        //查询blog信息
        List<Article> articles = articleMapper.selectList(null);
        Map<String, Integer> viewMap = articles.stream().collect(Collectors.toMap(article -> article.getId().toString(), article -> article.getViewCount().intValue()));
        //存储到reids中
        redisCache.setCacheMap(SystemConstants.REDIS_KEY,viewMap);
    }
}
