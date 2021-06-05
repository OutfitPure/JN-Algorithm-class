package HomeWork4_ChipsMove;
import java.util.*;
public class ChipsMove {
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
    private void ChipsLocation(int[] chipsLoc) {//返回奇数位置和偶数位置，比较，返回小的哪一个即为最小代价
        for(int check = 0; check < chipsLoc.length;check++) {//输入的位置不能是负数，或者大于筹码的个数
            if(chipsLoc[check] > chipsLoc.length || chipsLoc[check] < 0) {
                System.out.print("位置有误");
                System.exit(0);
            }
        }
        int countArray[] = new int[2];

        //System.out.println(countArray[0]+"  "+countArray[1]);

        for(int index = 0; index < chipsLoc.length;index++) {
            if(chipsLoc[index]%2 == 0)
                countArray[0]++;
            else
                countArray[1]++;
        }

        //System.out.println(countArray[0]+"  "+countArray[1]);

        if(countArray[0] >= countArray[1])
            System.out.print(countArray[1]);
        else
            System.out.print(countArray[0]);
    }
    public static void main(String[] args) {
        ChipsMove chipsMove = new ChipsMove();
        chipsMove.ChipsLocation(chipsMove.arrayInput());
    }
}
