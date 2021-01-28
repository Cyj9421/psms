package com.psms.project.system.service;

import com.psms.project.system.domain.SysUserNumber;

import java.util.List;

/**
 * 服务层 员工工号
 */
public interface ISysUserNumberService {
    /**
     * 员工列表
     * @param sysUserNumber
     * @return
     */
    public List<SysUserNumber> numberList(SysUserNumber sysUserNumber);

    /**
     * 员工工号详情
     * @param WorkId
     * @return
     */
    public SysUserNumber numberInfo(int WorkId);

    /**
     * 员工工号详情
     * @param workNum
     * @return
     */
    public SysUserNumber numberByWorkNum(String workNum);

    /**
     * 新增工号
     * @param sysUserNumber
     * @return
     */
    public int addNumber(SysUserNumber sysUserNumber);

    /**
     * 批量注销工号
     * @param sysUserNumber
     * @return
     */
    public int delNumbers(SysUserNumber sysUserNumber);

    /**
     * 根据姓名查找老员工
     * @param fullName
     * @return
     */
    public SysUserNumber checkNum(String fullName);

    /**
     * 保存原有资料，更新员工工号
     * @param sysUserNumber
     * @return
     */
    public int saveNewNum(SysUserNumber sysUserNumber);

    /**
     * 查询所有的工号
     * @return
     */
    public List<String> numList();

}

