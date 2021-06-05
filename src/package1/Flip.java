package package1;
import java.util.*;
public class Flip {
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
    public int Flipcount(int[] array, int i, int j) {
        int count = 0;
        for(;i < array.length; i++ ) {
            for(j = i+1;j < array.length; j++) {
                if(array[i] > 2 * array[j])   //满足翻转对 count+1
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] fliparray;                         //数组定义
        Flip flip = new Flip();
        fliparray = flip.Inputarray(flip.Inputlength()); // 输入数组内容
        //System.out.println();
        /*for(int x = 0 ; x < fliparray.length; x++)     //输出数组
            System.out.print(fliparray[x]+" ");       //同上*/
        //System.out.println();
        System.out.println(flip.Flipcount(fliparray,0,1));
    }
}
