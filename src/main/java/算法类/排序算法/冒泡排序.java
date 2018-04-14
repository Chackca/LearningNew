package 算法类.排序算法;



public class 冒泡排序 implements Sort {
    @Override
    public void executeSort(int[] data) {
        bubbleSort(data);

    }


    /*
     * 冒泡排序
     */
    public static void bubbleSort(int[] data){
        if(data == null) return;
        for (int i = 0; i < data.length; i++) {
            for (int j = 1; j < data.length-i; j++) {
                if (data[j-1]>data[j]) {
                    int temp = data[j];
                    data[j]=data[j-1];
                    data[j-1]=temp;
                }
            }
        }
        return;
    }
    @Test
    private void testBubbleSort(){
        int[] data = {5,4,3,1,2,6,10,7};
        bubbleSort(data);
        System.out.print("数组冒泡排序：\t");
        for(int item: data){
            System.out.print(item);
            System.out.print('\t');
        }
        System.out.println();
    }
}
