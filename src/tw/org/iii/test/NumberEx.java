package tw.org.iii.test;

import javax.swing.JOptionPane;

public class NumberEx {

	public static void main(String[] args) {
		//�]�w ����Ʀr��, ����
			String Numch[] = {"�s","��","�L","��","�v","��","��","�m","��","�h"};
			String Nchars[] = {"��","�B","��","�d","�U","�B","��","�d","��","�B"};
			
			String in = JOptionPane.showInputDialog("�п�J�Ʀr");
			//�p���J�Ʀr���X��
			int n = in.length();
		for (int i = 0; i < n; i++) {
			// �̷ӼƦr�h�ֺ�ӬB��...���O�|�q���}�l�L�X��
			String sub = in.substring(i, i + 1);
			int convert = Integer.parseInt(sub);
			System.out.print(Numch[convert]+Nchars[n-1-i]);
			
		}		
		
	}

}
