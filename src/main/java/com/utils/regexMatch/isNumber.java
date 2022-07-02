package com.utils.regexMatch;

import java.util.regex.Pattern;

public class isNumber {

    // 正则表达式判断是否这个字符串是否是数字组成
    public static boolean isNum(String string) {
        if (string == null)
            return false;
        Pattern pattern = Pattern.compile("[0-9]+");
        return pattern.matcher(string).matches();
    }
}
