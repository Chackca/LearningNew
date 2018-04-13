package 算法类.剑指offer;

public class 题21调整数组顺序使奇数位于偶数前面 {
	
	
	private static void Reorder(int[] data) {
		if (data == null || data.length == 1) return;
			
		int start = 0;
		int end = data.length -1 ;
		
		while (start < end) {
			//为偶数
			while (start<end && isEven(data[end])) {
				end--;
			}
			//为奇数
			while (start<end && !isEven(data[start])) {
				start++;
			}
			//为奇数
			if (start<end) {
				int temp = data[start];
				data[start] = data[end];
				data[end] = temp;
			}
			
		}
		
	}
	//判断是否为偶数
	private static boolean isEven(int n) {
		return (n&1)==0;
	}

	public static void main(String[] args){
        int[] data = {10,1,2,3,4,5,7,7,8,20};
        Reorder(data);
        for(int i=0;i<data.length;i++) {
            System.out.print(data[i]);
            System.out.print('\t');
        }
        System.out.println();
    }

	
}
