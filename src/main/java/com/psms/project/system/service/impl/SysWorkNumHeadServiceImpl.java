package com.psms.project.system.service.impl;

import com.psms.project.system.domain.SysWorkNumHead;
import com.psms.project.system.mapper.SysWorkNumHeadMapper;
import com.psms.project.system.service.ISysWorkNumHeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysWorkNumHeadServiceImpl implements ISysWorkNumHeadService {
    @Autowired
    private SysWorkNumHeadMapper sysWorkNumHeadMapper;

    /**
     * 工号开头列表
     * @param sysWorkNumHead
     * @return
     */
    @Override
    public List<SysWorkNumHead> headList(SysWorkNumHead sysWorkNumHead) {
        return sysWorkNumHeadMapper.headList(sysWorkNumHead);
    }

    /**
     * 查找工号开头
     * @param deptId
     * @param postId
     * @return
     */
    @Override
    public SysWorkNumHead selectHeadByDeptId(long deptId,long postId) {
        return sysWorkNumHeadMapper.selectHeadByDeptId(deptId,postId);
    }

    /**
     * 新增工号开头
     * @param sysWorkNumHead
     * @return
     */
    @Override
    public int addHead(SysWorkNumHead sysWorkNumHead) {
        return sysWorkNumHeadMapper.addHead(sysWorkNumHead);
    }

    /**
     * 修改工号开头
     * @param sysWorkNumHead
     * @return
     */
    @Override
    public int updateHead(SysWorkNumHead sysWorkNumHead) {
        return sysWorkNumHeadMapper.updateHead(sysWorkNumHead);
    }

    /**
     * 批量删除工号开头
     * @param headIds
     * @return
     */
    @Override
    public int delHead(int[] headIds) {
        return sysWorkNumHeadMapper.delHead(headIds);
    }
}
