package com.psms.project.attendance.service.impl;

import com.psms.project.attendance.domain.AttendanceScheduleOrder;
import com.psms.project.attendance.mapper.AttendanceScheduleOrderMapper;
import com.psms.project.attendance.service.IAttendanceScheduleOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现 班次管理
 */
@Service
public class AttendanceScheduleOrderServiceImpl implements IAttendanceScheduleOrderService {
    @Autowired
    private AttendanceScheduleOrderMapper attendanceScheduleOrderMapper;

    /**
     * 班次列表
     * @param attendanceScheduleOrder
     * @return
     */
    @Override
    public List<AttendanceScheduleOrder> orderList(AttendanceScheduleOrder attendanceScheduleOrder) {
        return attendanceScheduleOrderMapper.orderList(attendanceScheduleOrder);
    }

    /**
     * 班次详情
     * @param orderId
     * @return
     */
    @Override
    public AttendanceScheduleOrder orderInfo(int orderId) {
        return attendanceScheduleOrderMapper.orderInfo(orderId);
    }

    /**
     * 新增班次
     * @param attendanceScheduleOrder
     * @return
     */
    @Override
    public int addOrder(AttendanceScheduleOrder attendanceScheduleOrder) {
        return attendanceScheduleOrderMapper.addOrder(attendanceScheduleOrder);
    }

    /**
     * 删除班次
     * @param orderId
     * @return
     */
    @Override
    public int delOrder(int orderId) {
        return attendanceScheduleOrderMapper.delOrder(orderId);
    }

    /**
     * 修改班次
     * @param attendanceScheduleOrder
     * @return
     */
    @Override
    public int updateOrder(AttendanceScheduleOrder attendanceScheduleOrder) {
        return attendanceScheduleOrderMapper.updateOrder(attendanceScheduleOrder);
    }

    /**
     * 班次详情
     * @param workNum
     * @return
     */
    @Override
    public AttendanceScheduleOrder orderInfo(String workNum) {
        return attendanceScheduleOrderMapper.selectOrder(workNum);
    }
}
