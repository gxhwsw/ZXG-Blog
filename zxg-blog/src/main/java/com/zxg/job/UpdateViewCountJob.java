package com.zxg.job;

import com.zxg.constants.SystemConstants;
import com.zxg.domain.entity.Article;
import com.zxg.service.ArticleService;
import com.zxg.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class UpdateViewCountJob {

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private ArticleService articleService;

//    Long.valueOf(entry.getKey()),entry.getValue().longValue())
    @Scheduled(cron = "0/55 * * * * ?")
    public void updateViewCount(){
        //获取redis中的浏览量
        Map<String, Integer> viewCountMap = redisCache.getCacheMap(SystemConstants.REDIS_KEY);

        List<Article> articles = viewCountMap.entrySet()
                .stream()
                .map(entry ->{
                    Article article=new Article();
                    article.setId(Long.valueOf(entry.getKey()));
                    article.setViewCount(entry.getValue().longValue());
                    return article;
                })
                .collect(Collectors.toList());
        //更新到数据库中
        articleService.updateBatchById(articles);
        System.out.println("定时刷新任务......");
    }
}
