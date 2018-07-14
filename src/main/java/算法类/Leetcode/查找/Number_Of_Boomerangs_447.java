package 算法类.Leetcode.查找;

import java.util.HashMap;

/**
 *  给出一个平面上的n个点，寻找存在多少个由这些点构成的三元组(i,j,k)，
 *  使得i,j两点的距离等于i.k两点的距离。其中n最多为500，
 *  且所有的点坐标的范围在[-10000.10000]之间
 */
public class Number_Of_Boomerangs_447 {

    public static int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for ( int i = 0 ; i < points.length ; i++){
            //key为两点的距离，value为出现次数
            HashMap<Integer,Integer> map = new HashMap();
            for (int j = 0 ; j < points.length ; j++ ){
                if (j!=i){
                    int dis = dis(points[i],points[j]);
                    if (map.containsKey(dis)){
                        map.put(dis,map.get(dis)+1);
                    }else
                        map.put(dis,1);
                }
            }
            for(Integer dis: map.keySet())
                res += map.get(dis) * (map.get(dis) - 1);
        }
        return res;
    }
    public static Integer dis(int[] a,int[] b){
        return (b[0]-a[0])*(b[0]-a[0])+(b[1]-a[1])*(b[1]-a[1]);
    }



    public static void main(String[] args) {
        int[][] points = {{0, 0}, {1, 0}, {2, 0}};
        System.out.println(numberOfBoomerangs(points));
    }

}
