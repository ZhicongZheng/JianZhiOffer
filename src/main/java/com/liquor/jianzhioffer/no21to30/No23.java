package com.liquor.jianzhioffer.no21to30;


import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 * <p>
 * 思路：用一个栈来打辅助，定义一个弹出索引从出栈顺序的第一个开始，先进行入栈操作，当栈顶元素和弹出索引对应的元素相等，开始出栈，
 * 同时弹出索引向右移动，如果入栈出栈操作完成，辅助栈不为空，证明不是弹出顺序
 *
 * @author zzc
 */
public class No23 {

    public boolean IsPopOrder(int[] pushA, int[] popA) {

        Stack<Integer> stack = new Stack<>();
        if (pushA.length != popA.length) {
            return false;
        }
        //弹出索引
        int popIndex = 0;
        for (int i = 0; i < popA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}
