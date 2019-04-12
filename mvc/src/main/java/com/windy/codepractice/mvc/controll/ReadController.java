package com.windy.codepractice.mvc.controll;

import com.itextpdf.text.DocumentException;
//import com.windy.Common.aspx.Excel2Pdf;
import com.windy.codepractice.mvc.AjaxResult;
import com.windy.codepractice.mvc.service.GrpcClientService;
import com.windy.codepractice.mvc.service.ItextPDFService;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.artofsolving.jodconverter.OfficeDocumentConverter;
import org.artofsolving.jodconverter.office.DefaultOfficeManagerConfiguration;
import org.artofsolving.jodconverter.office.OfficeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

//import com.itextpdf.text.*;
//import com.itextpdf.text.pdf.*;

@Controller
public class ReadController {

    private static final String OFFICE_HOME = "C:/Program Files (x86)/OpenOffice 4";
    private static final Integer PORT = 8100;
    private static OfficeManager officeManager;

    @Value("${excel.outputPath}")
    String outputPath;

    @Value("${excel.test.filePath}")
    String testFile;

    @Value("${excel.test.pdfFilePath}")
    String pdfFile;

    @Value("${excel.test.pdfOutFilePath}")
    String pdfOutFile;

    @Value("${pdf.test.filePath}")
    String pdfPath;

    @Autowired
    GrpcClientService grpcClientService;

    @Autowired
    ItextPDFService itextPDFService;

    @PostMapping("read")
    @ResponseBody
    public AjaxResult read(@RequestParam("file") MultipartFile file, HttpServletResponse resp) throws IOException, InvalidFormatException, DocumentException {



        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.put("data",file == null ? "": file.getOriginalFilename());
        ajaxResult.put("code", 0);
        ajaxResult.put("msg", "success");

//        ExcelData excelData = ExcelData.readExcel(testFile);
//
//        Sheet sheet = excelData.getWorkbook().getSheet("Contract-read only");
//        int rowCount = sheet.getLastRowNum()+1;
//        int colCount = excelData.getColumnCount(1);
//
//        Iterator<Row> rowIterator = sheet.rowIterator();
//        while (rowIterator.hasNext()) {
//            Row row = rowIterator.next();
//            float rowPixHeight = (row.getHeightInPoints() / 72) * 96;
//            int rowNUm =  row.getRowNum();
//        }

//        if (StringUtils.isEmpty(file.getOriginalFilename())){
//            //给定路径写文件
//            ExcelData.writeExcel(testFile,testFile,0,"E26","5.789");
//        }else{
//            //写流文件
//            ExcelData.writeExcel(file, outputPath,0,"E26","5");
//        }

// 先安装 Openoffice 调用 它的服务去进行转换（效果不好）
//        try{
//            startService();
//            System.out.println("进行文档转换转换:" + testFile + " --> " + pdfFile);
//            OfficeDocumentConverter converter = new OfficeDocumentConverter(officeManager);
//            converter.convert(new File(testFile), new File(pdfFile));
//        }
//        finally {
//            stopService();
//        }

        //调用 组件 转换 PDF
        ///refer:http://www.cnblogs.com/luckyxiaoxuan/archive/2012/06/13/2548331.html
        //1.下载jacob-1.18-M2.zip
        //2.解压出 jacob.jar 和 jacob-1.18-M2-x64.dll 放到这个项目中的src目录
        //3. idea->file-?project structure->Libraies 添加src\jacob.jar。
        //ExcelData.convertExcel2Pdf(testFile,2,pdfFile);


        //Grpc
        //String result = grpcClientService.sendMessage("ali");
        //String result = grpcClientService.entityByName("ali").toString();

        //itextPDFService.writePdf(pdfPath,pdfOutFile);

        //Excel2Pdf.excel2pdf(testFile,pdfOutFile);


        //success
        return ajaxResult;
    }





    @PostMapping("upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        //soffice -headless -accept="socket,host=127.0.0.1,port=8100;urp;" -nofirststartwizard
        startService();
        System.out.println("进行文档转换转换:" + testFile + " --> " + pdfFile);

        OfficeDocumentConverter converter = new OfficeDocumentConverter(officeManager);
        converter.convert(new File(testFile), new File(pdfFile));

        stopService();
        System.out.println();

        return "";
    }

    // 打开服务器
    public static void startService() {
        DefaultOfficeManagerConfiguration configuration = new DefaultOfficeManagerConfiguration();
        try {
            //RUN this at first: soffice -headless -accept="socket,host=127.0.0.1,port=8100;urp;" -nofirststartwizard
            System.out.println("准备启动服务....");

            configuration.setOfficeHome(OFFICE_HOME);// 设置OpenOffice.org安装目录
            configuration.setPortNumbers(PORT); // 设置转换端口，默认为8100
            configuration.setTaskExecutionTimeout(1000 * 60 * 5L);// 设置任务执行超时为5分钟
            configuration.setTaskQueueTimeout(1000 * 60 * 60 * 24L);// 设置任务队列超时为24小时

            officeManager = configuration.buildOfficeManager();
            officeManager.start(); // 启动服务
            System.out.println("office转换服务启动成功!");
        } catch (Exception ce) {
            System.out.println("office转换服务启动失败!详细信息:" + ce);
        }
    }

    // 关闭服务器
    public static void stopService() {
        System.out.println("关闭office转换服务....");
        if (officeManager != null) {
            officeManager.stop();
        }
        System.out.println("关闭office转换成功!");
    }









}
