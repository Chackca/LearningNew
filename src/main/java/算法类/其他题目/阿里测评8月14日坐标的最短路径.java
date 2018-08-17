package 算法类.其他题目;

import java.util.Scanner;

/**
 * 如图，某物流派送员p，需要给a、b、c、d4个快递点派送包裹，
 * 请问派送员需要选择什么的路线，才能完成最短路程的派送。
 * 假设如图派送员的起点坐标(0,0)，派送路线只能沿着图中的方格边行驶，每个小格都是正方形，
 * 且边长为1，如p到d的距离就是4。随机输入n个派送点坐标，
 * 求输出最短派送路线值（从起点开始完成n个点派送并回到起始点的距离）。
 *
 * 输入：
 * 3
 * 2,2
 * 5,1
 * 4,3
 */
public class 阿里测评8月14日坐标的最短路径 {

    private static int min = Integer.MAX_VALUE; //全局最小路径，初始为无穷大
    private static Point start; //起点
    private static Point[] points; //所有的顶点数组

    private static class Point {
        private int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        start = new Point(0, 0);
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int pointNum = sc.nextInt();
            sc.nextLine();
            points = new Point[pointNum];
            for (int i = 0; i < pointNum; i++) {
                String temp = sc.nextLine();
                String[] arr = temp.split(",");
                points[i] = new Point(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
            }
            System.out.println(minPath(points));
        }
    }


    /**
     * 计算最短路径的算法，深搜，回溯等
     * @return 返回全局最小路径数值
     */
    private static int minPath(Point[] points) {
        boolean[] b = new boolean[points.length];
        int path = 0;
        for (int i=0; i<points.length; i++) {
            path += getDis(start, points[i]);
            dfs(i, path, b, 1, points.length);
        }
        return min;
    }

    /**
     * 深搜主算法
     * @param index 当前顶点的序号
     * @param path 所有距离累加值
     * @param memo 标记数组，true则在当前路径上
     * @param level 深搜深度
     * @param length 总深度
     */
    private static void dfs(int index, int path, boolean[] memo, int level, int length) {
        if (level == length) {
            path += getDis(start, points[index]);
            if (path < min) min = path;
            return;
        }
        memo[index] = true;
        for (int i=0; i<points.length; i++) {
            if (!memo[i]) {
                path += getDis(points[index], points[i]);
                dfs (i, path, memo, level+1, length);
            }
        }
        memo[index] = false;
    }

    /**
     * 由两个点获取期间的距离算法
     * @param start
     * @param point
     * @return
     */
    private static int getDis(Point start, Point point) {
        return Math.abs(start.x-point.x) + Math.abs(start.y-point.y);
    }
}
