package 算法类.Leetcode.查找;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 给出一个整形数组nums，是否存在索引i和j，使得nums[i]和nums[j]之间的差别不超过给定的
 * 整数t，且i和j之间的差别不超过给定的整数k
 */
public class Contails_Duplicate_III_220 {

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(t < 0)
            return false;
        TreeSet<Long> set = new TreeSet();
        for (int i = 0 ; i < nums.length ; i++){
            if (set.ceiling((long)nums[i]-(long)t)!=null
                    &&set.ceiling((long)nums[i]-(long)t)<=(long)nums[i]+(long)t)
                return true;
            set.add((long)nums[i]);

            if (set.size()==k+1){
                set.remove((long)nums[i-k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {-2147483648, -2147483647};
        int k = 3;
        int t = 3;
        System.out.println(containsNearbyAlmostDuplicate(nums, k, t));
    }
}
