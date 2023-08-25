## 树形dp

树形DP准确的说是一种DP的思想，将DP建立在树状结构的基础上。整体的思路大致就是用树形的结构存储数据。

树形DP的关键和实现方法是 dfs。

先找到树根，从树根开始运用 dfs 递归，跟 dfs 一样先初始化，然后递归到叶子节点上为止，把最底层的 f [ i ] [ j ] 更新完毕，再回来往上走，自底向上地根据题意更新上层的 f 数组，最后输出答案即可。

### 概述

一般基础的题转移方程有三种模式：

**选择节点类**

<img src="..\docs\asset\tp\选择节点类.png" alt="image-20230329231609981" style="zoom:80%;" />

选择节点式的题首先前提条件是整个数据是由树形结构存储的，或者应该用树形结构存，效率更高什么的，然后会告诉你相邻的节点是不能同时存在的，要求取最大最小值 ，类似 P2016 战略游戏、P1352 没有上司的舞会（下面都有详解和题目链接哦）

**树形背包类**

<img src="..\docs\asset\tp\树形背包类.png" alt="image-20230329231704910" style="zoom:80%;" />

树形背包，就是背包加上条件，一个物品只有选择了它的主件（根节点）才能选择，类似 P2014 [CTSC 1997] 选课。

**换根DP**

树形 DP 中的换根 DP 问题又被称为二次扫描，通常不会指定根结点，并且根结点的变化会对一些值，例如子结点深度和、点权和等产生影响。

通常需要两次 DFS，第一次 DFS 预处理诸如深度，点权和之类的信息，在第二次 DFS 开始运行换根动态规划。

**DFS**

直接通过dfs计算放回对应结果，即 `int dfs(...)` 函数形式，通常也可以使用记忆化搜索解决。

### 例题

#### 选择节点

