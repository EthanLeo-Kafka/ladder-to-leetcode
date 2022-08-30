package com.fish.leetcode;

import java.util.Stack;

/**
 * @author yufei.liu
 * @version v1.0
 * @description 有效的括号
 * @date 2022-08-30 17:27
 */
public class P20_ValidParentheses {

    public static void main(String[] args) {
        System.err.println(validParentheses("]"));
    }

    public static boolean validParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        boolean isValid = true;
        for (char c : s.toCharArray()) {
            if ('(' == c || '[' == c || '{' == c) {
                stack.push(c);
            } else {
                if (')' == c) {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        isValid = false;
                    }
                } else if (']' == c) {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        isValid = false;
                    }
                } else if ('}' == c) {
                    if (!stack.isEmpty() && stack.peek() == '{') {
                        stack.pop();
                    } else {
                        isValid = false;
                    }
                }
            }
        }
        return stack.isEmpty() && isValid;
    }
}
