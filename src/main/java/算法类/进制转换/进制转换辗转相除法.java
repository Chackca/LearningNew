package 算法类.进制转换;

import java.util.Scanner;

public class 进制转换辗转相除法 {

    //进制转换:给定一个十进制数M，以及需要转换的进制N。将十进制数M转化为N进制数
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().split(" ");
        int m = Integer.valueOf(nums[0]);
        int n = Integer.valueOf(nums[1]);
        StringBuffer sb = new StringBuffer();
        char[] arr = {'A','B','C','D','E','F'};
        int temp = 0;
        boolean fs = false;
        if(m < 0){
            fs = true;
            m = -m;
        }
        while(m != 0){
            temp = m%n;
            if(temp > 9)
                sb.append(arr[temp-9-1]);
            else
                sb.append(temp);
            m = m/n;
        }
        if(fs)
            sb.append("-");
        System.out.println(sb.reverse().toString());
    }
}
