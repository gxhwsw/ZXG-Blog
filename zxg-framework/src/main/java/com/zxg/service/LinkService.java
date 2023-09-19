package com.zxg.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zxg.domain.ResponseResult;
import com.zxg.domain.entity.Link;

/**
 * 友链(Link)表服务接口
 *
 * @author makejava
 * @since 2023-09-19 10:06:19
 */
public interface LinkService extends IService<Link> {

    ResponseResult getAllLink();
}

