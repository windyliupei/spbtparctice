package com.windy.codepractice.mvc.excel;
//ref:https://www.cnblogs.com/dzpykj/p/8417738.html
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

public class ExcelData {

    private final static String OFFICE_EXCEL_XLS = "xls";
    private final static String OFFICE_EXCEL_XLSX = "xlsx";

    private Workbook workbook;

    public Workbook getWorkbook() {
        return workbook;
    }

    public void setWorkbook(Workbook workbook) {
        this.workbook = workbook;
    }


    /**
     * 获取指定的Cell
     * @param sheetIndex sheet序号,从0开始
     * @param cellAddress cell 的 Address 例如 A1
     */
    public Cell getCell(Integer sheetIndex,String cellAddress){

        Cell cell = null;

        if (this.workbook==null){
            return cell;
        }else {
            Sheet targetSheet= workbook.getSheetAt(sheetIndex);
            if (targetSheet==null){
                return cell;
            }else{
                cell = getCell(cellAddress, cell, targetSheet);
            }
        }

        return cell;
    }

    /**
     * 获取指定的Cell
     * @param sheetName sheet名称
     * @param cellAddress cell 的 Address 例如 A1
     */
    public Cell getCell(String sheetName,String cellAddress){

        Cell cell = null;

        if (this.workbook==null){
            return cell;
        }else {
            Sheet targetSheet= workbook.getSheet(sheetName);
            if (targetSheet==null){
                return cell;
            }else{
                cell = getCell(cellAddress, cell, targetSheet);
            }
        }

        return cell;
    }

    /**
     * 获取指定的Cell
     * @param sheetIndex sheet序号,从0开始
     * @param cellRange cell 的 Address范围 例如 A1-B3
     */
    public List<Cell> getCells(Integer sheetIndex,CellRange cellRange){

        List<Cell> cells = new ArrayList<Cell>();

        if (this.workbook==null){
            return cells;
        }else {
            Sheet targetSheet= workbook.getSheetAt(sheetIndex);
            if (targetSheet==null){
                return cells;
            }else{
                cells = getCells(cellRange,targetSheet);
            }
        }

        return cells;
    }

    /**
     * 获取指定的Cell
     * @param sheetName sheet名称
     * @param cellRange cell 的 Address范围 例如 A1-B3
     */
    public List<Cell> getCells(String sheetName,CellRange cellRange){

        List<Cell> cells = new ArrayList<Cell>();

        if (this.workbook==null){
            return cells;
        }else {
            Sheet targetSheet= workbook.getSheet(sheetName);
            if (targetSheet==null){
                return cells;
            }else{
                cells = getCells(cellRange,targetSheet);
            }
        }

        return cells;
    }





    /**
     * 根据文件路径获取Workbook对象
     * @param filePath 文件全路径
     */
    public static Workbook getWorkBook(String filePath)
            throws EncryptedDocumentException, InvalidFormatException, IOException {
        InputStream is = null;
        Workbook wb = null;
        checkFile(filePath);

        try {
            is = new FileInputStream(filePath);
            wb = WorkbookFactory.create(is);
        } finally {
            if (is != null) {
                is.close();
            }
            if (wb != null) {
                wb.close();
            }
        }
        return wb;
    }


    /**
     * 根据文件路径获取Workbook对象
     * @param file 上传文件
     */
    public static Workbook getWorkBook(MultipartFile file) {
        //获得文件名
        String fileName = file.getOriginalFilename();
        //创建Workbook工作薄对象，表示整个excel
        Workbook workbook = null;
        try {
            //获取excel文件的io流
            InputStream is = file.getInputStream();
            //根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
            if(fileName.endsWith(OFFICE_EXCEL_XLS)){
                //2003
                workbook = new HSSFWorkbook(is);
            }else if(fileName.endsWith(OFFICE_EXCEL_XLSX)){
                //2007
                workbook = new XSSFWorkbook(is);
            }
        } catch (IOException e) {

        }
        return workbook;
    }


    /**
     * 创建Excel文件
     * @param  inPath 文件全路径
     * @param outPath 新路径
     * @param sheetIndex sheet index
     * @param cellAddress 单元格的Address
     * @param newValue 新的值
     */
    public static boolean writeExcel(String inPath,String outPath, Integer sheetIndex, String cellAddress,String newValue) throws IOException, InvalidFormatException {
        Boolean success = false;

        //读取原始Excel
        Workbook workBook = getWorkBook(inPath);
        ExcelData excelData = new ExcelData();
        excelData.setWorkbook(workBook);

        //查找Cell并更新值
        Cell cell = excelData.getCell(sheetIndex, cellAddress);
        cell.setCellValue(newValue);

        //保存
        FileOutputStream excelFileOutPutStream = new FileOutputStream(outPath);
        workBook.write(excelFileOutPutStream);
        excelFileOutPutStream.flush();
        excelFileOutPutStream.close();

        return success;
    }


    private static void checkFile(MultipartFile file) throws IOException{
        //判断文件是否存在
        if(null == file){
            throw new FileNotFoundException("文件不存在！");
        }
        //获得文件名
        String fileName = file.getOriginalFilename();
        //判断文件是否是excel文件
        if(!fileName.endsWith(OFFICE_EXCEL_XLS) && !fileName.endsWith(OFFICE_EXCEL_XLSX)){
            throw new IOException(fileName + "不是excel文件");
        }
    }

    private static void checkFile(String filePath) throws IOException{
        if (StringUtils.isBlank(filePath)) {
            throw new IllegalArgumentException("文件不存在");
        }
        //判断文件是否是excel文件
        if(!filePath.endsWith(OFFICE_EXCEL_XLS) && !filePath.endsWith(OFFICE_EXCEL_XLSX)){
            throw new IOException(filePath + "不是excel文件");
        }
    }

    private Cell getCell(String cellAddress, Cell cell, Sheet targetSheet) {
        Iterator<Row> rowIterator = targetSheet.rowIterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell curCell = cellIterator.next();
                if (curCell.getAddress().toString().equals(cellAddress)) {
                    cell = curCell;
                    return cell;
                }
            }
        }
        return cell;
    }

    private List<Cell> getCells(CellRange cellRange,Sheet targetSheet) {

        List<Cell> cells = new ArrayList<Cell>();

        Iterator<Row> rowIterator = targetSheet.rowIterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell curCell = cellIterator.next();
                if (cellRange.isInRange(curCell)) {
                    cells.add(curCell);
                }
            }
        }
        return cells;
    }
}
