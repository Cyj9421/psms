package com.psms.project.attendance.mapper;

import com.psms.project.attendance.domain.AttendanceEarly;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 业务层 早退记录
 */
@Mapper
@Repository
public interface AttendanceEarlyMapper {
    /**
     * 早退列表
     * @return
     */
    List<AttendanceEarly> earlyList(AttendanceEarly attendanceEarly);

    /**
     * 早退详情
     * @param earlyId
     * @return
     */
    AttendanceEarly earlyInfo(int earlyId);

    /**
     * 新增早退记录
     * @param attendanceEarly
     * @return
     */
    public int addEarly(AttendanceEarly attendanceEarly);

    /**
     * 批量删除早退信息
     * @param earlyIds
     * @return
     */
    public int delEarly(int [] earlyIds);
}
