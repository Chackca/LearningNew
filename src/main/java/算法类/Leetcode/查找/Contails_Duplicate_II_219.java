package 算法类.Leetcode.查找;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * 给出一个整形数组nums和一个整数k，是否存在索引i和j，
 * 使得nums[i]==nums[j]且i和j之间的差不超过k
 */
public class Contails_Duplicate_II_219 {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        ArrayList list = new ArrayList();
        for (int i = 0 ; i < nums.length ; i++){
            if (list.contains(nums[i])){
                return true;
            }
            if (list.size()==k+1){
                list.remove(0);
            }
            list.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3,4,5,3,7,0};
        int k = 4;
        System.out.println(containsNearbyDuplicate(nums, k));
    }
}
