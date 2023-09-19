package com.zxg.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zxg.domain.ResponseResult;
import com.zxg.domain.entity.Article;
import com.zxg.domain.entity.LoginUser;
import com.zxg.domain.entity.User;
import com.zxg.domain.vo.BlogUserLoginVo;
import com.zxg.domain.vo.UserInfoVo;
import com.zxg.service.BlogLoginService;
import com.zxg.utils.BeanCopyUtils;
import com.zxg.utils.JwtUtil;
import com.zxg.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

/**
 * @author gxhhhh
 * @create 2023/9/15 19:19
 */
@Service
public class BlogLoginServiceImpl implements BlogLoginService {
    @Autowired
    private RedisCache redisCache;
    @Autowired
    private AuthenticationManager authenticationManager;


   @Override
   public ResponseResult login(User user) {
       UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
       Authentication authenticate = authenticationManager.authenticate(authenticationToken);
       //判断是否认证通过
       if(Objects.isNull(authenticate)){
           throw new RuntimeException("用户名或密码错误");
       }
//获取userid 生成token
       LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
       String userId = loginUser.getUser().getId().toString();
       String jwt = JwtUtil.createJWT(userId);
//把用户信息存入redis
       redisCache.setCacheObject("bloglogin:"+userId,loginUser);
//把token和userinfo封装 返回
//把User转换成UserInfoVo
       UserInfoVo userInfoVo = BeanCopyUtils.copyBean(loginUser.getUser(), UserInfoVo.class);
       BlogUserLoginVo vo = new BlogUserLoginVo(jwt,userInfoVo);
       return ResponseResult.okResult(vo);
   }

    @Override
    public ResponseResult logout() {
        return null;
    }
}
