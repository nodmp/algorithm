package com.nodmp.algorithm.leetcode.lc_efcz;

public class EfczTest {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 2, 2, 5, 6, 7};
        new EfczTest().left_efcz2_dd(nums, 2);

    }
    int efcz1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // 注意

        while(left < right) {
            int mid = left + (right - left) / 2;
            System.out.printf("left:%s right:%s mid:%s \n", left, right, mid);
            if(nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1; // 注意
            else if (nums[mid] > target)
                right = mid - 1; // 注意
        }
        System.out.printf("left:%s right:%s \n", left, right);
        return -1;
    }


    //[1,2,2,2,2,4,5] 获取左边的2
    int left_efcz2(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        //[left,right)
        //终止条件left == right [left, left)
        while (left < right) {
            int mid = left + (right - left) / 2;
            System.out.printf("left:%s right:%s mid:%s \n", left, right, mid);
            if (nums[mid] == target) {
                //往右边进行查找，但是当前的这个不能丢弃
                right = mid;
            } else if (nums[mid] < target) {
                //mid这个<target
                left = mid + 1;
            } else if (nums[mid] > target) {
                //如果nums[mid]这里
                right = mid; //为啥不是mid-1
            }
        }
        System.out.printf("left:%s right:%s \n", left, right);
        return left;
    }
    int left_efcz2_dd(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        //left=right+1 退出
        //[right+1,right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            System.out.printf("left:%s right:%s mid:%s \n", left, right, mid);

            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        ///需要进行排除一场条件
        System.out.printf("left:%s right:%s \n", left, right);
        //////右边边界  左边边界
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    int right_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                left = mid + 1; // 注意
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left - 1; // 注意
    }

    int binary_search_release(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if(nums[mid] == target) {
                // 直接返回
                return mid;
            }
        }
        // 直接返回
        return -1;
    }

    int left_bound_release(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，锁定左侧边界
                right = mid - 1;
            }
        }
        // 最后要检查 left 越界的情况
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }


    int right_bound_release(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，锁定右侧边界
                left = mid + 1;
            }
        }
        // 最后要检查 right 越界的情况 补丁状态
        if (right < 0 || nums[right] != target)
            return -1;
        return right;
    }
}
