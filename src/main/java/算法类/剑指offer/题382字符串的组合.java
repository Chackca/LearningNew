package 算法类.剑指offer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
	 * 题目要求：
	输入一个字符串，打印出该字符串中字符的所有组合。如输入abc，则打印a，b，c，ab，ac，bc，abc。
	
	解题思路：
	这道题目是在38题.字符串的排列的扩展部分出现的。排列的关键在于次序，而组合的关键在于状态，即该字符是否被选中进入组合中。
	对于无重复字符的情况，以a,b,c为例，每一个字符都有两种状态：被选中、不被选中；2*2*2=8，再排除为空的情况，一共有7种组合：
	
	 */
public class 题382字符串的组合 {
	
	public static List<char[]> combination(char[] strs) {
        if (strs == null || strs.length == 0)
            return null;
        Arrays.sort(strs);
        List<char[]> ret = new LinkedList<>();
        combinationCore(strs,ret,new StringBuilder(),0);
        return ret;
    }

	
	private static void combinationCore(char[] strs, List<char[]> ret, StringBuilder stringBuilder, int cur) {
		if(cur==strs.length ) {
            if(stringBuilder.length()>0)
                ret.add(stringBuilder.toString().toCharArray());
        }
        else if(cur+1==strs.length||strs[cur]!=strs[cur+1]){
        	//被选中
            combinationCore(strs,ret,stringBuilder.append(strs[cur]),cur+1);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            //不被选中
            combinationCore(strs,ret,stringBuilder,cur+1);

        }
        else{
            //先计算出重复次数
            int dumplicateStart = cur;
            while(cur!=strs.length&&strs[dumplicateStart]==strs[cur]){
                stringBuilder.append(strs[cur]);
                cur++;
            }
            int newStart = cur;
            while (cur>=dumplicateStart) {
            	//全部都不被选中，一个被选中，两个被选中......
                combinationCore(strs, ret, stringBuilder, newStart);
                if(cur!=dumplicateStart)
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                cur--;
            }

        }
	}


	public static void main(String[] args) {
        char[] strs2 = {'a', 'a', 'b'};
        List<char[]> ret2 = combination(strs2);
        for (char[] item : ret2) {
            for (int i = 0; i < item.length; i++)
                System.out.print(item[i]);
            System.out.println();
        }
    }

	
}
