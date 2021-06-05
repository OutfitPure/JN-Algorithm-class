package Homework4_LongestRoad;
import java.util.*;
public class LongestRoad {
    Scanner input = new Scanner(System.in);          //输入方法
    public int N_return() {
        return input.nextInt();
    }//输入数字N，矩阵的大小，返回N
    public int[][] Array_Initialization(int N_number) {
        int[][] Array = new int[N_number][N_number];
        return Array;
    }//引入N，初始化数组空间大小N*N，返回这个初始化好的二维数组
    public int[][] ArrayContentFill(int[][] array_initialized) {
        for(int x = 0;x < array_initialized.length; x++)
            for(int y = 0; y < array_initialized.length; y++)
                array_initialized[x][y] = input.nextInt();
        /*for(int x = 0;x < array_initialized.length; x++)
            for (int y = 0; y < array_initialized.length; y++)
                System.out.print(array_initialized[x][y]+" "); //检查输入数组内容  */
        return array_initialized;
    }//引入一个初始化好的数组，可以通过输入array的内容，将每个元素的值变为经过该格子的奖励——也就是路径长度
    //返回内容是这个二维数组，每个元素是该点路径长度，也就是奖励
    public void Length_Gaining_Array(int[][] ArrayContentFill) {
        int[][] Length_Array = new int[ArrayContentFill.length][ArrayContentFill.length];//路径数组大小初始化
        Length_Array[0][0] = ArrayContentFill[0][0];
        if(Length_Array.length == 1)
            System.out.println(ArrayContentFill[Length_Array.length - 1][Length_Array.length - 1]);
        for(int x = 1;x < Length_Array.length;x++) {
            Length_Array[x][0] = Length_Array[x - 1][0] + ArrayContentFill[x][0];
        }//初始化路径长度数组的最左一列，这一列的每个元素的值——到达此位置的最大长度只能通过单向地向下走获得。
        for(int y = 1;y < Length_Array[0].length;y++) {
            Length_Array[0][y] = Length_Array[0][y - 1] + ArrayContentFill[0][y];
        }//初始化路径长度数组的最上一行，这一行的每个元素的值——到达此位置最大长度只能通过单向地向右走获得。
        for(int i = 1;i < Length_Array.length;i++) {
            for(int j = 1; j < Length_Array.length;j++) {
                if(Length_Array[i][j - 1] >= Length_Array[i - 1][j])
                Length_Array[i][j] = Length_Array[i][j - 1] + ArrayContentFill[i][j];
                if(Length_Array[i -1][j] >= Length_Array[i][j - 1])
                Length_Array[i][j] = Length_Array[i -1][j] + ArrayContentFill[i][j];
            }
        }
        /*for(int x = 0;x < Length_Array.length; x++) {
            for (int y = 0; y < Length_Array.length; y++)
                System.out.print(Length_Array[x][y] + " "); //检查路径最长数组的内容
            System.out.println();
        }*/
        System.out.println(Length_Array[Length_Array.length - 1][Length_Array.length - 1]);
    }//引入一个有具体内容——每个元素是每点经过的长度的数组
    // 在计算经过每个点的最长路径后，输出最终从头到尾的最长路径——奖励——也就是此二维数组的右下角元素
    public static void main(String[] args) {
        LongestRoad longestRoad = new LongestRoad();
        longestRoad.Length_Gaining_Array(longestRoad.ArrayContentFill(longestRoad.Array_Initialization(longestRoad.N_return())));
    }
}
