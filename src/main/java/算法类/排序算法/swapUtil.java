package 算法类.排序算法;

public class swapUtil {
	public static void swap(int[] data, int index, int index2) {
		int temp = data[index2];
		data[index2] = data[index];
		data[index] = temp;
	}
}
