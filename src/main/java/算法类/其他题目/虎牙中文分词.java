package 算法类.其他题目;

import java.util.*;

/**
 * 题目描述
 中文分词正向最大匹配算法（MM）是基于字典的最长词优先匹配，原理如下：
 1）从左向右取待切分汉语句的m个字符作为匹配字段，m为大机器词典中最长词条个数；
 2）查找词典并进行匹配。若匹配成功，则将这个匹配字段作为一个词切分出来；
 现有如下词典：
 “中国”、“直播”、“游戏”、“游戏直播”、“综艺娱乐”、“互动直播平台”
 通过编程实现对如下句子进行正向最大匹配算法分词并找出和词典相匹配的结果，写出结果。
 输入描述:
 分词句子：“虎牙直播中国最大最好的互动直播平台。众多热门高清的游戏直播；上千款游戏，游戏大神齐聚虎牙。星光闪耀，顶尖赛事，综艺娱乐，美女秀场……不一样的精彩直播”
 输出描述:
 多个词用半角逗号分开,如:直播,游戏,虎牙
 示例1
 输入
 虎牙直播中国最大最好的互动直播平台。众多热门高清的游戏直播；上千款游戏，游戏大神齐聚虎牙。星光闪耀，顶尖赛事，综艺娱乐，美女秀场……不一样的精彩直播
 输出
 多个词用半角逗号分开,如:直播,游戏,虎牙
 */
public class 虎牙中文分词 {

    private static final int LONGEST_STR = 6;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> wordsSet = new HashSet<String>(){
            {
                add("中国");
                add("直播");
                add("游戏");
                add("游戏直播");
                add("综艺娱乐");
                add("互动直播平台");
            }
        };

        while (sc.hasNext()){
            Set<String> resultSet = new LinkedHashSet<>();

            String str = sc.nextLine();

            while(str.length()>1){
                int len=LONGEST_STR;
                if(str.length()<len){
                    len=str.length();
                }
                //取指定的最大长度的文本去词典里面匹配
                String tryWord = str.substring(0, 0+len);
                while(!wordsSet.contains(tryWord)){
                    //如果长度为一且在词典中未找到匹配，则按长度为一切分
                    if(tryWord.length()-1<=1){
                        break;
                    }
                    //如果匹配不到，则长度减一继续匹配
                    tryWord=tryWord.substring(0, tryWord.length()-1);
                }
                if (wordsSet.contains(tryWord)) {
                    //System.out.println(tryWord);
                    str = str.substring(tryWord.length());
                    resultSet.add(tryWord);
                }else {
                    str = str.substring(tryWord.length()-1);
                }
                //从待分词文本中去除已经分词的文本
            }
            System.out.println(resultSet.toString().substring(1,resultSet.toString().length()-1).replaceAll(" ",""));
        }
    }
}