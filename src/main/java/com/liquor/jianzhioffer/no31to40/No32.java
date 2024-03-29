package com.liquor.jianzhioffer.no31to40;

/**
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,
 * 常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 * <p>
 * 题目整的花里胡哨，其实这是一个经典题目，就是求一个数组里面，连续的子数组和的最大值，要求时间复杂度为O(n)
 * 最简单的就是暴力解法，就像冒泡排序一样，先从第一个开始求后面所有数的和，然后再从第二个数开始，求后面所有数的和，维护一个最大值，
 * 这样显然时间复杂度是O(n2),不足以拿到offer
 * <p>
 * 其实换个思路，我们顺序地从前往后遍历，维护一个和的数值，如果加一个数之后，当前的和成了负数，也就是说前面那个子数组的和肯定比从当前数组开始的子数组的和小
 * 那么可以直接把前面的子数组丢掉，从当前数字开始的子数组往后找
 * https://blog.csdn.net/DERRANTCM/article/details/46736967
 *
 * @author zzc on 19.12.20
 */
public class No32 {

    public int FindGreatestSumOfSubArray(int[] array) {

        if (array.length == 0) {
            return -1;
        }
        if (array.length == 1) {
            return array[0];
        }
        //最大值，初始为-1,牛客上面默认返回错误值就是-1,
        int max = -1;
        //当前的和
        int val = -1;
        for (int n : array) {
            //当前的和是负数，或者刚开始遍历
            if (val <= 0) {
                val = n;
            } else {
                //大于0时，需要继续往后找
                val += n;
            }

            if (max < val) {
                //如果当前和大于最大值，把当前和给了最大值
                max = val;
            }
        }
        return max;
    }
}
