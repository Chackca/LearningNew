package 算法类.排序算法;

public class 堆排序 implements Sort {

	@Override
	public void executeSort(int[] data) {
		heapSort(data);
	}
	
	/*	堆排序：堆排序的基本思想是：将待排序序列构造成一个大顶堆，
		此时，整个序列的最大值就是堆顶的根节点。将其与末尾元素进行交换，
		此时末尾就为最大值。然后将剩余n-1个元素重新构造成一个堆，
		这样会得到n个元素的次小值。如此反复执行，便能得到一个有序序列了
		一般升序采用大顶堆，降序采用小顶堆
		堆排序由构建初始堆+交换堆顶元素和末尾元素并重建堆   两部分组成
	*/

	private static void heapSort(int[] data) {
		if (data == null) return;
		//1.构建初始大顶堆
		//data.length/2-1定位到倒数第一个非叶子结点
		for (int i = data.length / 2 - 1; i >= 0; i--) {
			adjustHeap(data, i, data.length);
			//adjustMinHeap(data,i,data.length);
		}
		//2.交换堆顶元素和末尾元素并重建堆
		for (int j = data.length - 1; j > 0; j--) {
			swapUtil.swap(data, 0, j);
			adjustHeap(data, 0, j);
			//adjustMinHeap(data,j,data.length);
		}
	}

	//调整堆为最大堆，第二个参数i为需要考虑调整的节点,此处需要传入第三个参数长度，因为最后搭建排序数组的时候参加运算的数组长度会减小
	private static void adjustHeap(int[] data, int i, int length) {
		int temp = data[i];
		for (int j = 2 * i + 1; j < length; j = 2 * j + 1) {
			//若当前节点的右子节点的值大于左子节点的值，则定位到右子节点
			if (j + 1 < length && data[j + 1] > data[j]) {
				j++;
			}
			//若当前考虑的节点（子节点）大于其父节点，则将其赋值给父节点，不用进行交换，到退出循环时再交换
			if (data[j] > temp) {
				data[i] = data[j];
				i = j;
			} else {
				break;
			}
		}
		data[i] = temp;
	}


	//与最大堆的完全一样
	private static void heapMinSort(int[] data) {
		if (data == null) return;
		//1.构建初始大顶堆
		//data.length/2-1定位到倒数第一个非叶子结点
		for (int i = data.length / 2 - 1; i >= 0; i--) {
			adjustMinHeap(data, i, data.length);
		}
		//2.交换堆顶元素和末尾元素并重建堆
		for (int j = data.length - 1; j > 0; j--) {
			swapUtil.swap(data, 0, j);
			adjustMinHeap(data, 0, j);
		}
	}

	//调整堆为最小堆，第二个参数i为需要考虑调整的节点,此处需要传入第三个参数长度，因为最后搭建排序数组的时候参加运算的数组长度会减小
	private static void adjustMinHeap(int[] data, int i, int length) {
		int temp = data[i];
		for (int j = 2 * i + 1; j < length; j = 2 * j + 1) {
			//若当前节点的右子节点的值小于左子节点的值，则定位到右子节点
			if (j + 1 < length && data[j + 1] < data[j]) {//与最大堆不同之处
				j++;
			}
			//若当前考虑的节点（子节点）小于其父节点，则将其赋值给父节点，不用进行交换，到退出循环时再交换
			if (data[j] < temp) {//与最大堆不同之处
				data[i] = data[j];
				i = j;
			} else {
				break;
			}
		}
		data[i] = temp;
	}

	//堆排序测试

	public static void main(String[] args) {
		int[] data = {5, 4, 3, 1, 5, 6, 4, 5, 2, 6, 10, 7, 12};
		System.out.println("数组堆排序：\t");
		heapSort(data);
		System.out.print("采用最大堆实现");
		for (int item : data) {
			System.out.print(item);
			System.out.print('\t');
		}
		System.out.println();

		heapMinSort(data);
		System.out.print("采用最小堆实现");
		for (int item : data) {
			System.out.print(item);
			System.out.print('\t');
		}
		System.out.println();
	}
}