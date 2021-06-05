package Homework3_StringMatch;
import java.util.*;
public class String_Match {
private Scanner input = new Scanner(System.in);
private String wordDict[];//dict
private String string;//字符
private String string_dict;//dict
private int count[];
private boolean end[];
    public static void main(String[] args) {
        String_Match string_match = new String_Match();
        string_match.string = string_match.input.nextLine();//输入字符
        string_match.string_dict = string_match.input.nextLine();//输入dict
        //System.out.println("需要被匹配字符串  "+string_match.string);
        //System.out.println("字典内容  "+string_match.string_dict);
        string_match.wordDict = string_match.string_dict.split(" ");//String[] split("")根据给定的正则表达式的匹配来拆分此字符串。形成一个新的String数组。
        //去空格转换成字符数组

        int x ;
        string_match.end = new boolean[string_match.wordDict.length + 1];//end数组必须初始化嗷，长度为字符串数组长度加一，从2 开始到最后
        string_match.end[0] = false;
        string_match.end[string_match.wordDict.length] = false;//最后一个先false嗷，下标就是数组长度
        for(x = 1;x < string_match.wordDict.length + 1; x ++ ) {//从下标1开始 到string_match.wordDict.length + 1，因为是从第二个开始嗷
//            System.out.println(string_match.wordDict[x - 1]);
            if( string_match.string.contains(string_match.wordDict[x - 1]) )//字符串数组对应的下标是x - 1
                string_match.end[x] = true;
            else
                break;//有一个不对就跳出去false嗷
        }
        System.out.println(string_match.end[string_match.wordDict.length]);//string_match.wordDict.length 下标对应最后一个嗷
    }//end数组从第二个元素开始判断，输出的是最后一个元素，如果全部正确，最后返回的一定是true
     //如果前面任何一个不被包含，就在循环中跳出，这时候输出的最后一个元素必定是false，在前面定义过
     //end 数组的长度为 字符串数组的长度加1
}
