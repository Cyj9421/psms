package com.psms.project.system.mapper;

import com.psms.project.system.domain.SysWorkNumHead;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysWorkNumHeadMapper {
    /**
     * 工号开头列表
     * @param sysWorkNumHead
     * @return
     */
    public List<SysWorkNumHead> headList(SysWorkNumHead sysWorkNumHead);

    /**
     * 通过部门id查找工号开头
     * @param deptId
     * @return
     */
    public SysWorkNumHead selectHeadByDeptId(long deptId,long postId);

    /**
     * 新增工号开头
     * @param sysWorkNumHead
     * @return
     */
    public int addHead(SysWorkNumHead sysWorkNumHead);

    /**
     * 修改工号开头
     * @param sysWorkNumHead
     * @return
     */
    public int updateHead(SysWorkNumHead sysWorkNumHead);

    /**
     * 批量删除工号开头
     * @param headIds
     * @return
     */
    public int delHead(int[] headIds);
}
