package com.zxg.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zxg.domain.entity.Tag;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;


/**
 * 标签(Tag)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-20 19:56:32
 */

public interface TagMapper extends BaseMapper<Tag> {
@Insert("insert into sg_tag(name,remark) values (#{name},#{remark})")
    void add(String name, String remark);
}

