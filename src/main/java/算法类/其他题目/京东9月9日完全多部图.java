package 算法类.其他题目;

import java.util.*;

public class 京东9月9日完全多部图 {

    //static ArrayList<ArrayList<Node>> list = new ArrayList<>();
    //static HashMap<Integer,Node> map = new HashMap<>();
    static ArrayList<String> res = new ArrayList();

    static class Node{
        int key;
        HashSet<Node> set = new HashSet();
        Node(int key){
            this.key = key;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            boolean flag = false;
            int T = sc.nextInt();
            while (--T>=0){
                int N = sc.nextInt();//N个点
                int M = sc.nextInt();//点之间的关系

                ArrayList<ArrayList<Node>> list = new ArrayList<>();
                HashMap<Integer,Node> map = new HashMap<>();

                while (--M>=0){
                    Node n1;
                    int cur = sc.nextInt();
                    if (!map.containsKey(cur)){
                        n1 = new Node(cur);
                        map.put(cur,n1);
                    }else n1 = map.get(cur);

                    Node n2;
                    int next = sc.nextInt();
                    if (!map.containsKey(next)){
                        n2 = new Node(next);
                        map.put(next,n2);
                    }else n2 = map.get(next);
                    n1.set.add(n2);
                    n2.set.add(n1);
                }
                for (int i = 1; i <= N; i++) {
                    Node node = map.get(i);
                }
                if (flag) {
                    flag = false;
                    res.add("Yes");
                }else {
                    flag = true;
                    res.add("No");
                }
            }
            for (String arg : res) {
                System.out.println(arg);
            }
        }
    }
}
