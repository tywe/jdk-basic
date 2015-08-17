package org.teng.jdk.simple.string;

/**
 * 字符串格式化
 *
 * @author baichuan
 * @date 2015-8-16
 */
public class StringFormatter {
    private static final String PREFIX_FORMATTER = "****-%S-****";


    public static String formatter(String param){
        return String.format(PREFIX_FORMATTER, param);
    }


    public static void main(String[] args){
        System.out.println(formatter("你好"));
    }
}
