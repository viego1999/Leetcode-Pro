package problems;

public class Problem779 {
    public static void main(String[] args) {

    }

    /*
        找规律 第n（n>1）行的前一半等于第n-1行，后一半等于n-1行的翻转
        即可从后往前推 看从第一行的0开始翻转了几次，奇数为1，偶数为0
     */
    public int kthGrammar__(int n, int k) {
        int t = 0; // 翻转的次数
        while (n > 1) {
            if (k > 1 << (n - 2)) {
                t++;
                k -= 1 << (n - 2);
            }
            n--;
        }
        return t & 1;
    }

    public int kthGrammar(int n, int k) { // 左右子树，自底向上递归
        if (n == 1) return 0;
        int fa = kthGrammar(n - 1, (k + 1) / 2);
        if (fa == 0) return 1 - k & 1;
        else return k & 1;
    }

    public int kthGrammar_(int n, int k) {
        if (n == 1) return 0;
        if (k > 1 << (n - 2)) return kthGrammar_(n - 1, k - (1 << (n - 2))) ^ 1;
        return kthGrammar_(n - 1, k);
    }
}
