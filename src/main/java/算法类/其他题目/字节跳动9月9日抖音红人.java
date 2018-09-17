package 算法类.其他题目;

import java.util.*;

public class 字节跳动9月9日抖音红人 {

    private static HashMap<Integer,People> peopleMap = new HashMap();

    static class People{
        private int ID;
        public HashSet<Integer> fansSet = new HashSet();
        public int fansNum = 0;
        People(int ID){
            this.ID = ID;
        }
        public HashSet getSet(){
            return fansSet;
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();//N个人
            int m = in.nextInt();//m个关系对
            for (int i = 1; i <= m*2; i+=2) {
                int cur = in.nextInt();
                People p1;
                if (!peopleMap.containsKey(cur)){
                    p1 = new People(cur);
                    peopleMap.put(cur,p1);
                }else
                    p1 = peopleMap.get(cur);

                People p2;
                int next = in.nextInt();
                if (!peopleMap.containsKey(next)){
                    p2 = new People(next);
                    peopleMap.put(next,p2);
                }else
                    p2 = peopleMap.get(next);
                fans(p1,p2);//左边为关注者，右边被关注
            }
            int res = 0;
            Collection<People> values = peopleMap.values();    //获取Map集合的value集合
            for (People people : values) {
                if (people.fansSet.size()==n)
                    res++;
            }
            System.out.println(res);
        }
    }

    public static void fans(People p1,People p2){
        if (p2.fansSet.add(p1.ID)){
            p2.fansNum++;
            HashSet<Integer> set = p1.getSet();
            for (Integer temp : set) {
                fans(peopleMap.get(temp),p2);
            }
        }
    }
}
