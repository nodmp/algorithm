# 回溯
```java
result = []
def backtrack(路径, 选择列表):
    if 满足结束条件:
        result.add(路径)
        return

    for 选择 in 选择列表:
        做选择
        backtrack(路径, 选择列表)
        撤销选择
```
## 1.全排列问题
```java
public class Test {
    static int i = 0;
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        new Test().layout(nums, 0);
        System.out.println(i);
    }
    public void layout(int[] nums, int index) {
        if (index == nums.length) {
            i++;
            System.out.println(Arrays.toString(nums));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            layout(nums, index + 1);
            swap(nums, index, i);
        }
    }
    private void swap(int[] nums, int index, int i) {
        int flag = nums[index];
        nums[index] = nums[i];
        nums[i] = flag;
    }
}
```
相关问题[24点问题](https://leetcode-cn.com/problems/24-game/)
另一种全排列代码
```java
List<List<Integer>> res = new LinkedList<>();

/* 主函数，输入一组不重复的数字，返回它们的全排列 */
List<List<Integer>> permute(int[] nums) {
    // 记录「路径」
    LinkedList<Integer> track = new LinkedList<>();
    backtrack(nums, track);
    return res;
}

// 路径：记录在 track 中
// 选择列表：nums 中不存在于 track 的那些元素
// 结束条件：nums 中的元素全都在 track 中出现
void backtrack(int[] nums, LinkedList<Integer> track) {
    // 触发结束条件
    if (track.size() == nums.length) {
        res.add(new LinkedList(track));
        return;
    }

    for (int i = 0; i < nums.length; i++) {
        // 排除不合法的选择
        if (track.contains(nums[i]))
            continue;
        // 做选择
        track.add(nums[i]);
        // 进入下一层决策树
        backtrack(nums, track);
        // 取消选择
        track.removeLast();
    }
}
```

## 2.树的遍历问题
树的访问框架
```java
void traverse(TreeNode root) {
    for (TreeNode child : root.childern)
        // 前序遍历需要的操作-访问某个节点之前做的操作
        traverse(child);
        // 后序遍历需要的操作-访问某个节点之后做的操作
}
```
