# 二分查找
二分查找框架
```java
int binaryS(int[] nums, int target){
int left = 0;
int right = nums.lenght();
while(...){
int mid = left + (right + left) /2;
if(nums[mid] == target){
...
}else if(nums[mind] < target){
left = ...
}else if(nums[mid] > target){
right = ...
}
}
return -1;
}
```
> tips: 为了防止溢出，我们使用了我们使用left+(right-left)/2和(left+right)/2

```java
int binarySearch(int[] nums, int target) {
    int left = 0; 
    int right = nums.length - 1; // 注意
    //为啥使用left<=right
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