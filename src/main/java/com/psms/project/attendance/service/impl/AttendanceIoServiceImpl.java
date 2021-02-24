package com.psms.project.attendance.service.impl;

import com.psms.project.attendance.domain.AttendanceIo;
import com.psms.project.attendance.mapper.AttendanceIoMapper;
import com.psms.project.attendance.service.IAttendanceIoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现 出入口管理
 */
@Service
public class AttendanceIoServiceImpl implements IAttendanceIoService {
    @Autowired
    private AttendanceIoMapper attendanceIoMapper;

    /**
     * 出入口列表
     * @return
     */
    @Override
    public List<AttendanceIo> ioList() {
        return attendanceIoMapper.ioList();
    }

    /**
     * 出入口详情
     * @param ioId
     * @return
     */
    @Override
    public AttendanceIo ioInfo(int ioId) {
        return attendanceIoMapper.ioInfo(ioId);
    }

    /**
     * 添加出入口
     * @param attendanceIo
     * @return
     */
    @Override
    public int addIo(AttendanceIo attendanceIo) {
        return attendanceIoMapper.addIo(attendanceIo);
    }

    /**
     * 修改出入口
     * @param attendanceIo
     * @return
     */
    @Override
    public int updateIo(AttendanceIo attendanceIo) {
        return attendanceIoMapper.updateIo(attendanceIo);
    }

    /**
     * 批量删除出入口
     * @param ioIds
     * @return
     */
    @Override
    public int delIos(int[] ioIds) {
        return attendanceIoMapper.delIos(ioIds);
    }
}
