## 序列DP
### 什么是序列DP
序列$dp$是一类最长，最多的子序列的相关问题。 状态转移方程中 $dp[i]$ 表示前$i$个元素$a [0],a [1],…a [i-1]$的某种性质, 坐标型 $dp$ 状态转移方程中$f [i]$表示以元素$a [i]$结尾的某种性质（方案数）。
### 总结
- 一、序列型 $dp$ 状态转移方程中 $f[i]$ 表示前 $i$ 个元素 $a[0],a[1],...a[i-1]$ 的某种性质，坐标型 $dp$ 状态转移方程中 $f[i]$ 表示以元素 $a[i]$ 结尾的某种性质。
- 二、在初始化时，序列型 $dp$ 中 $f[0]$ 一般表示的是空序列一般是 $f[0] = 0$，坐标型 $dp$ 中 $f[0]$ 表示以 $a[0]$ 结尾的子问题具有的性质，得看具体条件。
- *序列型动态规划方程dp[i]中的下标i表示前i个元素A[0] A[1]..A[i-1]的某种性质。通常在思考最后一步时，需要考虑前一步处于什么状态。*

    *坐标型的dp[i]表示以A[i]为结尾的子序列的性质*

    *例如：最长升序子串中，以A[i]元素为结尾的最长升序子串*

    *序列型动态规划初始化中，dp[0]表示空序列的性质。*

    *坐标型动态规划的初始条件dp[0]就是指以A[0]为结尾的子序列的性质*

    *例如：最小路径和中dp[0][0]表示以坐标(0,0)为起点和终点的最短路径。*
### 题目列表

301. [最长递增子序列的个数](https://leetcode.cn/problems/number-of-longest-increasing-subsequence/)

```java
class Solution {
    public int findNumberOfLIS(int[] nums) {
    	int n = nums.length, ans = 0, max = 0;
        int[] dp = new int[n]; // dp[i]表示1-i中最长递增子序列长度
        int[] f = new int[n]; // f[i]表示以nums[i]结尾最大递增子序列个数
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    f[i] = f[j]; // 重置f[i]
                } else if (dp[i] == dp[j] + 1) {
                    f[i] += f[j];
                }
            }
         	max = Math.max(dp[i], max);
        }
        for (int i = 0; i < n; i++) if (dp[i] == max) ans += f[i];
        return ans;
    }
}
```

301. [不同的子序列 II](https://leetcode.cn/problems/distinct-subsequences-ii/)

- 解法一

```java
class Solution {
    public int distinctSubseqII(String s) {
    	int n = s.length(), mod = (int) 1e9 + 7, ans = 0;
        int[] last = int[26]; // last[i]表示上一轮结尾字符为i时的不同子序列个数
        int[] f = new int[n]; // f[i]表示以字符s[i]结尾的不同子序列个数
        Arrays.fill(last, -1);
        Arrays.fill(f, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) { // 遍历上一轮结尾的字符
                if (last[i] != -1) {
                    f[i] = (f[i] + f[last[i]]) % mod;
                }
            }
            last[s.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < 26; i++) if (last[i] != -1) ans = (ans + f[last[i]]) % mod;
        return ans;
    }
}
```

- 解法二

```java
class Solution {
    public int distinctSubseqII(String s) {
        int n = s.length(), ans = 0, mod = (int) 1e9 + 7;
        int[][] dp = new int[n][26]; // dp[i][j]表示当第i位字符位j时不同的子序列个数
        dp[0][s.charAt(0) - 'a'] = 1;
        for (int i = 1; i < n; i++) {
            int c = s.charAt(i) - 'a';
            for (int j = 0; j < 26; j++) {
                if (c != j) dp[i][j] = dp[i - 1][j];
                else {
                    int t = 1;
                    for (int k = 0; k < 26; k++) t = (t + dp[i - 1][k]) % mod;
                    dp[i][j] = t;
                }
            }
        }
        for (int i = 0; i < 26; i++) ans = (ans + dp[n - 1][i]) % mod;
        return ans;
    }
}
```

354. [俄罗斯套娃信封问题](https://leetcode.cn/problems/russian-doll-envelopes/)

```java
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, (x, y) -> x[0] == y[0] ? y[1] - x[1] : x[0] - y[0]);
        // lit.get(i)表示了长度为 i 的情况下，最后一个元素的大小
        List<Integer> f = new ArrayList<Integer>();
        f.add(envelopes[0][1]);
        for (int i = 1; i < n; ++i) {
            int num = envelopes[i][1];
            if (num > f.get(f.size() - 1)) {
                f.add(num);
            } else {
                int index = binarySearch(f, num);
                f.set(index, num);
            }
        }
        return f.size();
    }

    public int binarySearch(List<Integer> f, int target) {
        int low = 0, high = f.size() - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (f.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
```

### 资料

​		http://blog.17baishi.com/17218/

​		https://leetcode.cn/problems/number-of-longest-increasing-subsequence/solution/gong-shui-san-xie-lis-de-fang-an-shu-wen-obuz/