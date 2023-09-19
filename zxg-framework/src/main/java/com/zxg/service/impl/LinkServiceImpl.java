package com.zxg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zxg.constants.SystemConstants;
import com.zxg.domain.ResponseResult;
import com.zxg.domain.entity.Link;
import com.zxg.domain.vo.LinkVo;
import com.zxg.mapper.LinkMapper;
import com.zxg.service.LinkService;
import com.zxg.utils.BeanCopyUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 友链(Link)表服务实现类
 *
 * @author makejava
 * @since 2023-09-19 10:06:19
 */
@Service("linkService")
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService {


        @Override
        public ResponseResult getAllLink() {
//查询所有审核通过的
            LambdaQueryWrapper<Link> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(Link::getStatus, SystemConstants.LINK_STATUS_NORMAL);
            List<Link> links = list(queryWrapper);
            //转换成vo
            List<LinkVo> linkVos = BeanCopyUtils.copyBeanList(links, LinkVo.class);
//封装返回
            return ResponseResult.okResult(linkVos);
        }

}

