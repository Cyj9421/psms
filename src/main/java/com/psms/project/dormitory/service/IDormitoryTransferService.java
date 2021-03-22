package com.psms.project.dormitory.service;

import com.psms.project.dormitory.domain.DormitoryTransfer;
import com.psms.project.dormitory.domain.vo.InsertTransferVo;
import com.psms.project.dormitory.domain.vo.UpdateTransferVo;

import java.util.List;

/**
 * 服务层 房间调动
 */
public interface IDormitoryTransferService {
    /**
     * 调动列表
     * @return
     */
    public List<DormitoryTransfer> transferList();

    /**
     * 统计调动次数
     * @param workNum
     * @return
     */
    public int totalNum(String workNum);

    /**
     * 调动详情
     * @param transferId
     * @return
     */
    public DormitoryTransfer transferInfo(int transferId);

    /**
     * 申请调动
     * @param insertTransferVo
     * @return
     */
    public int addTransfer(InsertTransferVo insertTransferVo);

    /**
     * 审核调动
     * @param updateTransferVo
     * @return
     */
    public int updateTransfer(UpdateTransferVo updateTransferVo);

    /**
     * 批量删除调动信息
     * @param transferIds
     * @return
     */
    public int delTransfers(int [] transferIds);

}
