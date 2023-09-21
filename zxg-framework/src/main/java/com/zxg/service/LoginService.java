package com.zxg.service;

import com.zxg.domain.ResponseResult;
import com.zxg.domain.entity.User;

/**
 * @author gxhhhh
 * @create 2023/9/15 19:19
 */
public interface LoginService {

    ResponseResult login(User user);


    ResponseResult logout();
}
