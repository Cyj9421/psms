package com.psms.project.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 工号开头表
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SysWorkNumHead {
    /** 工号开头id */
    private int headId;
    /** 工号开头 */
    private String workNumHead;
    /** 部门id */
    private long deptId;
}
