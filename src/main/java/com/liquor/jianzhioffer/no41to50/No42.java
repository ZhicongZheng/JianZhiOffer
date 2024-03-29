package com.liquor.jianzhioffer.no41to50;

/**
 * 数组中只出现一次的数字，一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * <p>
 * 自认为懂了一点套路的我，第一时间想到不能暴力遍历，应该用一些合适的数据结构，是用一个 HashMap？先遍历，用数作为key,出现的次数作为value，最后再遍历hashmap,应该是可以
 * 或者是栈？这个栈好像是不太行。树？不不不，没点关系。队列？那更扯不上
 * 如果要是对空间复杂度有要求，就不能用HashMap,必须另辟蹊径
 * <p>
 * 大佬的方法是利用位运算，没错，就是异或运算，因为异或运算有一个性质
 * <p>
 * 两个相同的数异或的结果是0，任何数和0异或的结果都是它本身！！！
 * <p>
 * 那我们可以遍历数组，逐个做异或运算嘛，如果只有一个出现一次的数，那最后的结果就是异或完的结果
 * 可是题目是两个只出现一次的数组，于是可以想办法把原数组分成两个数组，每个数组再逐个异或，便可求出结果
 * <p>
 * 本体的精髓就在于如何将原数组分成两个数组，且只出现一次的那两个数字恰好分布在两个数组里面
 *
 * @author zzc on 2020.1.7
 */
public class No42 {

    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array.length == 0) {
            return;
        }
        if (array.length == 2) {
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        }
        //这个异或的数值其实是那两个数异或的结果
        int yihuo = 0;
        for (int value : array) {
            yihuo ^= value;
        }
        //两个不相同的数异或的结果，一定有一位为1
        //就找到这个为1的位数，就可以把原数组分为两组，这两组并不一定长度相等
        int index = 0;
        while ((yihuo & 1) == 0 && index < 32) {
            yihuo >>= 1;
            index++;
        }
        for (int i : array) {
            //判断第一位为1的那个是0还是1，从而分成两组
            if ((i >> index & 1) == 1) {
                num1[0] ^= i;
            } else {
                num2[0] ^= i;
            }
        }
    }
}
