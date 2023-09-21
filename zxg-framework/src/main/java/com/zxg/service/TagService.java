package com.zxg.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zxg.domain.ResponseResult;
import com.zxg.domain.dto.TagListDto;
import com.zxg.domain.entity.Tag;
import com.zxg.domain.vo.PageVo;


/**
 * 标签(Tag)表服务接口
 *
 * @author makejava
 * @since 2023-09-20 19:56:42
 */
public interface TagService extends IService<Tag> {

    ResponseResult<PageVo> pageTagList(Integer pageNum, Integer pageSize, TagListDto tagListDto);

    void add(String name, String remark);
}
