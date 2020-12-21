package com.psms.project.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
 * 权限表 sys_acount_permissions
 *
 */
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SysAcountPermissions {
    /** 权限id  */
    private Long permissionId;
    /** 工号  */
    private String workNum;
    /** 员工姓名  */
    private String fullName;
    /** 职位名称  */
    private String postName;
    /** 权限  */
    private String permissions;

}
