package package1.FindK1;
import java.util.*;
public class FindK_Qsort {
    Scanner input = new Scanner(System.in);
    public int Inputlength() {
        //System.out.println("请输入数组的长度：");
        int length = input.nextInt();
        return length;
    }
    public int[] Inputarray(int length1) {
        //System.out.println("请输入数组的内容");
        int array[] = new int[length1];
        for(int x = 0; x < array.length;x++)
        {
            array[x]=input.nextInt();
        }
        return array;
    }
    public int K_int() {
        int k = input.nextInt();
        input.close();
        return k;
    }
    public int[] qsort(int[] arr,int start,int end) { //快速排序
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
        if (i-1>start) arr=qsort(arr,start,i-1);
        if (j+1<end) arr=qsort(arr,j+1,end);
        return (arr);
    }
    public static void main(String[] args) {
        Scanner input1 = new Scanner(System.in);
        int[] array;
        FindK_Qsort findK_qsort = new FindK_Qsort();
        array = findK_qsort.Inputarray(findK_qsort.Inputlength());
        int len = array.length - 1;
        array = findK_qsort.qsort(array,0,len);
        int k = findK_qsort.K_int();
        /*for (int i:array) {                    //打印数组
            System.out.print(i+"\t");
        }*/
        System.out.print(array[array.length-k]);
    }
}