package com.psms.project.induction.mapper;

import com.psms.project.induction.domain.InductionWorkCard;
import com.psms.project.induction.domain.vo.InductionVo;
import com.psms.project.induction.domain.vo.InsertInductionVo;
import com.psms.project.induction.domain.vo.SelectInductionVo;
import com.psms.project.induction.domain.vo.UpdateInductionVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 业务层 入职申请
 */
@Mapper
public interface InductionStaffMapper {
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
     * 验证身份证号
     * @param idCard
     * @return
     */
    public InductionVo inductionInfoByIdCard(String idCard);

    /**
     * 入职申请
     * @param insertInductionVo
     * @return
     */
    public int addInduction(InsertInductionVo insertInductionVo);

    /**
     * 入职审核
     * @param inductionId
     * @param inductionStatus
     * @return
     */
    public int updateInductionStatus(int inductionId,int inductionStatus);

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

    /**
     * 删除入职申请
     * @param inductionId
     * @return
     */
    public int delInduction(int inductionId);

    /**
     * 工牌信息
     * @param workNums
     * @return
     */
    public List<InductionWorkCard> cardList(String [] workNums);

    /**
     * 离职
     * @param inductionId
     * @return
     */
    public int updateWorkStatus(int inductionId);
}
