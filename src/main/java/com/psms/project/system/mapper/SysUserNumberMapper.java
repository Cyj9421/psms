package com.psms.project.system.mapper;

import com.psms.project.system.domain.SysUserNumber;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 数据层 员工工号
 */
@Mapper
public interface SysUserNumberMapper {
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
     * 新增工号
     * @param sysUserNumber
     * @return
     */
    public int addNumber(SysUserNumber sysUserNumber);

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

}
