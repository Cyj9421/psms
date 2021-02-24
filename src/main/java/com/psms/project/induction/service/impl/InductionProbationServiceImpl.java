package com.psms.project.induction.service.impl;

import com.psms.project.induction.domain.InductionProbation;
import com.psms.project.induction.mapper.InductionProbationMapper;
import com.psms.project.induction.service.IInductionProbationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现 试用期记录
 */
@Service
public class InductionProbationServiceImpl implements IInductionProbationService {
    @Autowired
    private InductionProbationMapper probationMapper;

    /**
     * 记录列表
     * @return
     */
    @Override
    public List<InductionProbation> probationList() {
        return probationMapper.probationList();
    }

    /**
     * 通过试用期id查询试用期详情
     * @param probationId
     * @return
     */
    @Override
    public InductionProbation probationInfo(int probationId) {
        return probationMapper.probationInfo(probationId);
    }

    /**
     * 添加记录
     * @param probation
     * @return
     */
    @Override
    public int addProbation(InductionProbation probation) {
        return probationMapper.addProbation(probation);
    }

    /**
     * 修改试用期
     * @param probation
     * @return
     */
    @Override
    public int updateProbation(InductionProbation probation) {
        return probationMapper.updateProbation(probation);
    }

    /**
     * 查询最大的id
     * @return
     */
    @Override
    public int maxProbationId() {
        return probationMapper.maxProbationId();
    }
}
