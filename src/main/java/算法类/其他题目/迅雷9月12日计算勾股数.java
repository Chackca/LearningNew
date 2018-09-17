package 算法类.其他题目;

import java.util.*;

/**
 * @Author Chackca
 * @Date 2018/9/12 19:25
 * @Description :
 * 勾股数，是由三个正整数组成的数组；能符合勾股定理 a*a + b*b = c*c ，
 * (a, b, c) 的正整数解。如果 (a, b, c) 是勾股数，它们的正整数倍数，
 * 也是勾股数。如果 (a, b, c) 互质，它们就称为素勾股数。给定正整数N，
 * 计算出小于或等于N的素勾股数个数。(0 < a <= b <= c <= N)
 *
 * 输入
 * 正整数N
 *
 * 输出
 * 小于或等于N的素勾股数个数
 *
 * (0 < a <= b <= c <= N)
 *
 *
 * 样例输入
 * 10
 * 样例输出
 * 1
 **/
public class 迅雷9月12日计算勾股数 {
    private static LinkedHashMap<Long,Long> map = new LinkedHashMap();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            map.clear();
            long n = sc.nextLong();
            getResult(n);
            System.out.println(map.size());
        }
    }

    public static void getResult(long max) {
        for (long i = 1; i < max; i++) {
            for (long j = i; j < max; j++) {
                Iterator<Long> iter = map.keySet().iterator();
                boolean flag = false;
                while (iter.hasNext() && !flag) {
                    Long key = iter.next();
                    Long val = map.get(key);
                    if ((i / key) == (j / val) && (i % key) == 0 && (j % val) == 0) {
                        flag = true;
                        break;
                    }
                }
                if (flag) continue;
                for (long n = j + 1; n < max; n++) {
                    long temp = i * i + j * j;
                    if (temp == n * n) {
                        map.put(i,j);
                        //System.out.println(i + " " + j + " " + n);
                        break;
                    } else if (temp < n * n){
                        break;
                    }
                }
            }
        }
    }
}
