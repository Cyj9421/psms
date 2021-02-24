package com.psms.project.attendance.service;

import com.psms.project.attendance.domain.AttendanceIo;

import java.util.List;

/**
 * 服务层 出入口管理
 */
public interface IAttendanceIoService {
    /**
     * 出入口列表
     * @return
     */
    public List<AttendanceIo> ioList();

    /**
     * 出入口详情
     * @param ioId
     * @return
     */
    public AttendanceIo ioInfo(int ioId);

    /**
     * 添加出入口
     * @param attendanceIo
     * @return
     */
    public int addIo(AttendanceIo attendanceIo);

    /**
     * 修改出入口
     * @param attendanceIo
     * @return
     */
    public int updateIo(AttendanceIo attendanceIo);

    /**
     * 批量删除出入口
     * @param ioIds
     * @return
     */
    public int delIos(int [] ioIds);
}