<details class="note" open="" style="box-sizing: inherit; background-color: var(--md-admonition-bg-color); border: 0.05rem solid rgb(68, 138, 255); border-radius: 0.2rem; box-shadow: var(--md-shadow-z1); color: rgba(0, 0, 0, 0.87); display: flow-root; font-size: 0.64rem; margin: 1.5625em 0px; padding: 0px 0.6rem; break-inside: avoid; overflow: visible; font-family: &quot;Fira Sans&quot;, -apple-system, BlinkMacSystemFont, Helvetica, Arial, sans-serif; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400; letter-spacing: normal; orphans: 2; text-align: start; text-indent: 0px; text-transform: none; white-space: normal; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; text-decoration-thickness: initial; text-decoration-style: initial; text-decoration-color: initial;"><summary style="box-sizing: border-box; background-color: rgba(68, 138, 255, 0.1); border-top: none; border-right: none; border-bottom: none; border-left: 0.2rem none; border-image: initial; font-weight: 700; margin: 0px -0.6rem; padding: 0.4rem 1.8rem 0.4rem 2rem; position: relative; cursor: pointer; display: block; min-height: 1rem; border-top-left-radius: 0.1rem; border-top-right-radius: 0.1rem; -webkit-tap-highlight-color: transparent; outline: none;">例题<span>&nbsp;</span><a href="https://www.luogu.com.cn/problem/P1352" style="box-sizing: inherit; -webkit-tap-highlight-color: transparent; color: var(--md-typeset-a-color); text-decoration: none; word-break: break-word; transition: color 125ms ease 0s;">洛谷 P1352 没有上司的舞会</a></summary><slot id="details-content"><p style="box-sizing: border-box; margin-bottom: 0.6rem;">某大学有<span>&nbsp;</span><mjx-container class="MathJax" jax="CHTML" style="box-sizing: inherit; line-height: 0;"><mjx-math class="MJX-TEX" style="box-sizing: inherit; display: inline-block; text-align: left; line-height: 0; text-indent: 0px; font-style: normal; font-weight: normal; font-size: 14.08px; letter-spacing: normal; border-collapse: collapse; overflow-wrap: normal; word-spacing: normal; white-space: nowrap; direction: ltr; padding: 1px 0px; font-family: MJXZERO, MJXTEX;"><mjx-mi class="mjx-i" style="box-sizing: inherit; display: inline-block; text-align: left;"><mjx-c class="mjx-c1D45B TEX-I" style="box-sizing: inherit; display: inline-block; font-family: MJXZERO, MJXTEX-I;"></mjx-c></mjx-mi></mjx-math><img src="data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7" title="n" style="box-sizing: inherit; border-style: none; width: 0px; height: auto; max-width: 100%;"></mjx-container><span>&nbsp;</span>个职员，编号为<span>&nbsp;</span><mjx-container class="MathJax" jax="CHTML" style="box-sizing: inherit; line-height: 0;"><mjx-math class="MJX-TEX" style="box-sizing: inherit; display: inline-block; text-align: left; line-height: 0; text-indent: 0px; font-style: normal; font-weight: normal; font-size: 14.08px; letter-spacing: normal; border-collapse: collapse; overflow-wrap: normal; word-spacing: normal; white-space: nowrap; direction: ltr; padding: 1px 0px; font-family: MJXZERO, MJXTEX;"><mjx-mn class="mjx-n" style="box-sizing: inherit; display: inline-block; text-align: left;"><mjx-c class="mjx-c31" style="box-sizing: inherit; display: inline-block;"></mjx-c></mjx-mn><mjx-mo class="mjx-n" space="4" style="box-sizing: inherit; display: inline-block; text-align: left; margin-left: 0.278em;"><mjx-c class="mjx-c223C" style="box-sizing: inherit; display: inline-block;"></mjx-c></mjx-mo><mjx-mi class="mjx-i" space="4" style="box-sizing: inherit; display: inline-block; text-align: left; margin-left: 0.278em;"><mjx-c class="mjx-c1D441 TEX-I" style="box-sizing: inherit; display: inline-block; font-family: MJXZERO, MJXTEX-I;"></mjx-c></mjx-mi></mjx-math><img title="1 \sim N" src="data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7" style="box-sizing: inherit; border-style: none; width: 0px; height: auto; max-width: 100%;"></mjx-container>。他们之间有从属关系，也就是说他们的关系就像一棵以校长为根的树，父结点就是子结点的直接上司。现在有个周年庆宴会，宴会每邀请来一个职员都会增加一定的快乐指数<span>&nbsp;</span><mjx-container class="MathJax" jax="CHTML" style="box-sizing: inherit; line-height: 0;"><mjx-math class="MJX-TEX" style="box-sizing: inherit; display: inline-block; text-align: left; line-height: 0; text-indent: 0px; font-style: normal; font-weight: normal; font-size: 14.08px; letter-spacing: normal; border-collapse: collapse; overflow-wrap: normal; word-spacing: normal; white-space: nowrap; direction: ltr; padding: 1px 0px; font-family: MJXZERO, MJXTEX;"><mjx-msub style="box-sizing: inherit; display: inline-block; text-align: left;"><mjx-mi class="mjx-i" style="box-sizing: inherit; display: inline-block; text-align: left;"><mjx-c class="mjx-c1D44E TEX-I" style="box-sizing: inherit; display: inline-block; font-family: MJXZERO, MJXTEX-I;"></mjx-c></mjx-mi><mjx-script style="box-sizing: inherit; display: inline-block; padding-right: 0.05em; padding-left: 0.033em; vertical-align: -0.15em;"><mjx-mi class="mjx-i" size="s" style="box-sizing: inherit; display: inline-block; text-align: left; font-size: 12px;"><mjx-c class="mjx-c1D456 TEX-I" style="box-sizing: inherit; display: inline-block; font-family: MJXZERO, MJXTEX-I;"></mjx-c></mjx-mi></mjx-script></mjx-msub></mjx-math><img src="data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7" title="a_i" style="box-sizing: inherit; border-style: none; width: 0px; height: auto; max-width: 100%;"></mjx-container>，但是呢，如果某个职员的直接上司来参加舞会了，那么这个职员就无论如何也不肯来参加舞会了。所以，请你编程计算，邀请哪些职员可以使快乐指数最大，求最大的快乐指数。</p></slot></details>

我们设 ![f(i,0/1)](data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7) 代表以 ![i](data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7) 为根的子树的最优解（第二维的值为 0 代表 ![i](data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7) 不参加舞会的情况，1 代表 ![i](data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7) 参加舞会的情况）。

对于每个状态，都存在两种决策（其中下面的 ![x](data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7) 都是 ![i](data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7) 的儿子）：

- 上司不参加舞会时，下属可以参加，也可以不参加，此时有 ![f(i,0) = \sum\max \{f(x,1),f(x,0)\}](data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7)；
- 上司参加舞会时，下属都不会参加，此时有 ![f(i,1) = \sum{f(x,0)} + a_i](data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7)。

我们可以通过 DFS，在返回上一层时更新当前结点的最优解。

