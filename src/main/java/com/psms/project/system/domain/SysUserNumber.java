package com.psms.project.system.domain;

import com.psms.framework.web.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * 实体 员工工号表
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SysUserNumber extends BaseEntity {
    /** 工号id */
    private int workId;
    /** 工号 */
    private String workNum;
    /** 工号开头id */
    private int headId;
    /** 部门id */
    private Long deptId;
    /** 岗位id */
    private Long postId;
    /** 员工姓名 */
    private String fullName;
    /** 工号使用状态(0,正常使用,1,注销) */
    private int useStatus;
    /** 工号创建者 */
    private String createBy;
    /** 工号创建时间 */
    private Date createTime;
    /** 工号修改者 */
    private String updateBy;
    /** 工号修改时间 */
    private Date updateTime;
    /** 岗位编码 */
    private String postCode;
    /** 岗位名称 */
    private String postName;
    /** 部门名称 */
    private String deptName;
    /** 负责人 */
    private String leader;
}
