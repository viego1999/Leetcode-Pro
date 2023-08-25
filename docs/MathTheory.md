## 数学理论常用算法

#### 最大公约数
- 辗转相除法

递归实现：
```java
public int gcd(int b, int a) { // 默认 b > a
    return a == 0 ? b : gac(a, b % a);    
}
```

非递归实现：
```java
public int gcd(int b, int a) {
    int c = b % a;
    while (c != 0) {
        b = a;
        a = c;
        c = b % a;
    }
    return a;
}
```

#### 最小公倍数

```java
public int lcm(int b, int a) {
    return b * a / gcd(b, a);
}
```

#### 快速幂

非递归实现
```java
public int quickMi(int a, int b) {
    int res = 1;
    while (b != 0) {
        if ((b & 1) == 1) res *= a;
        a *= a;
        b >>= 1;
    }
    return res;
}
```

递归实现 1
```java
public int quickMi(int x, int n) {
    if (n == 0) return 1;
    return (n & 1) == 1 ? x * quickMi(x * x, n >> 1) : quickMi(x * x, n >> 1);
}
```
递归实现 2
```java
public int quickMi(int x, int n) {
    if (n == 0) return 1;
    int y = quickMi(x, n >> 1);
    return (n & 1) == 1 ? x * y * y : y * y;
}
```

#### 快速乘

非递归实现：
```java
public int quickMulti(int x, int y) {
    int res = 0;
    while (y != 0) {
        if ((y & 1) == 1) res += x;
        x *= 2;
        y >>= 1;
    }
    return res;
}
```

递归实现 1
```java
public int quickMulti(int x, int y) {
    if (y == 0) return 0; 
    if ((y & 1) == 1) return x + quickMulti(x * 2, y >> 1);
    else return quickMulti(x * 2, y >> 1);
}
```

递归实现 2
```java
public int quickMulti(int x, int y) {
    if (y == 0) return 0; 
    if ((y & 1) == 1) return x + quickMulti(x, y - 1);
    else return quickMulti(x * 2, y >> 1);
}
```

#### 快速幂求逆元
- 概念：
这里说的逆元是指乘法逆元。

​        若在 $mod\ p$ 意义下，对于一个整数 $a$，有$a*b≡1(mod\ p)$，那么这个整数 $b$ 即为 $a$ 的乘法逆元，同时 $a$ 也为 $b$ 的乘法逆元，这里的 $b$ 对于 $a$ 来说类似于 ${1\over a}$ 的存在（*“≡”是恒等号或同余号*。表示同余符号，用于同余式。例设 $m$ 是大于 $1$ 的正整数，$a，b$ 是整数，如果$m|(a-b)$，则称 $a$ 与 $b$ 关于模 $m$ 同余，记作 $a≡b(mod\ M)$。）

​        **求  $(a / b)\% p$ 等同于求 $a∗(b的逆元)\%p$ **，除以一个数等同于乘一个数的倒数。

​        有什么用呢？对于一个分数，分子分母同余一个数是不等于原分数模这个数的，而两个数相乘的时候是可以的。 即 $(a / b) \% p ≠ ((a \% p ) / ( b \% p)) \% p，而 (a * b) \% p = ((a \% p ) * ( b \% p)) \% p$

​        需要取模运算的时候，乘法是优于除法的，所以有了逆元的概念。

- 思路：

  当模数 $p$ 是质数时，对于质数 $p$ 可由费马小定理 $b^{(n-1)} ≡ 1 (mod\ p)$，得 $b * b ^ {(n - 2)} ≡ 1 (mod\ n)$，$b^{(p-2)}$ 即为 $b$ 在 $mod\ p$ 意义下的逆元。

​        快速计算 $b^{(p-2)}$ 就可以由上篇专栏讲的快速幂解决了。

