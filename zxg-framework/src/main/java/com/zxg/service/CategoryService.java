package com.zxg.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zxg.domain.ResponseResult;
import com.zxg.domain.entity.Category;


/**
 * 分类表(Category)表服务接口
 *
 * @author makejava
 * @since 2023-09-18 17:34:36
 */
public interface CategoryService extends IService<Category> {

    ResponseResult getCategoryList();
}
