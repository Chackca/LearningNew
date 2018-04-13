package 算法类.其他题目;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class CVTE面试第一个出现最多次的字符 {

    private static char FirstAppearMost(String str) {
        if(str == null) return ' ';

        Map<Character,Integer> map = new LinkedHashMap();
        for (int i = 0 ; i < str.length() ; i++){
            if (!map.containsKey(str.charAt(i))){
                map.put(str.charAt(i),1);
            }else{
                map.replace(str.charAt(i),map.get(str.charAt(i))+1);
            }
        }
        Iterator itr = map.entrySet().iterator();
        char cha = ' ';
        int count = 0;
        while (itr.hasNext()){
            Map.Entry entry = (Map.Entry) itr.next();
            int cur = (int)entry.getValue();
            if (cur>count){
                cha = (char)entry.getKey();
                count = cur;
            }
        }
        return cha;
    }

    public static void main(String[] args) {
        String str = new String("abcdefgf");
        System.out.println(FirstAppearMost(str));
    }


}
