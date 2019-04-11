package com.example.oepnoffice.aposeTest;

import com.aspose.cells.Workbook;
import com.aspose.slides.Presentation;
import com.aspose.words.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.aspose.slides.SaveFormat;

import java.io.*;
/**
 * @Author:fy.sheng
 * @Date:Greated in 11:57 2019/1/31
 */
public class Word2PdfUtil {
    /**
     * The constant LOG.
     *
     */
    private static final Logger LOG = LoggerFactory.getLogger(Word2PdfUtil.class);

    /**
     * 获取license
     *
     * @return
     */
    public static boolean getWordLicense() {
        boolean result = false;
        try {
            InputStream license = new FileInputStream(new File("D:\\aspose\\license.xml"));// license路径
            com.aspose.words.License aposeLic = new com.aspose.words.License();
            aposeLic.setLicense(license);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public static boolean getPPTLicense() {
        boolean result = false;
        try {
            InputStream license = new FileInputStream(new File("D:\\aspose\\license.xml"));// license路径
            com.aspose.slides.License aposeLic = new com.aspose.slides.License();
            aposeLic.setLicense(license);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public static boolean getExcelLicense() {
        boolean result = false;
        try {
            InputStream license = new FileInputStream(new File("D:\\aspose\\license.xml"));// license路径
            com.aspose.cells.License aposeLic = new com.aspose.cells.License();
            aposeLic.setLicense(license);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * Word 2 pdf.
     *
     * @param in the multipart file
     * @param pdfFilePath   the pdf file path
     */
    public static void word2Pdf(InputStream in, String pdfFilePath) {
        FileOutputStream fileOS = null;
        // 验证License
        if (!getWordLicense()) {
            LOG.error("验证License失败！");
            return;
        }
        try {
            Document doc = new Document(in);
            fileOS = new FileOutputStream(new File(pdfFilePath));
            // 保存转换的pdf文件
            doc.save(fileOS, com.aspose.words.SaveFormat.PDF);
        } catch (Exception e) {
            LOG.error("error:", e);
        } finally {
            try {
                if(fileOS != null){
                    fileOS.close();
                }
            } catch (IOException e) {
                LOG.error("error:", e);
            }
        }
    }
    public static void ppt2Pdf(InputStream in, String pdfFilePath){
        FileOutputStream fileOS = null;
        // 验证License
        if (!getPPTLicense()) {
            LOG.error("验证License失败！");
            return;
        }
        try {
            fileOS = new FileOutputStream(new File(pdfFilePath));
            Presentation ppt = new Presentation(in);
            ppt.save(fileOS, SaveFormat.Pdf);
        } catch (Exception e) {
            LOG.error("error:", e);
        } finally {
            try {
                if(fileOS != null){
                    fileOS.close();
                }
            } catch (IOException e) {
                LOG.error("error:", e);
            }
        }
    }
    public static void excel2Pdf(InputStream in, String pdfFilePath){
        FileOutputStream fileOS = null;
        // 验证License
        if (!getExcelLicense()) {
            LOG.error("验证License失败！");
            return;
        }
        try {
            fileOS = new FileOutputStream(new File(pdfFilePath));
            Workbook excel = new Workbook(in);
            excel.save(pdfFilePath,com.aspose.cells.SaveFormat.PDF);
        } catch (Exception e) {
            LOG.error("error:", e);
        } finally {
            try {
                if(fileOS != null){
                    fileOS.close();
                }
            } catch (IOException e) {
                LOG.error("error:", e);
            }
        }
    }
    public static void main(String[] args) {
        try {
            InputStream wordIn = new FileInputStream(new File("D:\\aspose\\test.docx"));
            word2Pdf(wordIn,"D:\\aspose\\test-word.pdf");

            InputStream pptIn = new FileInputStream(new File("D:\\aspose\\test.pptx"));
            ppt2Pdf(pptIn,"D:\\aspose\\test-ppt.pdf");

            InputStream excelIn = new FileInputStream(new File("D:\\aspose\\test.xlsx"));
            excel2Pdf(excelIn,"D:\\aspose\\test-excel.pdf");

            InputStream txtIn = new FileInputStream(new File("D:\\aspose\\test.txt"));
            word2Pdf(txtIn,"D:\\aspose\\test-txt.pdf");

        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }
}
