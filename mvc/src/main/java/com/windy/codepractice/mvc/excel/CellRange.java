package com.windy.codepractice.mvc.excel;

public class CellRange {

    public CellRange(String startAddress, String endAddress) {
        this.startAddress = startAddress;
        this.endAddress = endAddress;
    }
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

    public Boolean isInRange(String address){
        return false;
    }

    private String startAddress;
    private String endAddress;

}
