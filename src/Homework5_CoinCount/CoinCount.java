package Homework5_CoinCount;
import java.util.*;
public class CoinCount {
    Scanner input = new Scanner(System.in);          //输入方法
    public static int[] Qsort(int[] arr,int start,int end) { //快速排序
        int pivot = arr[start];
        int i = start;
        int j = end;
        while (i<j) {
            while ((i<j)&&(arr[j]>pivot)) {
                j--;
            }
            while ((i<j)&&(arr[i]<pivot)) {
                i++;
            }
            if ((arr[i]==arr[j])&&(i<j)) {
                i++;
            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        if (i-1>start) {
            arr=Qsort(arr,start,i-1);
        }
        if (j+1<end) {
            arr=Qsort(arr,j+1,end);
        }
        return (arr);
    } //快排
    public int[] CoinValueArray(int length) {
        int[] CoinValueArray = new int[length];
        for(int x = 0; x < CoinValueArray.length;x++)
        {
            CoinValueArray[x]=input.nextInt();
        }
        CoinValueArray = Qsort(CoinValueArray,0,CoinValueArray.length - 1);
        /*for(int x:CoinValueArray)
        System.out.print(x+" ");//测试排序后面额数组是否正确*/
        return CoinValueArray;
    }//引入长度，输入多个硬币的面额，存储数组中，
    // 紧接着调用快速排序，将面额排序，并返回排序后的面额数组。
    public void NumberOfCoins(int[] CoinValue,int Value) {
        int count = 0;//count计数商的和，即需要的硬币个数
        /*for(int tail = CoinValue.length - 1;tail > 0;tail--) {
            count += Value / CoinValue[tail];//商
            Value = Value % CoinValue[tail];//余数，减去大额度后剩余的钱，是下一次的额度
//            System.out.println("第"+(CoinValue.length - tail)+"次循环");
//            System.out.println("count是"+count);
//            System.out.println("Value是"+Value);//打印测试是否正确
            if(Value == 0) {
                System.out.println(count);
                break;
            }//如果恰好是大面额的整数倍，直接输出count
            if(tail == 1 && Value % CoinValue[tail - 1] != 0) {
                System.out.println("-1");
            }//如果循环到下标1后，剩余的额度和最小的面额求余不等于0，小于额度说明没法整除
            //等于额度说明剩余的额度小于最小的面额，两种情况都无法凑成，输出-1
            if(tail == 1 && Value % CoinValue[tail - 1] == 0) {
                int lastcount = Value / CoinValue[tail - 1];
                lastcount += count;
//                System.out.println("第"+(CoinValue.length - tail + 1)+"次循环");
//                System.out.println("count是"+lastcount);
//                System.out.println("Value是"+(Value % CoinValue[tail - 1]));//打印测试是否正确
                System.out.println(lastcount);
            }//如果循环到下标等于1后，剩余额度对最小的面额取余数等于0，则说明最小额度刚好够用，算出这个lastcount，加上先前的count 输出即可
        }//算法写错了，日后再改*/
        int[] dp = new int[Value + 1];
        for (int i = 1; i <= Value; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int c : CoinValue) {
                if (i - c >= 0 && dp[i - c] != Integer.MAX_VALUE) { //判断是否可以凑成金额 i-c
                    dp[i] = Math.min(dp[i], dp[i - c] + 1);
                }
            }
        }//网上copy的源代码
        System.out.println(dp[Value] == Integer.MAX_VALUE ? -1 : dp[Value]);
    }//引入面额数组以及总面额，打印出最终结果。
    // 打印最少需要多少硬币，或者打印-1
    public static void main(String[] args) {
        CoinCount coinCount = new CoinCount();
        coinCount.NumberOfCoins(coinCount.CoinValueArray(coinCount.input.nextInt()/*此处input是输入硬币面额多少种*/),
/*右边是NumberOfCoinsd的第二个参数*/coinCount.input.nextInt()/*此处input输入总面额*/);
    }
}