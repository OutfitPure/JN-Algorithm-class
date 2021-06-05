package Homework2_DigitalTriangle;
import java.util.*;
public class DigitalTriangle { //网上抄的
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int[][] num=new int[n][n];
        int[][] maxSum=new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<=i;j++)
                num[i][j]=input.nextInt();
        input.close();
        for(int i=0;i<n;i++)
            maxSum[n-1][i]=num[n-1][i];     //最后一行数据固定，复制
        for(int i=n-2;i>=0;i--)
            for(int j=0;j<=i;j++)
                maxSum[i][j]=Math.max(maxSum[i+1][j], maxSum[i+1][j+1])+num[i][j];
        System.out.println(maxSum[0][0]);
    }
}