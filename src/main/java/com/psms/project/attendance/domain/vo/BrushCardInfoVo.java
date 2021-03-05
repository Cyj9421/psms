package com.psms.project.attendance.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class BrushCardInfoVo {
    /** 姓名 */
    private String fullName;
    /** 部门名称 */
    private String deptName;
    /** 工号 */
    private String workNum;
    /** 个人照片 */
    private String personalPhoto;
    /** 剩余可刷次数 */
    private int brushNum;
    /** 携带人数 */
    private int carryNum;
    /** 刷卡时间 */
    private String BrushCardTime;
}
