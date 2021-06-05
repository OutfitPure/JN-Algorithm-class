package HomeWork5_ArrayDivision;
import java.util.*;
public class ArrayDivision {
    private Scanner input = new Scanner(System.in);
    private int[] arrayInput() {
        String targetString = input.nextLine();
        String[] stringArray = targetString.split(" ");
        int[] intArray = new int[stringArray.length];
        for(int x = 0;x < intArray.length;x++) {
            intArray[x] = Integer.valueOf(stringArray[x]);
        }

//        for(int a = 0;a < intArray.length;a++)//测试数组内容
//            System.out.print(intArray[a]+" ");
//        System.out.println();

        return intArray;
    }//连续输入数字转化为数组，改int[]加return可返回数组
    private int Number() {
        return input.nextInt();
    }
    private void ArrayDivide(int[] numArray,int divisor) {
        if(numArray.length%2 != 0) {//如果不是偶数个，结束嗷
            System.out.println("数组长度不为偶数！");
            System.exit(0);
        }
        int sum = 0;
        for (int i : numArray) {
            sum += i;
        }
        if(sum%divisor==0)
            System.out.print("true");
        else
            System.out.print("false");
    }
    public static void main(String[] args) {
        ArrayDivision arrayDivision = new ArrayDivision();
        arrayDivision.ArrayDivide(arrayDivision.arrayInput(), arrayDivision.Number());
    }
}
