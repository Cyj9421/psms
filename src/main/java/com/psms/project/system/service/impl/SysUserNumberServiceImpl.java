package com.psms.project.system.service.impl;

import com.psms.framework.aspectj.lang.annotation.DataScope;
import com.psms.project.system.domain.SysUserNumber;
import com.psms.project.system.mapper.SysUserNumberMapper;
import com.psms.project.system.service.ISysUserNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现 员工工号
 */
@Service
public class SysUserNumberServiceImpl implements ISysUserNumberService {
    @Autowired
    private SysUserNumberMapper sysUserNumberMapper;
    /**
     * 员工列表
     * @param sysUserNumber
     * @return
     */
    @Override
    public List<SysUserNumber> numberList(SysUserNumber sysUserNumber) {
        return sysUserNumberMapper.numberList(sysUserNumber);
    }

    /**
     * 工号详情
     * @param WorkId
     * @return
     */
    @Override
    public SysUserNumber numberInfo(int  WorkId) {
        return sysUserNumberMapper.numberInfo(WorkId);
    }

    /**
     * 工号详情
     * @param workNum
     * @return
     */
    @Override
    public SysUserNumber numberByWorkNum(String workNum) {
        return sysUserNumberMapper.numberByWorkNum(workNum);
    }

    /**
     * 新增工号
     * @param sysUserNumber
     * @return
     */
    @Override
    public int addNumber(SysUserNumber sysUserNumber) {
        return sysUserNumberMapper.addNumber(sysUserNumber);
    }

    /**
     * 批量注销工号
     * @param sysUserNumber
     * @return
     */
    @Override
    public int delNumbers(SysUserNumber sysUserNumber) {
        return sysUserNumberMapper.delNumbers(sysUserNumber);
    }

    /**
     * 检查员工是否为老员工
     * @param fullName
     * @return
     */
    @Override
    public SysUserNumber checkNum(String fullName) {
        return sysUserNumberMapper.checkNum(fullName);
    }

    /**
     * 保存原有资料，更新员工工号
     * @param sysUserNumber
     * @return
     */
    @Override
    public int saveNewNum(SysUserNumber sysUserNumber) {
        return sysUserNumberMapper.saveNewNum(sysUserNumber);
    }

    /**
     * 返回所有的工号
     * @return
     */
    @Override
    public List<String> numList(String workNum) {
        return sysUserNumberMapper.numList(workNum);
    }
}