**单向**

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N = 6005;
    static int[][] dp = new int[N][2]; // dp[i][j] 表示以i为根节点，0-表示当前节点不参加，1-表示当前节点参加
    static int[] scores = new int[N], degrees = new int[N];
    static List<Integer>[] adjs;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 1; i <= n; i++) scores[i] = scan.nextInt();
        adjs = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) adjs[i] = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            int v = scan.nextInt(), u = scan.nextInt();
            adjs[u].add(v);
            degrees[v]++;
        }
        int root = -1;
        for (int i = 1; i <= n; i++) {
            if (degrees[i] == 0) {
                root = i;
                break;
            }
        }
        dfs(root);
        System.out.println(Math.max(dp[root][0], dp[root][1]));
    }

    public static void dfs(int u) {
        dp[u][0] = 0;
        dp[u][1] = scores[u];
        for (int v : adjs[u]) {
            dfs(v);
            dp[u][0] += Math.max(dp[v][0], dp[v][1]);
            dp[u][1] += dp[v][0];
        }
    }
}
```

- **洛谷P2016 战略游戏**

**单向**

Bob 喜欢玩电脑游戏，特别是战略游戏。但是他经常无法找到快速玩过游戏的办法。现在他有个问题。

题目描述 他要建立一个古城堡，城堡中的路形成一棵无根树。他要在这棵树的结点上放置最少数目的士兵，使得这些士兵能瞭望到所有的路。 注意，某个士兵在一个结点上时，与该结点相连的所有边将都可以被瞭望到。请你编一程序，给定一树，帮 Bob 计算出他需要放置最少的士兵。

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int[][] dp;
    static List<Integer>[] adjs;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), root = -1;
        adjs = new ArrayList[n];
        // dp[i][j] - 表示在节点i处，（0-不放置士兵，1-放置士兵）时监控到所有节点需要的最少士兵数目
        dp = new int[n][2]; 
        int[] degrees = new int[n];
        for (int i = 0; i < n; i++) adjs[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int u = scan.nextInt(), k = scan.nextInt();
            for (int j = 0; j < k; j++) {
                int v = scan.nextInt();
                adjs[u].add(v);
                degrees[v]++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (degrees[i] == 0) {
                root = i;
                break;
            }
        }
        dfs(root);
        System.out.println(Math.min(dp[root][0], dp[root][1]));
    }

    public static void dfs(int u) {
        dp[u][0] = 0;
        dp[u][1] = 1;
        for (int v : adjs[u]) {
            dfs(v);
            // 如果当前节点不放置士兵,那么它的子节点必须全部放置士兵,因为要满足士兵可以看到所有的边
            dp[u][0] += dp[v][1]; 
            dp[u][1] += Math.min(dp[v][0], dp[v][1]);
        }
    }
}
```

#### 树上背包

树上的背包问题，简单来说就是背包问题与树形 DP 的结合。

