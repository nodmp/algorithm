package com.nodmp.algorithm.lcof.lcof_11;

import java.util.Arrays;

/**
 * 示例 1：
 * 输入：[3,4,5,1,2]
 * 输出：1
 *
 * 示例 2：
 * 输入：[2,2,2,0,1]
 * 输出：0
 */
public class Solution {
    public int minArray(int[] numbers) {
        //二分查找，顺序数组
        int min = 0;
        int max = numbers.length - 1;
        while (min < max) {
            int mid = min + (max - min) / 2;
            //判断中间数
            if (numbers[max] > numbers[mid]) {
                max = mid;
            } else if (numbers[max] < numbers[mid]) {
                min = mid + 1;
            } else {
                max--;
                //修正步骤
            }

        }
        return numbers[min];
    }

    //二分查找
    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 2, 2};
        int i = new Solution().minArray(nums);
        System.out.println(i);

    }



}
