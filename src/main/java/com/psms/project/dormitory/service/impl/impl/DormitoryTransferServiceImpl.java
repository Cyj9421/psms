package com.psms.project.dormitory.service.impl.impl;

import com.psms.project.dormitory.domain.DormitoryTransfer;
import com.psms.project.dormitory.domain.vo.InsertTransferVo;
import com.psms.project.dormitory.domain.vo.UpdateTransferVo;
import com.psms.project.dormitory.mapper.DormitoryTransferMapper;
import com.psms.project.dormitory.service.IDormitoryTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现 房间调动
 */
@Service
public class DormitoryTransferServiceImpl implements IDormitoryTransferService {
    @Autowired
    private DormitoryTransferMapper transferMapper;

    /**
     * 调动列表
     * @return
     */
    @Override
    public List<DormitoryTransfer> transferList() {
        return transferMapper.transferList();
    }

    /**
     * 统计调动次数
     * @param workNum
     * @return
     */
    @Override
    public int totalNum(String workNum) {
        return transferMapper.totalNum(workNum);
    }

    /**
     * 调动详情
     * @param transferId
     * @return
     */
    @Override
    public DormitoryTransfer transferInfo(int transferId) {
        return transferMapper.transferInfo(transferId);
    }

    /**
     * 调动申请
     * @param insertTransferVo
     * @return
     */
    @Override
    public int addTransfer(InsertTransferVo insertTransferVo) {
        return transferMapper.addTransfer(insertTransferVo);
    }

    /**
     * 审核调动
     * @param updateTransferVo
     * @return
     */
    @Override
    public int updateTransfer(UpdateTransferVo updateTransferVo) {
        return transferMapper.updateTransfer(updateTransferVo);
    }

    /**
     * 批量删除调动信息
     * @param transferIds
     * @return
     */
    @Override
    public int delTransfers(int[] transferIds) {
        return transferMapper.delTransfers(transferIds);
    }
}
