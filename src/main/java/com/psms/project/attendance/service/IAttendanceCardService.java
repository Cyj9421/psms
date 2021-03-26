package com.psms.project.attendance.service;

import com.psms.project.attendance.domain.AttendanceCard;

import java.util.List;

/**
 * 服务层
 */
public interface IAttendanceCardService {

    /**
     * 卡号列表
     * @param attendanceCard
     * @return
     */
    public List<AttendanceCard> cardList(AttendanceCard attendanceCard);

    /**
     * 卡号详情
     * @param cardId
     * @return
     */
    public AttendanceCard cardInfo(int cardId);

    /**
     * 绑定卡号
     * @param attendanceCard
     * @return
     */
    public int addCard(AttendanceCard attendanceCard);

    /**
     * 修改卡号信息
     * @param attendanceCard
     * @return
     */
    public int updateCard(AttendanceCard attendanceCard);

    /**
     * 批量删除卡号
     * @param cardIds
     * @return
     */
    public int delCard(int [] cardIds);

    /**
     * 通过卡号查看卡号详情
     * @param cardNum
     * @return
     */
    public AttendanceCard attendanceCardInfo(String cardNum);

    /**
     * 通过工号查找卡号列表
     * @param workNum
     * @return
     */
    public List<AttendanceCard> cardInfoByWorkNum(String workNum);
}
