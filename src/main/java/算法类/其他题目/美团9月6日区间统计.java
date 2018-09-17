package 算法类.其他题目;

import java.util.HashMap;
import java.util.Scanner;

public class 美团9月6日区间统计 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int t=sc.nextInt();
            int k=sc.nextInt();
            int n=sc.nextInt();
            int[] array=new int[n];
            int count=0;
            if(n==0||k==0||t==0||k<t){
                System.out.println(0);
            }
            for(int i=0;i<n;i++){
                array[i]=sc.nextInt();
            }
            for(int i=0;i<=n-k;i++){
                int jump=hasT(array,t,i,i+k-1);
                if(jump!=-1){
                    i=i+jump;
                    count=count+jump+1;
                }
            }
            System.out.println(count);
        }
    }
    public static int hasT(int[] a,int t,int s,int e){
        int count=0;
        HashMap<Integer,Integer> hashMap=new HashMap<Integer, Integer>();
        HashMap<Integer,Integer> hm=new HashMap<Integer, Integer>();
        for(int i=s;i<=e;i++){
            hashMap.put(a[i],hashMap.get(a[i])==null?1:(hashMap.get(a[i])+1));
            if(!hm.containsKey(a[i])) {
                hm.put(a[i],i);
            }
            if(hashMap.get(a[i])>=t){
                return  hm.get(a[i])-s;
            }
        }
        return -1;
    }
}
