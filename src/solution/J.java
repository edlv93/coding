package solution;

public class J {
    public static void main(String[] args) {
        String[] t = {"兴", "招", "前", "易", "中"};
        double[] a = {11965.47, 7385.47, 10957.15, 26181.46, 4619.39};
        double[] r = {1.68, 2.44, 1.84, 1.71, 1.71};
        double res = 0;
        for (int i = 0; i < a.length; i++) {
            System.out.println(t[i] + ":" + (a[i] * (1 + r[i] / 100)));
            res += a[i] * r[i] / 100;
        }
        System.out.println("今日：" + res);
    }
}
