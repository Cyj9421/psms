package com.psms.project.induction.mapper;

import com.psms.project.induction.domain.InductionCitizenship;
import com.psms.project.induction.domain.vo.CitizenshipVo;
import com.psms.project.induction.domain.vo.SelectCitizenshipVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 国籍管理
 */
@Mapper
public interface InductionCitizenshipMapper {
    /**
     * 国籍列表
     * @param selectCitizenshipVo
     * @return
     */
    public List<InductionCitizenship> citizenshipList(SelectCitizenshipVo selectCitizenshipVo);

    /**
     * 国籍详情
     * @param citizenshipId
     * @return
     */
    public InductionCitizenship citizenshipInfo(int citizenshipId);

    /**
     * 新增国籍
     * @param citizenshipVo
     * @return
     */
    public int addCitizenship(CitizenshipVo citizenshipVo);

    /**
     * 修改国籍
     * @param citizenshipVo
     * @return
     */
    public int updateCitizenship(CitizenshipVo citizenshipVo);

    /**
     * 批量删除国籍
     * @param citizenshipIds
     * @return
     */
    public int delCitizenship(int [] citizenshipIds);
}
