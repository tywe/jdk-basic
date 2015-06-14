package org.teng.basic.string;

/**
 * Created by Administrator on 15-6-13.
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
