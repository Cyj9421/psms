package com.psms.project.induction.service.impl;

import com.psms.project.induction.domain.InductionEducationBackground;
import com.psms.project.induction.domain.vo.UpdateEducationBackgroundVo;
import com.psms.project.induction.mapper.InductionEducationBackgroundMapper;
import com.psms.project.induction.service.IInductionEducationBackgroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现 学历管理
 */
@Service
public class InductionEducationBackgroundServiceImpl implements IInductionEducationBackgroundService {
    @Autowired
    private InductionEducationBackgroundMapper educationBackgroundMapper;

    /**
     * 学历列表
     * @return
     */
    @Override
    public List<InductionEducationBackground> educationBackgroundList() {
        return educationBackgroundMapper.educationBackgroundList();
    }

    /**
     * 学历详情
     * @param educationId
     * @return
     */
    @Override
    public InductionEducationBackground educationBackgroundInfo(int educationId) {
        return educationBackgroundMapper.educationBackgroundInfo(educationId);
    }

    /**
     * 学历详情
     * @param educationBackground
     * @return
     */
    @Override
    public InductionEducationBackground educationBackground(String educationBackground) {
        return educationBackgroundMapper.educationBackground(educationBackground);
    }

    /**
     * 添加学历
     * @param educationBackground
     * @return
     */
    @Override
    public int addEducationBackground(String educationBackground) {
        return educationBackgroundMapper.addEducationBackground(educationBackground);
    }

    /**
     * 修改学历
     * @param updateEducationBackgroundVo
     * @return
     */
    @Override
    public int updateEducationBackground(UpdateEducationBackgroundVo updateEducationBackgroundVo) {
        return educationBackgroundMapper.updateEducationBackground(updateEducationBackgroundVo);
    }

    /**
     * 批量删除学历
     * @param educationIds
     * @return
     */
    @Override
    public int delEducationBackgrounds(int[] educationIds) {
        return educationBackgroundMapper.delEducationBackgrounds(educationIds);
    }
}
