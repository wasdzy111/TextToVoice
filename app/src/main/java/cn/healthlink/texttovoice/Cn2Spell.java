package cn.healthlink.texttovoice;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;

/**
 * 借助pinyin4j:2.5.0将汉字转换为汉语拼音
 */
public class Cn2Spell {

    public static StringBuffer stringBuffer = new StringBuffer();

    /**
     * 获取汉字的汉语拼音
     */
    public static String getPinYin(String chines) {
        stringBuffer.setLength(0);
        char[] nameChar = chines.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (int i = 0; i < nameChar.length; i++) {
            if (nameChar[i] > 128) {
                try {
                    stringBuffer.append(PinyinHelper.toHanyuPinyinStringArray(nameChar[i], defaultFormat)[0]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                stringBuffer.append(nameChar[i]);
            }
        }
        return stringBuffer.toString();
    }

}