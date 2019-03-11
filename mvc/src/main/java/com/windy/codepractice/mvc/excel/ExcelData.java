package com.windy.codepractice.mvc.excel;

import org.apache.poi.ss.formula.functions.Index;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelData {
//    private List<Cell> cells;
//    private List<Row> rows;
//    private List<Sheet> sheets;
    private Workbook workbook;

    public Workbook getWorkbook() {
        return workbook;
    }

    public void setWorkbook(Workbook workbook) {
        this.workbook = workbook;
    }


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
                if (cellRange.isInRange(curCell.getAddress().toString())) {
                    cells.add(curCell);
                }
            }
        }
        return cells;
    }


}
