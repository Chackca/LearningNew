package 算法类.其他题目;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 字节跳动减法求值8月25日 {
    private static List<Expree> expressList = new ArrayList<>();
    private static List<Quest> questionList = new ArrayList<>();
    private static List<Integer> res = new ArrayList<>();


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {//注意while处理多个case
            String[] arr = in.nextLine().split(" ");
            for (int i = 0; i < Integer.valueOf(arr[0]); i++) {
                expressList.add(parseExpress(in.nextLine()));
            }
            for (int i = 0; i < Integer.valueOf(arr[1]); i++) {
                questionList.add(parseQuestion(in.nextLine()));
            }




        }

    }



    private static Expree parseExpress(String express){
        String[] argus = express.split(" ");
        return new Expree(Integer.valueOf(argus[0]),Integer.valueOf(argus[1]),Integer.valueOf(argus[2]));
    }

    private static class Expree{
        private int left;
        private int sub;
        private int right;
        Expree(int left, int sub, int right){
            this.left = left;
            this.sub = sub;
            this.right = right;
        }
    }

    private static Quest parseQuestion(String question){
        String[] argus = question.split(" ");
        return new Quest(Integer.valueOf(argus[0]),Integer.valueOf(argus[1]));
}

    private static class Quest{
        private int left;
        private int sub;
        Quest(int left, int sub){
            this.left = left;
            this.sub = sub;
        }
    }
}


