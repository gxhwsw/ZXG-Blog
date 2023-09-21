package com.zxg.domain.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gxhhhh
 * @create 2023/9/21 19:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class TagListDto {
    private String name;
    private String remark;
}
