package HomeWork1_StockProfit;
import java.util.*;
public class Stock_Profit {
    private Scanner input = new Scanner(System.in);
    private void StockCompute(int[] stockPrice){
        int ProfitMax = 0;
        if(stockPrice.length > 0){
            for(int index = 0;index + 1 < stockPrice.length;index++){
                if(stockPrice[index] < stockPrice[index + 1]){
                    ProfitMax += stockPrice[index + 1] - stockPrice[index];
                }
            }
            System.out.print(ProfitMax);
        }
        else System.out.print("0");
    }
    public static void main(String[] args) {
        Stock_Profit stockProfit = new Stock_Profit();
        String Stock = stockProfit.input.nextLine();
        //System.out.println(Stock); //测试输入字符串
        String[] StrStock = Stock.split(" ");//去空格，转化为字符串数
        int[] IntStock = new int[StrStock.length];//变int数组
        //System.out.println(StrStock.length);
        for(int x = 0;x< StrStock.length;x++)
            IntStock[x] = Integer.valueOf(StrStock[x]);
//        for(int x = 0;x<IntStock.length;x++)
//            System.out.print(IntStock[x]+" ");
        stockProfit.StockCompute(IntStock);
        stockProfit.input.close();
    }
}