<details class="note" open="" style="box-sizing: inherit; background-color: var(--md-admonition-bg-color); border: 0.05rem solid rgb(68, 138, 255); border-radius: 0.2rem; box-shadow: var(--md-shadow-z1); color: rgba(0, 0, 0, 0.87); display: flow-root; font-size: 0.64rem; margin: 1.5625em 0px; padding: 0px 0.6rem; break-inside: avoid; overflow: visible; font-family: &quot;Fira Sans&quot;, -apple-system, BlinkMacSystemFont, Helvetica, Arial, sans-serif; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400; letter-spacing: normal; orphans: 2; text-align: start; text-indent: 0px; text-transform: none; white-space: normal; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; text-decoration-thickness: initial; text-decoration-style: initial; text-decoration-color: initial;"><summary style="box-sizing: border-box; background-color: rgba(68, 138, 255, 0.1); border-top: none; border-right: none; border-bottom: none; border-left: 0.2rem none; border-image: initial; font-weight: 700; margin: 0px -0.6rem; padding: 0.4rem 1.8rem 0.4rem 2rem; position: relative; cursor: pointer; display: block; min-height: 1rem; border-top-left-radius: 0.1rem; border-top-right-radius: 0.1rem; -webkit-tap-highlight-color: transparent; outline: none;">例题<span>&nbsp;</span><a href="https://www.luogu.com.cn/problem/P2014" style="box-sizing: inherit; -webkit-tap-highlight-color: transparent; color: var(--md-typeset-a-color); text-decoration: none; word-break: break-word; transition: color 125ms ease 0s;">洛谷 P2014 CTSC1997 选课</a></summary><p style="box-sizing: border-box;">现在有<span>&nbsp;</span><mjx-container class="MathJax" jax="CHTML" style="box-sizing: inherit; line-height: 0;"><mjx-math class="MJX-TEX" style="box-sizing: inherit; display: inline-block; text-align: left; line-height: 0; text-indent: 0px; font-style: normal; font-weight: normal; font-size: 14.08px; letter-spacing: normal; border-collapse: collapse; overflow-wrap: normal; word-spacing: normal; white-space: nowrap; direction: ltr; padding: 1px 0px; font-family: MJXZERO, MJXTEX;"><mjx-mi class="mjx-i" style="box-sizing: inherit; display: inline-block; text-align: left;"><mjx-c class="mjx-c1D45B TEX-I" style="box-sizing: inherit; display: inline-block; font-family: MJXZERO, MJXTEX-I;"></mjx-c></mjx-mi></mjx-math><img src="data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7" title="n" style="box-sizing: inherit; border-style: none; width: 0px; height: auto; max-width: 100%;"></mjx-container><span>&nbsp;</span>门课程，第<span>&nbsp;</span><mjx-container class="MathJax" jax="CHTML" style="box-sizing: inherit; line-height: 0;"><mjx-math class="MJX-TEX" style="box-sizing: inherit; display: inline-block; text-align: left; line-height: 0; text-indent: 0px; font-style: normal; font-weight: normal; font-size: 14.08px; letter-spacing: normal; border-collapse: collapse; overflow-wrap: normal; word-spacing: normal; white-space: nowrap; direction: ltr; padding: 1px 0px; font-family: MJXZERO, MJXTEX;"><mjx-mi class="mjx-i" style="box-sizing: inherit; display: inline-block; text-align: left;"><mjx-c class="mjx-c1D456 TEX-I" style="box-sizing: inherit; display: inline-block; font-family: MJXZERO, MJXTEX-I;"></mjx-c></mjx-mi></mjx-math><img src="data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7" title="i" style="box-sizing: inherit; border-style: none; width: 0px; height: auto; max-width: 100%;"></mjx-container><span>&nbsp;</span>门课程的学分为<span>&nbsp;</span><mjx-container class="MathJax" jax="CHTML" style="box-sizing: inherit; line-height: 0;"><mjx-math class="MJX-TEX" style="box-sizing: inherit; display: inline-block; text-align: left; line-height: 0; text-indent: 0px; font-style: normal; font-weight: normal; font-size: 14.08px; letter-spacing: normal; border-collapse: collapse; overflow-wrap: normal; word-spacing: normal; white-space: nowrap; direction: ltr; padding: 1px 0px; font-family: MJXZERO, MJXTEX;"><mjx-msub style="box-sizing: inherit; display: inline-block; text-align: left;"><mjx-mi class="mjx-i" style="box-sizing: inherit; display: inline-block; text-align: left;"><mjx-c class="mjx-c1D44E TEX-I" style="box-sizing: inherit; display: inline-block; font-family: MJXZERO, MJXTEX-I;"></mjx-c></mjx-mi><mjx-script style="box-sizing: inherit; display: inline-block; padding-right: 0.05em; padding-left: 0.033em; vertical-align: -0.15em;"><mjx-mi class="mjx-i" size="s" style="box-sizing: inherit; display: inline-block; text-align: left; font-size: 12px;"><mjx-c class="mjx-c1D456 TEX-I" style="box-sizing: inherit; display: inline-block; font-family: MJXZERO, MJXTEX-I;"></mjx-c></mjx-mi></mjx-script></mjx-msub></mjx-math><img src="data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7" title="a_i" style="box-sizing: inherit; border-style: none; width: 0px; height: auto; max-width: 100%;"></mjx-container>，每门课程有零门或一门先修课，有先修课的课程需要先学完其先修课，才能学习该课程。</p><p style="box-sizing: border-box;">一位学生要学习<span>&nbsp;</span><mjx-container class="MathJax" jax="CHTML" style="box-sizing: inherit; line-height: 0;"><mjx-math class="MJX-TEX" style="box-sizing: inherit; display: inline-block; text-align: left; line-height: 0; text-indent: 0px; font-style: normal; font-weight: normal; font-size: 14.08px; letter-spacing: normal; border-collapse: collapse; overflow-wrap: normal; word-spacing: normal; white-space: nowrap; direction: ltr; padding: 1px 0px; font-family: MJXZERO, MJXTEX;"><mjx-mi class="mjx-i" style="box-sizing: inherit; display: inline-block; text-align: left;"><mjx-c class="mjx-c1D45A TEX-I" style="box-sizing: inherit; display: inline-block; font-family: MJXZERO, MJXTEX-I;"></mjx-c></mjx-mi></mjx-math><img src="data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7" title="m" style="box-sizing: inherit; border-style: none; width: 0px; height: auto; max-width: 100%;"></mjx-container><span>&nbsp;</span>门课程，求其能获得的最多学分数。</p><p style="box-sizing: border-box; margin-bottom: 0.6rem;"><mjx-container class="MathJax" jax="CHTML" style="box-sizing: inherit; line-height: 0;"><mjx-math class="MJX-TEX" style="box-sizing: inherit; display: inline-block; text-align: left; line-height: 0; text-indent: 0px; font-style: normal; font-weight: normal; font-size: 14.08px; letter-spacing: normal; border-collapse: collapse; overflow-wrap: normal; word-spacing: normal; white-space: nowrap; direction: ltr; padding: 1px 0px; font-family: MJXZERO, MJXTEX;"><mjx-mi class="mjx-i" style="box-sizing: inherit; display: inline-block; text-align: left;"><mjx-c class="mjx-c1D45B TEX-I" style="box-sizing: inherit; display: inline-block; font-family: MJXZERO, MJXTEX-I;"></mjx-c></mjx-mi><mjx-mo class="mjx-n" style="box-sizing: inherit; display: inline-block; text-align: left;"><mjx-c class="mjx-c2C" style="box-sizing: inherit; display: inline-block;"></mjx-c></mjx-mo><mjx-mi class="mjx-i" space="2" style="box-sizing: inherit; display: inline-block; text-align: left; margin-left: 0.167em;"><mjx-c class="mjx-c1D45A TEX-I" style="box-sizing: inherit; display: inline-block; font-family: MJXZERO, MJXTEX-I;"></mjx-c></mjx-mi><mjx-mo class="mjx-n" space="4" style="box-sizing: inherit; display: inline-block; text-align: left; margin-left: 0.278em;"><mjx-c class="mjx-c2264" style="box-sizing: inherit; display: inline-block;"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="4" style="box-sizing: inherit; display: inline-block; text-align: left; margin-left: 0.278em;"><mjx-c class="mjx-c33" style="box-sizing: inherit; display: inline-block;"></mjx-c><mjx-c class="mjx-c30" style="box-sizing: inherit; display: inline-block;"></mjx-c><mjx-c class="mjx-c30" style="box-sizing: inherit; display: inline-block;"></mjx-c></mjx-mn></mjx-math><img title="n,m \leq 300" src="data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7" style="box-sizing: inherit; border-style: none; width: 0px; height: auto; max-width: 100%;"></mjx-container></p></details>

