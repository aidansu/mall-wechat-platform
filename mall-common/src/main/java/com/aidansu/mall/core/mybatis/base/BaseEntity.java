package com.aidansu.mall.core.mybatis.base;

import com.aidansu.mall.core.constant.CommonConstant;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 基础实体类
 *
 * @author Chill
 */
@Data
public class BaseEntity implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 创建人
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "创建人")
    private Long createUser;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = CommonConstant.DEFAULT_DATA_FORMAT)
    @JsonFormat(pattern = CommonConstant.DEFAULT_DATA_FORMAT)
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;
    /**
     * 更新人
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "更新人")
    private Long updateUser;
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = CommonConstant.DEFAULT_DATA_FORMAT)
    @JsonFormat(pattern = CommonConstant.DEFAULT_DATA_FORMAT)
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;
    /**
     * 状态[1:正常]
     */
    @ApiModelProperty(value = "业务状态")
    private Integer status;
    /**
     * 状态[0:未删除,1:删除]
     */
    @TableLogic
    @ApiModelProperty(value = "是否已删除")
    private Integer isDeleted;
}
