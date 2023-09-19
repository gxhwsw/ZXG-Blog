package com.zxg.test;

import com.zxg.ZXGBlogApplication;
import com.zxg.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ZXGBlogApplication.class)
@Transactional
public class ConnectdbTest {

    @Autowired
    private ArticleService articleService;

    @Test
    public void test01(){
        articleService.list();
    }
}
