package HomeWork3_ContinueSequence;
import java.util.*;
public class Sequence {
    private Scanner input = new Scanner(System.in);
    private int[] arrayInput() {
        String targetString = input.nextLine();
        String[] stringArray = targetString.split(" ");//去空格，变string数组
        int[] intArray = new int[stringArray.length];//int数组初始化
        for(int x = 0;x < intArray.length;x++) {//for循环，转格式，string数组赋值int数组
            intArray[x] = Integer.valueOf(stringArray[x]);
        }

//        for(int a = 0;a < intArray.length;a++)//测试数组内容
//            System.out.print(intArray[a]+" ");
//        System.out.println();

        return intArray;
    }//连续输入数字转化为数组，int[] return返回数组。
    private void ArrayJudge(int[] targetArray) {
        int head = 0;
        int tail = 0;
        for(int x = 0;x < targetArray.length;x++){
            if(x == targetArray.length - 1){
                tail = x - 1;
                if(tail - head + 1 < 3) {
                    System.out.print("false");
                    break;
                }
            }
            if(targetArray[x] == targetArray[x + 1] - 1) {//如果下一个是上一个加1，则tail = x + 1，尾巴是下一个元素，
                // 如果是倒数第二个元素，那么tail的位置就是最后一个元素了
                tail = x + 1;

//                System.out.println("尾巴是第"+(tail + 1)+"个元素");
//                System.out.println("头部是第"+(head + 1)+"个元素");
//                System.out.println("尾巴减头"+(tail - head + 1));
//                System.out.println("此时x是"+x);
//                System.out.println();

            }
            if(x == targetArray.length - 2 && targetArray[x + 1] == targetArray[x] + 1 && tail - head + 1 >= 3) {
                System.out.print("true");//，判断是不是倒数第二个元素，防止溢出，成功的话返回true，break结束
                break;
            }
            if(targetArray[x] == targetArray[x + 1] || targetArray[x + 1] > targetArray[x] + 1) {//如果下一个不连续，
                // 则根据head和tail判断长度，如果长度小于3，false，break，如果长度大于等于3（else的内容）
                // 然后将head给下一个元素的下标，从下一个元素开始子序列，tail在上一个if中可以赋值
                if(tail - head + 1< 3){
                    System.out.print("false");
                    break;
                }
                else{
                    head = x + 1;

//                    System.out.println("经历了一次不连续整数");
//                    System.out.println("尾巴是第"+(tail + 1)+"个元素");
//                    System.out.println("头部是第"+(head + 1)+"个元素");
//                    System.out.println("此时x是"+x);
//                    System.out.println();

                }
            }
        }
    }//判断是否可划分为多个子序列
    public static void main(String[] args) {
        Sequence sequence = new Sequence();
        sequence.ArrayJudge(sequence.arrayInput());
    }
}
