package package1.FindK;
import java.util.*;
public class FindK_Qsourt_second {
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
    public int K_int() {
        int k = input.nextInt();
        input.close();
        return k;
    }
    public static void main(String[] args) {
        FindK_Qsourt_second findK_qsourt_second = new FindK_Qsourt_second();
        int[] arrayFindK = findK_qsourt_second.Inputarray(findK_qsourt_second.Inputlength());
        int len = arrayFindK.length-1;
        arrayFindK = Qsort(arrayFindK,0,len);
        /*for (int i:arrayFindK) {                    //打印数组
            System.out.print(i+"\t");
        }*/
        int k = findK_qsourt_second.K_int();
        System.out.println(arrayFindK[arrayFindK.length-k]);
    }
}