- [AcWing 876.快速幂求逆元](https://www.acwing.com/problem/content/876/)   
题意：给定 $n$ 组 $a_i,p_i$，其中 $p_i$ 是质数，求 $a_i$ 模 $p_i$ 的乘法逆元，若逆元不存在则输出 $impossible$。

代码：
```java
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while (n-- > 0) {
            int a = scan.nextInt(), p = scan.nextInt();
            if (a % p > 0) { // p已经是质数了，那么如果a还不能整除p，就说明它们互质
                System.out.println(quickMi(a, p - 2, p));
            } else System.out.println("impossible");
        }
    }

    public static long quickMi(long a, long b, long c) {
        long res = 1;
        while (b != 0) {
            if ((b & 1) == 1) res = res * a % c;
            a = a * a % c;
            b >>= 1;
        }
        return res;
    }
}
```

#### 等比数列求和公式
- 公式  
  （1）定义式： ${a_n\over a_{n-1}} = q (n ≥ 2, a_{n-1} ≠ 0) $  

  （2）通项公式（等比数列通项公式通过定义式叠乘而来）： $a_n=a_1·q^{n-1}$ 

  （3）求和公式：
  $$
      &S_n = na_1(q=1) \\
      &S_n = {a_1(1-q^n)\over{1-q}}(q≠1) \\
      &S_n = {a_1-a_nq\over{1-q}}(q≠1)
  $$
  

​        求和公式用文字来描述就是：Sn=首项（1-公比的n次方）/1-公比（公比≠1）如果公比q=1，则等比数列中每项都相等，其通项公式为 $a_1q$ ，任意两项 $a_m,\ a_n $ 的关系为 $a_n=a_m · q^{n-m}$ ；在运用等比数列的前n项和时，一定要注意讨论**公比q是否为1**.
#### 等差数列求和公式
- 公式  
  （1）定义式： ${a_n = a_{n-1} + d}$  
  
  （2）通项公式： ${a_n=a_1+(n-1)·d}$  

  （3）求和公式：  
  $$
  \begin{aligned}
      & S_n = a_1·n + {n·(n-1)·d\over 2} \\
      & S_n = {n·(a_1+a_n)\over 2} \\  
      & S_n = {d\over2} · n^2 + (a_1 - {d\over2}) · n  
  \end{aligned}
  $$

#### 平方和求和公式
<img src="asset/mt/img.png" style="zoom: 80%" alt="" align="center">


- 如下数列求和
$ 1 = 1 $
$ 1，2 = 3 $
$ 1，2，3 = 6 $
$ 1，2，3，4 = 10 $
$ 1，2，3，4，5 = 15 $
$ ...... $
$ 1,3,6,10,15,......数列的通项公式n*(n+1)/2,故前n项和为n(n+1)(n+2)/6; $

#### 排列组合

$$
\begin{aligned}
  & A^m_n={n!\over(n−m)!}=n∗(n−1)∗(n−2)∗……∗(n−m+1) \\
  & C_n^m={A_n^m\over m!}={n!\over (n−m)!∗m!}={n*(n-1)*(n-2)*......*(n-m+1)\over m!}
\end{aligned}
$$

```java
public int calculatePermutations(int m, int n) {
    int ans = 1;
    // n * (n - 1) * ... * (n - m + 1)
    for (int i = n; i > n - m; i--) {
        ans *= i;
    }
    return ans;
}

public int calculateCombinations(int m, int n) {
    int ans = 1;
    // Amn
    for (int i = n; i > n - m; i--) {
        ans *= i;
    }
    // Cmn = Amn / m!
    for (int i = m; i > 0; i--) {
        ans /= i;
    }
    return ans;
}
```

例题：

**计算字符串重新排列数**
题目描述：
给定一个只包含大写英文字母的字符串S，要求你给出对S重新排列的所有不相同的排列数。
如：S为ABA，则不同的排列有ABA、AAB、BAA三种。

解题思路：
先把每个字符当成唯一出现过一次，计算所有排列数；再统计重复出现的字母，除去每个字母的排列次数。例如：
对于ABA，当成三个不同字符则排列数为：$S_总 = A_3^3 $
其中A出现两次，排列数为：$S_A = A_2^2$；
B出现两次，排列数为：$S_B = A_1^1$；
最终计算得：
$S = S_总 / ( S_A ∗ S_B ) =3∗2∗1/(2∗1∗1)=3$

```java
class Solution {
    
    public int countStringRearrangements(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int ans = calPermutations(s.length(), s.length());
        for (int i : map.values()) {
            ans /= calPermutations(i, i);
        }
        return ans;
    }
    
    public int calPermutations(int m, int n) {
        int ans = 1;
        for (int i = n; i > n - m; i--) {
            ans *= i;
        }
        return ans;
    }
}
```

————————————————
原文链接：https://blog.csdn.net/gyxx1998/article/details/123839921