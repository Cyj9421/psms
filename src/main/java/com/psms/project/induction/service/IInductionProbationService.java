package com.psms.project.induction.service;

import com.psms.project.induction.domain.InductionProbation;

import java.util.List;

/**
 * 服务层 试用期记录
 */
public interface IInductionProbationService {
    /**
     * 试用期记录列表
     * @return
     */
    public List<InductionProbation> probationList();

    /**
     * 通过id查询试用期记录
     * @param probationId
     * @return
     */
    public InductionProbation probationInfo(int probationId);

    /**
     * 添加试用期记录
     * @param probation
     * @return
     */
    public int addProbation(InductionProbation probation);

    /**
     * 修改试用期
     * @param probation
     * @return
     */
    public int updateProbation(InductionProbation probation);

    /**
     * 查询最大的试用期id
     * @return
     */
    public int maxProbationId();
}
