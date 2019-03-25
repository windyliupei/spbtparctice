package com.windy.codepractice.mvc.controll;

import com.windy.codepractice.mvc.AjaxResult;
import com.windy.codepractice.mvc.excel.ExcelData;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ReadController {

    @Value("${excel.outFilePath}")
    String outFilePath;

    @Value("${excel.test.filePath}")
    String testFile;

    @PostMapping("read")
    @ResponseBody
    public AjaxResult read(@RequestParam("file") MultipartFile file, HttpServletResponse resp) throws IOException, InvalidFormatException {



        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.put("data",file.getOriginalFilename());
        ajaxResult.put("code", 0);
        ajaxResult.put("msg", "success");

        if (StringUtils.isEmpty(file.getOriginalFilename())){
            //给定路径写文件
            ExcelData.writeExcel(testFile,testFile,0,"D24","new value"+System.currentTimeMillis());
        }else{
            //写流文件
            ExcelData.writeExcel(file,outFilePath,0,"D26","new Value"+System.currentTimeMillis());
        }

        //success
        return ajaxResult;
    }



    public static ExcelData readExcel3(MultipartFile file) throws IOException {

        //获得Workbook工作薄对象
        Workbook workbook = ExcelData.getWorkBook(file);
        ExcelData excelData = new ExcelData();
        excelData.setWorkbook(workbook);
        return excelData;
    }

    public static ExcelData readExcel2(String filePath) throws IOException, InvalidFormatException {

        //获得Workbook工作薄对象
        Workbook workbook = ExcelData.getWorkBook(filePath);
        ExcelData excelData = new ExcelData();
        excelData.setWorkbook(workbook);
        return excelData;
    }









}
