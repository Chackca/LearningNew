package 算法类.剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 虎牙9月6日排序之冒泡算法 {

    public static void sort(MyObject[] a){
        Arrays.sort(a);
    }

    static class MyObject implements Comparable<MyObject>{

        @Override
        public int compareTo(MyObject o) {
            if (this.score>o.score)
                return 1;
            else if (this.score<o.score)
                return -1;
            else return 0;
        }

        int id;
        int score;

        public MyObject(int id, int score){
            this.id = id;
            this.score = score;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        @Override
        public String toString() {
            return "{" + id + ":" + score + '}';
        }
    }

    public static MyObject[] parseSampleInput(){
        Scanner in = new Scanner(System.in);
        List<MyObject> inList = new ArrayList<>();
        while(in.hasNextInt()){
            int id = in.nextInt();
            int score = in.nextInt();
            inList.add(new MyObject(id,score));
        }
        MyObject[] a = new MyObject[inList.size()];
        return inList.toArray(a);
    }

    public static void main(String[] args) {
        MyObject[] a = parseSampleInput();
        sort(a);
        System.out.println("Result: "+Arrays.toString(a));
    }
}
