package JavaStudy10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MoneyExchange extends JFrame
{
	private JTextField money;
	private JLabel inputLabel, outputLabel, resultLabel;
	public MoneyExchange()

	{
		Container contentPane = getContentPane();
		setTitle("환전기");
		setSize(400, 100);
		
		contentPane.setLayout(new FlowLayout());
		inputLabel = new JLabel("환전금액(원화)을 입력하세요:");
		outputLabel = new JLabel("환전받는 금액(달러화): $");
		resultLabel = new JLabel("---");
		money = new JTextField(10);
		
		contentPane.add(inputLabel);
		contentPane.add(money);
		contentPane.add(outputLabel);
		contentPane.add(resultLabel);
		
		MoneyListener listener = new MoneyListener();
		money.addActionListener(listener);
		contentPane.setBackground(Color.green);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private class MoneyListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			int won, dollar;
			String text = money.getText();
			won = Integer.parseInt(text);
			dollar = won / 1200;
			resultLabel.setText(Integer.toString(dollar));
		}
	}

	public static void main(String[] args)
	{
		MoneyExchange frame = new MoneyExchange();
		frame.setVisible(true);
	}
}