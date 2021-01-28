package com.psms.project.attendance.mapper;

import com.psms.project.attendance.domain.AttendanceCard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 业务层 刷卡管理
 */
@Mapper
public interface AttendanceCardMapper {

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
}
