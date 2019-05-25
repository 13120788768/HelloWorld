package main.java.com.wayyer.HelloWorld.math;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

/**
 * @Author: wayyer
 * @Description: 有两个用字符串表示的非常大的大整数,算出他们的乘积，
 * 也是用字符串表示。不能用系统自带的大整数类型
 * @Program: HelloWorld
 * @Date: 2019.05.05
 */
public class Multiplies {

    // 规模只要在这个范围内可以直接计算（整型数值满足）
    private final static int SIZE = 4;

    // 其中，len为X、Y的长度最大值
    private static String bigIntMultiply(String X, String Y, int len) {
        String str = "";

        if (len <= SIZE) { // 少于4位数，可直接计算
            return "" + (Integer.parseInt(X) * Integer.parseInt(Y));
        }

        if (X.length() != Y.length()) { // 长度不同，调用formatNumber方法，补齐X、Y，使之长度相同
            X = formatNumber(X, len);
            Y = formatNumber(Y, len);
        }

        // 将X、Y分别对半分成两部分
        int len1 = len / 2;
        int len2 = len - len1;
        String A = X.substring(0, len1);
        String B = X.substring(len1);
        String C = Y.substring(0, len1);
        String D = Y.substring(len1);

        // 乘法法则，分块处理
        int lenM = Math.max(len1, len2);
        String AC = bigIntMultiply(A, C, len1);
        String AD = bigIntMultiply(A, D, lenM);
        String BC = bigIntMultiply(B, C, lenM);
        String BD = bigIntMultiply(B, D, len2);

        // 注意处理进位的方法，巧妙地运用了字符串的拼接方面
        // 【1】 处理BD，得到原位及进位
        String[] sBD = dealString(BD, len2);
        // 【2】 处理AD + BC的和
        String ADBC = add(AD, BC);
        // 【3】 加上BD的进位
        if (!"0".equals(sBD[1])) {
            ADBC = add(ADBC, sBD[1]);
        }
        // 【4】 得到ADBC的进位
        String[] sADBC = dealString(ADBC, lenM);

        // 【5】 AC加上ADBC的进位
        AC = add(AC, sADBC[1]);
        // 【6】 最终结果
        str = AC + sADBC[0] + sBD[0];

        return str;
    }

    // 两个数字串按位加
    private static String add(String ad, String bc) {
        // 返回的结果
        String str = "";

        // 两字符串长度要相同
        int lenM = Math.max(ad.length(), bc.length());
        ad = formatNumber(ad, lenM);
        bc = formatNumber(bc, lenM);

        // 按位加，进位存储在flag中
        int flag = 0;
        // 按序从后往前按位求和
        for (int i = lenM - 1; i >= 0; i--) {
            int t = flag + Integer.parseInt(ad.substring(i, i + 1))
                    + Integer.parseInt(bc.substring(i, i + 1));
            // 结果超过9，则进位当前位，保留个位数
            if (t > 9) {
                flag = 1;
                t = t - 10;
            } else {
                flag = 0;
            }
            // 拼接结果字符串
            str = "" + t + str;
        }
        if (flag != 0) {
            str = "" + flag + str;
        }
        return str;
    }

    // 处理数字串，分离出进位,String数组第一个为原位数字，第二个为进位
    private static String[] dealString(String ac, int lenn) {
        String[] str = { ac, "0" };

        if (lenn < ac.length()) {
            int t = ac.length() - lenn;
            str[0] = ac.substring(t);
            str[1] = ac.substring(0, t);
            // System.out.println("+++++++++");
            // System.out.println(str[0]);
            // System.out.println(str[1]);
            // System.out.println(t);
        } else {
            // 保证结果length与lenn一致，少于则高位补0
            String result = str[0];
            for (int i = result.length(); i < lenn; i++) {
                result = "0" + result;
            }
            str[0] = result;
        }
        return str;
    }

    // 格式化操作的数字字符串，高位补零
    private static String formatNumber(String x, int len) {
        while (len > x.length()) {
            x = "0" + x;
        }
        return x;
    }

    public static void main(String[] args) {
        String pat = "^[1-9]\\d*$"; // 正则表达式：不以0开头的数字串
        Pattern p = Pattern.compile(pat); // 将给定的正则表达式编译并赋予给Pattern类

        System.out.println("乘数A（不以0开头的正整数）：");
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        Matcher m = p.matcher(A);

        if (!m.matches()) {
            System.out.println("数字不合法！");
            return;
        }

        System.out.println("乘数B（不以0开头的正整数）：");
        String B = sc.next();
        m = p.matcher(B);
        if (!m.matches()) {
            System.out.println("数字不合法！");
            return;
        }
        // Math.max(A.length(), B.length())比较读入的字符串的长短
        System.out.println(A + " * " + B + " = "
                + bigIntMultiply(A, B, Math.max(A.length(), B.length())));
    }

}
