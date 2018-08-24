package 算法类.其他题目;

import java.util.TreeMap;

/**
 * 2018.4.1  58同城在线考试第一道编程题
 * 给定一个字母组成的字符串str，给定一个整数n，请用代码实现一个函数，
 * 得到字符串中连续出现次数为给定整数的所有子串，输出格式为
 * （子串起始位置，子串结束位置，子串），起始位置以1开始

 * 示例如下：给定字符串“abbcccddeefffgggcc”，给定整数2，
 * 则符合条件的子串为（2，3，bb）、（7，8，dd）、（9，10，ee）、（17,18，cc）。
 */
public class 打印连续字符串 {

    public static void main(String args[]) {
        String str = "abbbccccddeefffaaaddzzzz";
        int n = 3;
        TreeMap<Integer,String> map= getResult(str,n);//Entry对，并且按照key排序
        for (int i :map.keySet()){
            System.out.println("("+i+","+(i+n-1)+","+map.get(i)+")");
        }
    }


    public static TreeMap<Integer, String> getResult(String str, int n) {
        TreeMap<Integer, String> map = new TreeMap();
        int sum;
        for (int i = 0; i <= str.length()-n; i+=sum) {
            sum=0;
            String string = "";
            for (int j = i; j < str.length(); j++) {
                if (str.charAt(j) == str.charAt(i)) {
                    sum++;
                    string+=str.charAt(i);
                }
                else {
                    break;
                }
            }
            if(sum==n){
                map.put(i,string);
            }
        }
        return map;
    }

}
