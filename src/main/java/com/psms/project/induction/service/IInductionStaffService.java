package com.psms.project.induction.service;

import com.psms.project.induction.domain.vo.InductionVo;
import com.psms.project.induction.domain.vo.InsertInductionVo;
import com.psms.project.induction.domain.vo.SelectInductionVo;
import com.psms.project.induction.domain.vo.UpdateInductionVo;

import java.util.List;

/**
 * 服务层 入职申请
 */
public interface IInductionStaffService {
    /**
     * 申请列表
     * @param selectInductionVo
     * @return
     */
    public List<InductionVo> inductionList(SelectInductionVo selectInductionVo);

    /**
     * 根据工号查底薪
     * @param workNum
     * @return
     */
    public double selectBaseSalary(String workNum);

    /**
     * 入职申请详情
     * @param inductionId
     * @return
     */
    public InductionVo inductionInfo(int inductionId);

    /**
     * 入职申请详情
     * @param workNum
     * @return
     */
    public InductionVo inductionInfoByWorkNum(String workNum);

    /**
     * 入职申请
     * @param insertInductionVo
     * @return
     */
    public int addInduction(InsertInductionVo insertInductionVo);

    /**
     * 修改入职申请
     * @param updateInductionVo
     * @return
     */
    public int updateInduction(UpdateInductionVo updateInductionVo);

    /**
     * 批量删除入职申请
     * @param inductionIds
     * @return
     */
    public int delInductions(int [] inductionIds);
}
