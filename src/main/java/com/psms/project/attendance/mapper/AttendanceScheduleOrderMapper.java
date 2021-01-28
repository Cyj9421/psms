package com.psms.project.attendance.mapper;

import com.psms.project.attendance.domain.AttendanceScheduleOrder;

import java.util.List;

/**
 * 业务层 班次管理
 */
public interface AttendanceScheduleOrderMapper {
    /**
     * 班次列表
     * @param attendanceScheduleOrder
     * @return
     */
    public List<AttendanceScheduleOrder> orderList(AttendanceScheduleOrder attendanceScheduleOrder);

    /**
     * 班次详情
     * @param orderId
     * @return
     */
    public AttendanceScheduleOrder orderInfo(int orderId);

    /**
     * 新增班次
     * @param attendanceScheduleOrder
     * @return
     */
    public int addOrder(AttendanceScheduleOrder attendanceScheduleOrder);

    /**
     * 删除班次
     * @param orderId
     * @return
     */
    public int delOrder(int orderId);

    /**
     * 修改班次
     * @param attendanceScheduleOrder
     * @return
     */
    public int updateOrder(AttendanceScheduleOrder attendanceScheduleOrder);

    /**
     * 班次详情
     * @param workNum
     * @return
     */
    public AttendanceScheduleOrder selectOrder(String workNum);
}
