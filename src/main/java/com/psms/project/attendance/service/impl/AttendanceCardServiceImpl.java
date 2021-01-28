package com.psms.project.attendance.service.impl;

import com.psms.project.attendance.domain.AttendanceCard;
import com.psms.project.attendance.mapper.AttendanceCardMapper;
import com.psms.project.attendance.service.IAttendanceCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现 刷卡管理
 */
@Service
public class AttendanceCardServiceImpl implements IAttendanceCardService {
    @Autowired
    private AttendanceCardMapper attendanceCardMapper;

    /**
     * 卡号列表
     * @param attendanceCard
     * @return
     */
    @Override
    public List<AttendanceCard> cardList(AttendanceCard attendanceCard) {
        return attendanceCardMapper.cardList(attendanceCard);
    }

    /**
     * 卡号详情
     * @param cardId
     * @return
     */
    @Override
    public AttendanceCard cardInfo(int cardId) {
        return attendanceCardMapper.cardInfo(cardId);
    }

    /**
     * 绑定卡号
     * @param attendanceCard
     * @return
     */
    @Override
    public int addCard(AttendanceCard attendanceCard) {
        return attendanceCardMapper.addCard(attendanceCard);
    }

    /**
     * 批量删除卡号
     * @param cardIds
     * @return
     */
    @Override
    public int delCard(int[] cardIds) {
        return attendanceCardMapper.delCard(cardIds);
    }

    /**
     * 通过卡号查看卡号详情
     * @param cardNum
     * @return
     */
    @Override
    public AttendanceCard attendanceCardInfo(String cardNum) {
        return attendanceCardMapper.attendanceCardInfo(cardNum);
    }
}
