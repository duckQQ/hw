package tw.org.iii.test;

import javax.swing.JOptionPane;

public class NumberEx {

	public static void main(String[] args) {
		//設定 中文數字組, 單位組
			String Numch[] = {"零","壹","貳","參","肆","伍","陸","柒","捌","玖"};
			String Nchars[] = {"元","拾","百","千","萬","拾","百","千","億","拾"};
			
			String in = JOptionPane.showInputDialog("請輸入數字");
			//計算輸入數字為幾位
			int n = in.length();
		for (int i = 0; i < n; i++) {
			// 依照數字多少算個拾百...但是會從元開始印出來
			String sub = in.substring(i, i + 1);
			int convert = Integer.parseInt(sub);
			System.out.print(Numch[convert]+Nchars[n-1-i]);
			
		}		
		
	}

}
