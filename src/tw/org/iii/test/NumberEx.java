package tw.org.iii.test;

import javax.swing.JOptionPane;

public class NumberEx {

	public static void main(String[] args) {
		//中文數字組與單位組
			String Numch[] = {"零","壹","貳","參","肆","伍","陸","柒","捌","玖"};
			String Nchars[] = {"元","拾","百","千","萬","拾","百","千",
					"億","十","百","千","兆"};
			
			String in = JOptionPane.showInputDialog("請輸入大於零的阿拉伯數字");
			//計算輸入數字字串長度
			int n = in.length();
		for (int i = 0; i < n; i++) {
			//以輸入字串長度來轉換文字
			String sub = in.substring(i, i + 1);//將輸入數字拆開(型別為字串)
			int convert = Integer.parseInt(sub);//將字串轉為整數
			System.out.print(Numch[convert]+Nchars[n-1-i]);
			
		}		
		
	}

}
