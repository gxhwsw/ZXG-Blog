package com.zxg.domain.dto;
import java.util.Date;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 评论表(Comment)表实体类
 *
 * @author makejava
 * @since 2023-09-19 14:27:20
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sg_comment")
@ApiModel(value = "添加评论dto")
public class AddCommentDto {
    @TableId
    @ApiModelProperty(value = "评论id")
    private Long id;

    //评论类型（0代表文章评论，1代表友链评论）
    @ApiModelProperty(value = "评论类型")
    private String type;
    //文章id
    @ApiModelProperty(value = "文章id")
    private Long articleId;
    //根评论id
    @ApiModelProperty(value = "父评论id")
    private Long rootId;
    //评论内容
    @ApiModelProperty(value = "评论id")
    private String content;
    //所回复的目标评论的userid
    @ApiModelProperty(value = "所回复的目标评论的userid")
    private Long toCommentUserId;
    //回复目标评论id
    @ApiModelProperty(value = "回复目标评论id")
    private Long toCommentId;
    /**
     * 创建人的用户id
     */
    @ApiModelProperty(value = "创建人的用户id")
    @TableField(fill = FieldFill.INSERT)
    private Long createBy;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    /**
     * 更新人
     */
    @ApiModelProperty(value = "更新人")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateBy;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    //删除标志（0代表未删除，1代表已删除）
    @ApiModelProperty(value = "删除状态")
    private Integer delFlag;



}
