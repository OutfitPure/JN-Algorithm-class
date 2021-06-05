package package1;
import java.util.*;
public class Magic_index {
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
    public int[] Magic_Index_Find(int[] array) {
        int[] mark = new int[2];
        for(int x = 0; x < array.length && mark[0] != 1; x++) {
            if(array[x] == x) {
            mark[0] = 1;
            mark[1] = x;
            }
            else
                mark[0] = -1;
        }
        return mark;
    }
    public static void main(String[] args) {
        Magic_index magic_index = new Magic_index();
        int[] magic_array = magic_index.Inputarray(magic_index.Inputlength());
        int[] mark = magic_index.Magic_Index_Find(magic_array);
        if(mark[0] == 1)
            System.out.print(mark[1]);
        else System.out.print(mark[0]);
    }
}
