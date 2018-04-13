package 算法类.其他题目;

public class 扩展1判断是否为质数 {

    public static boolean isPrime(int number){
        if (number<2) return false;
        boolean result = true;
        for (int i = 2;i<=Math.sqrt(number);i++){
            if (number%i==0){
                result = false;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        for (int i = 2; i<10 ; i++) {
            System.out.println(i+"是否为质数"+isPrime(i));
        }
    }
}
