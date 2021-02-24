package com.psms.project.induction.service.impl;

import com.psms.project.induction.domain.InductionCitizenship;
import com.psms.project.induction.domain.vo.CitizenshipVo;
import com.psms.project.induction.domain.vo.SelectCitizenshipVo;
import com.psms.project.induction.mapper.InductionCitizenshipMapper;
import com.psms.project.induction.service.IInductionCitizenshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现 国籍管理
 */
@Service
public class InductionCitizenshipServiceImpl implements IInductionCitizenshipService {
    @Autowired
    private InductionCitizenshipMapper citizenshipMapper;

    /**
     * 国籍列表
     * @param selectCitizenshipVo
     * @return
     */
    @Override
    public List<InductionCitizenship> citizenshipList(SelectCitizenshipVo selectCitizenshipVo) {
        return citizenshipMapper.citizenshipList(selectCitizenshipVo);
    }

    /**
     * 国籍详情
     * @param citizenshipId
     * @return
     */
    @Override
    public InductionCitizenship citizenshipInfo(int citizenshipId) {
        return citizenshipMapper.citizenshipInfo(citizenshipId);
    }

    /**
     * 添加国籍
     * @param citizenshipVo
     * @return
     */
    @Override
    public int addCitizenship(CitizenshipVo citizenshipVo) {
        return citizenshipMapper.addCitizenship(citizenshipVo);
    }

    /**
     * 修改国籍
     * @param citizenshipVo
     * @return
     */
    @Override
    public int updateCitizenship(CitizenshipVo citizenshipVo) {
        return citizenshipMapper.updateCitizenship(citizenshipVo);
    }

    /**
     * 批量删除国籍
     * @param citizenshipIds
     * @return
     */
    @Override
    public int delCitizenship(int[] citizenshipIds) {
        return citizenshipMapper.delCitizenship(citizenshipIds);
    }
}
