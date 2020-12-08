package com.fxr.certificate_collector.dto;

import com.fxr.certificate_collector.entity.Certificate;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author fanXiaoRui
 * @date 2020/12/1 10:34
 */
@Data
public class CertificateDTO {

    @ApiModelProperty("证书名")
    private String name;

    @ApiModelProperty("模块id")
    private String moduleId;

    @ApiModelProperty("级别id")
    private String levelId;

    @ApiModelProperty("证书图片地址")
    private String picture;

    @ApiModelProperty("奖项")
    private String awards;

    @ApiModelProperty("分值")
    private Integer fraction;

    @ApiModelProperty("状态")
    private boolean status = false;

    @ApiModelProperty("原因")
    private String reason;

}
