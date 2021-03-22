package com.psms.project.attendance.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class AskVo {
    private String workNum;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date nowDateTime;
}
