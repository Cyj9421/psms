package com.psms.project.attendance.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("考勤返回参数表")
public class AttendanceVo {
    @ApiModelProperty("考勤id")
    private int attendanceId;
    @ApiModelProperty("工号")
    private String workNum;
    @ApiModelProperty("姓名")
    private String fullName;
    @ApiModelProperty("部门名称")
    private String deptName;
    @ApiModelProperty("岗位名称")
    private String postName;
    @ApiModelProperty("是否加班(1:否；2：是)")
    private int isOvertime;
    @ApiModelProperty("是否迟到(1:否；2：是)")
    private int isLate;
    @ApiModelProperty("是否早退(1:否；2：是)")
    private int isEarly;
    @ApiModelProperty("是否缺勤(1:否；2：是)")
    private int isAbsenteeism;
    @ApiModelProperty("是否请假(1:否；2：是)")
    private int isAsk;
    @ApiModelProperty("是否休假(1:否；2：是)")
    private int isVacate;
    @ApiModelProperty("上班打卡时间")
    @JsonFormat(pattern = "HH:mm:ss")
    private Date startTime;
    @ApiModelProperty("下班打卡时间")
    @JsonFormat(pattern = "HH:mm:ss")
    private Date endTime;
    @ApiModelProperty("考勤状态(1:正常；2：异常)")
    private int attendanceStatus;
    @ApiModelProperty("考勤日期")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date attendanceDate;
    @ApiModelProperty("查询类型(1未出勤,2休假中,3迟到,4早退,5旷工,6犯错,7已出勤)")
    private int selectType;
}
