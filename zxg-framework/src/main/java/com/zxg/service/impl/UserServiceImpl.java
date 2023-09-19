package com.zxg.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxg.domain.ResponseResult;
import com.zxg.domain.entity.User;
import com.zxg.mapper.UserMapper;
import com.zxg.service.UserService;
import com.zxg.utils.SecurityUtils;
import org.springframework.stereotype.Service;

/**
 * 用户表(User)表服务实现类
 *
 * @author makejava
 * @since 2023-09-19 14:34:39
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    /**
     *
     * 获取用户id
     * @return {@link ResponseResult}
     */
    @Override
    public ResponseResult userInfo() {
        // TODO 55P
        //Long userId=SecurityUtils.getUserId();

        return null;
    }
}

