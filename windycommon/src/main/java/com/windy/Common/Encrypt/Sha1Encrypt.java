package com.windy.Common.Encrypt;

import com.windy.Common.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;

public class Sha1Encrypt {

    public static String sha1Encrypt(String originStr){

        byte[] bytes = DigestUtils.sha1(originStr);

        return StringUtils.byte2String(bytes);

    }
    
}
