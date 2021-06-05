package Homework1_WaysToUpStairs;
import java.util.*;
public class WaysToUpstairs {
    Scanner input = new Scanner(System.in);          //输入方法
    public int[][] ChartInitialization(int M_stairs_in_MArray) {
        int[][] chart = new int[M_stairs_in_MArray/2 + 1][M_stairs_in_MArray]; //初始化的是长度
        return chart;
    }            //初始化数组
    public int FiboChartFill(int[][] chart) {
        for(int row = 0;row < chart[0].length;row++)
            chart[0][row] = 1;                         //初始化表格的第一行
        for(int row = 0;row < chart[0].length;row++)
            chart[1][row] = row;                       //初始化表格的第二行
        for(int row = 3/*从下标3开始即从第4列开始满足规律*/;row < chart[0].length;row++) {
            for(int line = 2/*从下标2开始即从有两个台阶2开始满足规律*/;line < chart.length;line++) {
                chart[line][row] = sumArray(line,row,chart);
            }
        }
            int sum = 0;
            for(int line = 0;line < chart.length;line++)
                sum += chart[line][chart[0].length - 1];  //求最后一列每个元素之和，得到ways的值，再将其返回
        return sum;
    }               //填充满足斐波那契数列的表格，表格每一列相加和，横向满足斐波那契
    public int sumArray(int line,int row,int[][]chart) {
        int sum = 0;
        for(int x = 0;x < row - 1;x++)
            sum += chart[line - 1][x];
        return sum;
    }     //按照规律计算元素上一行从第0开始到下标减2的元素和
    public int M_stairs() {
        int stairs = input.nextInt();
        return stairs;
    }          //输入M级台阶
    public int N_example() {
        int Ncount = input.nextInt();
        return Ncount;
    }           //输入N个实例
    public static void main(String[] args) {
        WaysToUpstairs upstairs = new WaysToUpstairs();
        int Wayscount;
        int N_count = upstairs.N_example();    //调用输入N方法，输入需要N个实例
        int[] MArray = new int[N_count];         //一维数组存储N个实例——每个是M级台阶
        for(int x = 0;x < N_count;x++ ) {
            MArray[x] = upstairs.M_stairs();     //调用输入M方法，给数组每个元素赋值，内容是每个实例有M级台阶
            /*System.out.println(MArray[x]+" ");   //检查输入的M级是否与数组对应成功*/
        }
        for(int x = 0;x < N_count;x++ ) {
            int[][] chart;
            if(MArray[x] == 1)
                System.out.println("1");
            if(MArray[x] == 2)
                System.out.println("2");
            if(MArray[x] == 3)
                System.out.println("3");
            if(MArray[x] >= 4) {
                chart = upstairs.ChartInitialization(MArray[x] - 0);   //初始化数组，长度基于MArray[]的内容，与上面的for循环一一对应
                Wayscount = upstairs.FiboChartFill(chart);
                System.out.println(Wayscount);
            }
        }
    }
}
