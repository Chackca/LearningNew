package 算法类.其他题目;

/**
 题目描述
 读入一个字符串str，输出字符串str中的连续最长的数字串
 输入描述:
 个测试输入包含1个测试用例，一个字符串str，长度不超过255。
 输出描述:
 在一行内输出str中里连续最长的数字串。
 示例1
 输入
 abcd12345ed125ss123456789
 输出

 123456789
 */
public class 牛客字符串中找出连续最长的数字串 {

    private static String LongestString(String str) {
        if(str.length()==0||str==null) return null;
        int end = 0;
        int max = 0;
        int count = 0;

        for (int i =0;i<str.length();i++){
            if (str.charAt(i)>='0'&&str.charAt(i)<='9'){
                count++;
                if (max<count){
                    end = i+1;
                    max = count;
                }
            } else {
                count=0;
            }
        }

        return str.substring(end-max,end);
    }



    public static void main(String[] args) {
        String str = new String("abcd12345ed125ss123456789");
        System.out.println(LongestString(str));
    }



}
