package com.windy.Common;

import java.util.Base64;

public class StringUtils {


    public static String byte2String(byte[] bytes){
        //Base64 Encoded
        String encoded = Base64.getEncoder().encodeToString(bytes);

        return encoded;
    }

    public static byte[] string2Byte(String str){

        //Base64 Decoded
        byte[] decoded = Base64.getDecoder().decode(str);

        return decoded;

    }

    public static String revertStr(String str){


        return "";

    }
}
