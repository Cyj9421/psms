package com.psms.project.induction.mapper;

import com.psms.project.induction.domain.InductionEducationBackground;
import com.psms.project.induction.domain.vo.UpdateEducationBackgroundVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 业务层 学历管理
 */
@Mapper
public interface InductionEducationBackgroundMapper {

    /**
     * 学历列表
     * @return
     */
    public List<InductionEducationBackground> educationBackgroundList();

    /**
     * 学历详情
     * @param educationId
     * @return
     */
    public InductionEducationBackground educationBackgroundInfo(int educationId);

    /**
     * 学历详情
     * @param educationBackground
     * @return
     */
    public InductionEducationBackground educationBackground(String educationBackground);

    /**
     * 添加学历
     * @param educationBackground
     * @return
     */
    public int addEducationBackground(String educationBackground);

    /**
     * 修改学历
     * @param updateEducationBackgroundVo
     * @return
     */
    public int updateEducationBackground(UpdateEducationBackgroundVo updateEducationBackgroundVo);

    /**
     * 批量删除学历
     * @param educationIds
     * @return
     */
    public int delEducationBackgrounds(int [] educationIds);
}
