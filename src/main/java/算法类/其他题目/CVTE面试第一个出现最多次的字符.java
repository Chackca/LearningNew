package 算法类.其他题目;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class CVTE面试第一个出现最多次的字符 {

    private static char FirstAppearMost(String str) {
        if (str == null) return ' ';
        //注意：LinkedHashMap没有获取Linked插入顺序的方法，只能通过iterator获取
        LinkedHashMap<Character,Integer> linkedHashMap = new LinkedHashMap();
        for (int i = 0 ; i < str.length() ; i++){
            Character character = str.charAt(i);
            if (linkedHashMap.containsKey(character)){
                linkedHashMap.put(character,linkedHashMap.get(character)+1);
            }else {
                linkedHashMap.put(character,1);
            }
        }
        Set<Map.Entry<Character,Integer>> entrySet = linkedHashMap.entrySet();
        Iterator itr = entrySet.iterator();
        int max = Integer.MIN_VALUE;
        char result = ' ';
        while (itr.hasNext()){
            Map.Entry<Character,Integer> entry = (Map.Entry)itr.next();
            if (max<entry.getValue()){
                max = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str = new String("abcdefgfa");
        System.out.println(FirstAppearMost(str));
    }


}
