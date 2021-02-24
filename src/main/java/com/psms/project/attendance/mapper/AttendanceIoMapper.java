package com.psms.project.attendance.mapper;

import com.psms.project.attendance.domain.AttendanceIo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 业务层 出入口管理
 */
@Mapper
public interface AttendanceIoMapper {
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
