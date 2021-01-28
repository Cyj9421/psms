package com.psms.project.system.mapper;

import com.psms.project.system.domain.vo.SysDeptVo;
import com.psms.project.system.domain.vo.SysIndexVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import java.util.Date;
import java.util.List;

/**
 * 业务层 系统首页
 */
@Mapper
public interface SysIndexMapper {

    /**
     * 本月在职人数
     * @return
     */
    public int onWork();

    /**
     * 本月累积工时
     * @return
     */
    public double workTime(SysIndexVo sysIndexVo);

    /**
     * 本月预计支出
     * @return
     */
    public double salaryCost();

    /**
     * 本月离职人数
     * @return
     */
    public int departure(SysIndexVo sysIndexVo);

    /**
     * 预计工时
     * @return
     */
    public double expectedTime(SysIndexVo sysIndexVo);

    /**
     * 实际工时
     * @return
     */
    public double actualTime(SysIndexVo sysIndexVo);

    /**
     * 各部门人数
     */
    public List<SysDeptVo> deptNum();

    /**
     * 各部门预计工时
     * @return
     */
    public List<SysDeptVo> expectedTimeByDept(SysIndexVo sysIndexVo);

    /**
     * 各部门实际工时
     * @return
     */
    public List<SysDeptVo> actualTimeByDept(SysIndexVo sysIndexVo);
}
