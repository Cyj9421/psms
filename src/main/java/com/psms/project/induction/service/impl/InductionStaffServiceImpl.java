package com.psms.project.induction.service.impl;

import com.psms.project.induction.domain.vo.InductionVo;
import com.psms.project.induction.domain.vo.InsertInductionVo;
import com.psms.project.induction.domain.vo.SelectInductionVo;
import com.psms.project.induction.domain.vo.UpdateInductionVo;
import com.psms.project.induction.mapper.InductionStaffMapper;
import com.psms.project.induction.service.IInductionStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现 入职申请
 */
@Service
public class InductionStaffServiceImpl implements IInductionStaffService {
    @Autowired
    private InductionStaffMapper inductionStaffMapper;

    /**
     * 入职申请列表
     * @param selectInductionVo
     * @return
     */
    @Override
    public List<InductionVo> inductionList(SelectInductionVo selectInductionVo) {
        return inductionStaffMapper.inductionList(selectInductionVo);
    }

    /**
     * 根据工号查找底薪
     * @param workNum
     * @return
     */
    @Override
    public double selectBaseSalary(String workNum) {
        return inductionStaffMapper.selectBaseSalary(workNum);
    }

    /**
     * 入职详情
     * @param inductionId
     * @return
     */
    @Override
    public InductionVo inductionInfo(int inductionId) {
        return inductionStaffMapper.inductionInfo(inductionId);
    }

    /**
     * 通过工号查找入职信息
     * @param workNum
     * @return
     */
    @Override
    public InductionVo inductionInfoByWorkNum(String workNum) {
        return inductionStaffMapper.inductionInfoByWorkNum(workNum);
    }

    /**
     * 添加入职申请
     * @param insertInductionVo
     * @return
     */
    @Override
    public int addInduction(InsertInductionVo insertInductionVo) {
        return inductionStaffMapper.addInduction(insertInductionVo);
    }

    /**
     * 修改入职申请
     * @param updateInductionVo
     * @return
     */
    @Override
    public int updateInduction(UpdateInductionVo updateInductionVo) {
        return inductionStaffMapper.updateInduction(updateInductionVo);
    }

    /**
     * 批量删除入职申请
     * @param inductionIds
     * @return
     */
    @Override
    public int delInductions(int[] inductionIds) {
        return inductionStaffMapper.delInductions(inductionIds);
    }
}
