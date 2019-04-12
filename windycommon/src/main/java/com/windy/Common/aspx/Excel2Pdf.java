//package com.windy.Common.aspx;
//
//import com.aspose.cells.FileFormatType;
//import com.aspose.cells.License;
//import com.aspose.cells.Workbook;
//
//import java.io.*;
//
//public class Excel2Pdf {
//    private static InputStream license;
//    /**
//     * Excel 2 pdf.
//     *
//     * @param excelFIlePath the multipart file
//     * @param pdfFilePath   the pdf file path
//     */
//    public static void excel2pdf(String excelFIlePath, String pdfFilePath) {
//        FileOutputStream fileOS = null;
//        // 验证License
//        if (!getLicense()) {
//            return;
//        }
//        try {
//            Workbook doc = new com.aspose.cells.Workbook(excelFIlePath);
//            //doc.getWorksheets().removeAt("Entry Overview");
//            doc.getWorksheets().removeAt(0);
//            fileOS = new FileOutputStream(new File(pdfFilePath));
//            // 保存转换的pdf文件
//            doc.save(fileOS, FileFormatType.PDF);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if(fileOS != null){
//                    fileOS.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//
//    public static boolean getLicense() {
//        boolean result = false;
//        try {
//            ClassLoader loader = Thread.currentThread().getContextClassLoader();
//            license = new FileInputStream(loader.getResource("license.xml").getPath());// 凭证文件
//            License aposeLic = new License();
//            aposeLic.setLicense(license);
//            result = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//}
