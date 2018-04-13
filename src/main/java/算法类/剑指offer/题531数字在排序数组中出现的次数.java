package 算法类.剑指offer;

public class 题531数字在排序数组中出现的次数 {
	
	private static int getNumberOfK(int[] data, int k) {
		if (data==null||data.length==0) return -1;
		int start = getStartOfK(data,k);
		if (start==-1) return -1;
		int end = getEndOfK(data, start,k);
		return end-start+1;
	}
	
	private static int getStartOfK(int[] data, int k) {
		int start = 0;
		int end = data.length-1;
		int mid = 0;
		while (start<=end) {
			if(start==end){
                if(data[start]==k)
                    return start;
                else
                    return -1;
            }
			mid=start+(end-start)/2;;
			int cur = data[mid];
			if (cur>k) {
				end = mid-1;
			}else if (cur<k) {
				start = mid+1;
			}else if (cur == k) {
				if (data[mid-1]== k) {
					end = mid-1;
				}else return mid;
			}
		}
		return -1;
	}
	
	private static int getEndOfK(int[] data, int start, int k) {
		int end = data.length-1;
		int mid = 0;
		while (start<=end) {
			if(start==end){
                if(data[start]==k)
                    return start;
                else
                    return -1;
            }
			mid=start+(end-start)/2;;
			int cur = data[mid];
			if (cur>k) {
				end = mid-1;
			}else if (cur<k) {
				start = mid+1;
			}else if (cur == k) {
				if (data[mid+1]== k) {
					start = mid+1;
				}else return mid;
			}
		}
		return -1;
	}


	public static void main(String[] args){
        int[] data1 = new int[]{1,2,3,3,3,3,5,6};
        int[] data2 = new int[]{1,2,3,3,3,3,4,5};
        int[] data3 = new int[]{3,3,3,3,3,3,3,3};
        int[] data4 = new int[]{1};
        int[] data5 = new int[]{};
        int[] data6 = new int[]{1,2,3,4,5,6,7,8};

        System.out.println(getNumberOfK(data1,4));
        System.out.println(getNumberOfK(data2,3));
        System.out.println(getNumberOfK(data3,3));
        System.out.println(getNumberOfK(data4,1));
        System.out.println(getNumberOfK(data4,3));
        System.out.println(getNumberOfK(data5,3));
        System.out.println(getNumberOfK(data6,8));

    }

	
}
