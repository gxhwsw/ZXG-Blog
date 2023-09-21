package com.zxg.constants;

/**
 * @author gxhhhh
 * @create 2023/9/18 16:22
 */
public class SystemConstants {
    /**
     *  文章是草稿
     */
    public static final int ARTICLE_STATUS_DRAFT = 1;
    /**
     *  文章是正常分布状态
     */
    public static final int ARTICLE_STATUS_NORMAL = 0;

    public static final String STATUS_NORMAL="0";
    /**
     * 友链审核通过
     */
    public static final String LINK_STATUS_NORMAL="0";
    /**
     *评论类型  文章评论
     */
    public static final String ARTICLE_COMMENT = "0";
    /**
     *评论类型  友链评论
     */
    public static final String LINK_COMMENT = "1";

    /**
     *获取游览量的key值
     */
    public static final String REDIS_KEY="Article:viewCount";

    public static final String MENU="C";
    public static final String BUTTON="F";
}
