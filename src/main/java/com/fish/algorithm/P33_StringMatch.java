package com.fish.algorithm;

/**
 * @author yufei.liu
 * @version v1.0
 * @description 字符串匹配
 * @date 2021-01-12 17:52
 */
public class P33_StringMatch {

    /**
     * 散列表大小。 此处假设，字符串的字符集范围在256个字符内
     */
    private static final int SIZE = 256;

    /**
     * 构建 模式串 散列表
     * 
     * @param b
     *            模式串
     * @param m
     *            模式串长度
     * @param bc
     *            散列表数组
     */
    private static void generateBC(char[] b, int m, int[] bc) {
        for (int i = 0; i < SIZE; ++i) {
            // 初始化bc
            bc[i] = -1;
        }
        for (int i = 0; i < m; ++i) {
            // 计算b[i]的ASCII值
            int ascii = b[i];
            bc[ascii] = i;
        }
    }

    /**
     * 字符串匹配算法：BM算法
     * 
     * @param a
     *            主串
     * @param n
     *            主串长度
     * @param b
     *            模式串
     * @param m
     *            模式串长度
     * @return 返回主串与模式串第一个匹配的字符的位置
     */
    public static int bm(char[] a, int n, char[] b, int m) {
        // 记录模式串中每个字符最后出现的位置
        int[] bc = new int[SIZE];
        // 构建坏字符哈希表
        generateBC(b, m, bc);

        // 主串字符index
        int i = 0;
        while (i <= n - m) {
            // 模式串字符index
            int j;
            // 模式串从后往前匹配
            for (j = m - 1; j >= 0; --j) {
                // 不匹配，说明出现坏字符
                // 坏字符即为：a[i+j]
                // 坏字符对应的模式串字符为：b[j]
                if (a[i + j] != b[j]) {
                    break;
                }
            }
            if (j < 0) {
                // 匹配成功，返回主串与模式串第一个匹配的字符的位置
                return i;
            }
            // 坏字符：我们从模式串的末尾往前倒着匹配，当我们发现某个字符没法匹配的时候。
            // 我们把这个没有匹配的字符叫作坏字符（主串中的字符）

            // 当发生不匹配的时候，我们把坏字符对应的模式串中的字符下标记作 si。
            // 如果坏字符在模式串中存在，我们把这个坏字符在模式串中的下标记作 xi。
            // 如果不存在，我们把 xi 记作 -1。那模式串往后移动的位数就等于 si-xi。
            //（注意，我这里说的下标，都是字符在模式串的下标）。


            // a[i+j] 即为 坏字符
            // bc[a[i+j]] 即为 坏字符在模式串中的index，若模式串中没有坏字符，则为-1
            // j-bc[a[i+j]] 即为 模式串向后滑动多少位
            // i+(j-bc[a[i+j]]) 即为 下一次循环，主串开始匹配的位置
            i = i + (j - bc[a[i + j]]);
        }
        return -1;
    }

    public static void main(String[] args) {
        String astr = "abcacabdc";
        String bstr = "abd";
        bm(astr.toCharArray(), astr.length(), bstr.toCharArray(), bstr.length());
    }

}
