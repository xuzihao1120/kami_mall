package com.kami.mall.java.comons.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangzi
 * @date 2021-07-08 7:32 PM
 */


import com.sun.org.glassfish.gmbal.Description;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @program: myutil
 * @description: 字符串工具类
 * @author: ChenWenLong
 * @create: 2019-05-21 15:30
 **/
public class StringUtils {

    public static final String EMPTY = "";
    public static final int INDEX_NOT_FOUND = -1;
    private static final int PAD_LIMIT = 8192;

    public StringUtils() {
        super();
    }

    /**
     * 功能描述:
     * 〈判断字符串是否为空.不包含空白字符串〉
     *
     * @return : boolean
     * @params : [str]
     * @author : cwl
     * @date : 2019/5/27 15:01
     */
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    /**
     * 功能描述:
     * 〈判断字符串不为空,不包含空白字符串〉
     *
     * @return : boolean
     * @params : [str]
     * @author : cwl
     * @date : 2019/5/27 15:02
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 功能描述:
     * 〈判断是否为空白字符串〉
     *
     * @return : boolean
     * @params : [str]
     * @author : cwl
     * @date : 2019/5/27 15:03
     */
    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 功能描述:
     * 〈判断是否不为空白字符串〉
     *
     * @return : boolean
     * @params : [str]
     * @author : cwl
     * @date : 2019/5/27 15:03
     */
    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    /**
     * 功能描述:
     * 〈去除字符串中间的空白〉
     *
     * @return : java.lang.String
     * @params : [util]
     * @author : cwl
     * @date : 2019/5/21 16:29
     */
    @Deprecated
    public static String removeBlank(String string) {
        if (string == null || " ".equals(string)) {
            throw new IllegalArgumentException("It is a not legal param");
        }
        return string.trim().replaceAll(" ", "");
    }

