package 算法类.动态规划;



/**  https://blog.csdn.net/ls5718/article/details/52227908
    背包问题主要是指一个给定容量的背包、若干具有一定价值和重量的物品，
    如何选择物品放入背包使物品的价值最大。其中又分01背包和无限背包，
    这里主要讨论01背包，即每个物品最多放一个。而无限背包可以转化为01背包。
    先说一下算法的主要思想，利用动态规划来解决。每次遍历到的第i个物品，
    根据w[i]和v[i]来确定是否需要将该物品放入背包中。即对于给定的n个物品，
    设v[i]、w[i]分别为第i个物品的价值和重量，C为背包的容量。
    再令v[i][j]表示在前i个物品中能够装入容量为j的背包中的最大价值。则我们有下面的结果：
    （1），v[i][0]=v[0][j]=0;
    （2），v[i][j]=v[i-1][j]   当w[i]>j
    （3），v[i][j]=max{v[i-1][j],v[i-1][j-w[i]]+v[i]}  当j>=w[i]
    好的，我们的算法就是基于此三个结论式。
 **/
//求背包能够装的最大价值
public class 背包问题 {

    //01、二维数组法
    @Test
    public static void DoubleArray() {
    //public static void main(String[] args) {
        int[] weight = {3,5,2,6,4}; //物品重量
        int[] val = {4,4,3,5,3}; //物品价值
        int length = weight.length;
        int w = 12;
        //dp[i][j]：代表前i个物品装入体积为j的背包的最大价值
        int[][] dp = new int[length+1][w+1];

        //循环遍历
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                //若当前背包体积无法装当前物品
                if (j<weight[i-1]){
                    dp[i][j]=dp[i-1][j];
                }else {
                    //当前背包能够装当前物品了
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i-1]]+val[i-1]);
                }
            }
        }
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }


    //P02、一维数组法（无须装满）
    @Test
    public static void SingleArray1() {
    //public static void main(String[] args) {
        int[] weight = {3,5,2,6,4}; //物品重量
        int[] val = {4,4,3,5,3}; //物品价值
        int length = weight.length;
        int w = 12;
        //dp[i][j]：代表前i个物品装入体积为j的背包的最大价值
        int[] dp = new int[w+1];//+1的目的使得i位置代表体积为i时

        //循环遍历
        for (int i = 0; i < length; i++) {
            for (int j = dp.length-1; j >= weight[i] ; j--) {
                dp[j] = Math.max(dp[j],dp[j-weight[i]]+val[i]);
            }
        }

        for(int i=0;i<dp.length;i++){
            System.out.print(dp[i]+" ");
        }
    }

    /**
     * 我们看到的求最优解的背包问题题目中，事实上有两种不太相同的问法。
     * 有的题目要求“恰好装满背包”时的最优解，有的题目则并没有要求必须把背包装满。
     * 一种区别这两种问法的实现方法是在初始化的时候有所不同。
     如果是第一种问法，要求恰好装满背包，那么在初始化时除了f[0]为0其它f[1..V]均设为-∞，
     这样就可以保证最终得到的f[N]是一种恰好装满背包的最优解。
     如果并没有要求必须把背包装满，而是只希望价格尽量大，初始化时应该将f[0..V]全部设为0。
     为什么呢？可以这样理解：初始化的f数组事实上就是在没有任何物品可以放入背包时的合法状态。
     如果要求背包恰好装满，那么此时只有容量为0的背包可能被价值为0的nothing“恰好装满”，
     其它容量的背包均没有合法的解，属于未定义的状态，它们的值就都应该是-∞了。
     如果背包并非必须被装满，那么任何容量的背包都有一个合法解“什么都不装”，
     这个解的价值为0，所以初始时状态的值也就全部为0了。
     */
    //P03、一维数组法（要装满）
    @Test
    public static void SingleArray2() {
    //public static void main(String[] args) {
        int[] weight = {3,5,2,6,4}; //物品重量
        int[] val = {4,4,3,5,3}; //物品价值
        int length = weight.length;
        int w = 12;
        //dp[i][j]：代表前i个物品装入体积为j的背包的最大价值
        int[] dp = new int[w+1];//+1的目的使得i位置代表体制为i时

        for(int i=1;i<dp.length;i++){     //必需装满则f[0]=0,f[1...m]都初始化为无穷小
            dp[i] = Integer.MIN_VALUE;
        }

        //循环遍历
        for (int i = 0; i < length; i++) {
            for (int j = dp.length-1; j >= weight[i] ; j--) {
                dp[j] = Math.max(dp[j],dp[j-weight[i]]+val[i]);
            }
        }

        for(int i=0;i<dp.length;i++){
            System.out.print(dp[i]+" ");
        }
    }

    /**有N种物品和一个容量为V的背包，每种物品都有无限件可用。
     第i种物品的费用是c[i]，价值是w[i]。
     求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大。
     **/
    //这个伪代码与P01的伪代码只有v的循环次序不同而已。
    //P04、完全背包问题
    public static void main(String[] args){
        int[] weight = {3,4,6,2,5};
        int[] val = {6,8,7,5,9};
        int length = weight.length;
        int w = 10;
        int[] dp = new int[w+1];

        for(int i=0;i<length;i++){
            for(int j=weight[i];j<dp.length;j++){
               dp[j] = Math.max(dp[j], dp[j-weight[i]]+val[i]);
            }
        }
        System.out.println(dp[w]);
    }

}
