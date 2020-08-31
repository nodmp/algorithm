# 二分查找【dev_1.0.1】
二分查找的细节十分重要，搜索一个元素的时候，有以下要点
## 搜索元素
- 搜索区间两端关闭[0,20]
- while要带=号，否则需要打补丁
- if相等的相等的时候直接返回
- mid 需要进行加减操作，因为区间是两端关闭的
- while结束的时候直接返回-1

```java
int efcz(int[] nums, int target) {
    int left = 0, right = ...;

    while(...) {
        //防止溢出操作
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            ...
        } else if (nums[mid] < target) {
            left = ...
        } else if (nums[mid] > target) {
            right = ...
        }
    }
    return ...;
}
```
### 寻找一个数字（基本地二分查找）
```java
int efcz1(int[] nums, int target) {
    int left = 0; 
    int right = nums.length - 1; // 注意

    while(left <= right) {
        int mid = left + (right - left) / 2;
        if(nums[mid] == target)
            return mid; 
        else if (nums[mid] < target)
            left = mid + 1; // 注意
        else if (nums[mid] > target)
            right = mid - 1; // 注意
    }
    return -1;
}
```
#### 为什么 while 循环的条件中是 <=，而不是 <？
如果使用left<=right的时候终止条件是[right+1,right],这时候退出条件成立
```ignorelang
left:0 right:7 mid:3 
left:4 right:7 mid:5 
left:6 right:7 mid:6 
left:7 right:7 mid:7 
left:8 right:7 
```
如果使用left<right的终止条件是[right,right],这个时候退出条件成立，但是缺少了一次循环
```ignorelang
left:0 right:7 mid:3 
left:4 right:7 mid:5 
left:6 right:7 mid:6 
left:7 right:7 
```
如果要使用left<right这时候就需要进行补丁`return nums[left] == target ? left : -1` 

#### 为什么left = mid + 1，right = mid - 1？
从上面`mid`而言，下一步的搜索空间到底是什么 根据需求进行搜索。
#### 算法缺陷
比如说给你有序数组`nums = [1,2,2,2,3]`，`target`为 `2`，此算法返回的索引是 `2`，没错。但是如果我想得到`target`的左侧边界，
即索引 `1`，或者我想得到`target`的右侧边界，即索引`3`，这样的话此算法是无法处理的。


## 搜索区间的时候
* 搜索左右的边界的时候，搜索区间要阐明
* 左开右闭最常见（0,9]
* while< 要使用小于号
* if 相等的时候不能返回
* mid+1 或者 mid-1 要看区间开闭
* while结束的时候，因为还没返回
* 索引可能出边界，if需要进行检查

> tips: 为了防止溢出，我们使用了我们使用left+(right-left)/2和(left+right)/2

### 寻找左侧边界的二分查找[1,2,2,2,3](1)
代码如下所示
```java
int left_efcz2(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        //[left,right)
        //终止条件left == right [left, left) 这时候直接退出了
        //因为right = nums.length 这个数字涉及边界所以不能取到
        while (left < right) {
            int mid = left + (right - left) / 2;
            System.out.printf("left:%s right:%s mid:%s \n", left, right, mid);
            if (nums[mid] == target) {
                //为何可以搜索左边界
                //[0,mid)-> 慢慢的逼近mid 因为当left == right -> [left,left)
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1; 
            } else if (nums[mid] > target) {
                right = mid; 
            } 
        //为啥需要 left = mid+ 1 right = mid
        //因为例如上面[0,nums.lenght)表示[0,mid),[mid+1,nums.lenght)
        }
        System.out.printf("left:%s right:%s \n", left, right);
/**
*if (left == nums.length) return -1;
*类似之前算法的处理方式
*return nums[left] == target ? left : -1;
*/

        return left; //因为left==right 所以返回哪个都可以
    }
```
### 寻找右侧边界的二分查找[1,2,2,2,3](3)
```java
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
```

## 统一规则 
###第一个，最基本地二分查找算法：

因为我们初始化 right = nums.length - 1
所以决定了我们的「搜索区间」是 [left, right]
所以决定了 while (left <= right)
同时也决定了 left = mid+1 和 right = mid-1

因为我们只需找到一个 target 的索引即可
所以当 nums[mid] == target 时可以立即返回

###第二个，寻找左侧边界的二分查找：

因为我们初始化 right = nums.length
所以决定了我们的「搜索区间」是 [left, right)
所以决定了 while (left < right)
同时也决定了 left = mid + 1 和 right = mid

因为我们需找到 target 的最左侧索引
所以当 nums[mid] == target 时不要立即返回
而要收紧右侧边界以锁定左侧边界

###第三个，寻找右侧边界的二分查找：

因为我们初始化 right = nums.length
所以决定了我们的「搜索区间」是 [left, right)
所以决定了 while (left < right)
同时也决定了 left = mid + 1 和 right = mid

因为我们需找到 target 的最右侧索引
所以当 nums[mid] == target 时不要立即返回
而要收紧左侧边界以锁定右侧边界

又因为收紧左侧边界时必须 left = mid + 1
所以最后无论返回 left 还是 right，必须减一

```java

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
```
