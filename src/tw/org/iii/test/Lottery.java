package tw.org.iii.test;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Lottery extends JFrame{
	
	private JButton b0, b1, b2, b3, b4, b5, b6, b7;
	private JTextField tf;
	private JLabel L1, L2;
	
	
	
	public Lottery(){
		
		
		super("樂透號碼產生器");
		//System.out.println(nos);
		
		b0 = new JButton("請 按 此 產 生 樂 透 號 碼");
		tf = new JTextField();
		
		tf.setEditable(false);
		//Layout
		add(b0,BorderLayout.PAGE_START);
		add(tf,BorderLayout.CENTER);
		//window
		setSize(600, 250);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		//Action
		b0.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println(nos + " " + sp);
				doGo();
			}
		});
	}
	public void doGo(){
		//String nos = createLott(6, 49);
		String sp = createLott(1, 10);
		String nos = createLott(6, 49);
		tf.setText("第一區是: " + "  " + nos +"  "+"第二區是: " + "" + sp);

	}
	
	public static void main(String[] args) {
		new Lottery(); 
	}
	

//製造樂透號碼	
	static String createLott(int a, int b){//a= 產生幾個  b= 產生到多少的數字
		int[] array = new int[a]; //a
		boolean isOK;
		int rand;
			for(int i=0; i<array.length; i++){
				do{
					rand = (int)((Math.random())*b+1); //b
			//check
					isOK = true;
					for(int j=0; j<i; j++){
						if(array[j]==rand){
							isOK = false;
							break;
							}								
						}
			//							
				}while(!isOK);
				array[i] = rand;}	
		String ret = "";
		for(int v : array) ret += v + " ";
		return ret.trim();
		
	}
	
	

}
