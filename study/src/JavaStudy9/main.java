//GUI 패널 만들기

package JavaStudy9;

import java.awt.*;
import javax.swing.*;

//JFrame 상속한 클래스로 GUI가능
public class main extends JFrame {

	public static void main(String[] args) {

		//새로운 Frame 생성
		JFrame frame = new JFrame("패널 포함");

		//Frame위에 Panel 생성
		JPanel panel = new JPanel();
		//panel의 색상 결정
		panel.setBackground(Color.green);
		//panel의 크기 결정
		panel.setPreferredSize(new Dimension(200, 100));
		//frame에 panel추가
		frame.getContentPane().add(panel);
		frame.pack();
		
		frame.setVisible(true);

	}

}