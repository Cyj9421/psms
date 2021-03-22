package com.psms.project.induction.service.impl;

import com.psms.project.induction.domain.InductionWorkCard;
import com.psms.project.induction.domain.vo.InductionVo;
import com.psms.project.induction.domain.vo.InsertInductionVo;
import com.psms.project.induction.domain.vo.SelectInductionVo;
import com.psms.project.induction.domain.vo.UpdateInductionVo;
import com.psms.project.induction.mapper.InductionStaffMapper;
import com.psms.project.induction.service.IInductionStaffService;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.FileInputStream;
import java.util.*;

/**
 * 服务实现 入职申请
 */
@Service
public class InductionStaffServiceImpl implements IInductionStaffService {
    @Autowired
    private InductionStaffMapper inductionStaffMapper;

    /**
     * 入职申请列表
     * @param selectInductionVo
     * @return
     */
    @Override
    public List<InductionVo> inductionList(SelectInductionVo selectInductionVo) {
        return inductionStaffMapper.inductionList(selectInductionVo);
    }

    /**
     * 根据工号查找底薪
     * @param workNum
     * @return
     */
    @Override
    public double selectBaseSalary(String workNum) {
        return inductionStaffMapper.selectBaseSalary(workNum);
    }

    /**
     * 入职详情
     * @param inductionId
     * @return
     */
    @Override
    public InductionVo inductionInfo(int inductionId) {
        return inductionStaffMapper.inductionInfo(inductionId);
    }

    /**
     * 通过工号查找入职信息
     * @param workNum
     * @return
     */
    @Override
    public InductionVo inductionInfoByWorkNum(String workNum) {
        return inductionStaffMapper.inductionInfoByWorkNum(workNum);
    }

    /**
     * 验证身份证号
     * @param idCard
     * @return
     */
    @Override
    public InductionVo inductionInfoByIdCard(String idCard) {
        return inductionStaffMapper.inductionInfoByIdCard(idCard);
    }

    /**
     * 添加入职申请
     * @param insertInductionVo
     * @return
     */
    @Override
    public int addInduction(InsertInductionVo insertInductionVo) {
        return inductionStaffMapper.addInduction(insertInductionVo);
    }

    /**
     * 入职审核
     * @param inductionId
     * @param inductionStatus
     * @return
     */
    @Override
    public int updateInductionStatus(int inductionId, int inductionStatus) {
        return inductionStaffMapper.updateInductionStatus(inductionId,inductionStatus);
    }

    /**
     * 修改入职申请
     * @param updateInductionVo
     * @return
     */
    @Override
    public int updateInduction(UpdateInductionVo updateInductionVo) {
        return inductionStaffMapper.updateInduction(updateInductionVo);
    }

    /**
     * 批量删除入职申请
     * @param inductionIds
     * @return
     */
    @Override
    public int delInductions(int[] inductionIds) {
        return inductionStaffMapper.delInductions(inductionIds);
    }

    /**
     * 工牌信息
     * @param workNums
     * @return
     */
    @Override
    public List<InductionWorkCard> cardList(String[] workNums) {
        return inductionStaffMapper.cardList(workNums);
    }

    /**
     * 根据出生日期计算年龄
     * @param bornDate
     * @return
     */
    @Override
    public int calculateAge(Date bornDate) {
        Calendar cal = Calendar.getInstance();
        int yearNow = cal.get(Calendar.YEAR);  //当前年份
        int monthNow = cal.get(Calendar.MONTH);  //当前月份
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH); //当前日期
        cal.setTime(bornDate);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
        int age = yearNow - yearBirth;   //计算整岁数
        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) age--;//当前日期在生日之前，年龄减一
            }else{
                age--;//当前月份在生日之前，年龄减一
            } }
        return age;
    }

//    /**
//     * @Description: 替换段落和表格中
//     */
//    public static void replaceAll(XWPFDocument doc) throws Exception {
//        doParagraphs(doc); // 处理段落文字数据，包括文字和表格、图片
//        //doCharts(doc);  // 处理图表数据，柱状图、折线图、饼图啊之类的
//    }
//
//
//    /**
//     * 处理段落文字
//     *
//     * @param doc
//     * @throws InvalidFormatException
//     */
//    public static void doParagraphs(XWPFDocument doc) throws Exception {
//
//        // 文本数据
//        Map<String, String> textMap = new HashMap<String, String>();
//        textMap.put("num", "000001");
//        textMap.put("name", "王麻子");
//        textMap.put("sex", "男");
//        textMap.put("dept", "嘻嘻哈哈部");
//        textMap.put("schedule", "打麻将班");
//        textMap.put("dorm", "A栋(302)");
//        textMap.put("phone", "139999999");
//        // 图片数据
//        Map<String, String> imgMap = new HashMap<String, String>();
//        imgMap.put("img", "D:\\IdeaProject\\psms\\src\\main\\resources\\img\\2.jpg");
//
//        /**----------------------------处理段落------------------------------------**/
//        List<XWPFParagraph> paragraphList = doc.getParagraphs();
//        if (paragraphList != null && paragraphList.size() > 0) {
//            for (XWPFParagraph paragraph : paragraphList) {
//                List<XWPFRun> runs = paragraph.getRuns();
//                for (XWPFRun run : runs) {
//                    String text = run.getText(0);
//                    if (text != null) {
//
//                        // 替换文本信息
//                        String tempText = text;
//                        String key = tempText.replaceAll("\\{\\{", "").replaceAll("}}", "");
//                        if (!StringUtils.isEmpty(textMap.get(key))) {
//                            run.setText(textMap.get(key), 0);
//                        }
//
//                        // 替换图片内容 参考：https://blog.csdn.net/a909301740/article/details/84984445
//                        String tempImgText = text;
//                        String imgkey = tempImgText.replaceAll("\\{\\{@", "").replaceAll("}}", "");
//                        if (!StringUtils.isEmpty(imgMap.get(imgkey))) {
//                            String imgPath = imgMap.get(imgkey);
//                            try {
//                                run.setText("", 0);
//                                run.addPicture(new FileInputStream(imgPath), Document.PICTURE_TYPE_PNG, "img.png", Units.toEMU(200), Units.toEMU(200));
//
//                            } catch (Exception e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
}
