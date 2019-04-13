package com.windy.Common.pdf;


import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;

import com.itextpdf.awt.geom.Rectangle2D;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.parser.GraphicsState;
import com.itextpdf.text.pdf.parser.TextRenderInfo;
import com.itextpdf.text.pdf.parser.ImageRenderInfo;
import com.itextpdf.text.pdf.parser.RenderListener;



public class PositionRenderListener implements RenderListener{

    private static final Logger logger = LoggerFactory.getLogger(PositionRenderListener.class);
    private static class Replacement{
        private String keyString;
        private String newText;
        /**
         * @return the keyString
         */
        public String getKeyString() {
            return keyString;
        }
        /**
         * @param keyString the keyString to set
         */
        public void setKeyString(String keyString) {
            this.keyString = keyString;
        }
        /**
         * @return the newText
         */
        public String getNewText() {
            return newText;
        }
        /**
         * @param newText the newText to set
         */
        public void setNewText(String newText) {
            this.newText = newText;
        }

    }

    private Map<String,String> replaceText = new HashMap<>();	//需要查找的文本
    private Map<String,Integer> replaceFontSize = new HashMap<>();	//需要查找的文本
    private Map<String, BaseColor> replaceFileColor = new HashMap<>();	//需要查找的文本
    private float defaultH;		///出现无法取到值的情况，默认为12
    private float fixHeight;	//可能出现无法完全覆盖的情况，提供修正的参数，默认为2

    public PositionRenderListener(Map<String,String> replaceText,Map<String,Integer> replaceFontSize,Map<String,BaseColor> replaceFileColor, float defaultH,float fixHeight) {
        this.replaceText = replaceText;
        this.replaceFontSize = replaceFontSize;
        this.replaceFileColor = replaceFileColor;
        this.defaultH = defaultH;
        this.fixHeight = fixHeight;
    }

    public PositionRenderListener(Map<String,String> replaceText,Map<String,Integer> replaceFontSize,Map<String,BaseColor> replaceFileColor) {
        this(replaceText, replaceFontSize, replaceFileColor, 12, 2);
    }

    @Override
    public void beginTextBlock() {
        //暂时未用到
    }

    @Override
    public void endTextBlock() {
        //暂时未用到
    }

    @Override
    public void renderImage(ImageRenderInfo imageInfo) {
        //暂时未用到
    }

    private Map<String, ReplaceRegion> result = new HashMap<>();
    @Override
    public void renderText(TextRenderInfo textInfo) {
        String findText = textInfo.getText();
        Replacement replacement = getReplacement(findText);

        if(replacement != null) {
            String keyString = replacement.getKeyString();
            ReplaceRegion replaceRegion = result.get(keyString);
            if(replaceRegion == null) {
                replaceRegion = new ReplaceRegion();
                result.put(keyString, replaceRegion);
            }
            Rectangle2D.Float bound = textInfo.getBaseline().getBoundingRectange();
            //反射获得实际的 fontsize
            int realFontSize = -1;
            try {
                Field fieldGs = TextRenderInfo.class.getDeclaredField("gs");
                fieldGs.setAccessible(true);

                GraphicsState gs = (GraphicsState)fieldGs.get(textInfo);
                float realFontSizeF = gs.getFontSize();

                BigDecimal b = new BigDecimal(realFontSizeF);
                realFontSize = b.setScale(0,BigDecimal.ROUND_HALF_UP).intValue();

            } catch (NoSuchFieldException | IllegalAccessException e) {
                logger.error("reflect error:",e);
            }
            int fontSize = 0;
            //反射获取成功
            if (realFontSize!= -1){
                fontSize = realFontSize;
            }else{
                fontSize = this.replaceFontSize.get(keyString) == null ? 0 : this.replaceFontSize.get(keyString);
            }
            replaceRegion.addRegion(bound.x, bound.y-this.fixHeight, bound.width, bound.height == 0 ? defaultH : bound.height,this.replaceFileColor.get(keyString),fontSize,replacement.getNewText());
        }
    }


    private Replacement getReplacement(String input) {
        Set<Map.Entry<String, String>> entrys = replaceText.entrySet();
        for (Map.Entry<String, String> entry : entrys) {
            String key = entry.getKey();
            String value = entry.getValue();
            //if(input.indexOf(key) != -1) {
            if(input.equals(key)){//全字匹配
                Replacement replacement = new Replacement();
                replacement.setKeyString(key);
                replacement.setNewText(input.replace(key, value));
                return replacement;
            }
        }
        return null;
    }


    public Collection<ReplaceRegion> getResult() {
        return this.result.values();
    }

}
