package com.zxg.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zxg.domain.entity.Role;

import java.util.List;


/**
 * 角色信息表(Role)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-21 11:22:16
 */
public interface RoleMapper extends BaseMapper<Role> {

    List<String> selectRoleKeyByUserId(Long id);
}

