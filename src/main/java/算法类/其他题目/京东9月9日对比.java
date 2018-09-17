package 算法类.其他题目;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 京东9月9日对比 {
    private static ArrayList<Node> list = new ArrayList();
    private static class Node implements Comparable<Node>{
        long a;
        long b;
        long c;
        boolean flag = false;
        Node(long a,long b,long c){
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public int compareTo(Node o){
            if (this.a>o.a && this.b >o.b &&this.c > o.c) {
                o.flag = true;
                return 1;
            }
            else if (this.a<o.a && this.b <o.b &&this.c < o.c) {
                this.flag = true;
                return -1;
            }
            else return 0;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            list.clear();
            int n = sc.nextInt();
            while (--n>=0){
                long a = sc.nextLong();
                long b = sc.nextLong();
                long c = sc.nextLong();
                list.add(new Node(a,b,c));
            }
            for (int i = 0; i < list.size(); i++) {
                Node node1 = list.get(i);
                for (int j = i+1; j < list.size(); j++) {
                    Node node2 = list.get(j);
                    if (node1.compareTo(node2)==1){
                        node2.flag = true;
                    }else if (node1.compareTo(node2)==-1){
                        node1.flag = true;
                    }
                }
            }

            //Collections.sort(list);
            int res = 0;
            for (Node node : list) {
                if (node.flag == true)
                    res++;
            }
            System.out.println(res);
        }
    }
}
/**
 3
 1 4 2
 4 3 2
 2 5 3

 3
 2 5 3
 1 4 2
 4 3 2

 4
 1 2 3
 2 3 4
 3 4 5
 4 5 6


 4
 4 5 6
 3 4 5
 2 3 4
 1 2 3


 */