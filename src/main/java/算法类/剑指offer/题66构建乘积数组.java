package 算法类.剑指offer;

public class 题66构建乘积数组 {
	
	public static int[] multiply(int[] data){
        if(data==null||data.length<2)
            return null;
        
        int[] result = new int[data.length];
        //求得数组C，存于result中
        result[0] = 1;//当i=0时，i不存在
        //自上而下
        for(int i=1;i<result.length;i++)
            result[i] = result[i-1]*data[i-1];//相当于c[i]
        
        //经过以上循环以后，result【i】中的值为c【i】，需要每个result【i】再去乘d【i】
        //先求得数组D中元素，再与C中元素相乘，存于result中
        //d【i】的最后一位不存在
        int temp = 1;
        
        for(int i=data.length-2;i>=0;i--){
            //数组D中的元素值
            temp = temp * data[i+1];
            //计算B[i]=C[i]*D[i]
            result[i] = result[i] * temp;
        }
        
        return result;
    }
	
	
	
    public static void main(String[] args){
        int[] data = new int[]{1,2,3,4,5};
        int[] result = multiply(data);
        
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]);
            System.out.print("  ");
        }
    }
}