每门课最多只有一门先修课的特点，与有根树中一个点最多只有一个父亲结点的特点类似。

因此可以想到根据这一性质建树，从而所有课程组成了一个森林的结构。为了方便起见，我们可以新增一门 0 学分的课程（设这个课程的编号为 ![0](data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7)），作为所有无先修课课程的先修课，这样我们就将森林变成了一棵以 ![0](data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7) 号课程为根的树。

我们设 f(u,i,j)![f(u,i,j)](data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7) 表示以 u 号点为根的子树中，已经遍历了 u 号点的前 i 棵子树，选了 j 门课程的最大学分。

转移的过程结合了树形 DP 和 [背包 DP](https://oi-wiki.org/dp/knapsack/) 的特点，我们枚举 ![u](data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7) 点的每个子结点 ![v](data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7)，同时枚举以 ![v](data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7) 为根的子树选了几门课程，将子树的结果合并到 ![u](data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7) 上。

记点 ![x](data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7) 的儿子个数为 ![s_x](data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7)，以 ![x](data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7) 为根的子树大小为 ![\textit{siz_x}](data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7)，可以写出下面的状态转移方程：

![ f(u,i,j)=\max_{v,k \leq j,k \leq \textit{siz_v}} f(u,i-1,j-k)+f(v,s_v,k) ]

注意上面状态转移方程中的几个限制条件，这些限制条件确保了一些无意义的状态不会被访问到。

![f](data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7) 的第二维可以很轻松地用滚动数组的方式省略掉，注意这时需要倒序枚举 ![j](data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7) 的值。

可以证明，该做法的时间复杂度为 ![O(nm)](data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7)[1](https://oi-wiki.org/dp/tree/#fn:note1)。

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int[][] dp; // dp[i][j] - 以i为根节点选了j门课程的最大学分
    static int n, m;
    static int[] scores;
    static List<Integer>[] adjs;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        dp = new int[n + 5][n + 5];
        scores = new int[n + 5];
        adjs = new ArrayList[n + 5];
        for (int i = 0; i < adjs.length; i++) adjs[i] = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int u = scan.nextInt(), score = scan.nextInt();
            adjs[u].add(i);
            scores[i] = score;
        }
        // 新增一门0学分的课程0，作为所有无先修课课程的先修课
        dfs(0);
        System.out.println(dp[0][m + 1]);
    }

    public static void dfs(int u) {
        dp[u][1] = scores[u];
        for (int v : adjs[u]) {
            dfs(v);
            // 注意下面两重循环的上界和下界
            // 只考虑已经合并过的子树，以及选的课程数超过 m+1 的状态没有意义
            for (int j = m + 1; j >= 1; --j) { // 背包重量
                for (int k = 0; k < j; k++) { // k < j，必须保证选 curr，才能往下选择其子节点
                    dp[u][j] = Math.max(dp[u][j], dp[v][k] + dp[u][j - k]);
                }
            }
        }
    }
}
```

#### 换根DP

<details class="note" open="" style="box-sizing: inherit; background-color: var(--md-admonition-bg-color); border: 0.05rem solid rgb(68, 138, 255); border-radius: 0.2rem; box-shadow: var(--md-shadow-z1); color: rgba(0, 0, 0, 0.87); display: flow-root; font-size: 0.64rem; margin: 1.5625em 0px; padding: 0px 0.6rem; break-inside: avoid; overflow: visible; font-family: &quot;Fira Sans&quot;, -apple-system, BlinkMacSystemFont, Helvetica, Arial, sans-serif; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400; letter-spacing: normal; orphans: 2; text-align: start; text-indent: 0px; text-transform: none; white-space: normal; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; text-decoration-thickness: initial; text-decoration-style: initial; text-decoration-color: initial;"><summary style="box-sizing: border-box; background-color: rgba(68, 138, 255, 0.1); border-top: none; border-right: none; border-bottom: none; border-left: 0.2rem none; border-image: initial; font-weight: 700; margin: 0px -0.6rem; padding: 0.4rem 1.8rem 0.4rem 2rem; position: relative; cursor: pointer; display: block; min-height: 1rem; border-top-left-radius: 0.1rem; border-top-right-radius: 0.1rem; -webkit-tap-highlight-color: transparent; outline: none;">例题<span>&nbsp;</span><a href="https://www.luogu.com.cn/problem/P3478" style="box-sizing: inherit; -webkit-tap-highlight-color: transparent; color: var(--md-typeset-a-color); text-decoration: none; word-break: break-word; transition: color 125ms ease 0s;">[POI2008]STA-Station</a></summary><slot id="details-content"><p style="box-sizing: border-box; margin-bottom: 0.6rem;">给定一个<span>&nbsp;</span><mjx-container class="MathJax" jax="CHTML" style="box-sizing: inherit; line-height: 0;"><mjx-math class="MJX-TEX" style="box-sizing: inherit; display: inline-block; text-align: left; line-height: 0; text-indent: 0px; font-style: normal; font-weight: normal; font-size: 14.08px; letter-spacing: normal; border-collapse: collapse; overflow-wrap: normal; word-spacing: normal; white-space: nowrap; direction: ltr; padding: 1px 0px; font-family: MJXZERO, MJXTEX;"><mjx-mi class="mjx-i" style="box-sizing: inherit; display: inline-block; text-align: left;"><mjx-c class="mjx-c1D45B TEX-I" style="box-sizing: inherit; display: inline-block; font-family: MJXZERO, MJXTEX-I;"></mjx-c></mjx-mi></mjx-math><img src="data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7" title="n" style="box-sizing: inherit; border-style: none; width: 0px; height: auto; max-width: 100%;"></mjx-container><span>&nbsp;</span>个点的树，请求出一个结点，使得以这个结点为根时，所有结点的深度之和最大。</p></slot></details>

不妨令 ![u](data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7) 为当前结点，![v](data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7) 为当前结点的子结点。首先需要用 ![s_i](data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7) 来表示以 ![i](data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7) 为根的子树中的结点个数，并且有 ![s_u=1+\sum s_v](data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7)。显然需要一次 DFS 来计算所有的 ![s_i](data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7)，这次的 DFS 就是预处理，我们得到了以某个结点为根时其子树中的结点总数。

考虑状态转移，这里就是体现＂换根＂的地方了。令 ![f_u](data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7) 为以 ![u](data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7) 为根时，所有结点的深度之和。

![f_v\leftarrow f_u](data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7) 可以体现换根，即以 u 为根转移到以 v 为根。显然在换根的转移过程中，以 v 为根或以 u 为根会导致其子树中的结点的深度产生改变。具体表现为：

- 所有在 v 的子树上的结点深度都减少了一，那么总深度和就减少了 sv；
- 所有不在 v 的子树上的结点深度都增加了一，那么总深度和就增加了 n - sv；

根据这两个条件就可以推出状态转移方程 ![f_v = f_u - s_v + n - s_v=f_u + n - 2 \times s_v](data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7)。

于是在第二次 DFS 遍历整棵树并状态转移 ![f_v=f_u + n - 2 \times s_v](data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7)，那么就能求出以每个结点为根时的深度和了。最后只需要遍历一次所有根结点深度和就可以求出答案。

**自底向上就是通过子节点去更新父节点的值 求 dp[u]**
**自顶向下就是通过父节点去更新子节点的值 求 dp[v]**

```java
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokenizer = new StringTokenizer("");
    static int N = (int) 1e6 + 5, n;
    // dpi-表示以i为根时所有节点的深度之和，szi-表示以i为根的子树中的节点个数
    static long[] dp = new long[N], sz = new long[N]; 
    static long[] dep = new long[N]; // depi-节点i的深度
    static List<Integer>[] adjs;

    public static void main(String[] args) {
        n = nextInt();
        adjs = new ArrayList[n + 5];
        for (int i = 0; i < adjs.length; i++) adjs[i] = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            int u = nextInt(), v = nextInt();
            adjs[u].add(v);
            adjs[v].add(u);
        }
        dfs1(1, 1);
        for (int i = 1; i <= n; i++) dp[1] += dep[i];
        dfs2(1, 1);
        long ans = -1;
        int idx = 0;
        for (int i = 1; i <= n; i++) { // 遍历以i为根节点时的答案
            if (dp[i] > ans) {
                ans = dp[i];
                idx = i;
            }
        }
        System.out.println(idx);
    }

    // 预处理 dfs - 得到以某个节点为根时，其子树中的节点总数 （自底向上）
    public static void dfs1(int u, int fa) {
        sz[u] = 1;
        dep[u] = dep[fa] + 1;
        for (int v : adjs[u]) {
            if (v != fa) {
                dfs1(v, u);
                sz[u] += sz[v];
            }
        }
    }

    // 换根dp - 自顶向下
    public static void dfs2(int u, int fa) {
        for (int v : adjs[u]) {
            if (v != fa) {
                // 所有在 v 的子树上的结点深度都减少了一，那么总深度和就减少了 sv；
                // 所有不在 v 的子树上的结点深度都增加了一，那么总深度和就增加了 n - sv；
                // dp[v] = dp[u] - s[v] * 1 + (n - s[v]) * 1
                dp[v] = dp[u] - sz[v] * 2 + n;
                dfs2(v, u);
            }
        }
    }

    public static String next() {
        while (!tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public static int nextInt() { return Integer.parseInt(next()); }

    public static long nextLong() { return Long.parseLong(next()); }

}
```

- [ACWing P1072.树的最长路径](https://blog.csdn.net/Jacob0824/article/details/123693835) 两类节点：向下走最长、次长

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * P1072.树的最长路径
 * <p>
 * 给定一棵树，树中包含n个结点 (编号1~n)和n-1条无向边，每条边都有一个权值现在请你找到树中的一条最长路径
 * 换句话说，要找到一条路径，使得使得路径两端的点的距离最远注意:路径中可以只包含一个点。
 *
 * <a href="https://blog.csdn.net/Jacob0824/article/details/123693835">P1072.树的最长路径</a>
 */
public class Main {
    static int N = (int) 1e4 + 5;
    static int[][] dp = new int[N][2]; // dp[i][0] - 最长路，dp[i][1] - 次长路
    static List<int[]>[] adjs;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), ans = -1;
        adjs = new ArrayList[n + 5];
        for (int i = 0; i < adjs.length; i++) adjs[i] = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            int u = scan.nextInt(), v = scan.nextInt(), w = scan.nextInt();
            adjs[u].add(new int[]{v, w});
            adjs[v].add(new int[]{u, w});
        }
        dfs(1, 1);
        for (int i = 1; i <= n; i++) ans = Math.max(ans, dp[i][0] + dp[i][1]);
        System.out.println(ans);
    }

    public static void dfs(int u, int fa) {
        dp[u][0] = dp[u][1] = 0;
        for (int[] vw : adjs[u]) {
            int v = vw[0], w = vw[1];
            if (v == fa) continue;
            dfs(v, u);
            if (dp[u][0] <= dp[v][0] + w) { // 更新最长距离
                // 先更新次长距离
                dp[u][1] = dp[u][0];
                // 在更新最长距离
                dp[u][0] = dp[v][0] + w;
            } else dp[u][1] = Math.max(dp[u][1], dp[v][0] + w);
        }
    }
}
```

- [ACWing P1073.树的中心节点](https://blog.csdn.net/Jacob0824/article/details/123701724) 三类节点：向下走最长，次长，和 向父节点走最长

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * P1073. 树的中心
 * <p>
 * 给定一棵树，树中包含n个结点 (编号1n)和n-1条无向边，每条边都有一个权值请你在树中找到一个点，使得该点到树中其他结点的最远距离最近。
 */
public class Main {
    static int N = (int) 1e4 + 5;
    // dp[i][0] - 向下的最长距离，dp[i][1] - 向下的次长距离，dp[i][2] - 向上的最长距离（走父节点）
    static int[][] dp = new int[N][3];
    static int[] sons = new int[N]; // sons[u] = v 表示 u 为父节点得到最大距离的子节点为 v
    static List<int[]>[] adjs;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        adjs = new ArrayList[n + 5];
        for (int i = 0; i < adjs.length; i++) adjs[i] = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            int u = scan.nextInt(), v = scan.nextInt(), w = scan.nextInt();
            adjs[u].add(new int[]{v, w});
            adjs[v].add(new int[]{u, w});
        }
        dfs1(1, 1);
        dfs2(1, 1);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) ans = Math.min(ans, Math.max(dp[i][0], dp[i][2]));
        System.out.println(ans);
    }

    // 求最长和次长 dp[i][0], dp[i][1]
    public static void dfs1(int u, int fa) {
        dp[u][0] = dp[u][1] = 0;
        for (int[] vw : adjs[u]) {
            int v = vw[0], w = vw[1];
            if (v == fa) continue;
            dfs1(v, u);
            if (dp[u][0] < dp[v][0] + w) {
                dp[u][1] = dp[u][0];
                dp[u][0] = dp[v][0] + w;
                sons[u] = v;
            } else dp[u][1] = Math.max(dp[u][1], dp[v][0] + w);
        }
    }

    public static void dfs2(int u, int fa) {
        for (int[] vw : adjs[u]) {
            int v = vw[0], w = vw[1];
            if (v == fa) continue;
            if (v == sons[u]) dp[v][2] = Math.max(dp[u][1], dp[u][2]) + w;
            else dp[v][2] = Math.max(dp[u][0], dp[u][2]) + w;
            dfs2(v, u);
        }
    }
}
```

#### DFS

- 百度0313笔试第三题

小红拿到了一棵树，每个节点被染成了红色或者蓝色。小红定义每条边的权值为：删除这条边时，形成的两个子树的同色连通块数量之差的绝对值。小红想知道，所有边的权值之和是多少？

```
4
BBRR
1 2
3 2
4 1
2