    /**
     * 功能描述:
     * 〈去除字符串当中的空白〉
     *
     * @return : java.lang.String
     * @params : [str]
     * @author : cwl
     * @date : 2019/5/29 14:31
     */
    public static String deleteWhitespace(String str) {
        if (isEmpty(str)) {
            return str;
        }
        int sz = str.length();
        char[] chs = new char[sz];
        int count = 0;
        for (int i = 0; i < sz; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                chs[count++] = str.charAt(i);
            }
        }
        if (count == sz) {
            return str;
        }
        return new String(chs, 0, count);
    }

    /**
     * 功能描述:
     * 〈去除空白字符串,null转换为null〉
     *
     * @return : java.lang.String
     * @params : [str]
     * @author : cwl
     * @date : 2019/5/27 15:08
     */
    public static String trim(String str) {
        return str == null ? null : str.trim();
    }

    /**
     * 功能描述:
     * 〈去除空白字符串,只要包含空白字符串,就转成null〉
     *
     * @return : java.lang.String
     * @params : [str]
     * @author : cwl
     * @date : 2019/5/27 15:09
     */
    public static String trimToNull(String str) {
        String ts = trim(str);
        return isEmpty(ts) ? null : ts;
    }

    /**
     * 功能描述:
     * 〈去除空白字符串,null转成空白字符串〉
     *
     * @return : java.lang.String
     * @params : [str]
     * @author : cwl
     * @date : 2019/5/27 15:10
     */
    public static String trimToEmpty(String str) {
        return str == null ? EMPTY : str.trim();
    }

    /**
     * 功能描述:
     * 〈找到searchStr在str中ordinal次出现的位置〉
     *
     * @return : int
     * @params : [str, searchStr, ordinal]
     * @author : cwl
     * @date : 2019/5/27 15:30
     */
    public static int ordinalIndexOf(String str, String searchStr, int ordinal) {
        if (str == null || searchStr == null || ordinal <= 0) {
            return INDEX_NOT_FOUND;
        }
        if (searchStr.length() == 0) {
            return 0;
        }
        int found = 0;
        int index = INDEX_NOT_FOUND;
        do {
            index = str.indexOf(searchStr, index + 1);
            if (index < 0) {
                return index;
            }
            found++;
        } while (found < ordinal);
        return index;
    }

    /**
     * 功能描述:
     * 〈判断str中是否包含searchStr〉
     *
     * @return : boolean
     * @params : [str, searchStr]
     * @author : cwl
     * @date : 2019/5/27 15:34
     */
    public static boolean contains(String str, String searchStr) {
        if (str == null || searchStr == null) {
            return false;
        }
        return str.indexOf(searchStr) >= 0;
    }

    /**
     * 功能描述:
     * 〈判断str中是否包含searchStr,忽略大小写〉
     *
     * @return : boolean
     * @params : [str, searchStr]
     * @author : cwl
     * @date : 2019/5/27 15:33
     */
    public static boolean containsIgnoreCase(String str, String searchStr) {
        if (str == null || searchStr == null) {
            return false;
        }
        return contains(str.toUpperCase(), searchStr.toUpperCase());
    }

    /**
     * 功能描述:
     * 〈str中完全不包含invalidChars〉
     *
     * @return : boolean
     * @params : [str, invalidChars]
     * @author : cwl
     * @date : 2019/5/27 15:39
     */
    public static boolean containsNone(String str, char[] invalidChars) {
        if (str == null || invalidChars == null) {
            return true;
        }
        int strSize = str.length();
        int validSize = invalidChars.length;
        for (int i = 0; i < strSize; i++) {
            char ch = str.charAt(i);
            for (int j = 0; j < validSize; j++) {
                if (invalidChars[j] == ch) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 功能描述:
     * 〈从start位置开始裁剪字符串,如果字符串为负数,则从后面进行裁剪,如果此时start仍然为负数,则当做0处理〉
     *
     * @return : java.lang.String
     * @params : [str, start]
     * @author : cwl
     * @date : 2019/5/27 15:47
     */
    public static String substring(String str, int start) {
        if (str == null) {
            return null;
        }
        // 处理负号，也就是最后n个字符
        if (start < 0) {
            // 记住start是负的
            start = str.length() + start;
        }

        if (start < 0) {
            start = 0;
        }
        if (start > str.length()) {
            return EMPTY;
        }

        return str.substring(start);
    }

    /**
     * 功能描述:
     * 〈指定开始和结束位置进行裁剪〉
     *
     * @return : java.lang.String
     * @params : [str, start, end]
     * @author : cwl
     * @date : 2019/5/27 15:52
     */
    public static String substring(String str, int start, int end) {
        if (str == null) {
            return null;
        }

        // 处理负号
        if (end < 0) {
            end = str.length() + end;
        }
        if (start < 0) {
            start = str.length() + start;
        }

        // 校验文本长度
        if (end > str.length()) {
            end = str.length();
        }

        // 如果开始比结束要长,则返回空字符串
        if (start > end) {
            return EMPTY;
        }

        if (start < 0) {
            start = 0;
        }
        if (end < 0) {
            end = 0;
        }

        return str.substring(start, end);
    }

    /**
     * 功能描述:
     * 〈从左边开始指定位置裁剪〉
     *
     * @return : java.lang.String
     * @params : [str, len]
     * @author : cwl
     * @date : 2019/5/27 15:53
     */
    public static String leftSubstring(String str, int len) {
        if (str == null) {
            return null;
        }
        if (len < 0) {
            return EMPTY;
        }
        if (str.length() <= len) {
            return str;
        }
        return str.substring(0, len);
    }

    /**
     * 功能描述:
     * 〈从右边开始指定位置裁剪〉
     *
     * @return : java.lang.String
     * @params : [str, len]
     * @author : cwl
     * @date : 2019/5/27 15:54
     */
    public static String right(String str, int len) {
        if (str == null) {
            return null;
        }
        if (len < 0) {
            return EMPTY;
        }
        if (str.length() <= len) {
            return str;
        }
        return str.substring(str.length() - len);
    }

    /**
     * 功能描述:
     * 〈指定separator字符进行分割,返回左边的字符串〉
     *
     * @return : java.lang.String
     * @params : [str, separator]
     * @author : cwl
     * @date : 2019/5/27 15:56
     */
    public static String substringBefore(String str, String separator) {
        if (isEmpty(str) || separator == null) {
            return str;
        }
        if (separator.length() == 0) {
            return EMPTY;
        }
        int pos = str.indexOf(separator);
        if (pos == -1) {
            return str;
        }
        return str.substring(0, pos);
    }

    /**
     * 功能描述:
     * 〈指定separator字符进行切割,返回右边的字符串〉
     *
     * @return : java.lang.String
     * @params : [str, separator]
     * @author : cwl
     * @date : 2019/5/27 15:59
     */
    public static String substringAfter(String str, String separator) {
        if (isEmpty(str)) {
            return str;
        }
        if (separator == null) {
            return EMPTY;
        }
        int pos = str.indexOf(separator);
        if (pos == -1) {
            return EMPTY;
        }
        return str.substring(pos + separator.length());
    }

    /**
     * 功能描述:
     * 〈指定separator裁剪str,在separator最后一次出现之前,全部裁剪出来〉
     *
     * @return : java.lang.String
     * @params : [str, separator]
     * @author : cwl
     * @date : 2019/5/27 16:01
     */
    public static String substringBeforeLast(String str, String separator) {
        if (isEmpty(str) || isEmpty(separator)) {
            return str;
        }
        int pos = str.lastIndexOf(separator);
        if (pos == -1) {
            return str;
        }
        return str.substring(0, pos);
    }

    /**
     * 功能描述:
     * 〈指定separator裁剪str,在separator第一次出现之前,全部裁剪出来〉
     *
     * @return : java.lang.String
     * @params : [str, separator]
     * @author : cwl
     * @date : 2019/5/27 16:12
     */
    public static String substringAfterLast(String str, String separator) {
        if (isEmpty(str)) {
            return str;
        }
        if (isEmpty(separator)) {
            return EMPTY;
        }
        int pos = str.lastIndexOf(separator);
        if (pos == -1 || pos == (str.length() - separator.length())) {
            return EMPTY;
        }
        return str.substring(pos + separator.length());
    }

    /**
     * 功能描述:
     * 〈指定str在tag中间包围的这部分字符串将被裁剪并且返回〉
     *
     * @return : java.lang.String
     * @params : [str, tag]
     * @author : cwl
     * @date : 2019/5/27 16:14
     */
    public static String substringBetween(String str, String tag) {
        return substringBetween(str, tag, tag);
    }

    /**
     * 功能描述:
     * 〈指定裁剪出str中open和close包含着的那部分字符串〉
     *
     * @return : java.lang.String
     * @params : [str, open, close]
     * @author : cwl
     * @date : 2019/5/27 16:15
     */
    public static String substringBetween(String str, String open, String close) {
        if (str == null || open == null || close == null) {
            return null;
        }
        int start = str.indexOf(open);
        if (start != -1) {
            int end = str.indexOf(close, start + open.length());
            if (end != -1) {
                return str.substring(start + open.length(), end);
            }
        }
        return null;
    }

    /**
     * 功能描述:
     * 〈指定裁剪出str中open和close包含着的那部分字符串,返回一个字符串数组〉
     *
     * @return : java.lang.String[]
     * @params : [str, open, close]
     * @author : cwl
     * @date : 2019/5/27 17:03
     */
    public static String[] substringsBetween(String str, String open, String close) {
        if (str == null || isEmpty(open) || isEmpty(close)) {
            return null;
        }
        int strLen = str.length();
        if (strLen == 0) {
            return new String[0];
        }
        int closeLen = close.length();
        int openLen = open.length();
        List list = new ArrayList();
        int pos = 0;
        while (pos < (strLen - closeLen)) {
            int start = str.indexOf(open, pos);
            if (start < 0) {
                break;
            }
            start += openLen;
            int end = str.indexOf(close, start);
            if (end < 0) {
                break;
            }
            list.add(str.substring(start, end));
            pos = end + closeLen;
        }
        if (list.isEmpty()) {
            return null;
        }
        return (String[]) list.toArray(new String[list.size()]);
    }

    /**
     * 功能描述:
     * 〈根据字符类型分割,区分大小写〉
     *
     * @return : java.lang.String[]
     * @params : [str]
     * @author : cwl
     * @date : 2019/5/28 9:32
     */
    public static String[] splitByCharacterType(String str) {
        return splitByCharacterType(str, false);
    }

    /**
     * 功能描述:
     * 〈根据字符类型分割,按照驼峰表示法来分割〉
     *
     * @return : java.lang.String[]
     * @params : [str]
     * @author : cwl
     * @date : 2019/5/28 9:33
     */
    public static String[] splitByCharacterTypeCamelCase(String str) {
        return splitByCharacterType(str, true);
    }

    /**
     * 功能描述:
     * 〈根据字符类型分割,camelCase为true时使用驼峰表示法分割,当camelCase为false时,则直接根据大小写进行分割〉
     *
     * @return : java.lang.String[]
     * @params : [str, camelCase]
     * @author : cwl
     * @date : 2019/5/28 9:37
     */
    private static String[] splitByCharacterType(String str, boolean camelCase) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return new String[0];
        }
        char[] c = str.toCharArray();
        List list = new ArrayList();
        int tokenStart = 0;
        int currentType = Character.getType(c[tokenStart]);
        for (int pos = tokenStart + 1; pos < c.length; pos++) {
            int type = Character.getType(c[pos]);
            if (type == currentType) {
                continue;
            }
            if (camelCase && type == Character.LOWERCASE_LETTER && currentType == Character.UPPERCASE_LETTER) {
                int newTokenStart = pos - 1;
                if (newTokenStart != tokenStart) {
                    list.add(new String(c, tokenStart, newTokenStart - tokenStart));
                    tokenStart = newTokenStart;
                }
            } else {
                list.add(new String(c, tokenStart, pos - tokenStart));
                tokenStart = pos;
            }
            currentType = type;
        }
        list.add(new String(c, tokenStart, c.length - tokenStart));
        return (String[]) list.toArray(new String[list.size()]);
    }

    /**
     * 功能描述:
     * 〈根据defaultStr分割str,index为返回的索引位置〉
     *
     * @params : [str, defaultStr]
     * @return : java.lang.String
     * @author : cwl
     * @date : 2019/6/12 15:31
     */
    public static String split(String str,String defaultStr,int index){
        if(null == str || str.length() == 0 || null == defaultStr){
            return "";
        }
        String[] split = str.split(defaultStr);
        return split[index];
    }

    /**
     * 功能描述:
     * 〈根据defaultStr分割str,index为返回的索引位置〉
     *A
     * @params : [str, defaultStr, index]
     * @return : java.lang.String
     * @author : cwl
     * @date : 2019/6/12 15:36
     */
    public static String split(String str,char defaultStr,int index){
        if(null == str || str.length() == 0){
            return "";
        }
        String[] split = str.split(String.valueOf(defaultStr));
        return split[index];
    }

    /**
     * 功能描述:
     * 〈将数组连接成为字符串,忽略null〉
     *
     * @return : java.lang.String
     * @params : [array]
     * @author : cwl
     * @date : 2019/5/28 9:39
     */
    public static String concatenate(Object[] array) {
        return "";
    }

    /**
     * 功能描述:
     * 〈根据字符separator连接array数组〉
     *
     * @return : java.lang.String
     * @params : [array, separator]
     * @author : cwl
     * @date : 2019/5/28 9:44
     */
    public static String join(Object[] array, char separator) {
        if (array == null) {
            return null;
        }

        return join(array, separator, 0, array.length);
    }

    /**
     * 功能描述:
     * 〈array数组根据separator字符,指定从startIndex开始到endIndex连接在一起〉
     *
     * @return : java.lang.String
     * @params : [array, separator, startIndex, endIndex]
     * @author : cwl
     * @date : 2019/5/28 11:20
     */
    public static String join(Object[] array, char separator, int startIndex, int endIndex) {
        if (array == null) {
            return null;
        }
        int bufSize = (endIndex - startIndex);
        if (bufSize <= 0) {
            return EMPTY;
        }

        bufSize *= ((array[startIndex] == null ? 16 : array[startIndex].toString().length()) + 1);
        StringBuffer buf = new StringBuffer(bufSize);

        for (int i = startIndex; i < endIndex; i++) {
            if (i > startIndex) {
                buf.append(separator);
            }
            if (array[i] != null) {
                buf.append(array[i]);
            }
        }
        return buf.toString();
    }

    /**
     * 功能描述:
     * 〈传入一个集合的迭代器iterator,使用separator将这个集合连接起来〉
     *
     * @return : java.lang.String
     * @params : [iterator, separator]
     * @author : cwl
     * @date : 2019/5/29 9:42
     */
    public static String join(Iterator iterator, char separator) {

        // 处理null,0或者是只有一个元素的情况
        if (iterator == null) {
            return null;
        }
        if (!iterator.hasNext()) {
            return EMPTY;
        }
        Object first = iterator.next();
        if (!iterator.hasNext()) {
            return first == null ? "" : first.toString();
        }

        // Java默认是16个字符,可能会太小了
        StringBuffer buf = new StringBuffer(256);
        if (first != null) {
            buf.append(first);
        }

        while (iterator.hasNext()) {
            buf.append(separator);
            Object obj = iterator.next();
            if (obj != null) {
                buf.append(obj);
            }
        }

        return buf.toString();
    }

    /**
     * 功能描述:
     * 〈传入一个集合的迭代器iterator,使用separator将这个集合连接起来〉
     *
     * @return : java.lang.String
     * @params : [iterator, separator]
     * @author : cwl
     * @date : 2019/5/29 14:28
     */
    public static String join(Iterator iterator, String separator) {

        // handle null, zero and one elements before building a buffer
        if (iterator == null) {
            return null;
        }
        if (!iterator.hasNext()) {
            return EMPTY;
        }
        Object first = iterator.next();
        if (!iterator.hasNext()) {
            return first == null ? "" : first.toString();
        }

        StringBuffer buf = new StringBuffer(256);
        if (first != null) {
            buf.append(first);
        }

        while (iterator.hasNext()) {
            if (separator != null) {
                buf.append(separator);
            }
            Object obj = iterator.next();
            if (obj != null) {
                buf.append(obj);
            }
        }
        return buf.toString();
    }

    /**
     * 功能描述:
     * 〈传入一个集合collection,使用separator将这个集合连接起来〉
     *
     * @return : java.lang.String
     * @params : [collection, separator]
     * @author : cwl
     * @date : 2019/5/29 14:29
     */
    public static String join(Collection collection, char separator) {
        if (collection == null) {
            return null;
        }
        return join(collection.iterator(), separator);
    }

    /**
     * 功能描述:
     * 〈传入一个集合collection,使用separator将这个集合连接起来〉
     *
     * @return : java.lang.String
     * @params : [collection, separator]
     * @author : cwl
     * @date : 2019/5/29 14:30
     */
    public static String join(Collection collection, String separator) {
        if (collection == null) {
            return null;
        }
        return join(collection.iterator(), separator);
    }

    /**
     * 功能描述:
     * 〈将str中从左到右删除remove〉
     *
     * @return : java.lang.String
     * @params : [str, remove]
     * @author : cwl
     * @date : 2019/5/29 14:32
     */
    public static String removeStart(String str, String remove) {
        if (isEmpty(str) || isEmpty(remove)) {
            return str;
        }
        if (str.startsWith(remove)) {
            return str.substring(remove.length());
        }
        return str;
    }

    /**
     * 功能描述:
     * 〈将str中从左到右删除remove,忽略大小写〉
     *
     * @return : java.lang.String
     * @params : [str, remove]
     * @author : cwl
     * @date : 2019/5/29 14:33
     */
    public static String removeStartIgnoreCase(String str, String remove) {
        if (isEmpty(str) || isEmpty(remove)) {
            return str;
        }
        if (startsWithIgnoreCase(str, remove)) {
            return str.substring(remove.length());
        }
        return str;
    }

    /**
     * 功能描述:
     * 〈将str中从右到左删除remove〉
     *
     * @return : java.lang.String
     * @params : [str, remove]
     * @author : cwl
     * @date : 2019/5/29 14:34
     */
    public static String removeEnd(String str, String remove) {
        if (isEmpty(str) || isEmpty(remove)) {
            return str;
        }
        if (str.endsWith(remove)) {
            return str.substring(0, str.length() - remove.length());
        }
        return str;
    }

    /**
     * 功能描述:
     * 〈将str中从右到左删除remove,忽略大小写〉
     *
     * @return : java.lang.String
     * @params : [str, remove]
     * @author : cwl
     * @date : 2019/5/29 14:34
     */
    public static String removeEndIgnoreCase(String str, String remove) {
        if (isEmpty(str) || isEmpty(remove)) {
            return str;
        }
        if (endsWithIgnoreCase(str, remove)) {
            return str.substring(0, str.length() - remove.length());
        }
        return str;
    }

    /**
     * 功能描述:
     * 〈将remove从str中删除〉
     *
     * @return : java.lang.String
     * @params : [str, remove]
     * @author : cwl
     * @date : 2019/5/29 14:35
     */
    public static String remove(String str, String remove) {
        if (isEmpty(str) || isEmpty(remove)) {
            return str;
        }
        return replace(str, remove, EMPTY, -1);
    }

    /**
     * 功能描述:
     * 〈将remove从str中删除〉
     *
     * @return : java.lang.String
     * @params : [str, remove]
     * @author : cwl
     * @date : 2019/5/29 14:35
     */
    public static String remove(String str, char remove) {
        if (isEmpty(str) || str.indexOf(remove) == -1) {
            return str;
        }
        char[] chars = str.toCharArray();
        int pos = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != remove) {
                chars[pos++] = chars[i];
            }
        }
        return new String(chars, 0, pos);
    }

    /**
     * 功能描述:
     * 〈从左到右从text中找到第一个searchString,将它替换成为replacement〉
     *
     * @return : java.lang.String
     * @params : [text, searchString, replacement]
     * @author : cwl
     * @date : 2019/5/29 14:37
     */
    public static String replaceOnce(String text, String searchString, String replacement) {
        return replace(text, searchString, replacement, 1);
    }

    /**
     * 功能描述:
     * 〈将text中的searching都替换成为replacement〉
     *
     * @return : java.lang.String
     * @params : [text, searchString, replacement]
     * @author : cwl
     * @date : 2019/5/29 14:38
     */
    public static String replace(String text, String searchString, String replacement) {
        return replace(text, searchString, replacement, -1);
    }

    /**
     * 功能描述:
     * 〈将text中的searching都替换成为replacement,max为最大替换长度,如果max小于0,则表示为全部替换〉
     *
     * @return : java.lang.String
     * @params : [text, searchString, replacement, max]
     * @author : cwl
     * @date : 2019/5/29 14:40
     */
    public static String replace(String text, String searchString, String replacement, int max) {
        if (isEmpty(text) || isEmpty(searchString) || replacement == null || max == 0) {
            return text;
        }
        int start = 0;
        int end = text.indexOf(searchString, start);
        if (end == -1) {
            return text;
        }
        int replLength = searchString.length();
        int increase = replacement.length() - replLength;
        increase = (increase < 0 ? 0 : increase);
        increase *= (max < 0 ? 16 : (max > 64 ? 64 : max));
        StringBuffer buf = new StringBuffer(text.length() + increase);
        while (end != -1) {
            buf.append(text.substring(start, end)).append(replacement);
            start = end + replLength;
            if (--max == 0) {
                break;
            }
            end = text.indexOf(searchString, start);
        }
        buf.append(text.substring(start));
        return buf.toString();
    }

    /**
     * 功能描述:
     * 〈将text中存在searchList全部替换成replacementList数组〉
     *
     * @return : java.lang.String
     * @params : [text, searchList, replacementList]
     * @author : cwl
     * @date : 2019/5/29 14:43
     */
    public static String replaceEach(String text, String[] searchList, String[] replacementList) {
        return replaceEach(text, searchList, replacementList, false, 0);
    }

    /**
     * 功能描述:
     * 〈将text中存在searchList全部替换成replacementList数组,timeToLive表示的是训话的次数,如果它小于0,则结束递归〉
     *
     * @return : java.lang.String
     * @params : [text, searchList, replacementList, repeat, timeToLive]
     * @author : cwl
     * @date : 2019/5/29 15:24
     */
    private static String replaceEach(String text, String[] searchList, String[] replacementList,
                                      boolean repeat, int timeToLive) {
        //这个类只能用于创建少量的对象,如果有性能方面的要求,可以自己定义一个固定大小的String[]
        if (text == null || text.length() == 0 || searchList == null ||
                searchList.length == 0 || replacementList == null || replacementList.length == 0) {
            return text;
        }

        //如果要进行递归,则timeToLive就不应该小于0
        if (timeToLive < 0) {
            throw new IllegalStateException("TimeToLive of " + timeToLive + " is less than 0: " + text);
        }

        int searchLength = searchList.length;
        int replacementLength = replacementList.length;

        // 确保长度是相等的
        if (searchLength != replacementLength) {
            throw new IllegalArgumentException("Search and Replace array lengths don't match: "
                    + searchLength
                    + " vs "
                    + replacementLength);
        }

        boolean[] noMoreMatchesForReplIndex = new boolean[searchLength];
        int textIndex = -1;
        int replaceIndex = -1;
        int tempIndex = -1;

        // 替换数组的索引，该数组将替换找到的搜索字符串
        // 进行逻辑复制
        for (int i = 0; i < searchLength; i++) {
            if (noMoreMatchesForReplIndex[i] || searchList[i] == null ||
                    searchList[i].length() == 0 || replacementList[i] == null) {
                continue;
            }
            tempIndex = text.indexOf(searchList[i]);

            if (tempIndex == -1) {
                noMoreMatchesForReplIndex[i] = true;
            } else {
                if (textIndex == -1 || tempIndex < textIndex) {
                    textIndex = tempIndex;
                    replaceIndex = i;
                }
            }
        }
        // 完全没有匹配的情况
        if (textIndex == -1) {
            return text;
        }

        int start = 0;

        // get a good guess on the size of the result buffer so it doesnt have to double if it goes over a bit
        int increase = 0;

        // count the replacement text elements that are larger than their corresponding text being replaced
        for (int i = 0; i < searchList.length; i++) {
            int greater = replacementList[i].length() - searchList[i].length();
            if (greater > 0) {
                increase += 3 * greater; // assume 3 matches
            }
        }
        // have upper-bound at 20% increase, then let Java take over
        increase = Math.min(increase, text.length() / 5);

        StringBuffer buf = new StringBuffer(text.length() + increase);

        while (textIndex != -1) {

            for (int i = start; i < textIndex; i++) {
                buf.append(text.charAt(i));
            }
            buf.append(replacementList[replaceIndex]);

            start = textIndex + searchList[replaceIndex].length();

            textIndex = -1;
            replaceIndex = -1;
            tempIndex = -1;
            // find the next earliest match
            // NOTE: logic mostly duplicated above START
            for (int i = 0; i < searchLength; i++) {
                if (noMoreMatchesForReplIndex[i] || searchList[i] == null ||
                        searchList[i].length() == 0 || replacementList[i] == null) {
                    continue;
                }
                tempIndex = text.indexOf(searchList[i], start);

                // see if we need to keep searching for this
                if (tempIndex == -1) {
                    noMoreMatchesForReplIndex[i] = true;
                } else {
                    if (textIndex == -1 || tempIndex < textIndex) {
                        textIndex = tempIndex;
                        replaceIndex = i;
                    }
                }
            }
            // NOTE: logic duplicated above END

        }
        int textLength = text.length();
        for (int i = start; i < textLength; i++) {
            buf.append(text.charAt(i));
        }
        String result = buf.toString();
        if (!repeat) {
            return result;
        }

        return replaceEach(result, searchList, replacementList, repeat, timeToLive - 1);
    }

    /**
     * 功能描述:
     * 〈str中的searchChar替换成为replaceChar〉
     *
     * @return : java.lang.String
     * @params : [str, searchChar, replaceChar]
     * @author : cwl
     * @date : 2019/5/29 15:27
     */
    public static String replaceChars(String str, char searchChar, char replaceChar) {
        if (str == null) {
            return null;
        }
        return str.replace(searchChar, replaceChar);
    }

    /**
     * 功能描述:
     * 〈将text中指定索引从start开始,end结束,替换成为overlay字符〉
     *
     * @return : java.lang.String
     * @params : [text, overlay, start, end]
     * @author : cwl
     * @date : 2019/5/29 15:30
     */
    @Description("建议使用下面那个方法,看一下你就懂了.哈哈哈!")
    @Deprecated
    public static String overlayString(String text, String overlay, int start, int end) {
        return new StringBuffer(start + overlay.length() + text.length() - end + 1)
                .append(text.substring(0, start))
                .append(overlay)
                .append(text.substring(end))
                .toString();
    }

    /**
     * 功能描述:
     * 〈将text中指定索引从start开始,end结束,替换成为overlay字符〉
     *
     * @return : java.lang.String
     * @params : [str, overlay, start, end]
     * @author : cwl
     * @date : 2019/5/29 15:39
     */
    public static String overlay(String str, String overlay, int start, int end) {
        if (str == null) {
            return null;
        }
        if (overlay == null) {
            overlay = EMPTY;
        }
        int len = str.length();
        if (start < 0) {
            start = 0;
        }
        if (start > len) {
            start = len;
        }
        if (end < 0) {
            end = 0;
        }
        if (end > len) {
            end = len;
        }
        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }
        return new StringBuffer(len + start - end + overlay.length() + 1)
                .append(str.substring(0, start))
                .append(overlay)
                .append(str.substring(end))
                .toString();
    }

    /**
     * 功能描述:
     * 〈去除换行符〉
     *
     * @return : java.lang.String
     * @params : [str]
     * @author : cwl
     * @date : 2019/5/29 15:44
     */
    public static String chomp(String str) {
        if (isEmpty(str)) {
            return str;
        }

        if (str.length() == 1) {
            char ch = str.charAt(0);
            if (ch == '\r' || ch == '\n') {
                return EMPTY;
            }
            return str;
        }

        int lastIdx = str.length() - 1;
        char last = str.charAt(lastIdx);

        if (last == '\n') {
            if (str.charAt(lastIdx - 1) == '\r') {
                lastIdx--;
            }
        } else if (last != '\r') {
            lastIdx++;
        }
        return str.substring(0, lastIdx);
    }

    /**
     * 功能描述:
     * 〈复制字符串str,repeat表示复制的次数,最终将所有的复制结果返回成为一个字符串〉
     *
     * @return : java.lang.String
     * @params : [str, repeat]
     * @author : cwl
     * @date : 2019/5/29 15:49
     */
    public static String repeat(String str, int repeat) {
        // Performance tuned for 2.0 (JDK1.4)

        if (str == null) {
            return null;
        }
        if (repeat <= 0) {
            return EMPTY;
        }
        int inputLength = str.length();
        if (repeat == 1 || inputLength == 0) {
            return str;
        }
        if (inputLength == 1 && repeat <= PAD_LIMIT) {
            return padding(repeat, str.charAt(0));
        }

        int outputLength = inputLength * repeat;
        switch (inputLength) {
            case 1:
                char ch = str.charAt(0);
                char[] output1 = new char[outputLength];
                for (int i = repeat - 1; i >= 0; i--) {
                    output1[i] = ch;
                }
                return new String(output1);
            case 2:
                char ch0 = str.charAt(0);
                char ch1 = str.charAt(1);
                char[] output2 = new char[outputLength];
                for (int i = repeat * 2 - 2; i >= 0; i--, i--) {
                    output2[i] = ch0;
                    output2[i + 1] = ch1;
                }
                return new String(output2);
            default:
                StringBuffer buf = new StringBuffer(outputLength);
                for (int i = 0; i < repeat; i++) {
                    buf.append(str);
                }
                return buf.toString();
        }
    }

    /**
     * 功能描述:
     * 〈当要复制的字符串只有一个时调用这个方法〉
     *
     * @return : java.lang.String
     * @params : [repeat, padChar]
     * @author : cwl
     * @date : 2019/5/29 15:53
     */
    private static String padding(int repeat, char padChar) throws IndexOutOfBoundsException {
        if (repeat < 0) {
            throw new IndexOutOfBoundsException("Cannot pad a negative amount: " + repeat);
        }
        final char[] buf = new char[repeat];
        for (int i = 0; i < buf.length; i++) {
            buf[i] = padChar;
        }
        return new String(buf);
    }

    /**
     * 功能描述:
     * 〈从str右边开始垫上4个空格〉
     *
     * @return : java.lang.String
     * @params : [str, size]
     * @author : cwl
     * @date : 2019/5/29 16:14
     */
    public static String rightPad(String str, int size) {
        return rightPad(str, size, ' ');
    }

    /**
     * 功能描述:
     * 〈从str的右边开始垫上指定的字符padChar〉
     *
     * @return : java.lang.String
     * @params : [str, size, padChar]
     * @author : cwl
     * @date : 2019/5/29 16:16
     */
    public static String rightPad(String str, int size, char padChar) {
        if (str == null) {
            return null;
        }
        int pads = size - str.length();
        if (pads <= 0) {
            return str; // returns original String when possible
        }
        if (pads > PAD_LIMIT) {
            return rightPad(str, size, String.valueOf(padChar));
        }
        return str.concat(padding(pads, padChar));
    }

    /**
     * 功能描述:
     * 〈从str的右边开始垫上指定的padStr字符串〉
     *
     * @return : java.lang.String
     * @params : [str, size, padStr]
     * @author : cwl
     * @date : 2019/5/29 16:17
     */
    public static String rightPad(String str, int size, String padStr) {
        if (str == null) {
            return null;
        }
        if (isEmpty(padStr)) {
            padStr = " ";
        }
        int padLen = padStr.length();
        int strLen = str.length();
        int pads = size - strLen;
        if (pads <= 0) {
            return str; // returns original String when possible
        }
        if (padLen == 1 && pads <= PAD_LIMIT) {
            return rightPad(str, size, padStr.charAt(0));
        }

        if (pads == padLen) {
            return str.concat(padStr);
        } else if (pads < padLen) {
            return str.concat(padStr.substring(0, pads));
        } else {
            char[] padding = new char[pads];
            char[] padChars = padStr.toCharArray();
            for (int i = 0; i < pads; i++) {
                padding[i] = padChars[i % padLen];
            }
            return str.concat(new String(padding));
        }
    }

    /**
     * 功能描述:
     * 〈从str左边垫上空格,size表示垫上几个〉
     *
     * @return : java.lang.String
     * @params : [str, size]
     * @author : cwl
     * @date : 2019/5/29 16:19
     */
    public static String leftPad(String str, int size) {
        return leftPad(str, size, ' ');
    }

    /**
     * 功能描述:
     * 〈从str左边指定size垫上padChar字符〉
     *
     * @return : java.lang.String
     * @params : [str, size, padChar]
     * @author : cwl
     * @date : 2019/5/29 16:20
     */
    public static String leftPad(String str, int size, char padChar) {
        if (str == null) {
            return null;
        }
        int pads = size - str.length();
        if (pads <= 0) {
            return str; // returns original String when possible
        }
        if (pads > PAD_LIMIT) {
            return leftPad(str, size, String.valueOf(padChar));
        }
        return padding(pads, padChar).concat(str);
    }

    /**
     * 功能描述:
     * 〈从str左边垫上指定个数size的字符串padStr〉
     *
     * @return : java.lang.String
     * @params : [str, size, padStr]
     * @author : cwl
     * @date : 2019/5/29 16:21
     */
    public static String leftPad(String str, int size, String padStr) {
        if (str == null) {
            return null;
        }
        if (isEmpty(padStr)) {
            padStr = " ";
        }
        int padLen = padStr.length();
        int strLen = str.length();
        int pads = size - strLen;
        if (pads <= 0) {
            return str; // returns original String when possible
        }
        if (padLen == 1 && pads <= PAD_LIMIT) {
            return leftPad(str, size, padStr.charAt(0));
        }

        if (pads == padLen) {
            return padStr.concat(str);
        } else if (pads < padLen) {
            return padStr.substring(0, pads).concat(str);
        } else {
            char[] padding = new char[pads];
            char[] padChars = padStr.toCharArray();
            for (int i = 0; i < pads; i++) {
                padding[i] = padChars[i % padLen];
            }
            return new String(padding).concat(str);
        }
    }

    /**
     * 功能描述:
     * 〈获取字符串的长度,与JDK不同的是对空做了0的处理〉
     *
     * @return : int
     * @params : [str]
     * @author : cwl
     * @date : 2019/5/29 16:22
     */
    public static int length(String str) {
        return str == null ? 0 : str.length();
    }

    /**
     * 功能描述:
     * 〈对字符串进行居中处理,居中位置为size/2,如果是偶数,则向左靠齐〉
     *
     * @return : java.lang.String
     * @params : [str, size]
     * @author : cwl
     * @date : 2019/5/29 16:24
     */
    public static String center(String str, int size) {
        return center(str, size, ' ');
    }

    /**
     * 功能描述:
     * 〈对字符串str进行居中处理,位置为size/2,如果是偶数,则向左靠齐,其余空出来的位置使用padChar来进行处理〉
     *
     * @return : java.lang.String
     * @params : [str, size, padChar]
     * @author : cwl
     * @date : 2019/5/29 16:25
     */
    public static String center(String str, int size, char padChar) {
        if (str == null || size <= 0) {
            return str;
        }
        int strLen = str.length();
        int pads = size - strLen;
        if (pads <= 0) {
            return str;
        }
        str = leftPad(str, strLen + pads / 2, padChar);
        str = rightPad(str, size, padChar);
        return str;
    }

    /**
     * 功能描述:
     * 〈将str转换成为大写,与JDK不同的是对null做了处理〉
     *
     * @return : java.lang.String
     * @params : [str]
     * @author : cwl
     * @date : 2019/5/29 16:33
     */
    public static String upperCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase();
    }

    /**
     * 功能描述:
     * 〈将str转换成小写,与JDK不同的是对null做了处理〉
     *
     * @return : java.lang.String
     * @params : [str]
     * @author : cwl
     * @date : 2019/5/29 16:39
     */
    public static String lowerCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toLowerCase();
    }

    /**
     * 功能描述:
     * 〈将str金子那个首字母大写处理〉
     *
     * @return : java.lang.String
     * @params : [str]
     * @author : cwl
     * @date : 2019/5/29 16:40
     */
    public static String capitalize(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return str;
        }
        return new StringBuffer(strLen)
                .append(Character.toTitleCase(str.charAt(0)))
                .append(str.substring(1))
                .toString();
    }

    /**
     * 功能描述:
     * 〈将str去除首字母大写〉
     *
     * @return : java.lang.String
     * @params : [str]
     * @author : cwl
     * @date : 2019/5/29 16:41
     */
    public static String uncapitalize(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return str;
        }
        return new StringBuffer(strLen)
                .append(Character.toLowerCase(str.charAt(0)))
                .append(str.substring(1))
                .toString();
    }

    /**
     * 功能描述:
     * 〈将str中的大写换成小写,小写换成大写〉
     *
     * @return : java.lang.String
     * @params : [str]
     * @author : cwl
     * @date : 2019/5/29 16:44
     */
    public static String swapCase(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return str;
        }
        StringBuffer buffer = new StringBuffer(strLen);

        char ch = 0;
        for (int i = 0; i < strLen; i++) {
            ch = str.charAt(i);
            if (Character.isUpperCase(ch)) {
                ch = Character.toLowerCase(ch);
            } else if (Character.isTitleCase(ch)) {
                ch = Character.toLowerCase(ch);
            } else if (Character.isLowerCase(ch)) {
                ch = Character.toUpperCase(ch);
            }
            buffer.append(ch);
        }
        return buffer.toString();
    }

    /**
     * 功能描述:
     * 〈返回在str中sub被匹配到的次数〉
     *
     * @return : int
     * @params : [str, sub]
     * @author : cwl
     * @date : 2019/5/29 16:45
     */
    public static int countMatches(String str, String sub) {
        if (isEmpty(str) || isEmpty(sub)) {
            return 0;
        }
        int count = 0;
        int idx = 0;
        while ((idx = str.indexOf(sub, idx)) != -1) {
            count++;
            idx += sub.length();
        }
        return count;
    }

    /**
     * 功能描述:
     * 〈判断str是否为纯字母的字符串〉
     *
     * @return : boolean
     * @params : [str]
     * @author : cwl
     * @date : 2019/5/29 16:47
     */
    public static boolean isAlpha(String str) {
        if (str == null) {
            return false;
        }
        int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if (Character.isLetter(str.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * 功能描述:
     * 〈判断str字符串是否为〉
     *
     * @return : boolean
     * @params : [str]
     * @author : cwl
     * @date : 2019/5/29 16:48
     */
    public static boolean isAlphaSpace(String str) {
        if (str == null) {
            return false;
        }
        int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if ((Character.isLetter(str.charAt(i)) == false) && (str.charAt(i) != ' ')) {
                return false;
            }
        }
        return true;
    }

    /**
     * 功能描述:
     * 〈字符串str是否由字母和数字组成〉
     *
     * @return : boolean
     * @params : [str]
     * @author : cwl
     * @date : 2019/5/30 9:31
     */
    public static boolean isAlphanumeric(String str) {
        if (str == null) {
            return false;
        }
        int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if (Character.isLetterOrDigit(str.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * 功能描述:
     * 〈字符串str是否是由字母数字和空格组成〉
     *
     * @return : boolean
     * @params : [str]
     * @author : cwl
     * @date : 2019/5/30 9:32
     */
    public static boolean isAlphanumericSpace(String str) {
        if (str == null) {
            return false;
        }
        int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if ((Character.isLetterOrDigit(str.charAt(i)) == false) && (str.charAt(i) != ' ')) {
                return false;
            }
        }
        return true;
    }

    /**
     * 功能描述:
     * 〈是否是ASCII码表当中能够打印出来的,ASCII码表只有32位以上127位(不包含)以下才能打印出来〉
     *
     * @return : boolean
     * @params : [str]
     * @author : cwl
     * @date : 2019/5/30 9:37
     */
    public static boolean isAsciiPrintable(String str) {
        if (str == null) {
            return false;
        }
        int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if ((str.charAt(i) >= 32 && str.charAt(i) < 127) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * 功能描述:
     * 〈字符串str是否是数字〉
     *
     * @return : boolean
     * @params : [str]
     * @author : cwl
     * @date : 2019/5/30 9:46
     */
    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if (Character.isDigit(str.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * 功能描述:
     * 〈是否是数字+空格〉
     *
     * @return : boolean
     * @params : [str]
     * @author : cwl
     * @date : 2019/5/30 9:49
     */
    public static boolean isNumericSpace(String str) {
        if (str == null) {
            return false;
        }
        int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if ((Character.isDigit(str.charAt(i)) == false) && (str.charAt(i) != ' ')) {
                return false;
            }
        }
        return true;
    }

    /**
     * 功能描述:
     * 〈是否是纯空格字符串〉
     *
     * @return : boolean
     * @params : [str]
     * @author : cwl
     * @date : 2019/5/30 9:50
     */
    public static boolean isWhitespace(String str) {
        if (str == null) {
            return false;
        }
        int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 功能描述:
     * 〈设置一个默认字符串,如果字符串str为null,则使用传入的defaultStr〉
     *
     * @return : java.lang.String
     * @params : [str, defaultStr]
     * @author : cwl
     * @date : 2019/5/30 9:51
     */
    public static String defaultString(String str, String defaultStr) {
        return str == null ? defaultStr : str;
    }

    /**
     * 功能描述:
     * 〈反转字符串,例如"abc"==>"cba"〉
     *
     * @return : java.lang.String
     * @params : [str]
     * @author : cwl
     * @date : 2019/5/30 9:59
     */
    public static String reverse(String str) {
        if (str == null) {
            return null;
        }
        return new StringBuffer(str).reverse().toString();
    }

    /**
     * 功能描述:
     * 〈返回str1与str2不同的地方〉
     *
     * @return : java.lang.String
     * @params : [str1, str2]
     * @author : cwl
     * @date : 2019/5/30 10:34
     */
    public static String difference(String str1, String str2) {
        if (str1 == null) {
            return str2;
        }
        if (str2 == null) {
            return str1;
        }
        int at = indexOfDifference(str1, str2);
        if (at == -1) {
            return EMPTY;
        }
        return str2.substring(at);
    }

    /**
     * 功能描述:
     * 〈找到str1和str2开始不同的索引〉
     *
     * @return : int
     * @params : [str1, str2]
     * @author : cwl
     * @date : 2019/5/30 10:34
     */
    public static int indexOfDifference(String str1, String str2) {
        if (str1 == str2) {
            return -1;
        }
        if (str1 == null || str2 == null) {
            return 0;
        }
        int i;
        for (i = 0; i < str1.length() && i < str2.length(); ++i) {
            if (str1.charAt(i) != str2.charAt(i)) {
                break;
            }
        }
        if (i < str2.length() || i < str1.length()) {
            return i;
        }
        return -1;
    }

    /**
     * 功能描述:
     * 〈获得数组当中数组元素开始变得不同的索引位置〉
     *
     * @return : int
     * @params : [strs]
     * @author : cwl
     * @date : 2019/5/30 10:37
     */
    public static int indexOfDifference(String[] strs) {
        if (strs == null || strs.length <= 1) {
            return -1;
        }
        boolean anyStringNull = false;
        boolean allStringsNull = true;
        int arrayLen = strs.length;
        int shortestStrLen = Integer.MAX_VALUE;
        int longestStrLen = 0;

        // find the min and max string lengths; this avoids checking to make
        // sure we are not exceeding the length of the string each time through
        // the bottom loop.
        for (int i = 0; i < arrayLen; i++) {
            if (strs[i] == null) {
                anyStringNull = true;
                shortestStrLen = 0;
            } else {
                allStringsNull = false;
                shortestStrLen = Math.min(strs[i].length(), shortestStrLen);
                longestStrLen = Math.max(strs[i].length(), longestStrLen);
            }
        }

        // handle lists containing all nulls or all empty strings
        if (allStringsNull || (longestStrLen == 0 && !anyStringNull)) {
            return -1;
        }

        // handle lists containing some nulls or some empty strings
        if (shortestStrLen == 0) {
            return 0;
        }

        // find the position with the first difference across all strings
        int firstDiff = -1;
        for (int stringPos = 0; stringPos < shortestStrLen; stringPos++) {
            char comparisonChar = strs[0].charAt(stringPos);
            for (int arrayPos = 1; arrayPos < arrayLen; arrayPos++) {
                if (strs[arrayPos].charAt(stringPos) != comparisonChar) {
                    firstDiff = stringPos;
                    break;
                }
            }
            if (firstDiff != -1) {
                break;
            }
        }

        if (firstDiff == -1 && shortestStrLen != longestStrLen) {
            // we compared all of the characters up to the length of the
            // shortest string and didn't find a match, but the string lengths
            // vary, so return the length of the shortest string.
            return shortestStrLen;
        }
        return firstDiff;
    }

    /**
     * 功能描述:
     * 〈获得数组元素当中前缀相同的字符〉
     *
     * @return : java.lang.String
     * @params : [strs]
     * @author : cwl
     * @date : 2019/5/30 10:39
     */
    public static String getCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return EMPTY;
        }
        int smallestIndexOfDiff = indexOfDifference(strs);
        if (smallestIndexOfDiff == -1) {
            // all strings were identical
            if (strs[0] == null) {
                return EMPTY;
            }
            return strs[0];
        } else if (smallestIndexOfDiff == 0) {
            // there were no common initial characters
            return EMPTY;
        } else {
            // we found a common initial character sequence
            return strs[0].substring(0, smallestIndexOfDiff);
        }
    }

    /**
     * 功能描述:
     * 〈判断字符str是否以prefix开头〉
     *
     * @return : boolean
     * @params : [str, prefix]
     * @author : cwl
     * @date : 2019/5/30 10:43
     */
    public static boolean startsWith(String str, String prefix) {
        return startsWith(str, prefix, false);
    }

    /**
     * 功能描述:
     * 〈判断字符str是否以prefix开头,忽略大小写〉
     *
     * @return : boolean
     * @params : [str, prefix]
     * @author : cwl
     * @date : 2019/5/30 10:43
     */
    public static boolean startsWithIgnoreCase(String str, String prefix) {
        return startsWith(str, prefix, true);
    }

    /**
     * 功能描述:
     * 〈判断字符str是否以prefix开头,ignoreCase为是否忽略大小写〉
     *
     * @return : boolean
     * @params : [str, prefix, ignoreCase]
     * @author : cwl
     * @date : 2019/5/30 10:44
     */
    private static boolean startsWith(String str, String prefix, boolean ignoreCase) {
        if (str == null || prefix == null) {
            return (str == null && prefix == null);
        }
        if (prefix.length() > str.length()) {
            return false;
        }
        return str.regionMatches(ignoreCase, 0, prefix, 0, prefix.length());
    }

    /**
     * 功能描述:
     * 〈判断str是否是以suffix结尾〉
     *
     * @return : boolean
     * @params : [str, suffix]
     * @author : cwl
     * @date : 2019/5/30 10:46
     */
    public static boolean endsWith(String str, String suffix) {
        return endsWith(str, suffix, false);
    }

    /**
     * 功能描述:
     * 〈判断str是否是以suffix结尾,忽略大小写〉
     *
     * @return : boolean
     * @params : [str, suffix]
     * @author : cwl
     * @date : 2019/5/30 10:46
     */
    public static boolean endsWithIgnoreCase(String str, String suffix) {
        return endsWith(str, suffix, true);
    }

    /**
     * 功能描述:
     * 〈判断str是否是以suffix结尾,ignoreCase为是否忽略大小写〉
     *
     * @return : boolean
     * @params : [str, suffix, ignoreCase]
     * @author : cwl
     * @date : 2019/5/30 10:47
     */
    private static boolean endsWith(String str, String suffix, boolean ignoreCase) {
        if (str == null || suffix == null) {
            return (str == null && suffix == null);
        }
        if (suffix.length() > str.length()) {
            return false;
        }
        int strOffset = str.length() - suffix.length();
        return str.regionMatches(ignoreCase, strOffset, suffix, 0, suffix.length());
    }
}

