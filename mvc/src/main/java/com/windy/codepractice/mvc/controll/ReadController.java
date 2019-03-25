package com.windy.codepractice.mvc.controll;

import com.windy.codepractice.mvc.AjaxResult;
import com.windy.codepractice.mvc.excel.CellRange;
import com.windy.codepractice.mvc.excel.ColumnAlphaMapping;
import com.windy.codepractice.mvc.excel.ExcelData;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@Controller
public class ReadController {




    @PostMapping("read")
    @ResponseBody
    public AjaxResult read(@RequestParam("file") MultipartFile file, HttpServletResponse resp) throws IOException, InvalidFormatException {

        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.put("data",file.getOriginalFilename());
        ajaxResult.put("code", 0);
        ajaxResult.put("msg", "success");

//        ExcelData excelData = readExcel3(file);
//
        String filePath = "C:\\WorkSpace\\RelateProject\\Saas\\私自\\戴姆勒\\Templates\\Templates\\Contract\\CIP.xls";
//        ExcelData excelData2 =readExcel2(filePath);
//        Cell cell = excelData2.getCell(0, "A1");


        ExcelData.writeExcel(filePath,filePath,0,"A1","new value");

//        Cell a1 = excelData.getCell(0, "A1");
//        CellRange cellRange = new CellRange("A1","B3");
//        List<Cell> cells = excelData.getCells(0, cellRange);


        //success
        return ajaxResult;
    }

    public String redirect(){
        return "writeExcel";
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
