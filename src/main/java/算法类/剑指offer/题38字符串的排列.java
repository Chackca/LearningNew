package 算法类.剑指offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。如输入abc，则打印abc，acb，bac，bca，cab，cba。
 * 解题思路：采用递归做法，将第一个字符固定在第一位，后面的字符能有什么排法，将第二个字符固定在第一位，
 * 后面的字符能有什么排法。。。对于相同的元素，可以采用set集合判断当前字符之前是否已经出现在第一位过了，出现过了就忽略当前字符
 */
public class 题38字符串的排列 {

    public static void main(String[] args) {
        System.out.println(Permutation("abc").toString());
    }

    public static ArrayList<String> Permutation(String str) {
        List<String> res = new ArrayList<>();
        if (str != null && str.length() > 0) {
            PermutationHelper(str.toCharArray(), 0, res);
            Collections.sort(res);
        }
        return (ArrayList)res;
    }

    public static void PermutationHelper(char[] cs, int i, List<String> list) {
        if (i == cs.length - 1) {
            String val = String.valueOf(cs);
            if (!list.contains(val))
                list.add(val);
        } else {
            for (int j = i; j < cs.length; j++) {
                swap(cs, i, j);
                PermutationHelper(cs, i+1, list);
                swap(cs, i, j);
            }
        }
    }

    public static void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }

}
