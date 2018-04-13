package 算法类.其他题目;

public class 一至100中不存在的区间 {

    private static void output(int[] data) {
        if (data == null ) return;
        int between = 0;
        for (int i = 0 ; i < data.length ; i++){
            if ( i == 0 ){
                between = data[i]-0;
            }else {
                between = data[i]-data[i-1] ;
            }
            if (between == 1) {
                if (i == data.length-1 && data[i] != 100) {
                    if (data[i] == 99) {
                        System.out.println(100);
                    } else
                        System.out.println((data[i] + 1) + "-" + 100);
                }
                continue;
            }
            else if (i == 0)
                System.out.println(1+"-"+(data[i]-1));
            else if (i == data.length-1 && data[i] != 100) {
                System.out.println((data[i-1]+1)+"-"+(data[i]-1));

                if (data[i] == 99){
                    System.out.println(100);
                } else
                    System.out.println((data[i] + 1) + "-" + 100);
            }
            else if ( between ==2 )
                System.out.println((data[i-1]+1));
            else
                System.out.println((data[i-1]+1)+"-"+(data[i]-1));
        }
    }

    public static void main(String[] args) {
        int[] data = new int[]{1,2,4,5,6,9,10,12,25,50,99};
        output(data);
    }

}
