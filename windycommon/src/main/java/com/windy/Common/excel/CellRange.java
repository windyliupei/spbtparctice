package com.windy.Common.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.springframework.util.StringUtils;

import java.util.HashMap;

public class CellRange {

    //startAddress :A1
    //endAddress :B5
    public CellRange(String startAddress, String endAddress) {
        this.startAddress = startAddress;
        this.endAddress = endAddress;
    }

    //addressRange:A1-B5
    public CellRange(String addressRange) {
         if (addressRange.contains("-")){
             String[] startEnd= addressRange.split("_");
             if(startEnd.length>1){
                 this.startAddress = startEnd[0];
                 this.endAddress = startEnd[1];
             }
         }

    }

    public String getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(String startAddress) {
        this.startAddress = startAddress;
    }

    public String getEndAddress() {
        return endAddress;
    }

    public void setEndAddress(String endAddress) {
        this.endAddress = endAddress;
    }

    //判断输入的 Cell 的Address是否在本范围内
    // A2 在 A1～A3内，
    //Excel：行号为数字1～65536，列为A～IV，所以Cell为A1～IV65536
    public Boolean isInRange(Cell cell){

        int cellRowIndex = cell.getRowIndex();
        int cellColIndex = cell.getColumnIndex();

        int startRowIndex = getRowIndex(this.startAddress);
        int startColumnIndex = getColumnIndex(this.startAddress);

        int endRowIndex = getRowIndex(this.endAddress);
        int endColumnIndex = getColumnIndex(this.endAddress);

        if ( (cellRowIndex>=startRowIndex &&  cellRowIndex<=endRowIndex)
        &&   (cellColIndex>=startColumnIndex &&  cellColIndex<=endColumnIndex)
        ){
            return true;
        }

        return false;
    }

    public static int getRowIndex(String address){
        String[] rowColumn = getRowColumn(address);
        return Integer.parseInt(rowColumn[1])-1;
    }

    private static String[] getRowColumn(String address) {
        int firstDigitIndex = 0;
        char[] split = address.toCharArray();

        for (char c:split) {
            if (Character.isDigit(c)){
                break;
            }
            firstDigitIndex++;
        }
        String column = address.substring(0,firstDigitIndex);
        String row    = address.substring(firstDigitIndex,address.length());

        String[] addressSplit = new String[]{column,row};

        return addressSplit;
    }

    public static int getColumnIndex(String address){
        String[] rowColumn = getRowColumn(address);

        HashMap<String,Integer> indexAlphaMapping = ColumnAlphaMapping.getIndexAlphaMapping();
        return indexAlphaMapping.get(rowColumn[0]);
    }

    private String startAddress;
    private String endAddress;

}
