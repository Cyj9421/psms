//package com.psms.common.utils;
//
//import com.documents4j.api.DocumentType;
//import com.documents4j.api.IConverter;
//import com.documents4j.job.LocalConverter;
//
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.InputStream;
//import java.io.OutputStream;
//
//public class WordToPdfUtils {
//
//    /**
//     * Word 转 PDF
//     *
//     * @param inPath  word文件地址
//     * @param outPath pdf文件地址
//     */
//    public static void doc2pdf(String inPath, String outPath) {
//        try  {
//            InputStream docxInputStream = new FileInputStream(inPath);
//            OutputStream outputStream = new FileOutputStream(outPath);
//            IConverter converter = LocalConverter.builder().build();
//            converter.convert(docxInputStream).as(DocumentType.DOCX).to(outputStream).as(DocumentType.PDF).execute();
//            outputStream.close();
//            System.out.println("success");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
