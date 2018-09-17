package 算法类.剑指offer;

import java.util.Scanner;

public class 虎牙9月6日对称加密算法 {

    public static void encode(int[] a){
        for (int i = 0; i < a.length; i++) {
            switch (a[i]){
                case 1:
                    System.out.print(5);
                    break;
                case 2:
                    System.out.print(3);
                    break;
                case 3:
                    System.out.print(1);
                    break;
                case 4:
                    System.out.print(2);
                    break;
                case 5:
                    System.out.print(4);
                    break;
            }
        }
    }

    public static int[] parseSampleInput(){
        Scanner in = new Scanner(System.in);
        if (in.hasNext()){
            String[] t1 = in.nextLine().split(" ");
            int[] t2 = new int[t1.length];
            for(int i = 0;i<t1.length;i++){
                t2[i] = Integer.parseInt(t1[i]);
            }
            return t2;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] a = parseSampleInput();
        encode(a);
    }
}
