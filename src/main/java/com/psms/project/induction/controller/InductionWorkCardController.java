package com.psms.project.induction.controller;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.psms.common.utils.WordPdfUtils;
import com.psms.framework.config.ServerConfig;
import com.psms.framework.web.controller.BaseController;
import com.psms.framework.web.domain.AjaxResult;
import com.psms.project.induction.domain.InductionWorkCard;
import com.psms.project.induction.service.IInductionStaffService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@RestController
@RequestMapping("/work/card")
@Api(tags = "工牌")
public class InductionWorkCardController extends BaseController {
    @Autowired
    private IInductionStaffService staffService;

    @Autowired
    private ServerConfig serverConfig;

    @Value("${psms.profile}")
    private String path;

    @Value("${address}")
    private String address;

    @Value("${server.port}")
    private String port;

    @PostMapping("/create")
    @ApiOperation(value = "生成工牌",notes = "生成工牌")
    public AjaxResult printWorkCard(@ApiParam("工号") @RequestParam(value = "workNums") String [] workNums)
            throws IOException {
        final String templateUrl =path+"test.docx";  // 模板文件
        List<String> pdfList = new ArrayList<>();  // 结果pdf文件
        InputStream is = new FileInputStream(new File(templateUrl));
        XWPFDocument doc = new XWPFDocument(is);
        List<InductionWorkCard> workCardList = staffService.cardList(workNums);
        for(int i=0;i<workCardList.size();i++) {
            // 文本数据
            InductionWorkCard workCard = workCardList.get(i);
            Map<String, String> textMap = new HashMap<String, String>();
            textMap.put("jobNum", workCard.getWorkNum());
            textMap.put("name", workCard.getFirstName()+workCard.getLastName());
            if(workCard.getSex()==1){
                textMap.put("sex","male");
            }else {
                textMap.put("sex","female");
            }
            textMap.put("dept", workCard.getDeptName());
            textMap.put("class", workCard.getScheduleName());
            textMap.put("dorm", workCard.getDormitoryName()+"("+workCard.getRoomName()+")");
            textMap.put("phone", workCard.getPhoneNumber());
            // 证件照
            Map<String, String> imgMap = new HashMap<String, String>();
            String img=workCard.getPassport();
            int index=img.indexOf("/");
            index=img.indexOf("/",index+4);
             img=img.substring(index);
            imgMap.put("img",path+img.substring(9));
            //返回docx路径
            String returnWordUrl=path+workCard.getWorkNum()+".docx";
            /**----------------------------处理段落------------------------------------**/
            List<XWPFParagraph> paragraphList = doc.getParagraphs();
            if (paragraphList != null && paragraphList.size() > 0) {
                for (XWPFParagraph paragraph : paragraphList) {
                    List<XWPFRun> runs = paragraph.getRuns();
                    for (XWPFRun run : runs) {
                        String text = run.getText(0);
                        if (text != null) {
                            // 替换文本信息
                            String tempText = text;
                            String key = tempText.replaceAll("\\{\\{", "").replaceAll("}}", "");
                            if (!StringUtils.isEmpty(textMap.get(key))) {
                                run.setText(textMap.get(key), 0);
                            }
                            // 替换图片内容 参考：https://blog.csdn.net/a909301740/article/details/84984445
                            String tempImgText = text;
                            String imgkey = tempImgText.replaceAll("\\{\\{@", "").replaceAll("}}", "");
                            if (!StringUtils.isEmpty(imgMap.get(imgkey))) {
                                String imgPath = imgMap.get(imgkey);
                                try {
                                    run.setText("", 0);
                                    run.addPicture(new FileInputStream(imgPath), Document.PICTURE_TYPE_PNG, "img.png", Units.toEMU(200), Units.toEMU(200));

                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
            // 保存结果文件
            try {
                File file = new File(returnWordUrl);
                if (file.exists()) {
                    file.delete();
                }
                FileOutputStream fos = new FileOutputStream(returnWordUrl);
                doc.write(fos);
                fos.close();
                //生成pdf文档
                BaseFont bfChinese = null;
                try {
                    bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
                } catch (DocumentException e) {
                    // Do sth. here
                } catch (IOException e) {
                    // Do sth. here
                }
                Font font = new Font(bfChinese, 16, Font.NORMAL);
                String pdfUrl=path+workCard.getFirstName()+workCard.getLastName()+workCard.getWorkNum()+".pdf";
                // 自定义页面大小使用
                Rectangle pagesize = new Rectangle(216f, 720f);
                // 第一步 创建文档实例
                com.itextpdf.text.Document document = new com.itextpdf.text.Document(pagesize,8f, 8f, 108f, 180f);
                // 第二步 获取PdfWriter实例
                PdfWriter.getInstance(document, new FileOutputStream(pdfUrl));
                // 第三步 打开文档
                document.open();
                // 第四步 添加段落内容
                document.add(new Paragraph("工号："+workCard.getWorkNum(),font));
                document.add(new Paragraph("名字："+workCard.getFirstName()+workCard.getLastName(),font));
                if(workCard.getSex()==1) {
                    document.add(new Paragraph("性别：male",font));
                }else {
                    document.add(new Paragraph("性别：female",font));
                }
                document.add(new Paragraph("部门："+workCard.getDeptName(),font));
                document.add(new Paragraph("班别："+workCard.getScheduleName(),font));
                document.add(new Paragraph("宿舍："+workCard.getDormitoryName()+"("+workCard.getRoomName()+")",font));
                document.add(new Paragraph("电话号码："+workCard.getPhoneNumber(),font));
                // 第五部 操作完成后必须执行文档关闭操作。
                document.close();
                pdfList.add(serverConfig.getUrl()+"/"+workCard.getFirstName()+workCard.getLastName()+workCard.getWorkNum()+".pdf");
            } catch (Exception e) {
                e.printStackTrace();
                return AjaxResult.error(400, "生成word文件失败");
            }
        }
        return AjaxResult.success(pdfList);
    }
    @GetMapping("/get/zip")
    @ApiOperation(value = "生成zip",notes = "生成zip")
    public AjaxResult getPdfZip(@ApiParam("工号") @RequestParam(value = "workNums") String [] workNums)
            throws IOException, DocumentException {
        if(com.psms.common.utils.StringUtils.isEmpty(workNums)){
            return AjaxResult.error(400,"请选择员工");
        }
        List<InductionWorkCard> workCardList = staffService.cardList(workNums);
        String resultZip = path+"workCards.zip";
        String serverZip =serverConfig.getUrl()+"/workCards.zip";
        //输出压缩包
        ZipOutputStream zip =
                new ZipOutputStream(new FileOutputStream(resultZip));
        for(int i=0;i<workCardList.size();i++) {
            InductionWorkCard workCard = workCardList.get(i);
            String pdfUrl =workCard.getFirstName() + workCard.getLastName() + workCard.getWorkNum() + ".pdf";
            ZipEntry entry = new ZipEntry(pdfUrl);
            zip.putNextEntry(entry);
            //生成pdf文档
            BaseFont bfChinese = null;
            try {
                bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            } catch (DocumentException e) {
                // Do sth. here
            } catch (IOException e) {
                // Do sth. here
            }
            Font font = new Font(bfChinese, 16, Font.NORMAL);
            // 自定义页面大小使用
            Rectangle pagesize = new Rectangle(216f, 720f);
            // 第一步 创建文档实例
            com.itextpdf.text.Document document = new com.itextpdf.text.Document(pagesize, 8f, 8f, 108f, 180f);
            // 第二步 获取PdfWriter实例
            PdfWriter writer = PdfWriter.getInstance(document, zip);
            writer.setCloseStream(false);
            // 第三步 打开文档
            document.open();
            // 第四步 添加段落内容
            document.add(new Paragraph("工号：" + workCard.getWorkNum(), font));
            document.add(new Paragraph("名字：" + workCard.getFirstName() + workCard.getLastName(), font));
            if (workCard.getSex() == 1) {
                document.add(new Paragraph("性别：male", font));
            } else {
                document.add(new Paragraph("性别：female", font));
            }
            document.add(new Paragraph("部门：" + workCard.getDeptName(), font));
            document.add(new Paragraph("班别：" + workCard.getScheduleName(), font));
            document.add(new Paragraph("宿舍：" + workCard.getDormitoryName() + "(" + workCard.getRoomName() + ")", font));
            document.add(new Paragraph("电话号码：" + workCard.getPhoneNumber(), font));
            // 第五部 操作完成后必须执行文档关闭操作。
            document.close();
            zip.closeEntry();
        }
        zip.close();
        return AjaxResult.success(serverZip);
    }
}
