package com.psms.project.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SysCardRep {
    /** 补卡id  */
    private Long replacementId;
    /** 员工工号 */
    private String workNum;
    /** 员工姓名 */
    private String fullName;
    /** 部门名称 */
    private String deptName;
    /** 职位名称 */
    private String postName;
    /** 部门领导 */
    private String deptLeader;
    /** 补卡原因 */
    private String reason;
    /** 补卡状态 */
    private char cardStatus;
    /** 创建人  */
    private String createBy;
    /** 创建时间  */
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;
    /** 更新人  */
    private String updateBy;
    /** 更新时间  */
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date updateTime;
}
