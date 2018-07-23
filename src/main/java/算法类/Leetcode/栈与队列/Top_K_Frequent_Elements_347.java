package 算法类.Leetcode.栈与队列;

import javafx.util.Pair;
import 算法类.domain.SortTestUtil;

import java.util.*;

/**
 * 给定一个非空数组，返回前k个出现频率最高的元素
 */
public class Top_K_Frequent_Elements_347 {

    //为treeset准备
    private static class PairComparator1 implements Comparator<Pair<Integer, Integer>>{
        @Override
        public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2){
            if(p1.getKey() != p2.getKey())//从大到小
                return p2.getKey() - p1.getKey();
            return p1.getValue() - p2.getValue();
        }
    }

    //为优先队列准备
    private static class PairComparator2 implements Comparator<Pair<Integer, Integer>> {
        @Override
        public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
            if (p1.getKey() != p2.getKey())
                return p1.getKey() - p2.getKey();
            return p1.getValue() - p2.getValue();
        }
    }
    //使用TreeSet实现
    public static List<Integer> topKFrequent(int[] nums, int k) {

        if(k <= 0)
            throw new IllegalArgumentException("k should be greater than 0");

        HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for(int i = 0 ; i < nums.length ; i ++)
            if(freq.containsKey(nums[i]))
                freq.put(nums[i], freq.get(nums[i]) + 1);
            else
                freq.put(nums[i], 1);

        if(k > freq.size())
            throw new IllegalArgumentException("k should be less than the number of unique numbers in nums");

        TreeSet<Pair<Integer, Integer>> set = new TreeSet<Pair<Integer, Integer>>(new PairComparator1());
        for(Integer key: freq.keySet())
            set.add(new Pair(freq.get(key), key));

        ArrayList<Integer> res = new ArrayList<Integer>();
        for(Pair<Integer, Integer> p: set){
            res.add(p.getValue());
            if(res.size() == k)
                break;
        }

        return res;
    }

    private static void printList(List<Integer> nums){
        for(Integer num: nums)
            System.out.print(num + " ");
        System.out.println();
    }

    //实现优先队列实现
    public static List<Integer> topKFrequent2(int[] nums, int k) {

        if(k <= 0)
            throw new IllegalArgumentException("k should be greater than 0");

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)){
                map.replace(num,map.get(num)+1);
            }else
                map.put(num,1);
        }

        PriorityQueue<Pair<Integer,Integer>> queue = new PriorityQueue<>(new PairComparator2());
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        for(Map.Entry<Integer, Integer> entry : entrySet){
            int key = entry.getKey();
            int value = entry.getValue();
            if (queue.size()==k){
                Pair<Integer, Integer> pair = queue.peek();
                if (value>pair.getKey()){
                    queue.poll();
                    queue.offer(new Pair<Integer, Integer>(value,key));
                }
            }else {
                queue.offer(new Pair<>(value,key));
            }
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        while(!queue.isEmpty())
            res.add(queue.poll().getValue());
        return res;
    }


    public static void main(String[] args) {
        int[] ints = SortTestUtil.generateRandomArray(10, 0, 6);
        List<Integer> list = topKFrequent2(ints,4);
        printList(list);
    }


}