7
RRBRRRB
1 2
1 3
1 4
3 5
3 6
4 7
16
```

```java
import java.util.*;

public class Main {
    static int N = (int) 2e5 + 5;
    static int[][] edges = new int[N][2];
    static char[] colors;
    static List<Integer>[] adjs;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        char[] cs = scan.next().toCharArray();
        colors = new char[n + 1];
        for (int i = 1; i <= n; i++) colors[i] = cs[i - 1];
        adjs = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) adjs[i] = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            int u = scan.nextInt(), v = scan.nextInt();
            edges[i] = new int[]{u, v};
            adjs[u].add(v);
            adjs[v].add(u);
        }
        long ans = 0;
        for (int i = 0; i < n - 1; i++) {
            int u = edges[i][0], v = edges[i][1];
            ans += Math.abs(dfs(u, v) - dfs(v, u));
        }
        System.out.println(ans);
    }

    public static int dfs(int u, int fa) {
        int sum = 1;
        for (int v : adjs[u]) {
            if (v == fa) continue;
            sum += dfs(v, u);
            if (colors[v] == colors[u]) sum--;
        }
        return sum;
    }
}
```

美团 2021 年第十场 Q4 [最优二叉树II](https://blog.csdn.net/qq_35915636/article/details/123462948)

小团有一个由N个节点组成的二叉树，每个节点有一个权值。定义二叉树每条边的开销为其两端节点权值的乘积，二叉树的总开销即每条边的开销之和。小团按照二叉树的中序遍历依次记录下每个节点的权值，即他记录下了N个数，第i个数表示位于中序遍历第i个位置的节点的权值。

之后由于某种原因，小团遗忘了二叉树的具体结构。在所有可能的二叉树中，总开销最小的二叉树被称为最优二叉树。现在，小团请小美求出最优二叉树的总开销。

```java
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N = 305;
    static int[] ws;
    static int[][][] dp = new int[N][N][N];


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        ws = new int[n + 5];
        for (int i = 1; i <= n; i++) ws[i] = scan.nextInt();
        for (int[][] ints : dp) for (int[] ints1 : ints) Arrays.fill(ints1, -1);
        // 0为添加的虚拟节点
        System.out.println(dfs(1, n, 0));
    }

    public static int dfs(int left, int right, int fa) {
        if (left > right) return 0;
        if (dp[left][right][fa] != -1) return dp[left][right][fa];
        int ans = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            int w = ws[fa] * ws[i];
            int ls = dfs(left, i - 1, i), rs = dfs(i + 1, right, i);
            ans = Math.min(ans, ls + rs + w);
        }
        return dp[left][right][fa] = ans;
    }
}
```

### 参考资料

https://blog.csdn.net/weixin_45697774/article/details/105352366

https://oi-wiki.org/dp/tree/

