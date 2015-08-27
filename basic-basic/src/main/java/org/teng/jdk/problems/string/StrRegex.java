package org.teng.jdk.problems.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * description:.
 *
 * @author:baichuan
 * @date:2015/8/27
 */
public class StrRegex {
    public static String replaceAll(String originStr, char splitor, String replacement) {
        if (originStr == null) {
            return null;
        }

        int splitorCount = 0;
        for (int i = 0, len = originStr.length(); i < len; i++) {
            if (originStr.charAt(i) == splitor) {
                splitorCount++;
            }
        }

        // 出现非字典标识的特殊字符%或根本没有%
        if (splitorCount % 2 != 0 || splitorCount == 0) {
            return originStr;
        }

        originStr = originStr.trim();
        String[] splitStrs = originStr.split(String.valueOf(splitor));

        int len = splitStrs.length;
        StringBuffer sbuff = new StringBuffer();

        for (int i = 1; i < len; i = i + 2) {
            sbuff.append(splitStrs[i - 1]).append(replacement);
        }

        //最后串补齐
        if (!((len % 2) == 0)) {
            sbuff.append(splitStrs[len - 1]);
        }

        return sbuff.toString();
    }

    public static boolean isAsrLegalPattern(String testStr) {
        // 当字符串为空或长度为0时，默认为非法的字符串，不进行存储
        testStr = testStr.trim();
        if (testStr.startsWith("^") && testStr.endsWith("$")) {
            testStr = testStr.substring(1, testStr.length() - 1);
        }

        // 避免%time%字典出现特殊连字符
        testStr = replaceAll(testStr, '%', "云");
        StringBuffer sbuff = new StringBuffer();
        // 过滤含？串
        String qfPattern = "(.*\\?+.*)+";
        // 过滤超过两个连续数字串
        String dfPattern = "(.*\\d{2,}.*)+";
        // 过滤超过两个连续字母串
        String afPattern = "(.*[a-z,A-Z]{2,}.*)+";
        // 过滤特殊字符
        String excludeCharPattern = "[`~!@#$^&*\\+\\-\\={}\\\\\\[\\]\\:\";'<>,./~·！@#￥……&*（）"
                + "——\\+\\-\\={}、：“”；‘’《》？，。、｀～！＠＃＄％＾＆＊（）＿＋－＝｛｝"
                + "｜［］＼：＂＂；＇＇＜＞？，"
                + "．／·～！＠＃￥％……＆×（）——＋－＝｛｝｜＼：“”；‘’《》？，。、]";
        String exludePattern = String.format("(.*%s+.*)+", excludeCharPattern);

        sbuff.append(exludePattern).append("|").append(qfPattern).append("|").append(dfPattern).append("|")
                .append(afPattern);

        Pattern r = Pattern.compile(sbuff.toString());
        Matcher m = r.matcher(testStr);

        // 匹配上面规则，则不符合语音句式要求
        return !m.matches();
    }

    public static void main(String[] args) {
        String testString = "%12%%term%";
        boolean status = isAsrLegalPattern(testString);
        System.out.println(status ? "true, 通用, -1" : "false, 语义, -3");
    }
}
