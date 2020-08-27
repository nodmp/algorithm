# 动态规划框架 
https://labuladong.gitbook.io/algo/dong-tai-gui-hua-xi-lie/dong-tai-gui-hua-xiang-jie-jin-jie
动态规划主要是求最值问题 
核心问题是 穷举
如果是穷举，那么就是暴力解法，但是动态规划的穷举 存在*重叠子问题*
需要【备忘录】 || 【dp table】
状态转移公式
明确base case->明确【状态】 -> 明确选择->定义dp数组/函数的含义 

```java
# 初始化 base case
dp[0][0][...] = base
# 进行状态转移
for 状态1 in 状态1的所有取值：
    for 状态2 in 状态2的所有取值：
        for ...
            dp[状态1][状态2][...] = 求最值(选择1，选择2...)
```
