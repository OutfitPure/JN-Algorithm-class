package HomeWork2_LongestArray;
import java.util.*;
public class Longest_Array {
    private Scanner input = new Scanner(System.in);
    private static int[] Qsort(int[] arr,int start,int end) { //快速排序
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
    private void LongArrayFind(int[] targetArray){
        int[] memory = new int[targetArray.length];//存储子数组的长度
        int memLength = 0;

//        System.out.println("\n\n初始化的数组是");//换行
//        for(int x = 0;x < memory.length;x++){//检查初始化的memory数组
//            System.out.print(memory[x]+" ");
//        }

        if(targetArray.length == 1 && targetArray[0] > 0) { //长度1且大于0的话，最长子数组长度就是1
            System.out.print(1);
        }
        if(targetArray.length ==1 && targetArray[0] == 0) {//长度为1且小于等于0，最长长度为0
            System.out.println(0);
        }
        int count = 0;//给memory数组计数用
        if(targetArray.length > 1) { //长度大于1
            memory[count] = memLength;
            for (int x = 0; x < targetArray.length - 1; x++) { //负数情况需要比较下一个元素，防止溢出
                if (targetArray[x] == 0) {//如果数组有一个元素为0，就终止，memLength给memory存储。x++
                    memory[count] = memLength;
                    count ++;
                }
                if (targetArray[x] < 0 && targetArray[x + 1] < 0) {//如果这个元素，下一个元素都小于0，那么memLength加2,x+2
                    memLength = memLength + 2;
                    memory[count] = memLength;
                    x++;
                }
                if (x == targetArray.length - 1 && (targetArray[x] > 0 && targetArray[x+1] > 0)){//如果是倒数俩都大于0，memLength加2
                    memLength = memLength+2;
                    memory[count] = memLength;
                    break;
                }
                if (targetArray[x] > 0) {//如果数组元素大于0，不影响，直接memLength加1，x++
                    memLength++;
                    memory[count] = memLength;
                }
                if (targetArray[x] < 0 && targetArray[x + 1 ] > 0) {//前为负数，后为正数
                    memory[count] = memLength;
                    count++;
                }
                if (targetArray[x] < 0 && targetArray[x + 1 ] == 0) {//前为负数，后为0，那么需要x++，防止与第一个重复计算
                    memory[count] = memLength;
                    count++;
                    x++;
                }
            }
        }

//        System.out.println("\n存储的子数组的长度");
//        for(int a = 0;a < memory.length;a++){//检查存储正子数组长度的memory数组
//            System.out.print(memory[a]+" ");
//        }
//        System.out.println("\n最长的正子数组长度是");//换行

        memory = Qsort(memory,0,memory.length - 1);
        System.out.print(memory[memory.length - 1]);
    }
    public static void main(String[] args) {
        Longest_Array longestArray = new Longest_Array();
        String String = longestArray.input.nextLine();
        String[] arrayString = String.split(" ");
        int[] intArray = new int[arrayString.length];
        for (int x = 0 ;x < intArray.length; x++)
            intArray[x] = Integer.valueOf(arrayString[x]);

//        System.out.println("\n输入的数组是");//检查输入的数组
//        for(int x = 0;x < intArray.length;x++)
//            System.out.print(intArray[x]+" ");

        longestArray.LongArrayFind(intArray);
    }
}
