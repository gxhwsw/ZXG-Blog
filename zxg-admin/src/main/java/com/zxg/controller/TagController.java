package com.zxg.controller;

import com.zxg.domain.ResponseResult;
import com.zxg.domain.dto.TagListDto;
import com.zxg.domain.vo.PageVo;
import com.zxg.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author gxhhhh
 * @create 2023/9/20 20:13
 */
@RestController
@RequestMapping("/content/tag")
public class TagController {
    @Autowired
    private TagService tagService;

    @GetMapping("/list")
    public ResponseResult<PageVo> list(Integer pageNum, Integer pageSize, TagListDto tagListDto){
        return tagService.pageTagList(pageNum,pageSize,tagListDto);
    }
    @PostMapping
    public ResponseResult add(@RequestBody String name, String remark){
        tagService.add(name,remark);
        return ResponseResult.okResult();

    }
}
