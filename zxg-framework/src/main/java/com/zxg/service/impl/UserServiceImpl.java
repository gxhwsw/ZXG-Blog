package com.zxg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxg.domain.ResponseResult;
import com.zxg.domain.entity.User;
import com.zxg.domain.vo.UserInfoVo;
import com.zxg.enums.AppHttpCodeEnum;
import com.zxg.exception.SystemException;
import com.zxg.mapper.UserMapper;
import com.zxg.service.UserService;
import com.zxg.utils.BeanCopyUtils;
import com.zxg.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.xml.namespace.QName;
import java.util.Objects;

/**
 * 用户表(User)表服务实现类
 *
 * @author makejava
 * @since 2023-09-19 14:34:39
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {



    @Autowired
    private PasswordEncoder passwordEncoder;
    /**
     *
     * 获取用户id
     * @return {@link ResponseResult}
     */
    @Override
    public ResponseResult userInfo() {
        Long userId=SecurityUtils.getUserId();
        User user = getById(userId);
        UserInfoVo vo = BeanCopyUtils.copyBean(user,UserInfoVo.class);
        return ResponseResult.okResult(vo);
    }

    @Override
    public ResponseResult updateUserInfo(User user) {
        // TODO 可优化
        updateById(user);
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult register(User user) {
        if(!StringUtils.hasText(user.getUserName())){
            throw new SystemException(AppHttpCodeEnum.USERNAME_NOT_NULL);
        }
        if(!StringUtils.hasText(user.getPassword())){
            throw new SystemException(AppHttpCodeEnum.PASSWORD_NOT_NULL);
        }
        if(!StringUtils.hasText(user.getEmail())){
            throw new SystemException(AppHttpCodeEnum.EMAIL_NOT_NULL);
        }
        if(!StringUtils.hasText(user.getNickName())){
            throw new SystemException(AppHttpCodeEnum.NICKNAME_NOT_NULL);
        }

        if(userNameExist(user.getUserName())){
           throw new SystemException(AppHttpCodeEnum.USERNAME_EXIST);
        }

        if(nickNameExist(user.getNickName())){
            throw new SystemException(AppHttpCodeEnum.NICKNAME_EXIST);
        }

        String encodepassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodepassword);
        save(user);
        return ResponseResult.okResult();
    }

    private boolean nickNameExist(String nickName) {
        LambdaQueryWrapper<User> queryWrapper=new LambdaQueryWrapper();
        queryWrapper.eq(User::getNickName,nickName);

        return count(queryWrapper)>0;

    }

    private boolean userNameExist(String userName) {
        LambdaQueryWrapper<User> queryWrapper=new LambdaQueryWrapper();
        queryWrapper.eq(User::getUserName,userName);

        return count(queryWrapper)>0;
    }
}

