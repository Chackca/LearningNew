package 算法类.其他题目;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class 大数据40亿数10M内存找不存在的数 {
    /**
     * 思路：对数据集进行两次扫描，就可以找出不在文件中的整数。可以将全部整数划分为同等大小的区块。
     * 第一次扫描数组：确定每个数组的元素个数。
     * 第二次扫描位向量：确定该范围内少的数字。
     *
     * bitSize::第一次扫描时每个块范围的大小。
     * blockNum:第一次扫描时块的个数。
     *
     * 值的确定：
     * 1）10MB——>2^23Byte。一个整数4个字节，因此，最多包含2^21个元素的数组。
     * 2)bitSize=（2^32/blockNum）<=2^21,所以，blockNum>=2^11。
     * 2^11<=bitSize<=2^23。
     * 在这些条件下，挑选出越靠中间的值，那么，在任何时候所需的内存就越少。
     */

    int bitSize=1048576;
    int blockNum=4096;

    byte[] bitfield2=new byte[bitSize/8];
    int[] blocks=new int[blockNum];

    public void findOpenNumber2() throws FileNotFoundException {
        Scanner in=new Scanner(new FileReader("f:\\file.txt"));

        int starting=-1;
        while(in.hasNext()){
            int n=in.nextInt();
            blocks[n/bitfield2.length*8]++;
        }

        for(int i=0;i<blocks.length;i++){
            /*
             * 若小于，则说明该块中至少少了一个数字
             */
            if(blocks[i]<bitfield2.length*8){
                starting=i*bitfield2.length*8;
                break;
            }
        }
        //进行第二次遍历
        in =new Scanner(new FileReader("f:\\file.txt"));
        while(in.hasNext()){
            int n=in.nextInt();
            if(n>=starting&&n<starting+bitfield2.length*8){
                bitfield2[(n-starting)/8]=(byte) (1<<((n-starting)%8));
            }
        }

        for(int i=0;i<bitfield2.length;i++){
            for(int j=0;j<8;j++){
                /*
                 * 取回每个字节的各个比特。当发现某个比特为0时，即找到相对应的值。
                 */
                if((bitfield2[i]&(1<<j))==0){
                    System.out.println(i*8+j+starting);
                    return;
                }
            }
        }

    }
}
