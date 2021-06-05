package package1;
import java.util.*;
public class Sort {
    Scanner input = new Scanner(System.in);          //输入方法
    public static int[] Qsort(int arr[],int start,int end) { //快速排序
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
        if (i-1>start) arr=Qsort(arr,start,i-1);
        if (j+1<end) arr=Qsort(arr,j+1,end);
        return (arr);
    }
    public int Inputlength() {
        //System.out.println("请输入数组的长度：");
        int length = input.nextInt();
        return length;
    }          //数组长度
    public int[] Inputarray(int length1) {
        //System.out.println("请输入数组的内容");
        int array[] = new int[length1];
        for(int x = 0; x < array.length;x++)
        {
            array[x]=input.nextInt();
        }
        return array;
    }            //获得数组
    public int[] arraymerge(int arr1[],int arr2[]) {
        int mergeArray[] = new int[arr1.length + arr2.length];
        int count = 0;
        for (; count < arr1.length; count ++) {
            mergeArray[count] = arr1[count];
        }
        for(;count < mergeArray.length; count++){
            mergeArray[count] = arr2[count-arr1.length];
        }
        return mergeArray;
    }   //合并两个数组
    public static void main(String[] args) {
        Sort sort = new Sort();
        int arr1[];
        int arr2[];
        int twoArrylength[];
        twoArrylength = sort.Inputarray(2); //获得两个数组长度
        arr1 = sort.Inputarray(twoArrylength[0]);   //获取第一个数组
        arr2 = sort.Inputarray(twoArrylength[1]);   //获取第二个数组
        int arr3[] = sort.arraymerge(arr1,arr2);     //第三个数组由题目两个数组合并得到
        int len = arr3.length-1;               //获得第三个数组长度
        arr3=Qsort(arr3,0,len);          //调用快排
        /*for (int i:arr3) {                    //打印数组3
            System.out.print(i+"\t");
        }*/
        //System.out.println();
        System.out.println(arr3[(arr3.length - 1) / 2 ]);
        //System.out.println();
    }
}
