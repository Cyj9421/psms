package com.psms.project.system.service.impl;

import com.psms.project.system.domain.vo.SysDeptVo;
import com.psms.project.system.domain.vo.SysIndexVo;
import com.psms.project.system.mapper.SysIndexMapper;
import com.psms.project.system.service.ISysIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现 首页
 */
@Service
public class SysIndexServiceImpl implements ISysIndexService {
    @Autowired
    private SysIndexMapper sysIndexMapper;

    /**
     * 在职人数
     * @return
     */
    @Override
    public int onWork() {
        return sysIndexMapper.onWork();
    }

    /**
     * 本月累积工时
     * @param sysIndexVo
     * @return
     */
    @Override
    public double workTime(SysIndexVo sysIndexVo) {
        return sysIndexMapper.workTime(sysIndexVo);
    }

    /**
     * 本月预计支出
     * @return
     */
    @Override
    public double salaryCost() {
        return sysIndexMapper.salaryCost();
    }

    /**
     * 本月离职人数
     * @param sysIndexVo
     * @return
     */
    @Override
    public int departure(SysIndexVo sysIndexVo) {
        return sysIndexMapper.departure(sysIndexVo);
    }

    /**
     * 当日预计工时
     * @param sysIndexVo
     * @return
     */
    @Override
    public double expectedTime(SysIndexVo sysIndexVo) {
        return sysIndexMapper.expectedTime(sysIndexVo);
    }

    /**
     * 当日实际工时
     * @param sysIndexVo
     * @return
     */
    @Override
    public double actualTime(SysIndexVo sysIndexVo) {
        return sysIndexMapper.actualTime(sysIndexVo);
    }

    /**
     * 各部门人数
     * @return
     */
    @Override
    public List<SysDeptVo> deptNum() {
        return sysIndexMapper.deptNum();
    }

    /**
     * 各部门预计工时
     * @param sysIndexVo
     * @return
     */
    @Override
    public List<SysDeptVo> expectedTimeByDept(SysIndexVo sysIndexVo) {
        return sysIndexMapper.expectedTimeByDept(sysIndexVo);
    }

    /**
     * 各部门实际工时
     * @param sysIndexVo
     * @return
     */
    @Override
    public List<SysDeptVo> actualTimeByDept(SysIndexVo sysIndexVo) {
        return sysIndexMapper.actualTimeByDept(sysIndexVo);
    }
}
