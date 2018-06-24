package 算法类.Leetcode.贪心;

/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
     You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1).
    You begin the journey with an empty tank at one of the gas stations.
     Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
     Note:
     The solution is guaranteed to be unique.

     在一个环形路线上有N个加油站，在第(i)个加油站的有(gas[i])数量的油
     你有一辆有可以装无限多油的汽车，从(i)到下一站（i+1），需要花费cost[i]汽油量。
    你在其中一个加油站带着的空的油箱开始了旅程。
     如果你能在环路中跑一圈，则返回起始加油站的索引i，否则返回-1。
     注意:
     这个解决方案肯定是独一无二的。

 思路：从start出发， 如果油量足够， 可以一直向后走 end++；  油量不够的时候，
 start向后退  最终 start == end的时候，如果有解一定是当前 start所在位置
 */
public class gas_station {
    public static class Solution {
        public static int canCompleteCircuit(int[] gas, int[] cost) {
            if (gas.length == 0) return -1;
            if (gas.length == 1) {
                if (gas[0] >= cost[0]) return 0;
                else return -1;
            }
            int start = 0;
            int end = 1;
            int surplusGas = 0;//车的油箱当前有的油量
            surplusGas = gas[start] - cost[start];//从0索引开始
            while (start != end){
                if (surplusGas>=0){
                    end++;
                    surplusGas += gas[end-1] - cost[end-1];
                    if (end == gas.length && surplusGas>0 ) return start;
                }else {
                    start--;
                    if (start<0){
                        start = gas.length-1;
                    }
                    surplusGas += gas[start] - cost[start];
                }
            }
            if (surplusGas>=0)
                return start;
            else return -1;
        }
    }


    public static void main(String[] args) {
        int[] gas = new int[]{1,5,4,3,7,4,3};
        int[] cost =new int[]{1,4,7,2,3,4,6};
        int[] gas2 = new int[]{5};
        int[] cost2 =new int[]{4};
        System.out.println(Solution.canCompleteCircuit(gas2,cost2));
    }
}
