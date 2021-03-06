package com.windy.Common.excel;

import java.util.HashMap;

public class ColumnAlphaMapping {

    private static HashMap<String,Integer> indexAlphaMapping = new HashMap<String,Integer>();
    static Integer index = 0;
    static {

        String[] alphaArray = new String[] {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X",
                "Y","Z",};
        String[] limitColumn = new String[] {"A","B","C","D","E","F","G","H","I"};

        for (String s:alphaArray) {
            indexAlphaMapping.put(s,index);
            index++;
        }

        for (String s:limitColumn) {
            getColumnName(s,alphaArray);
            index++;
        }
    }

    static void getColumnName(String initAlpha,String[] alphaArray){
        for (String s:alphaArray) {
            indexAlphaMapping.put(initAlpha+s,index);
            index++;
        }
    }

    public static HashMap<String,Integer> getIndexAlphaMapping(){
        return indexAlphaMapping;
    }

}
