package 算法类.其他题目;

import java.util.Scanner;

public class 字节跳动9月9日最大不重复子串 {
    private static int solution(String string) {
        if(string == null || string.trim().length()==0)
            return 0;
        int curLength = 0;
        int maxLength = 0;

        int[] position = new int[26];
        for(int i=0;i<position.length;i++)
            position[i] = -1;

        for(int i =0 ; i<string.length() ; i++){
            int preIndex = position[string.charAt(i)-'a'];
            if(preIndex < 0 || i-preIndex>curLength)
                curLength++;
            else{
                if(curLength>maxLength)
                    maxLength=curLength;
                curLength=i-preIndex;
            }
            position[string.charAt(i) - 'a']=i;
        }
        if(curLength>maxLength)
            maxLength=curLength;
        return maxLength;
    }



    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            System.out.println(solution(str));
        }

        //System.out.println(solution("arabcacfr"));
        //System.out.println(solution("abcdefaaa"));
    }
}
