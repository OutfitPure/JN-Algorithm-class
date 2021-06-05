package package1.RightCompare;
import java.util.*;
public class RightCompare {
    Scanner input = new Scanner(System.in);          //输入方法
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
    public int[] RightCompareFuntion(int[] contentArray,int[] consequenceArray) {
        for(int x = 0;x < contentArray.length;x++) {
            for(int j = x + 1;j < contentArray.length;j++) {
                if(contentArray[x] > contentArray[j]) {
                    consequenceArray[x] = consequenceArray[x] + 1;
                }
            }
        }
        return consequenceArray;
    }
    public static void main(String[] args) {
        RightCompare rightCompare = new RightCompare();
        int[] contentArray = rightCompare.Inputarray(rightCompare.Inputlength());//输入数组大小以及内容
        int[] consequenceArray = new int[contentArray.length];
        for(int x = 0; x < consequenceArray.length;x++)
            consequenceArray[x] = 0;                 //将数组初始化为0
        consequenceArray = rightCompare.RightCompareFuntion(contentArray,consequenceArray);
        for (int i:consequenceArray) {                    //打印数组
            System.out.print(i+" ");
        }
    }
}
