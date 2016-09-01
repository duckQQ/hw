package tw.org.iii.test;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GuessN extends JFrame implements ActionListener{
	private JButton guessB;
	private JTextField guessArea;
	private JTextArea showGuess;	
	private String answer = createAnswer(4); // 產生謎底
	
	public GuessN(){
				
		super("猜數字");
	//物件
		guessB = new JButton("猜");
		guessArea = new JTextField(20);
		showGuess = new JTextArea();
		showGuess.setEditable(false);

	//Layout
		JPanel top = new JPanel(new FlowLayout(FlowLayout.CENTER));
		top.add(guessArea); top.add(guessB);
		add(top,BorderLayout.NORTH);
		guessB.addActionListener(this);
		add(showGuess, BorderLayout.CENTER);
	//window size
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
	}
	
	
	public static void main(String[] args) {
		new GuessN();						
	}
	
	//要用在Listener裡面的計數器
	int i = 1; int count = 0;
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(answer);
			String guess = guessArea.getText();
			String result = checkAB(answer, guess);

			if(guess.length()==4){	
				if(count<5){			
					boolean isWINNER = false;
					
					// 比對
					if (guess.equals(answer)){
						// 對了 => 恭喜老爺,...
						isWINNER = true;
						JOptionPane.showMessageDialog(null, "恭喜答對 ^_^");
						showGuess.append("猜第"+i+"次"+guess+" => "+result + "\n");
						i++; count++;
						//break;
					}else{
						// 錯了 => 提示 1A2b
						showGuess.append("猜第"+i+"次"+guess+" => "+result + "\n");
						i++; count++;	
					}

				}else{
					JOptionPane.showMessageDialog(null, "QQ 你是魯蛇, \n答案是:" + 
							answer);
				}
		}else {//判斷輸入數字是否為四個數字
			JOptionPane.showMessageDialog(null, "請輸入四個數字!");
		}
			
			
		}
		
		//check answer method
		static String checkAB(String a, String g){
			int A, B; A = B = 0;
			for (int i=0; i<g.length();i++){
				if (g.charAt(i) == a.charAt(i)){
					A++;
				}else if (a.indexOf(g.charAt(i)) != -1){
					B++;
				}
			}
			return A + "A" + B + "B";
		}		
		
		//Create answer Method
		static String createAnswer(int n){
			// 洗牌
			int[] poker = new int[n];	// 0,0,...0
			int rand;
			boolean isOK;
			for (int i=0; i<poker.length; i++){
				
				do {
					rand = (int)(Math.random()*10);
					// 檢查機制
					isOK = true;
					for (int j=0;j<i;j++){
						if (poker[j]==rand){
							isOK = false;
							break;
						}
					}
					
				}while (!isOK);
				
				poker[i] = rand;
				//System.out.println(poker[i]);
			}
			String ret = "";
			for (int v : poker) ret += v;
			
			return ret;
		}
	
}
