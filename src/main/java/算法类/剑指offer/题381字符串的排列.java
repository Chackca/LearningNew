package 算法类.剑指offer;

import java.util.*;

/*
 * 题目要求：
	输入一个字符串，打印出该字符串中字符的所有排列。如输入abc，
	则打印abc，acb，bac，bca，cab，cba。
	
	解题思路：
	排列与组合是数学上的常见问题。解题思路与数学上求排列总数类似：
	首先确定第一个位置的元素，然后一次确定每一个位置，
	每个位置确实时把所有情况罗列完全即可。以abc为例，
	我之前更习惯于设置三个空，然后选择abc中的元素放入上述的空中。
	而书中给的思路是通过交换得到各种可能的排列，具体思路如下：

	对于a,b,c（下标为0,1,2）
	0与0交换,得a,b,c => 1与1交换,得a,b,c =>2与2交换,得a,b,c(存入)
	                => 1与2交换，得a,c,b =>2与2交换,得a,c.b(存入)
	0与1交换,得b,a,c => 1与1交换,得b,a,c =>2与2交换,得b,a,c(存入)
	                => 1与2交换，得b,c,a =>2与2交换,得b,c,a(存入)
	0与2交换,得c,b,a => 1与1交换,得c,b,a =>2与2交换,得c,b,a(存入)
	                => 1与2交换，得c,a,b =>2与2交换,得c,a.b(存入)
	                
	对于a,a,b（下标为0,1,2）
	0与0交换,得a,a,b => 1与1交换,得a,a,b =>2与2交换,得a,a,b(存入)
	                => 1与2交换，得a,b,a =>2与2交换,得a,b,a(存入)
	0与1相同,跳过
	0与2交换,得b,a,a =>1与1交换,得b,a,a =>2与2交换,得b,a,a(存入)
	                =>1与2相同，跳过
 */
public class 题381字符串的排列 {
	
	private static List<char[]> permutation(char[] strs) {
		if (strs==null) return null;
		if (strs.length == 1) return new ArrayList<char[]>(strs[0]);
		List<char[]> list = new ArrayList<char[]>();
		//list.add(strs);
		permutationCore(strs,list,0);
		
		return list;
	}
	
	private static void permutationCore(char[] strs, List<char[]> list, int index) {
		if (index == strs.length){
			list.add(Arrays.copyOf(strs, strs.length));
			return;
		}
        Set<Character> set = new HashSet<>();
        for (int i = index; i < strs.length; i++) {
            if (set.add(strs[i])) {
                swap(strs, index, i);
                permutationCore(strs, list, index + 1);
                swap(strs, index, i);
            }
        }
	}
	
	public static void swap(char[] strs,int i,int j){
		char temp = strs[i];
		strs[i] = strs[j];
		strs[j] = temp;
	}

	public static void main(String[] args) {
        char[] strs = {'a', 'b', 'c'};
        List<char[]> ret = permutation(strs);
        for (char[] item : ret) {
            for (int i = 0; i < item.length; i++)
                System.out.print(item[i]);
            System.out.println();
        }
        System.out.println();
        char[] strs2 = {'a', 'a', 'b','b'};
        List<char[]> ret2 = permutation(strs2);
        for (char[] item : ret2) {
            for (int i = 0; i < item.length; i++)
                System.out.print(item[i]);
            System.out.println();
        }
    }
}
