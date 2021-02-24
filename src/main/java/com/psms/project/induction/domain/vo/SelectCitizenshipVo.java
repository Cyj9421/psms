package com.psms.project.induction.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("查询条件参数")
public class SelectCitizenshipVo {
    @ApiModelProperty("国籍名称")
    private String citizenshipName;
}
