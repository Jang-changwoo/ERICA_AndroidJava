package JavaStudy9;
import java.awt.*;
import javax.swing.*;

public class main extends JFrame {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("패널 포함");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.green);
		panel.setPreferredSize(new Dimension(200, 100));
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);

	}

}
